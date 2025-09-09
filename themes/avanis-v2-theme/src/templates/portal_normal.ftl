<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	
	<link rel="manifest" href="${templates_folder}/manifest.json">

	<link rel="apple-touch-icon" sizes="192x192" href="/o/theme-avanis/images/pwa/logo192.png" />
	<link rel="apple-touch-icon" sizes="512x512" href="/o/theme-avanis/images/pwa/logo512.png" />

	<@liferay_util["include"] page=top_head_include />
	<link rel="stylesheet" href="${theme_display.getPathThemeRoot()}/css/cropper/cropper.min.css" />

	<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />

	<#--<script src="${javascript_folder}/jquery-3.6.0.min.js"></script>
	<script src="${javascript_folder}/bootstrap.min.js"></script>
	-->
	<#-- <script src="${javascript_folder}/emoji-mart/emoji-mart-5.6.0.browser.min.js"></script>-->
	<script src="${javascript_folder}/select2.min.js"></script>
	<script src="${javascript_folder}/micromodal.min.js"></script>

	<script src="${javascript_folder}/commons.js"></script>
	<script src="${javascript_folder}/modal-template.js"></script>
	<script src="${javascript_folder}/notification-template.js"></script>
	<script src="${javascript_folder}/multiselect-and-filters-template.js"></script>
	<script src="${javascript_folder}/slider-draggable.js"></script>
	<script src="${javascript_folder}/cropper.min.js"></script>

	<#--<script type="text/javascript">
		// handle the noconflict designation, use namespace dnjq for DN's jQ.
		$ = jQuery.noConflict(true);
	</script>-->
	<!-- Include Leaflet CSS -->
	<link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
	<!-- Include Leaflet JS -->
	<script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>

	<!-- Include Leaflet Geosearch CSS -->
	<link rel="stylesheet" href="https://unpkg.com/leaflet-geosearch/dist/geosearch.css" />
	<!-- Include Leaflet Geosearch JS -->
	<script src="https://unpkg.com/leaflet-geosearch/dist/bundle.min.js"></script>
</head>

<body class="${css_class}">

<#-- <@liferay_ui["quick-access"] contentId="#main-content" /> -->

<@liferay_util["include"] page=body_top_include />

<div class="d-flex flex-column min-vh-100">
	<@liferay.control_menu />

	<div class="d-flex flex-column flex-fill position-relative" id="wrapper">
	<header id="banner" role="banner">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</div>
		</div>

		<#if !is_signed_in && show_sign_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>

		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>

	<section id="content">
		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language_format
				arguments='<a href="http://www.liferay.com" rel="external">Liferay</a>'
				key="powered-by-x"
			/>
		</p>
	</footer>
	</div>
</div>

<@liferay_util["include"] page=body_bottom_include />
<@liferay_util["include"] page=bottom_include />

<!-- Include - Notification -->
<#include "./modals.ftl">
<!-- Include - Notification -->
<#include "./notifications.ftl">
<!-- Include - Multiselect with tags  -->
<#include "./multiselect-and-filters.ftl">

</body>

</html>
