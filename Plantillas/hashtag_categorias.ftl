
<#assign categoryEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryLocalService")>
<#if request.getParameter("category") ??>
<#assign categoryParameterValues = request.getParameterValues("category") >
<script>
window.onload = () => {
document.querySelector('.portlet-search-bar form').addEventListener('submit', function(e) {
e.preventDefault();
if (document.querySelector('.portlet-search-bar form input[name="q"]').value.length > 0){
<#list categoryParameterValues as categoryParameterValue>
var inputCategoryParameter = document.createElement("input");
inputCategoryParameter.setAttribute('type', 'hidden');
inputCategoryParameter.setAttribute('name', 'category');
inputCategoryParameter.setAttribute('value', ${categoryParameterValue});
						 	 var c = document.querySelector('.portlet-search-bar form');
						 	 c.appendChild(inputCategoryParameter);
			 	 	 	 </#list>
	 	 	 	 	 }
	 	 	 	 	 document.querySelector('.portlet-search-bar form').submit();
			 	 });
			 }
		</script>
</#if>
<#if request.getParameter("categoryPage") ??>
	<#assign
		curEntryCategory = request.getParameter("categoryPage")
		categoryEntry_ = categoryEntryLocalService.getCategory(curEntryCategory?number)
		categoryEntryName_ = categoryEntry_.getName()
	/>
		<div>
				<p>
						<h2>#${categoryEntryName_}<h2>
				</p>
		</div>
</#if>
