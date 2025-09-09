<%@ include file="/init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

<h4>Comparte en tus redes sociales</h4>
<!-- Incluye la biblioteca de Font Awesome para los iconos -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">


<h1><liferay-ui:message key="share-page" /></h1>

<div class="share-buttons">
	<!-- Botón para compartir en whatsapp -->
	<a href="#" id="whatsapp-share" title="Compartir en Whatsapp">
		<i class="fab fa-whatsapp"></i>
	</a>

	<!-- Botón para compartir en LinkedIn -->
	<a href="#" id="linkedin-share" title="Compartir en LinkedIn">
		<i class="fab fa-linkedin-in"></i>
	</a>

	<!-- Botón para compartir en Facebook -->
	<a href="#" id="facebook-share" title="Compartir en Facebook">
		<i class="fab fa-facebook"></i>
	</a>

	<!-- Botón para compartir en Twitter -->
	<a href="#" id="twitter-share" title="Compartir en Twitter">
		<i class="fab fa-x-twitter"></i>
	</a>
</div>
<div class="av-ac-mp__share__link">
	<span class="av-ac-mp__label">Si lo prefieres, envía el enlace</span>

	<aui:input
			id="enlaceInput"
			name="enlace"
			type="text"
			label=""
			max="20"
			min="5"
			value=""
			disabled="true"
			placeholder=""
			cssClass="form-control av-ac-mp__input av-ac-mp__email-input av-ac-mp__enlace"
	/>

	<div class="div-copiar-enlace">
	<img class="clone-text" src="<%=request.getContextPath()%>/icons/clone.svg" alt="clone-text" />
	<p class="compartir-copiar-enlace" id="copyLinkButton">Copiar enlace</p>
	</div>
	</div>

<div id="notification-link-copiado" class="notification-link-copiado" style="display: none;">Enlace copiado</div>

<script>
	// URL que deseas compartir
	var urlToShare = "${url}";
	var textToShare = encodeURIComponent("<liferay-ui:message key="share-title" />");

	// Darle valor a Copiar enlace
	$(".av-ac-mp__enlace").val(urlToShare);

	// Compartir en LinkedIn
	document.getElementById("linkedin-share").onclick = function() {
		var encodedUrl = encodeURIComponent(urlToShare);
		window.open('https://www.linkedin.com/shareArticle?mini=true&url=' + encodedUrl, '_blank', 'width=600,height=400');
		return false;
	};

	// Compartir en Facebook
	document.getElementById("facebook-share").onclick = function() {
		window.open('https://www.facebook.com/sharer/sharer.php?u=' + urlToShare, '_blank', 'width=600,height=400');
		return false;
	};

	// Compartir en Twitter
	document.getElementById("twitter-share").onclick = function() {
		window.open('https://twitter.com/intent/tweet?url=' + urlToShare + '&text=' + textToShare, '_blank', 'width=600,height=400');

		return false;
	};

	// Compartir en WhatsApp
	document.getElementById("whatsapp-share").onclick = function() {
		var whatsappUrl = "https://api.whatsapp.com/send?text=" + encodeURIComponent("¡Mira este increíble sitio web!" + " " + urlToShare);
		window.open(whatsappUrl, '_blank');
		return false;
	};

	$("#copyLinkButton").on("click", function () {
            const enlaceInput = $("#<portlet:namespace/>enlaceInput");
            enlaceInput.prop("disabled", false);  // Enable input temporarily to select text
            enlaceInput.select();
            document.execCommand("copy");
            enlaceInput.prop("disabled", true);   // Re-disable input after copying
		// Mostrar la notificación
		const notification = $("#notification-link-copiado");
		notification.fadeIn(400).delay(1500).fadeOut(600);
        });

</script>
