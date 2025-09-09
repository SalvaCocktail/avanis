<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:actionURL var="downloadUserDataURL" name="downloadUserData"/>

<portlet:resourceURL var="tabsURL">
    <portlet:param name="mvc.command.name" value="getTab"/>
</portlet:resourceURL>

<div class="av-main__header">
    <img class="go-to-menu" onClick="displayMenu()" class="mr-2"
         src="<%=request.getContextPath()%>/images/arrow-left.png" alt="arrow left"/>
    <h2>Administra tu cuenta</h2>
</div>
<div class="administrar-mi-cuenta">


    <form method="post" cssClass="av-form-my-account" onSubmit="downloadDataForm(this);false;" name="fma"
          enctype="multipart/form-data">
        <input type="hidden" value="userData" name="tab"/>

        <section>

            <h3>Acceso y descarga de tu información</h3>
            <p>Accede a todos tus datos de forma sencilla descargando un archivo que incluye tus publicaciones, fotos,
                configuraciones de privacidad y más. Dándote acceso a la descarga de tu información, nos aseguramos de
                que tienes el poder de gestionar y controlar tu presencia en nuestra plataforma de una manera fácil y
                transparente.</p>
            <div class="av-info-box">
                <div class="av-info-box-icon">
                <span class="icono-descargar">
                    <img src="<%=request.getContextPath()%>/images/ico-file.png">
                </span></div>
                <div>${fileName}</div>
                <div class="av-buttons-center">
                    <button type="submit" value="userData">Descargar documentos</button>
                </div>
            </div>
            <h3>Desactiva tu cuenta</h3>
            <p>Si has decidido dejar de formar parte de Avanis, solo tienes que enviarnos correo electrónico a <a class="link-avanis"
                    href="mailto:soporte@avanis.es">soporte@avanis.es</a> añadiendo un asunto con la palabra “Baja”. A
                continuación, recibirás una confirmación de que lo hemos recibido y nuestro equipo se encargará de
                procesar tu solicitud de manera rápida y sin complicaciones. Y si alguna vez decides regresar, estaremos
                aquí con los brazos abiertos. ¡Gracias por ser parte de nuestra comunidad!</p>
        </section>

    </form>
</div>


<script>
    function downloadDataForm(form) {
        let formData = $(form).serialize();

        $.ajax({
            url: '${tabsURL}',
            type: 'GET',
            data: formData,
            xhrFields: {
                responseType: 'blob'
            },
            success: function (data) {
                var blob = new Blob([data], {type: 'application/zip'});

                // Crear un URL de objeto para el Blob
                var url = window.URL.createObjectURL(blob);

                // Crear un enlace para la descarga
                var a = document.createElement('a');
                a.style.display = 'none';
                a.href = url;
                a.download = '${fileName}'; // Puedes cambiar el nombre del archivo

                // Añadir el enlace al documento y simular el clic
                document.body.appendChild(a);
                a.click();

                // Limpiar el URL del objeto para liberar memoria
                window.URL.revokeObjectURL(url);
                document.body.removeChild(a);


            },
            error: function (xhr, status, error) {
                console.error('Error en la petición AJAX:', error);
            }
        });
        return false;
    }
</script>