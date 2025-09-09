<%@ include file="../../init.jsp"%>


	<div class="av-modal-all-events-container modal-s micromodal-slide" id="<portlet:namespace />modal-allEvents" aria-hidden="true">

		<div class="av-modal-all-events__content">
			<div class="av-list-events-left">
				<jsp:include page="/META-INF/resources/modal/allEventsModal/calendar.jsp"></jsp:include>
			</div>
			<div class="av-list-events-right">
				<div class="av-modal-all-events__header">
					<header>
						<button class="modal__close" aria-label="Close modal" data-micromodal-close="">
							<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" clip-rule="evenodd" d="M1.05752 1.05752C1.57822 0.536817 2.42244 0.536817 2.94313 1.05752L10.0003 8.11471L17.0575 1.05752C17.5782 0.536817 18.4224 0.536817 18.9431 1.05752C19.4638 1.57822 19.4638 2.42244 18.9431 2.94313L11.8859 10.0003L18.9431 17.0575C19.4638 17.5782 19.4638 18.4224 18.9431 18.9431C18.4224 19.4638 17.5782 19.4638 17.0575 18.9431L10.0003 11.8859L2.94313 18.9431C2.42244 19.4638 1.57822 19.4638 1.05752 18.9431C0.536817 18.4224 0.536817 17.5782 1.05752 17.0575L8.11471 10.0003L1.05752 2.94313C0.536817 2.42244 0.536817 1.57822 1.05752 1.05752Z" fill="#101717"/>
							</svg>
						</button>
					</header>
				</div>
				<jsp:include page="/META-INF/resources/modal/allEventsModal/allEventList.jsp"></jsp:include>

			</div>
		</div>
	</div>

<script>
	var selectedValuesGlobal = [];
	$(document).ready(function() {
		// Array global para almacenar los valores seleccionados.

		let calendar = $('#<portlet:namespace />allEventsCalendar');
		let eventList = $('#<portlet:namespace />allEventsList');
		//let modalMenuId = $('#<portlet:namespace />modal-menu').attr("id");
		//let modalPreference = $('#<portlet:namespace />modal-event-preferences');
		//let modalPreferencesId = $('#<portlet:namespace />modal-event-preferences').attr("id");

		//open-close micromodal menu
		/*modalIconDots.on('click', function() {
			if(modalMenu.hasClass( "is-open" )){
				MicroModal.close(modalMenuId);
			}else	{
				MicroModal.show(modalMenuId);
			}
		});

		//open-close micromodal filters
		modalMenu.on('click', function() {
			if(modalPreference.hasClass( "is-open" )){
				MicroModal.close(modalPreferencesId);
			}else	{
				MicroModal.show(modalPreferencesId);
			}
		});*/

	});


</script>