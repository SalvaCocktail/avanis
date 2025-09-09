<#-- Intentar obtener el parámetro "eventTitle" desde la solicitud -->
<#assign eventTitleParam = "" />
<#if themeDisplay.getRequest()??>
    <#assign httpServletRequest = themeDisplay.getRequest() />
    <#if httpServletRequest.getParameter("eventTitle")??>
        <#assign eventTitleParam = httpServletRequest.getParameter("eventTitle") />
    </#if>
</#if>

<#-- Verificar si el eventTitleParam está presente -->
<#if eventTitleParam?has_content>

<#-- Reemplazar guiones por espacios en el título del evento -->
    <#assign eventTitleParam = eventTitleParam?replace("-", " ") />

<#-- Obtener el servicio de CalendarBookingLocalService -->
    <#assign calService = serviceLocator.findService("com.liferay.calendar.service.CalendarBookingLocalService") />

<#-- Obtener la lista de eventos -->
    <#assign eventList = calService.getCalendarBookings(-1, -1) />

<#-- Filtrar la lista para encontrar el evento que coincide con el título -->
    <#assign filteredEvents = eventList?filter(event -> event.getTitle(locale)?lower_case == eventTitleParam?lower_case) />

<#-- Validar si hay eventos filtrados -->
    <#if filteredEvents?has_content>
        <#assign eventId = filteredEvents?first.getCalendarBookingId() />

    <#-- Obtener el servicio AssetEntryLocalService para obtener la entrada del evento -->
        <#assign assetEntryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
        <#assign assetEntry = assetEntryService.getEntry("com.liferay.calendar.model.CalendarBooking", eventId) />

    <#-- Obtener el servicio de AssetCategoryLocalService para obtener las categorías -->
        <#assign assetCategoryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryLocalService") />

    <#-- Obtener el classNameId utilizando ClassNameLocalService -->
        <#assign classNameLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.ClassNameLocalService") />
        <#assign classNameId = classNameLocalService.getClassNameId("com.liferay.calendar.model.CalendarBooking") />

    <#-- Obtener las categorías asociadas al evento usando classNameId y entryId -->
        <#assign categories = assetCategoryService.getCategories(classNameId, assetEntry.getClassPK()) />

    <#-- Validar si hay categorías asociadas -->
        <#if categories?has_content>
            <ul>
                <#list categories as category>
                    <li>${category.getName()}</li>
                </#list>
            </ul>
        <#else>
            <p>No hay categorías asociadas a este evento.</p>
        </#if>

    <#-- Obtener servicios para las nuevas entidades Protagonist y Sponsor -->
        <#assign sponsorLocalService = serviceLocator.findService("avanis.calendarbooking.sb.service.SponsorLocalService") />
        <#assign protagonistLocalService = serviceLocator.findService("avanis.calendarbooking.sb.service.ProtagonistLocalService") />

        <#assign event = calService.getCalendarBooking(eventId) />

        <#if event??>
            <div class="av-event-details">
                <h1>${event.getTitle(locale)}</h1>
                <p>${event.getDescription(locale)}</p>

                <#-- Mostrar fechas y horas -->
                <#assign startTime = event.getStartTime() />
                <#assign endTime = event.getEndTime() />

                <#assign startDate = startTime?number_to_date />
                <#assign endDate = endTime?number_to_date />

                <#assign startDateFormatted = startDate?string("EEEE d 'de' MMMM") />
                <#assign endDateFormatted = endDate?string("EEEE d 'de' MMMM") />

                <#assign startTimeFormatted = startDate?string("HH:mm") />
                <#assign endTimeFormatted = endDate?string("HH:mm") />

                <p>
                    Fecha: De ${startDateFormatted} a ${endDateFormatted} <br>
                    Hora: ${startTimeFormatted} - ${endTimeFormatted}
                </p>

                <p>Ubicación: ${event.getLocation()}</p>

                <#-- Obtener los archivos adjuntos asociados al evento -->
                <#assign assetEntry = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService").getEntry("com.liferay.calendar.model.CalendarBooking", eventId) />
                <#assign assetLinks = serviceLocator.findService("com.liferay.asset.link.service.AssetLinkLocalService").getDirectLinks(assetEntry.getEntryId()) />

                <#if assetLinks?? && (assetLinks?size > 0)>
                    <h2>Archivos Adjuntos</h2>
                    <ul>
                        <#list assetLinks as assetLink>
                            <#assign fileAssetEntry = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService").getEntry(assetLink.getEntryId2()) />
                            <#assign fileEntry = serviceLocator.findService("com.liferay.document.library.kernel.service.DLAppLocalService").getFileEntry(fileAssetEntry.getClassPK()) />

                            <#if fileEntry?? && (fileEntry.getFileEntryId()??) && (fileEntry.getMimeType()??)>
                                <li>
                                    <a href="/documents/${fileEntry.getGroupId()}/${fileEntry.getUuid()}/${fileEntry.getFileName()}?download=true">${fileEntry.getFileName()}</a>
                                </li>
                            <#else>
                                <li>
                                    <p>El archivo no está disponible o no es válido.</p>
                                </li>
                            </#if>
                        </#list>
                    </ul>
                <#else>
                    <p>No hay archivos adjuntos para este evento.</p>
                </#if>

                <#-- Obtener los BookingAgenda relacionados -->
                <#-- <#assign bookingAgendaService = serviceLocator.findService("avanis.calendarbooking.sb.service.BookingAgendaLocalService") />
                 <#assign bookingAgendas = bookingAgendaService.getBookingAgendasByCalendarBookingId(eventId) />

                 <#if bookingAgendas?has_content>
                     <h2>Agendas</h2>
                     <ul>
                         <#list bookingAgendas as bookingAgenda>
                             <li>
                                 <strong>${bookingAgenda.getTitle()}</strong>: ${bookingAgenda.getDescription()}
                                 <br>Hora: ${bookingAgenda.getStartHour()} - ${bookingAgenda.getEndHour()}
                             </li>
                         </#list>
                     </ul>
                 <#else>
                     <p>No hay agendas registradas para este evento.</p>
                 </#if>-->

                <h2>Protagonistas</h2>
                <#assign protagonistLocalService = serviceLocator.findService("avanis.calendarbooking.sb.service.ProtagonistLocalService") />
                <#assign protagonists = protagonistLocalService.getProtagonistsByCalendarBookingId(eventId) />
                <#if protagonists?has_content>
                    <ul id="protagonist-list">
                        <#list protagonists as protagonist>
                            <li class="protagonist <#if (protagonist_index > 1)>hidden-protagonist</#if>">
                                ${protagonist.getName()} ${protagonist.getLastName()}<br>
                                ${protagonist.getProfession()}<br>
                                ${protagonist.getBio()}<br>
                                <#-- Mostrar la imagen del protagonista -->
                                <#assign imageUrl = protagonist.getPortraitUrl() />
                                <#if imageUrl?has_content>
                                    <a href="${imageUrl}">${protagonist.getName()}</a>
                                </#if>
                            </li>
                        </#list>
                    </ul>

                    <!-- Botón para mostrar más -->
                    <#if (protagonists?size > 2)>
                        <button id="show-more-protagonists" onclick="showAllProtagonists()">Mostrar todos los protagonistas</button>
                    </#if>

                <#else>
                    <p>No hay protagonistas registrados para este evento.</p>
                </#if>

                <h2>Patrocinadores</h2>
                <#assign sponsorLocalService = serviceLocator.findService("avanis.calendarbooking.sb.service.SponsorLocalService") />
                <#assign sponsors = sponsorLocalService.getSponsorsByCalendarBookingId(eventId) />
                <#if sponsors?has_content>
                    <ul id="sponsor-list">
                        <#list sponsors as sponsor>
                            <li class="sponsor <#if (sponsor_index > 14)>hidden-sponsor</#if>">
                                ${sponsor.getName()}<br>
                                <#assign imageUrl = sponsor.getIconUrl() />
                                <#if imageUrl?has_content>
                                    <a href="${imageUrl}">${sponsor.getName()}</a>
                                </#if>
                            </li>
                        </#list>
                    </ul>

                    <!-- Botón para mostrar más -->
                    <#if (sponsors?size > 15)>
                        <button id="show-more-sponsors" onclick="showAllSponsors()">Mostrar todos los patrocinadores</button>
                    </#if>

                <#else>
                    <p>No hay patrocinadores registrados para este evento.</p>
                </#if>

            </div>
        <#else>
            <p>El evento no se ha encontrado.</p>
        </#if>
    <#else>
        <p>Evento con título '${eventTitleParam}' no encontrado.</p>
    </#if>
<#else>
    <p>Página detalle evento vacía.</p>
</#if>


<script>
    function showAllProtagonists() {
        var hiddenProtagonists = document.querySelectorAll('.hidden-protagonist');
        hiddenProtagonists.forEach(function(protagonist) {
            protagonist.classList.remove('hidden-protagonist');
        });
        document.getElementById('show-more-protagonists').style.display = 'none';
    }

    function showAllSponsors() {
        var hiddenSponsors = document.querySelectorAll('.hidden-sponsor');
        hiddenSponsors.forEach(function(sponsor) {
            sponsor.classList.remove('hidden-sponsor');
        });
        document.getElementById('show-more-sponsors').style.display = 'none';
    }
</script>


<style>
    .hidden-protagonist {
        display: none;
    }
    .hidden-sponsor {
        display: none;
    }
</style>