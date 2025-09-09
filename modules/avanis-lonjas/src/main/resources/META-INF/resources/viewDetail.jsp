<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ include file="/init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>

<script src="/o/avanis-v2-theme/js/emoji-mart/emoji-mart-5.6.0.browser.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<div class="modal-respuestaposts3">
	<div id="respuestawysiwig3" class="av-te-ma-modal alertModal" style="display: none;">
		<div class="av-te-ma-modal__panel">
			<div class="av-te-ma-modal__header">
				<h5 class="modal-title" id="exampleModalLabel3">Editar comentario</h5>
				<span id="closeModal3" class="av-icon-close">&times;</span>
			</div>
			<div class="av-te-ma-modal__content">
				<!-- Editor WYSIWYG -->
				<div class="input-container">
					<div id="editable3" contenteditable="true" placeholder="Escribe algo"></div>
					<div class="toolbar3">
                            <span class="icon smiley" data-target="#emote-menu3"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
<path fill-rule="evenodd" clip-rule="evenodd" d="M12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4ZM2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM7.85 9.3C7.85 8.49919 8.49919 7.85 9.3 7.85C10.1008 7.85 10.75 8.49919 10.75 9.3C10.75 10.1008 10.1008 10.75 9.3 10.75C8.49919 10.75 7.85 10.1008 7.85 9.3ZM13.25 9.3C13.25 8.49919 13.8992 7.85 14.7 7.85C15.5008 7.85 16.15 8.49919 16.15 9.3C16.15 10.1008 15.5008 10.75 14.7 10.75C13.8992 10.75 13.25 10.1008 13.25 9.3ZM9.19955 13.1994C9.19954 13.1994 9.19955 13.1994 9.19955 13.1994L9.19836 13.1978L9.19718 13.1963L9.19621 13.195C9.1962 13.195 9.19634 13.1952 9.19665 13.1956C9.19718 13.1962 9.19801 13.1975 9.19955 13.1994C9.20434 13.2054 9.21413 13.2175 9.22838 13.2345C9.25694 13.2685 9.30383 13.3223 9.36808 13.3893C9.49741 13.5243 9.69219 13.7078 9.94442 13.8913C10.4527 14.2609 11.1505 14.6 12 14.6C12.8495 14.6 13.5473 14.2609 14.0556 13.8913C14.3078 13.7078 14.5026 13.5243 14.6319 13.3893C14.6962 13.3223 14.7431 13.2685 14.7716 13.2345C14.7859 13.2175 14.7955 13.2056 14.8002 13.1995C14.8018 13.1975 14.8029 13.1962 14.8034 13.1955C15.1356 12.7576 15.7597 12.6698 16.2 13C16.6418 13.3314 16.7314 13.9582 16.4 14.4L15.6411 13.8308C16.4 14.4 16.3998 14.4003 16.3995 14.4006L16.399 14.4013L16.3979 14.4028L16.3952 14.4063L16.3883 14.4153C16.383 14.4222 16.3764 14.4308 16.3683 14.4409C16.3523 14.4612 16.3306 14.488 16.3036 14.5202C16.2495 14.5846 16.1734 14.6715 16.0759 14.7732C15.8818 14.9757 15.5984 15.2422 15.2319 15.5087C14.5027 16.0391 13.4005 16.6 12 16.6C10.5995 16.6 9.49727 16.0391 8.76808 15.5087C8.40156 15.2422 8.11821 14.9757 7.92411 14.7732C7.82664 14.6715 7.75048 14.5846 7.69643 14.5202C7.66937 14.488 7.64775 14.4612 7.63166 14.4409C7.62362 14.4308 7.61695 14.4222 7.61167 14.4153L7.60479 14.4063L7.60214 14.4028L7.601 14.4013L7.60048 14.4006C7.60024 14.4003 7.60001 14.4 8.35214 13.8359L7.6 14.4C7.26863 13.9582 7.35817 13.3314 7.8 13C8.24034 12.6697 8.86441 12.7576 9.19665 13.1956M9.19955 13.1994C9.19954 13.1994 9.19955 13.1994 9.19955 13.1994V13.1994Z" fill="#101717"/>
</svg>
</span>
						<span class="icon user d-none" data-target="#user-menu">👤</span>
						<span class="icon hashtag d-none" data-target="#hashtag-menu">#️⃣</span>
						<span class="icon format" data-target="#format-menu3"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
<path fill-rule="evenodd" clip-rule="evenodd" d="M3 21C3 20.4477 3.44772 20 4 20H20C20.5523 20 21 20.4477 21 21C21 21.5523 20.5523 22 20 22H4C3.44772 22 3 21.5523 3 21Z" fill="#101717"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M11.19 4.59741L9.4707 11.5999H14.5293L12.81 4.59741L12.8091 4.59413C12.8077 4.58876 12.8048 4.57835 12.8004 4.5636C12.7915 4.53396 12.7769 4.48783 12.7559 4.43087C12.713 4.31435 12.6485 4.16595 12.5614 4.02398C12.3731 3.71728 12.188 3.59998 12 3.59998C11.812 3.59998 11.6269 3.71728 11.4386 4.02398C11.3515 4.16595 11.287 4.31435 11.2441 4.43087C11.2231 4.48783 11.2085 4.53396 11.1996 4.5636C11.1952 4.57835 11.1923 4.58876 11.1909 4.59413L11.19 4.59741ZM14.9221 13.1999H9.07785L8.0481 17.3938C7.94286 17.8225 7.51628 18.0831 7.09532 17.9759C6.67435 17.8688 6.4184 17.4344 6.52364 17.0058L9.6664 4.20595L10.4285 4.39994C9.6664 4.20595 9.6664 4.20595 9.6664 4.20595L9.66668 4.2048L9.667 4.2035L9.66776 4.20045L9.66977 4.19256L9.67576 4.16988C9.68064 4.15181 9.68735 4.12785 9.696 4.09884C9.71325 4.04098 9.73849 3.96212 9.77276 3.86908C9.84033 3.6856 9.94772 3.43401 10.1061 3.17599C10.4089 2.68269 11.0095 2 12 2C12.9905 2 13.5911 2.68269 13.8939 3.17599C14.0523 3.43401 14.1597 3.6856 14.2272 3.86908C14.2615 3.96212 14.2868 4.04098 14.304 4.09884C14.3127 4.12785 14.3194 4.15181 14.3242 4.16988L14.3302 4.19256L14.3322 4.20045L14.333 4.2035L14.3333 4.2048C14.3333 4.2048 14.3336 4.20595 13.5714 4.39997L14.3336 4.20595L17.4764 17.0058C17.5816 17.4344 17.3257 17.8688 16.9047 17.9759C16.4837 18.0831 16.0571 17.8225 15.9519 17.3938L14.9221 13.1999Z" fill="#101717"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M9.95616 3.08439C10.2705 2.57228 10.9172 1.82495 11.9992 1.82495C13.0812 1.82495 13.7279 2.57228 14.0422 3.08439C14.2084 3.35505 14.3204 3.61784 14.3907 3.80855C14.4264 3.90549 14.4528 3.98789 14.4709 4.04879C14.48 4.07934 14.4871 4.10476 14.4924 4.1242L14.499 4.14935L14.501 4.15724L14.502 4.16099L14.5024 4.16272C14.5024 4.16266 14.5024 4.16279 14.5024 4.16272C14.5025 4.16314 14.5027 4.16375 14.5028 4.16417L17.6455 16.964C17.773 17.4834 17.4636 18.014 16.9471 18.1455C16.4293 18.2773 15.9089 17.956 15.7811 17.4355L14.7841 13.3748H9.21428L8.21726 17.4355C8.08947 17.956 7.56911 18.2773 7.05135 18.1455C6.53478 18.014 6.22536 17.4834 6.35289 16.964L9.49564 4.16417L9.56962 4.18233C9.56962 4.18235 9.56963 4.18231 9.56962 4.18233L9.49564 4.16417L9.49634 4.16137L9.49719 4.15796L9.49977 4.14782L9.50576 4.12515C9.51101 4.1057 9.51839 4.07934 9.52749 4.04879C9.54565 3.98789 9.57204 3.90549 9.60774 3.80855C9.67798 3.61784 9.79002 3.35505 9.95616 3.08439ZM9.79346 4.41903L6.6928 17.0475C6.60984 17.3853 6.81232 17.7235 7.13769 17.8063C7.46186 17.8888 7.79466 17.6889 7.87735 17.3521L8.9071 13.1581C8.92631 13.0798 8.99648 13.0248 9.07705 13.0248H14.9213C15.0019 13.0248 15.0721 13.0798 15.0913 13.1581L16.1211 17.3521C16.2037 17.6889 16.5365 17.8888 16.8607 17.8063C17.1861 17.7235 17.3886 17.3853 17.3056 17.0475L14.2049 4.41903L13.6137 4.56951C13.5201 4.59336 13.4248 4.53676 13.401 4.44309C13.3771 4.34943 13.4337 4.25417 13.5274 4.23033C13.823 4.15509 14.0038 4.10888 14.1143 4.08052C14.1003 4.03685 14.083 3.98595 14.0622 3.92951C13.9973 3.75326 13.8946 3.51287 13.744 3.26749C13.4527 2.793 12.8982 2.17495 11.9992 2.17495C11.1002 2.17495 10.5457 2.793 10.2544 3.26749C10.1038 3.51287 10.0011 3.75326 9.93618 3.92951C9.91533 3.98611 9.898 4.03715 9.88395 4.0809L10.4709 4.2303C10.5645 4.25414 10.6211 4.3494 10.5973 4.44306C10.5735 4.53672 10.4782 4.59332 10.3845 4.56948L9.79346 4.41903ZM14.2843 4.03654C14.2844 4.0365 14.2844 4.0365 14.2843 4.03654V4.03654ZM11.9992 3.77493C11.9 3.77493 11.7615 3.83118 11.587 4.11547C11.5076 4.2448 11.4478 4.382 11.4075 4.4913C11.388 4.54436 11.3745 4.58696 11.3665 4.61356C11.3627 4.62651 11.3602 4.63538 11.3591 4.63948C11.3591 4.63956 11.3591 4.63941 11.3591 4.63948L11.3588 4.64067L9.69306 11.4248H14.3053L12.6396 4.64067C12.6385 4.63668 12.6358 4.62676 12.6319 4.61356C12.624 4.58696 12.6104 4.54436 12.5909 4.4913C12.5506 4.382 12.4908 4.2448 12.4114 4.11547C12.2369 3.83118 12.0984 3.77493 11.9992 3.77493ZM11.2887 3.93238C11.4907 3.60329 11.7223 3.42493 11.9992 3.42493C12.2761 3.42493 12.5077 3.60329 12.7097 3.93238C12.8046 4.087 12.8738 4.24661 12.9193 4.37034C12.9417 4.4312 12.9575 4.48087 12.9673 4.51356C12.9721 4.52984 12.9754 4.54171 12.9773 4.54844L12.9792 4.55562L14.6985 11.5581C14.7113 11.6103 14.6994 11.6655 14.6662 11.7078C14.633 11.7501 14.5823 11.7748 14.5285 11.7748H9.4699C9.41614 11.7748 9.36536 11.7501 9.33219 11.7078C9.29901 11.6655 9.28713 11.6103 9.29994 11.5581L11.0201 4.55241L11.021 4.54914C11.0228 4.54241 11.0263 4.52984 11.0311 4.51356C11.0409 4.48087 11.0567 4.4312 11.0791 4.37034C11.1246 4.24661 11.1938 4.087 11.2887 3.93238Z" fill="#101717"/>
</svg>
</span>
					</div>


					<!-- Menús -->
					<div class="menu" id="emote-menu3" style="display:none;"></div>
					<div class="menu" id="user-menu3" style="display:none;">Usuarios</div>
					<div class="menu" id="hashtag-menu3" style="display:none;">Hashtags</div>
					<div class="menu" id="format-menu3" style="display:none;">
						<button data-cmd="bold"><b>B</b></button>
						<button data-cmd="italic"><i>I</i></button>
						<button data-cmd="underline"><u>U</u></button>
						<button data-cmd="strikeThrough"><s>S</s></button>
					</div>
				</div>
				<!-- Botón de envío -->
				<button id="sendButton3" class="send-button">
					<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path d="M2 21L23 12L2 3V10L17 12L2 14V21Z" fill="currentColor"/>
					</svg>
				</button>
				<div id="botones-nuevo-comentario">
					<button type="submit" id="cancelar" class="av-theme__btn av-theme__btn--secondary">
						Cancelar</button>
					<button type="submit" id="messageUpdateButton3" class="av-theme__btn av-theme__btn--primary">
						Publicar</button>
				</div>

			</div>
		</div>
	</div>
</div>
<div class="modal-seguidores">
	<div id="alertModal" class="av-te-ma-modal alertModal">
		<div class="av-te-ma-modal__panel">
			<div class="av-te-ma-modal__header">
				<h5 class="modal-title" id="exampleModalLabel">Ver este producto</h5>
				<span class="av-icon-close">&times;</span>
			</div>
			<div class="av-te-ma-modal__content">
				<div class="av-te-ma-modal__text">
					<span class="av-te-ma-modal__text-title"><strong>Crea tu cuenta gratis o inicia sesión para ver este producto</strong></span>
					<span id="modal-description">¿Ya eres miembro?
                        <a href="/login"><span id="iniciar-sesion-link">Inicia sesión</span></a>
                    </span>
				</div>
				<!-- Accede con google -->
				<div class="my-3 av-form-content">
					<div class="av-social-login">
						<div>
							<div class="av-social-login-google">
								<a
										href="${urlsessionGoogle}"
										class="google mb-2 undefined btn-100x100 btn-social-google"
								>
									<svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
										<g fill="#000" fill-rule="evenodd">
											<path d="M9 3.48c1.69 0 2.83.73 3.48 1.34l2.54-2.48C13.46.89 11.43 0 9 0 5.48 0 2.44 2.02.96 4.96l2.91 2.26C4.6 5.05 6.62 3.48 9 3.48z"
												  fill="#EA4335"></path>
											<path d="M17.64 9.2c0-.74-.06-1.28-.19-1.84H9v3.34h4.96c-.1.83-.64 2.08-1.84 2.92l2.84 2.2c1.7-1.57 2.68-3.88 2.68-6.62z"
												  fill="#4285F4"></path>
											<path d="M3.88 10.78A5.54 5.54 0 0 1 3.58 9c0-.62.11-1.22.29-1.78L.96 4.96A9.008 9.008 0 0 0 0 9c0 1.45.35 2.82.96 4.04l2.92-2.26z"
												  fill="#FBBC05"></path>
											<path d="M9 18c2.43 0 4.47-.8 5.96-2.18l-2.84-2.2c-.76.53-1.78.9-3.12.9-2.38 0-4.4-1.57-5.12-3.74L.97 13.04C2.45 15.98 5.48 18 9 18z"
												  fill="#34A853"></path>
											<path fill="none" d="M0 0h18v18H0z"></path>
										</g>
									</svg>
									<span style="padding: 10px 10px 10px 0px; font-weight: 500">Acceder con Google</span>
								</a>
							</div>
						</div>
					</div>
					<p class="mb-2">
						<strong>O si lo prefieres...</strong>
					</p>
					<div class="av-buttons-tipo-registro js-btn-register-email" style="margin-top: 8px; margin-bottom: 24px;">
						<a href="/tipo-registro?fromModal=true">
							<button class="btn av-theme__btn av-theme__btn--primary btn-100x100 btn-secondary"
									id="_avanis_custom_login_AvanisCustomLoginPortlet_INSTANCE_mjei_umzz" type="button"
									label="">
								<span class="lfr-btn-label">Regístrate con tu email</span>
							</button>
						</a>
					</div>
					<div class="seguir-politicas">Al hacer clic en Continuar con Google, aceptas las 
						<a href="condiciones-de-uso"><span
								class="politicas-link">condiciones de uso</span></a> y la <a
								href="/politica-de-privacidad"><span
								class="politicas-link">política de privacidad</span></a> de
						Avanis.
					</div>
				</div>

			</div>
		</div>

	</div>
</div>





<c:if test="${empty primerProducto}">
	<div class="alert alert-success">
		Avanis Detalle Lonjas no está disponible.
	</div>
</c:if>
<c:if test="${not empty primerProducto}">
	<div class="av-lmd">
		<div class="av-lmd__container">
			<div class="lonja-breadcrumb-container"><a href="/lonjas" class="lonja-breadcrumb">Lonjas y mercados</a>
				<p class="lonja-breadcrumb-and">/</p>
				<p class="lonja-breadcrumb-title">${primerProducto.nombreProducto} </p>
			</div>
			<div class="av-lmd__row av-lmd__row--001">
				<h2 class="av-lmd__title-h2">${primerProducto.nombreProducto} en Lonja de ${primerProducto.nombreLonja}</h2>
			</div>

			<div class="av-lmd__row av-lmd__row--002">
				<div class="av-lmd__row-002-block-001">
					<div class="av-theme__icon-box-16">
						<svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd" clip-rule="evenodd" d="M7.99992 1.33337C8.19777 1.33337 8.3854 1.42126 8.51207 1.57325L10.1787 3.57325C10.2786 3.69306 10.3333 3.84408 10.3333 4.00004V7.01296L11.7497 8.14613C11.9079 8.27264 11.9999 8.46419 11.9999 8.66671V13.3334H13.3333V10.3568L12.6301 9.88807C12.3238 9.68384 12.241 9.26993 12.4452 8.96357C12.6495 8.65722 13.0634 8.57444 13.3697 8.77867L14.3697 9.44534C14.5552 9.56898 14.6666 9.77714 14.6666 10V14C14.6666 14.3682 14.3681 14.6667 13.9999 14.6667H1.99992C1.63173 14.6667 1.33325 14.3682 1.33325 14V10C1.33325 9.77714 1.44465 9.56898 1.63012 9.44534L2.63012 8.77867C2.93647 8.57444 3.35038 8.65722 3.55462 8.96357C3.75885 9.26993 3.67607 9.68384 3.36972 9.88807L2.66659 10.3568V13.3334H3.99992V8.66671C3.99992 8.46419 4.09198 8.27264 4.25012 8.14613L5.66659 7.01296V4.00004C5.66659 3.84408 5.72126 3.69306 5.8211 3.57325L7.48777 1.57325C7.61443 1.42126 7.80207 1.33337 7.99992 1.33337ZM5.33325 13.3334H5.99992V11.3334C5.99992 10.2288 6.89535 9.33337 7.99992 9.33337C9.10449 9.33337 9.99992 10.2288 9.99992 11.3334V13.3334H10.6666V8.98712L9.25012 7.85395C9.09198 7.72744 8.99992 7.5359 8.99992 7.33337V4.24141L7.99992 3.04141L6.99992 4.24141V7.33337C6.99992 7.5359 6.90786 7.72744 6.74972 7.85395L5.33325 8.98712V13.3334ZM8.66659 13.3334V11.3334C8.66659 10.9652 8.36811 10.6667 7.99992 10.6667C7.63173 10.6667 7.33325 10.9652 7.33325 11.3334V13.3334H8.66659Z" fill="#646B6B"/>
						</svg>
					</div>
					<span>Lonja de ${primerProducto.nombreLonja}</span>
				</div>
				<div class="av-lmd__row-002-block-002">
					<div class="av-lmd__add-to-favorites">
						<label class="av-lmd__favorites-label">
							<input type="checkbox" <c:if test="${!primerProducto.favorito}"> checked </c:if> onclick="addToFavoriteDetail();" name="favorites" id="av-lmd__favorites-icon" class="js-av-lmd__ad-to-favorites">
							<c:if test="${primerProducto.favorito}">
								<span><liferay-ui:message key="avanis.lonjas.producto.quitar.de.favorito"/></span>
							</c:if>
							<c:if test="${!primerProducto.favorito}">
								<span><liferay-ui:message key="avanis.lonjas.producto.anadir.a.favorito"/></span>
							</c:if>
						</label>
					</div>
					<div class="av-lmd__add-to-plots">
						<div class="av-theme__icon-box-16">
							<svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" clip-rule="evenodd" d="M2.66663 2C2.88953 2 3.09768 2.1114 3.22133 2.29687L4.55466 4.29687C4.62767 4.40638 4.66663 4.53505 4.66663 4.66667V6H5.99996V4.66667C5.99996 4.53505 6.03892 4.40638 6.11193 4.29687L7.44526 2.29687C7.5689 2.1114 7.77706 2 7.99996 2C8.22286 2 8.43102 2.1114 8.55466 2.29687L9.88799 4.29687C9.961 4.40638 9.99996 4.53505 9.99996 4.66667V6H11.3333V4.66667C11.3333 4.53505 11.3723 4.40638 11.4453 4.29687L12.7786 2.29687C12.9022 2.1114 13.1104 2 13.3333 2C13.5562 2 13.7643 2.1114 13.888 2.29687L15.2213 4.29687C15.2943 4.40638 15.3333 4.53505 15.3333 4.66667V13.3333C15.3333 13.7015 15.0348 14 14.6666 14H12C11.6318 14 11.3333 13.7015 11.3333 13.3333V11.3333H9.99996V13.3333C9.99996 13.7015 9.70148 14 9.33329 14H6.66663C6.29844 14 5.99996 13.7015 5.99996 13.3333V11.3333H4.66663V13.3333C4.66663 13.7015 4.36815 14 3.99996 14H1.33329C0.965103 14 0.666626 13.7015 0.666626 13.3333V4.66667C0.666626 4.53505 0.705585 4.40638 0.778592 4.29687L2.11193 2.29687C2.23557 2.1114 2.44372 2 2.66663 2ZM4.66663 10H5.99996V7.33333H4.66663V10ZM3.33329 12.6667H1.99996V4.86852L2.66663 3.86852L3.33329 4.86852V12.6667ZM7.33329 12.6667H8.66663V4.86852L7.99996 3.86852L7.33329 4.86852V12.6667ZM9.99996 7.33333V10H11.3333V7.33333H9.99996ZM12.6666 12.6667H14V4.86852L13.3333 3.86852L12.6666 4.86852V12.6667Z" fill="#107E3E"/>
							</svg>
						</div>
						<span>Añadir a Mi explotación</span>
					</div>
				</div>
			</div>

			<div class="av-lmd__row av-lmd__row--003">
				<h4 class="av-lmd__title-h4">Evolución del precio ${primerProducto.nombreProducto}</h4>
				<!-- Tabs -->
				<div class="tabs-container">
					<ul class="nav nav-tabs" id="graficoTabs" role="tablist">
						<c:if test="${not empty listaMesActual}">
							<li class="nav-item" role="presentation">
								<button class="nav-link active" id="tab-30-dias" data-tab="grafico30Dias" type="button" role="tab">30 días</button>
							</li>
						</c:if>
						<c:if test="${not empty listaTresMeses}">
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="tab-3-meses" data-tab="grafico3Meses" type="button" role="tab">3 meses</button>
							</li>
						</c:if>
						<c:if test="${not empty listaSeisMeses}">
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="tab-6-meses" data-tab="grafico6Meses" type="button" role="tab">6 meses</button>
							</li>
						</c:if>
						<c:if test="${not empty listaDoceMeses}">
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="tab-12-meses" data-tab="grafico12Meses" type="button" role="tab">12 meses</button>
							</li>
						</c:if>
						<c:if test="${not empty listaProductos}">
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="tab-historico" data-tab="graficoHistorico" type="button" role="tab">Histórico</button>
							</li>
						</c:if>
					</ul>

					<!-- Tab Content -->
					<div class="tab-content">
						<c:if test="${not empty listaMesActual}">
							<div class="tab-pane fade show active chart-container" id="grafico30Dias" role="tabpanel">
								<canvas id="grafico30DiasCanvas"></canvas>
							</div>
						</c:if>
						<c:if test="${not empty listaTresMeses}">
							<c:choose>
								<c:when test="${empty listaMesActual}">
									<div class="tab-pane fade show active chart-container" id="grafico3Meses" role="tabpanel">
								</c:when>
								<c:otherwise>
									<div class="tab-pane fade chart-container" id="grafico3Meses" role="tabpanel">
								</c:otherwise>
							</c:choose>
								<canvas id="grafico3MesesCanvas"></canvas>
							</div>
						</c:if>
						<c:if test="${not empty listaSeisMeses}">
							<div class="tab-pane fade chart-container" id="grafico6Meses" role="tabpanel">
								<canvas id="grafico6MesesCanvas"></canvas>
							</div>
						</c:if>
						<c:if test="${not empty listaDoceMeses}">
							<div class="tab-pane fade chart-container" id="grafico12Meses" role="tabpanel">
								<canvas id="grafico12MesesCanvas"></canvas>
							</div>
						</c:if>
						<c:if test="${not empty listaProductos}">
							<div class="tab-pane fade chart-container" id="graficoHistorico" role="tabpanel">
								<canvas id="graficoHistoricoCanvas"></canvas>
							</div>
						</c:if>
					</div>
				</div>
			</div>

			<div class="av-lmd__row av-lmd__row--004">
				<h4 class="av-lmd__title-h4">Última subasta</h4>
				<%@ include file="/card-last-auction.jsp" %>
			</div>

			<div class="av-lmd__row av-lmd__row--004">
				<h4 class="av-lmd__title-h4">Evolución del precio ${primerProducto.nombreProducto} en Lonja de ${primerProducto.nombreLonja}</h4>

				<!-- Mostrar las primeras 4 tarjetas -->
				<div class="cards-container visible-cards">
					<c:forEach var="producto" items="${listaProductos}" varStatus="status">
						<c:if test="${status.count > 1 && status.count <= 5}">
							<%@ include file="/card-detail.jsp" %>
						</c:if>
					</c:forEach>
				</div>

			</div>

			<div class="av-lmd__row av-lmd__row--006">
				<div class="av-theme__btn av-theme__btn--link av-lmd__view-historic-all">Ver Todas</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function () {
			// Seleccionar los tabs y sus contenidos
			const tabs = document.querySelectorAll('.nav-link');
			const tabPanes = document.querySelectorAll('.tab-pane');

			// Añadir eventos a los tabs
			tabs.forEach(tab => {
				tab.addEventListener('click', function () {
					const targetTab = this.getAttribute('data-tab'); // Obtener el target del tab

					// Quitar la clase "active" de todos los tabs y el contenido
					tabs.forEach(t => t.classList.remove('active'));
					tabPanes.forEach(content => content.classList.remove('show', 'active'));

					// Activar el tab clicado y el contenido correspondiente
					this.classList.add('active');
					document.getElementById(targetTab).classList.add('show', 'active');
				});
			});

			// Normalización de precios (S/C usa precioAnterior)
			const normalizePrice = (product) => {
				return product.precio === "S/C"
						? parseFloat(product.precioAnterior.replace(",", "."))
						: parseFloat(product.precio.replace(",", "."));
			};

			// Preparar datos para el gráfico
			const prepareDataForChart = (data) => {
				return data.map((product) => ({
					fecha: new Date(product.fecha).toLocaleDateString("es-ES", {
						day: "2-digit",
						month: "short",
						year: "numeric",
					}), // Mantener formato de fecha
					precio: normalizePrice(product),
					variacionPorcentaje: product.variacionPorcentaje,
				})).reverse();
			};

			// Configurar la gráfica
			const configGrafico = (data, canvasId) => {
				if (data.length === 0) return;

				const preparedData = prepareDataForChart(data); // Usar la función para preparar datos
				const labels = preparedData.map((d) => d.fecha);
				const precios = preparedData.map((d) => d.precio);

				new Chart(document.getElementById(canvasId), {
					type: 'line',
					data: {
						labels: labels,
						datasets: [{
							label: '', // Esto elimina el texto adicional en la parte superior
							data: precios,
							borderColor: '#3cab5a',
							backgroundColor: 'rgba(30, 86, 49, 0.1)',
							pointBackgroundColor: precios.map(p => p === null ? '#E63946' : '#1E5631'),
							pointRadius: 0, // Eliminar puntos completamente
							spanGaps: true,
							borderWidth: 2,
							tension: 0.4
						}]
					},
					options: {
						responsive: true,
						plugins: {
							legend: {
								display: false // Deshabilita la leyenda
							},
							tooltip: {
								enabled: false, // Desactivar el tooltip predeterminado
								external: function (context) {
									// Crear contenedor del tooltip si no existe
									let tooltipEl = document.getElementById('custom-tooltip');
									if (!tooltipEl) {
										tooltipEl = document.createElement('div');
										tooltipEl.id = 'custom-tooltip';
										tooltipEl.style.position = 'absolute';
										tooltipEl.style.background = '#f5f5f5'; // Fondo gris claro
										tooltipEl.style.border = '1px solid #ccc';
										tooltipEl.style.borderRadius = '8px';
										tooltipEl.style.padding = '10px';
										tooltipEl.style.boxShadow = '0px 4px 6px rgba(0, 0, 0, 0.1)';
										tooltipEl.style.pointerEvents = 'none';
										tooltipEl.style.transition = 'opacity 0.2s';
										document.body.appendChild(tooltipEl);
									}

									// Obtener modelo del tooltip
									const tooltipModel = context.tooltip;

									// Ocultar tooltip si no hay datos
									if (tooltipModel.opacity === 0) {
										tooltipEl.style.opacity = 0;
										return;
									}

									const formatPrice = (price) => {
										return new Intl.NumberFormat('es-ES', { minimumFractionDigits: 2, maximumFractionDigits: 2 }).format(price);
									};

									// Obtener datos del tooltip
									const dataPoint = tooltipModel.dataPoints && tooltipModel.dataPoints[0];
									if (dataPoint) {
										const index = dataPoint.dataIndex;
										const variacionPorcentaje = preparedData[index]?.variacionPorcentaje || 'N/A';
										const precio = formatPrice(dataPoint.raw); // Aplicar el formato al precio

										// Construcción del contenido del tooltip
										tooltipEl.innerHTML =
												'<div style="display: flex; flex-direction: column; align-items: center;">' +
												'<div style="margin-bottom: 5px; font-weight: bold;">' + dataPoint.label + '</div>' +
												'<div style="display: flex; justify-content: space-between; gap: 8px;">' +
												'<div style="display: inline-block; padding: 4px 8px; border-radius: 4px; background-color: ' +
												(parseFloat(dataPoint.raw) === 0.0 ? '#F6F6F6' : '#1E5631') + '; color: ' +
												(parseFloat(dataPoint.raw) === 0.0 ? '#000' : '#FFFFFF') + '; font-weight: bold;">' +
												precio + ' ' + unitOfMeasure + '</div>' + // Usar el precio formateado aquí
												'<div style="display: inline-block; padding: 4px 8px; border-radius: 4px; background-color: ' +
												(variacionPorcentaje > 0 ? '#DFFFD9' : variacionPorcentaje < 0 ? '#FFE5E5' : '#F6F6F6') + '; color: ' +
												(variacionPorcentaje > 0 ? '#1E5631' : variacionPorcentaje < 0 ? '#E63946' : '#000') + '; font-weight: bold;">' +
												(variacionPorcentaje > 0 ? '↑ ' : variacionPorcentaje < 0 ? '↓ ' : '– ') + variacionPorcentaje + '%</div>' +
												'</div>' +
												'</div>';

										// Posicionar el tooltip
										const position = context.chart.canvas.getBoundingClientRect();
										tooltipEl.style.left = position.left + window.pageXOffset + tooltipModel.caretX + 'px';
										tooltipEl.style.top = position.top + window.pageYOffset + tooltipModel.caretY + 'px';
										tooltipEl.style.opacity = 1;
									}
								},
							}
						},
						scales: {
							y: {
								title: {
									display: !!unitOfMeasure,
									text: unitOfMeasure ? 'Precio (' + unitOfMeasure + ')' : "",
								},
								suggestedMin: 0,
								grid: {
									display: true // Mantén las líneas horizontales
								}
							},
							x: {
								title: {
									display: false,
									text: 'Fechas'
								},
								grid: {
									display: false // Oculta las líneas verticales
								}
							}
						}
					}
				});
			};

			// Convertir datos de JSP en JSON para JavaScript
			const listaMesActual = [
				<c:forEach var="producto" items="${listaMesActual}" varStatus="status">
				{
					fecha: "${producto.dateProducto}",
					precio: "${producto.precioUltimo}".replace(",", "."),
					unidadMedida: "${producto.unidadMedida}",
					precioAnterior: "${producto.precioAnterior}",
					variacionPorcentaje: "${producto.variacionPorcentaje}"
				}<c:if test="${!status.last}">,</c:if>
				</c:forEach>
			];

			const listaTresMeses = [
				<c:forEach var="producto" items="${listaTresMeses}" varStatus="status">
				{
					fecha: "${producto.dateProducto}",
					precio: "${producto.precioUltimo}".replace(",", "."),
					unidadMedida: "${producto.unidadMedida}",
					precioAnterior: "${producto.precioAnterior}",
					variacionPorcentaje: "${producto.variacionPorcentaje}"
				}<c:if test="${!status.last}">,</c:if>
				</c:forEach>
			];

			const listaSeisMeses = [
				<c:forEach var="producto" items="${listaSeisMeses}" varStatus="status">
				{
					fecha: "${producto.dateProducto}",
					precio: "${producto.precioUltimo}".replace(",", "."),
					unidadMedida: "${producto.unidadMedida}",
					precioAnterior: "${producto.precioAnterior}",
					variacionPorcentaje: "${producto.variacionPorcentaje}"
				}<c:if test="${!status.last}">,</c:if>
				</c:forEach>
			];

			const listaDoceMeses = [
				<c:forEach var="producto" items="${listaDoceMeses}" varStatus="status">
				{
					fecha: "${producto.dateProducto}",
					precio: "${producto.precioUltimo}".replace(",", "."),
					unidadMedida: "${producto.unidadMedida}",
					precioAnterior: "${producto.precioAnterior}",
					variacionPorcentaje: "${producto.variacionPorcentaje}"
				}<c:if test="${!status.last}">,</c:if>
				</c:forEach>
			];

			const listaProductos = [
				<c:forEach var="producto" items="${listaProductos}" varStatus="status">
				{
					fecha: "${producto.dateProducto}",
					precio: "${producto.precioUltimo}".replace(",", "."),
					unidadMedida: "${producto.unidadMedida}",
					precioAnterior: "${producto.precioAnterior}",
					variacionPorcentaje: "${producto.variacionPorcentaje}"
				}<c:if test="${!status.last}">,</c:if>
				</c:forEach>
			];

			// Obtener unidad de medida desde los datos
			const unitOfMeasure = listaProductos.length > 0 ? listaProductos[0].unidadMedida : null;

			if (listaMesActual.length > 0) configGrafico(listaMesActual, 'grafico30DiasCanvas');
			if (listaTresMeses.length > 0) configGrafico(listaTresMeses, 'grafico3MesesCanvas');
			if (listaSeisMeses.length > 0) configGrafico(listaSeisMeses, 'grafico6MesesCanvas');
			if (listaDoceMeses.length > 0) configGrafico(listaDoceMeses, 'grafico12MesesCanvas');
			if (listaProductos.length > 0) configGrafico(listaProductos, 'graficoHistoricoCanvas');
		});


		var isExecutingViewDetailsMarkets = false;

		function deleteProductoUserModal(entityId) {
			document.querySelector('.producto-modal-' + entityId).remove();
		}

		function addToFavoriteDetail(){
			<portlet:resourceURL var="addProductoUserURL" id="resource_cmd_command">
			<portlet:param name="<%=Constants.CMD%>" value="addProductoUser"/>
			</portlet:resourceURL>
			<portlet:resourceURL var="deleteProductoUserURL" id="resource_cmd_command">
			<portlet:param name="<%=Constants.CMD%>" value="deleteProductoUser"/>
			</portlet:resourceURL>

			let urlToSend = '<%=addProductoUserURL%>';
			if (document.querySelector('.js-av-lmd__ad-to-favorites').checked) {
				urlToSend = '<%=deleteProductoUserURL%>';
			}
			urlToSend = urlToSend + '&<portlet:namespace/>idLonja=${primerProducto.idLonja}&<portlet:namespace/>productoId=${primerProducto.productoId}';

			fetch(urlToSend, {method: 'post'
			}).then(response => {
				let messageAddToFavorites = '<liferay-ui:message key="avanis.lonjas.producto.quitar.de.favorito"/>';
				if (document.querySelector('.js-av-lmd__ad-to-favorites').checked){
					messageAddToFavorites = '<liferay-ui:message key="avanis.lonjas.producto.anadir.a.favorito"/>';
					openNotification('<liferay-ui:message key="avanis.lonjas.producto.seguimiento.de.precio.quitado" />', 'succes');
				} else {
					openNotification('<liferay-ui:message key="avanis.lonjas.producto.seguimiento.de.precio.anadido" />', 'succes');
				}
				document.querySelector('.av-lmd__favorites-label span').innerHTML = messageAddToFavorites;
			}).catch(error => {
				console.warn('Something went wrong.', error);
			});
		}

		function handleViewDetailsMarkets() {
			if (isExecutingViewDetailsMarkets) {
				return;
			}

			isExecutingViewDetailsMarkets = true;

			const modalButtonsPlots = [
				{
					text: 'Cancelar',
					classes: ['av-theme__btn', 'av-theme__btn--secondary'],
					callback: (modal) => { closeModal(modal); },
				},
				{
					classes: ['av-theme__btn', 'av-theme__btn--primary'],
					<c:if test="${empty explotaciones}">
						text: 'Añadir parcela',
						callback: (modal) => {
							window.location.href = '/explotacion';
						},
					</c:if>
					<c:if test="${not empty explotaciones}">
						text: 'Guardar',
						callback: (modal) => {
							const form = document.getElementById('<portlet:namespace/>formPlots');
							const formData = new FormData(form);
							fetch(form.action, {
								method: form.method, body: formData,
							}).then(response => {
								closeModal(modal); openNotification('<liferay-ui:message key="avanis.lonjas.producto.en.parcelas.actualizado" />', 'succes');
							}).catch(error => {
								closeModal(modal);
							});
						},
					</c:if>
				},
			];
			const modalButtonsHistoricAll = [
				{
					text: 'Aceptar',
					classes: ['av-theme__btn', 'av-theme__btn--primary'],
					callback: (modal) => {
						closeModal(modal);
					},
				}
			];

			document.querySelector('.av-lmd__add-to-plots').addEventListener('click', () => {
				<portlet:renderURL var="anadirAExplotacionURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
				<portlet:param name="mvcRenderCommandName" value="render_cmd_command" />
				<portlet:param name="<%=Constants.CMD%>" value="anadir_a_explotacion" />
				<portlet:param name="productoId" value="${''.concat(primerProducto.productoId)}" />
				<portlet:param name="idLonja" value="${''.concat(primerProducto.idLonja)}" />
				</portlet:renderURL>

				fetch('<%=anadirAExplotacionURL%>').then(response => {
					return response.text();
				}).then(function (html) {
					openModal(html, 'Añadir a Mi explotación', modalButtonsPlots);
				}).catch(error => {
					console.warn('Something went wrong.', error);
				});
			});

			document.querySelector('.av-lmd__view-historic-all').addEventListener('click', () => {
				<portlet:renderURL var="listaHistoricoProducto" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
				<portlet:param name="mvcRenderCommandName" value="render_cmd_command" />
				<portlet:param name="<%=Constants.CMD%>" value="lista_historico_producto" />
				<portlet:param name="productoId" value="${''.concat(primerProducto.productoId)}" />
				<portlet:param name="idLonja" value="${''.concat(primerProducto.idLonja)}" />
				</portlet:renderURL>

				fetch('<%=listaHistoricoProducto%>').then(response => {
					return response.text();
				}).then(function (html) {
					openModal(html, 'Evolución del precio ${primerProducto.nombreProducto} en Lonja de ${primerProducto.nombreLonja}', modalButtonsHistoricAll);
				}).catch(error => {
					console.warn('Something went wrong.', error);
				});
			});
		}

		window.onload = function () {
			handleViewDetailsMarkets();
		};

		Liferay.on('allPortletsReady', function () {
			handleViewDetailsMarkets();
		});

		Liferay.on('screenLoad', function () {
			handleViewDetailsMarkets();
		});

		Liferay.on('endNavigate', function () {
			handleViewDetailsMarkets();
		});

		Liferay.on('SPA_NAVIGATION', function (event) {
			handleViewDetailsMarkets();
		});

		Liferay.on('routeChanged', function () {
			handleViewDetailsMarkets();
		});
	</script>

	<%
		String reservedArticleId = "12345"; // Reemplaza con el ID de la lonja o recurso
	%>

	<%
		Object lonjaIdObj = request.getAttribute("lonjaId");
		Object productoIdObj = request.getAttribute("primerProducto");

		String lonjaId = String.valueOf(lonjaIdObj); // Convierte el objeto a String (maneja null como "null")

		List<InfoProducto> listaProductos = (List<InfoProducto>) request.getAttribute("listaProductos");
		String productoId = String.valueOf(listaProductos.get(0).getProductoId());

		// Obtengo el namespace del portlet actual
		String randomNamespace = PortalUtil.generateRandomKey(request, "namespace");

	%>

	<%-- Invocación portlet para comentarios en lonjas --%>
	<liferay-portlet:runtime
			portletName="avanis_embedded_comunidad_portlet_AvanisEmbeddedComunidadPortlet"
			queryString='<%= "resourceClassName=lonja&resourceId=" + productoId + "&view=desktop" %>'
			instanceId="<%= randomNamespace %>"
	/>
</c:if>

<script>

	//INICIO Btn EDITAR POST
	$(document).ready(function () {

		$(document).on('click', 'div[id^="menu-de-acciones-3-puntos_"]', function() {
			//console.log("Click detected on:", this);

			// Encuentra el siguiente elemento hermano con un id que comience con "menu-abierto_"
			var $dropdownMenu = $(this).next('div[id^="menu-abierto_"]').find('.dropdown-menu');
			//console.log("Dropdown Menu:", $dropdownMenu);

			if ($dropdownMenu.length) {
				if ($dropdownMenu.css('display') === 'none') {
					$dropdownMenu.css('display', 'block');
					//console.log("Dropdown menu shown.");
				} else {
					$dropdownMenu.css('display', 'none');
					//console.log("Dropdown menu hidden.");
				}
			} else {
				console.error("No se encontró el menú desplegable.");
			}
		});
	$(document).on('click', '.dropdown-item.lfr-icon-item.taglib-icon.eliminar', function(event) {
		event.preventDefault(); // Evita la acción por defecto del enlace
		console.log("CLICK MODIFICAR");
		// Encuentra el contenido del mensaje más cercano
		let messageContent = $(this).closest('.panel-body').find('.message-content').text().trim();
		//console.log("Contenido del mensaje:", messageContent);

		// Coloca el contenido del mensaje en el editor WYSIWYG
		$('#editable3').text(messageContent);

		let $menuAbierto = $(this).closest('.open.lfr-icon-menu-open');
		let fullId = $menuAbierto.attr('id');
		activeMessageId = fullId.match(/\d+$/)[0]; // Extrae el número final del ID
		//console.log("ID del mensaje activo:", activeMessageId);
		// Muestra el modal
		$('#respuestawysiwig3').show();
		$('#respuestawysiwig3 #editable').focus();
	});
	$('#messageUpdateButton3').click(function(event) {
		event.preventDefault();

		// Simular un clic en el botón "Enviar"
		$('#sendButton3').click();
	});
	$('#sendButton3').click(function(event) {
		event.preventDefault();

		//console.log("EVENTO MODIFICADO");

		let newMessageHTML = $('#editable3').html().trim();
		let newMessageText = $('#editable3').text().trim(); // Obtener solo el texto, sin HTML

		if (!newMessageText) { // Validar con el texto, no con el HTML que podría estar vacío por las etiquetas
			console.error("El mensaje no puede estar vacío.");
			return;
		}

		if (activeMessageId) {
			$('#loadingSpinner').show();
			let userId = themeDisplay.getUserId();
			let urlHost = window.location.origin;

			// URL con encodeURIComponent (recomendado)
			let urlEditEncoded = urlHost + "/o/avanis/actualizarMensaje?userId=" + userId + "&messageId=" + activeMessageId + "&newMessage=" + encodeURIComponent(newMessageHTML);

			// URL sin encodeURIComponent (para probar si es el problema)
			let urlEditNoEncoded = urlHost + "/o/avanis/actualizarMensaje?userId=" + userId + "&messageId=" + activeMessageId + "&newMessage=" + newMessageHTML;

			//console.log("URL construida (codificada):", urlEditEncoded);
			//console.log("URL construida (sin codificar - PRUEBA):", urlEditNoEncoded);

			// Prueba primero con la URL codificada
			var settingsEncoded = {
				"url": urlEditNoEncoded,
				"method": "GET",
				"timeout": 0,
			};

			$.ajax(settingsEncoded).done(function(response) {

				location.reload();
				//console.log("Respuesta AJAX (codificada):", response);
			}).fail(function(jqXHR, textStatus, errorThrown) {
				console.error("Error en la solicitud AJAX (codificada): ", textStatus, errorThrown);
			});


		} else {
			console.log("No hay un mensaje activo seleccionado para actualizar.");
		}
	});
	// Manejar el cierre del modal
	$('#closeModal3, #cancelar').on('click', function() {
		$('#respuestawysiwig3').hide();
	});
	//FIN Btn EDIAR POST
	const editableDiv3 = document.getElementById('editable3');
	let emojiPicker3;
	let savedRange3 = null;

	$('.toolbar3 .icon').on('click', function () {
		let targetMenu = $(this).data('target');
		$('.menu').not(targetMenu).hide();
		$('.icon').not(this).removeClass('active');

		if ($(targetMenu).is(':visible')) {
			$(targetMenu).hide();
			$(this).removeClass('active');
		} else {
			$(targetMenu).show();
			$(this).addClass('active');

			if (targetMenu === '#emote-menu3') {
				saveCursorPosition3();

				showEmojiPicker3();

			}
		}
	});

	async function showEmojiPicker3() {
		const emoteMenu3 = document.getElementById('emote-menu3');
		if (!emojiPicker3) {
			const response = await fetch('/o/avanis-v2-theme/js/emoji-mart/es.json');
			const i18n = await response.json();

			emojiPicker3 = new EmojiMart.Picker({
				set: 'google',
				theme: 'light',
				emojiSize: 24,
				perLine: 8,
				title: 'Selecciona un emoji',
				i18n,
				onEmojiSelect: (emoji) => {
					restoreCursorPosition3();
					insertAtCursor3(emoji.native);
				}
			});

			emoteMenu3.appendChild(emojiPicker3);
		}
		setTimeout(() => {
			const emojiPicker = document.querySelector('em-emoji-picker');
			if (emojiPicker && emojiPicker.shadowRoot) {
				const shadowRoot = emojiPicker.shadowRoot;
				const previewElement = shadowRoot.querySelector('#preview');
				if (previewElement) {
					previewElement.style.display = 'none';
				}
			}
		}, 300);
	}

	function saveCursorPosition3() {
		const selection = window.getSelection();
		if (selection.rangeCount > 0) {
			const range = selection.getRangeAt(0);
			if (editableDiv3.contains(range.commonAncestorContainer)) {
				savedRange3 = range;
			}
		}
	}

	function restoreCursorPosition3() {
		const selection = window.getSelection();
		if (savedRange3) {
			selection.removeAllRanges();
			selection.addRange(savedRange3);
		} else {
			editableDiv3.focus();
		}
	}

	function insertAtCursor3(text) {
		restoreCursorPosition3();
		const selection = window.getSelection();
		if (selection.rangeCount > 0) {
			const range = selection.getRangeAt(0);
			const textNode = document.createTextNode(text);
			range.deleteContents();
			range.insertNode(textNode);
			range.setStartAfter(textNode);
			range.setEndAfter(textNode);
			selection.removeAllRanges();
			selection.addRange(range);
		}
	}

	$('#format-menu3 button').on('click', function (e) {
		e.preventDefault();
		let cmd = $(this).data('cmd');
		document.execCommand(cmd, false, null);
		updateFormatMenuState3();
		$('#editable3').focus();
	});

	function updateFormatMenuState3() {
		$('#format-menu3 button').each(function () {
			let cmd = $(this).data('cmd');
			if (document.queryCommandState(cmd)) {
				$(this).addClass('active');
			} else {
				$(this).removeClass('active');
			}
		});
	}

	$('#editable3<portlet:namespace />').on('mouseup keyup', function () {
		updateFormatMenuState3();
		saveCursorPosition3();
	});
	});








	//Btn ELIMINAR post
	//console.log("CARGANDO JS");
	if (typeof themeDisplay !== 'undefined') {
		//console.log("User ID from themeDisplay:", themeDisplay.getUserId());

		$(document).on('click', 'a[id^="btn-eliminar_"]', function(event) {
			event.preventDefault(); // Evita que el enlace realice su acción por defecto

			let $this = $(this);
			let userId = themeDisplay.getUserId();
			let fullId = $this.attr('id');
			//console.log("Full ID:", fullId);

			let idMessaje = fullId.split('_')[1];
			//console.log("Message ID:", idMessaje);

			if (!userId || !idMessaje) {
				console.error("Error: User ID o Message ID no están definidos.");
				return;
			}

			// Verificar si el menú correspondiente está visible
			let $menuAbierto = $('#menu-abierto_' + idMessaje);
			//console.log("Verificando visibilidad del menú:", $menuAbierto);

			if ($menuAbierto.length && $menuAbierto.css('display') === 'block') {
				//console.log("El menú está visible, procediendo con la solicitud AJAX.");
				$('#loadingSpinner').show();

				let urlHost = window.location.origin;
				let urlEdit = urlHost + "/o/avanis/eliminarMensaje?userId=" + userId + "&messageId=" + idMessaje;

				//console.log("URL construida:", urlEdit);

				var settings = {
					"url": urlEdit,
					"method": "GET",
					"timeout": 0,
				};

				$.ajax(settings).done(function(response) {
					console.log("Respuesta AJAX:", response);
					location.reload();
				}).fail(function(jqXHR, textStatus, errorThrown) {
					console.error("Error en la solicitud AJAX: ", textStatus, errorThrown);
				});
			} else {
				console.log("El menú no está visible, no se realizará la solicitud AJAX.");
			}
		});

	} else {
		console.error("themeDisplay no está definido.");
	}
</script>