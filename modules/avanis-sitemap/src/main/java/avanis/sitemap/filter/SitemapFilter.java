package avanis.sitemap.filter;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.sitemap.configuration.SitemapConfig;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component(
        immediate = true,
        property = {
                "before-filter=URL Rewrite Filter",
                "dispatcher=REQUEST",
                "servlet-context-name=",
                "servlet-filter-name=Avanis Sitemap Filter",
                "url-pattern=*.xml"
        },
        configurationPid = "avanis.sitemap.configuration.SitemapConfig",
        service = Filter.class
)
public class SitemapFilter extends BaseFilter {

    private static final Log _log = LogFactoryUtil.getLog(SitemapFilter.class);
    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    private static final String URLSET_OPEN = "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n";
    private static final String URLSET_CLOSE = "</urlset>";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .withZone(ZoneOffset.UTC);

    private volatile SitemapConfig _configuration;

    @Reference(target = "(model.class.name=com.liferay.blogs.model.BlogsEntry)")
    private ModelResourcePermission<BlogsEntry> _blogsEntryModelResourcePermission;

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _configuration = Configurable.createConfigurable(SitemapConfig.class, properties);
    }

    @Override
    protected Log getLog() {
        return _log;
    }

    @Override
    protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws Exception {
        String currentURL = request.getRequestURI();
        _log.info("[processFilter] currentURL from request: " + currentURL);

        String sitemapXml = generateSitemap(currentURL, request);

        response.setContentType("application/xml");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(sitemapXml);
    }

    // Método principal para generar el sitemap según la URL
    private String generateSitemap(String currentURL, HttpServletRequest request) {
        switch (currentURL.toLowerCase()) {
            case "/es/sitemap.xml":
                return generateMainSitemapXML();
            case "/es/paginas_sitemap.xml":
                return generateSitemapForLayouts(request);
            case "/es/actualidad_sitemap.xml":
                return generateSitemapForBlogs(request);
            default:
                return StringPool.BLANK;
        }
    }

    // Generar Sitemap para el archivo principal
    private String generateMainSitemapXML() {
        StringBuilder xmlBuilder = new StringBuilder(XML_HEADER).append(URLSET_OPEN);

        for (String categoria : _configuration.categorias().split(";")) {
            appendUrlToSitemap(xmlBuilder, _configuration.siteUrl() + "/" + categoria + "_sitemap.xml", null);
        }

        return xmlBuilder.append(URLSET_CLOSE).toString();
    }

    // Método general para generar el sitemap de layouts (páginas)
    private String generateSitemapForLayouts(HttpServletRequest request) {
        List<Layout> layouts = getOrderedLayouts();
        StringBuilder xmlBuilder = new StringBuilder(XML_HEADER).append(URLSET_OPEN);

        try {
            PermissionChecker permissionChecker = getGuestPermissionChecker(request);

            for (Layout layout : layouts) {
                if (isValidLayoutForSitemap(layout, permissionChecker) && !layout.getFriendlyURL().contains("home")) {
                    appendUrlToSitemap(xmlBuilder, _configuration.siteUrl() + layout.getFriendlyURL(), layout.getModifiedDate());
                }
            }
        } catch (Exception e) {
            _log.error("Error al generar el sitemap para Páginas", e);
        }

        return xmlBuilder.append(URLSET_CLOSE).toString();
    }

    // Método general para generar el sitemap de blogs
    private String generateSitemapForBlogs(HttpServletRequest request) {
        List<BlogsEntry> blogEntries = getOrderedBlogsEntries();
        StringBuilder xmlBuilder = new StringBuilder(XML_HEADER).append(URLSET_OPEN);

        try {
            PermissionChecker permissionChecker = getGuestPermissionChecker(request);

            for (BlogsEntry blogEntry : blogEntries) {
                if (isValidBlogForSitemap(blogEntry, permissionChecker)) {
                    appendUrlToSitemap(xmlBuilder, _configuration.siteUrl() + "/b/" + blogEntry.getUrlTitle(), blogEntry.getModifiedDate());
                }
            }
        } catch (Exception e) {
            _log.error("Error al generar el sitemap para Actualidad", e);
        }

        return xmlBuilder.append(URLSET_CLOSE).toString();
    }

    // Método reutilizable para verificar si el layout es válido
    private boolean isValidLayoutForSitemap(Layout layout, PermissionChecker permissionChecker) throws Exception {
        return !layout.getFriendlyURL().contains("error") &&
                LayoutPermissionUtil.contains(permissionChecker, layout, ActionKeys.VIEW);
    }

    // Método reutilizable para verificar si el blog es válido
    private boolean isValidBlogForSitemap(BlogsEntry blogEntry, PermissionChecker permissionChecker) throws Exception {
        return blogEntry.isVisible() && blogEntry.isApproved() &&
                _blogsEntryModelResourcePermission.contains(permissionChecker, blogEntry, ActionKeys.VIEW);
    }

    // Obtener y ordenar layouts
    private List<Layout> getOrderedLayouts() {
        OrderByComparator<Layout> orderByComparator = OrderByComparatorFactoryUtil.create("Layout", "modifiedDate", false);
        return LayoutLocalServiceUtil.getLayouts(Long.parseLong(_configuration.groupId()), false, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
    }

    // Obtener y ordenar BlogsEntry
    private List<BlogsEntry> getOrderedBlogsEntries() {
        List<BlogsEntry> blogEntries = new ArrayList<>(BlogsEntryLocalServiceUtil.getBlogsEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
        Collections.sort(blogEntries, (entry1, entry2) -> entry2.getModifiedDate().compareTo(entry1.getModifiedDate()));
        return blogEntries;
    }

    // Obtener PermissionChecker para el usuario invitado
    private PermissionChecker getGuestPermissionChecker(HttpServletRequest request) throws Exception {
        long companyId = PortalUtil.getCompanyId(request);
        User guestUser = UserLocalServiceUtil.getGuestUser(companyId);
        return PermissionCheckerFactoryUtil.create(guestUser);
    }

    // Método para agregar URLs al Sitemap
    private void appendUrlToSitemap(StringBuilder xmlBuilder, String loc, Date lastmod) {
        xmlBuilder.append("<url>\n");
        xmlBuilder.append("<loc>").append(loc).append("</loc>\n");
        if (lastmod != null) {
        	xmlBuilder.append("<lastmod>")
            .append(DATE_FORMATTER.format(lastmod.toInstant()))
            .append("</lastmod>\n");
        }
        xmlBuilder.append("</url>\n");
    }
}
