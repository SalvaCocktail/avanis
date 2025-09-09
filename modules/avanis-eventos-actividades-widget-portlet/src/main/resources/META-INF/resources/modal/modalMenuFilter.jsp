<%@ include file="/init.jsp" %>

<!-- modal menu -->
<div id="<portlet:namespace />modal-menu" class="av-modal--menu modal micromodal-slide" aria-hidden="true" style="overflow: hidden">
  <div class="modal__overlay" tabindex="-1" data-micromodal-close style="position: unset;">
    <div class="modal__container" role="dialog" aria-modal="true" aria-labelledby="modal-1-title" style="padding: unset;">
      <main class="modal__content" id="<portlet:namespace />modal-menu-content" style="min-height: unset;padding-top: unset;">
        <img src="<%=request.getContextPath()%>/images/IconFilterIntereses.png">
        <span class="av-micro_modal--menu-text">
				<liferay-ui:message	key="event.widget.filter.modal.title"/>
				</span>
      </main>
    </div>
  </div>
</div>