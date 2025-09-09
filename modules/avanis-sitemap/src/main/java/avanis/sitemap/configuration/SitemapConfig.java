package avanis.sitemap.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "other", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "avanis.sitemap.configuration.SitemapConfig", localization = "content/Language", name = "Sitemap Config")
public interface SitemapConfig {

    @Meta.AD(name = "Group ID", deflt="20117")
    String groupId();

    @Meta.AD(name = "Site URL", deflt="https://www.avanis.es")
    String siteUrl();

    @Meta.AD(name = "Categorias", deflt="paginas;actualidad")
    String categorias();
    
    @Meta.AD(name = "Max Layouts", deflt="100")
    int maxLayouts();

    @Meta.AD(name = "Max Blogs", deflt="100")
    int maxBlogs();

}
