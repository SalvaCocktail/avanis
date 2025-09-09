<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title}</title>

	<@liferay_util["include"] page=top_head_include />

	<#--<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />

	<script src="${javascript_folder}/jquery-3.6.0.min.js"></script>
	<script src="${javascript_folder}/bootstrap.min.js"></script>
	<script src="${javascript_folder}/select2.min.js"></script>
	<script src="${javascript_folder}/micromodal.min.js"></script>-->

	<script type="text/javascript">
		// handle the noconflict designation, use namespace dnjq for DN's jQ.
		$ = jQuery.noConflict(true);
	</script>
</head>

<body class="bg-white portal-popup ${css_class}">

<@liferay_util["include"] page=content_include />

<@liferay_util["include"] page=bottom_ext_include />

</body>

</html>