function ajaxFilterEvents(portletNameSpace, filterUrl, selectedValuesGlobal) {
    calendarBookingIdsArray;
    $('.success2').css('display','none');
    $('.error').css('display','none');

    if (!selectedValuesGlobal) {
        $('.error').css('display','block');
        $('#<portlet:namespace />modal-menu').removeClass('is-open');
        $('.error').html('Por favor importa un archivo excel: .xlsx, .xlsm, .xls unicamente.').fadeIn('slow');
    } else {
        $('.error').css('display','none');
        // Crear un objeto que contenga ambos arrays
        var dataToSend = {
            selectedValuesGlobal: selectedValuesGlobal,
            calendarBookingIdsArray: calendarBookingIdsArray
        };

        $.ajax({
            contentType: 'application/json',
            processData: false,
            data: JSON.stringify(dataToSend),
            type: 'POST',
            url: filterUrl,

            error: function (jqXHR, textStatus, errorThrown) {
                $(".error").html(errorThrown).fadeIn('slow');

            }
                }).fail(function() {
                    alert( "error" );
                    $('#success').css("display","none");
                    $('.error').css("display","block");
                    $('#<portlet:namespace />modal-menu').removeClass('is-open');
                }).done(function (data) {

                $('.error').css('display','none');
                //borro el contenido del div
                    $('.success').empty();
                    console.log("calendarBookingIdsArray "+calendarBookingIdsArray);

            //console.log(data);  // Esto imprimirá todo el JSON recibido en la consola

            // Aquí puedes recorrer el array de eventos JSON para mostrar los detalles en la página
            var htmlContent = ''; // Variable para construir el contenido HTML dinámicamente
            var monthAbbreviations = {
                1: "ENE",
                2: "FEB",
                3: "MAR",
                4: "ABR",
                5: "MAY",
                6: "JUN",
                7: "JUL",
                8: "AGO",
                9: "SEP",
                10: "OCT",
                11: "NOV",
                12: "DIC"
            };

            if (!data || data.length === 0 || (typeof data === 'object' && Object.keys(data).length === 0)) {
                $('.error').css('display','block');

            } else {
                $('.error').css('display','none');
            }

            // Suponiendo que 'data' es tu jsonBookingFiltered recibido del servidor
            data.forEach(function(event) {
                // Construcción de las partes del HTML para cada evento
                var bookingContainerStart = '<div class="av-pe__content">';
                var bookingEventStart = '<div class="av-pe__event">';
                var bookingCalendarStart = '<div class="av-pe__event-calendar">';
                var bookingMonth = '<div class="av-pe__calendar-month" id="booking-month">' + monthAbbreviations[event.startTimeMonth] + '</div>';
                var bookingDay = '<div class="av-pe__calendar-day" id="day"><b>' + event.startTimeDay + '</b></div>';
                var bookingCalendarEnd = '</div>'; // cierra av-pe__event-calendar

                var bookingTextStart = '<div class="av-pe__event-text">';
                var bookingTitle = '<div class="av-pe__event-title" id="title">' + event.title + '</div>';
                var bookingDescription = '<div class="booking-description" id="booking-description">' + event.description + '</div>';

                // Obtener la duración del evento
                var bookingDuration = '<div class="av-pe__event-date" id="booking-duration">'
                    + 'Del ' + event.startTimeDay + ' al ' + event.endTimeDay + ' de ' + monthAbbreviations[event.startTimeMonth] + ' de ' + event.endTimeYear
                    + '</div>';

                var bookingLocation = '<div class="av-pe__event-location" id="booking-location">' + event.location + '</div>';
                var bookingTextEnd = '</div>'; // cierra av-pe__event-text
                var bookingEventEnd = '</div>'; // cierra av-pe__event
                var bookingContainerEnd = '</div>'; // cierra av-pe__content

                // Concatenar todas las partes en htmlContent
                htmlContent += bookingContainerStart;
                htmlContent += bookingEventStart;
                htmlContent += bookingCalendarStart + bookingMonth + bookingDay + bookingCalendarEnd;
                htmlContent += bookingTextStart + bookingTitle + bookingDuration + bookingLocation + bookingDescription + bookingTextEnd;
                htmlContent += bookingEventEnd;
                htmlContent += bookingContainerEnd;
            });

            // Inyectar el contenido en el div de éxito
            $('#success').html(htmlContent);
        });
    }
}




