<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--TODO: Falta maquetación -->
<div class="faqs-container-lfr fcl">
    <div class="fcl-container"><!-- Titulo -->
        <div class="back-icon">
            <img class="go-to-menu" onClick="displayMenu()" class="mr-2"
                 src="<%=request.getContextPath()%>/images/arrow-left.png" alt="arrow left"/>
            <h2 class="fcl__title">Preguntas frecuentes</h2> <!-- Pestañas -->
        </div>
            <div class="fcl__tab-container">
            <div class="fcl__tab-container-gradient"></div>
            <ul class="nav nav-tabs fcl__tabs" id="myTab" role="tablist">
                <li class="nav-item fcl__tabs-li" role="presentation"><button class="nav-link fcl__tab-btn active" id="home-tab" data-toggle="tab" data-target="#SobreAvanis" type="button" role="tab" aria-controls="home" aria-selected="true"> Sobre Avanis </button></li>
                <li class="nav-item fcl__tabs-li" role="presentation"><button class="nav-link fcl__tab-btn" id="home-tab" data-toggle="tab" data-target="#Miperfil" type="button" role="tab" aria-controls="home" aria-selected="true"> Mi perfil </button></li>
                <li class="nav-item fcl__tabs-li" role="presentation"><button class="nav-link fcl__tab-btn" id="home-tab" data-toggle="tab" data-target="#Alertasmetereolgicas" type="button" role="tab" aria-controls="home" aria-selected="true"> Alertas metereológicas </button></li>
                <li class="nav-item fcl__tabs-li" role="presentation"><button class="nav-link fcl__tab-btn " id="home-tab" data-toggle="tab" data-target="#ComunidadAvanis" type="button" role="tab" aria-controls="home" aria-selected="true"> Comunidad Avanis </button></li>
            </ul>
        </div> <!-- Preguntas y Respuestas -->
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="SobreAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Quién puede formar parte de Avanis?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--active fcl__question-arrow--more"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>La plataforma de Avanis está abierta a cualquier persona o empresa que se dedique al sector agroalimentario. Tanto si quieres entrar de manera individual (como agricultor, ganadero, mecánico, ingeniero, etc.) o como empresa (de fitosanitarios, maquinaria, semillas, etc.), Avanis tiene algo para ti. Descubre todo lo que Avanis puede ayudarte en tu día a día en nuestra página inicial y explora todas las funcionalidades existentes. ¡La comunidad está esperándote!</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="SobreAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Qué opciones tengo para registrarme?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--active fcl__question-arrow--more"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>¡Cualquier persona! Tanto individuales (agricultores, ganaderos, aficionados...), como empresas (de semillas, de fitosanitarios...). Si te dedicas al sector agroalimentario, como si simplemente te apasiona, Avanis es tu lugar.</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="SobreAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cuánto cuesta crearse una cuenta en Avanis?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--active fcl__question-arrow--more"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer">
                    <p>¡Nada! Disfrutar de Avanis es completamente gratis. Solo tendrás que darnos algunos de tus datos personales, decirnos qué temas te interesan y, desde ese momento, podrás disfrutar de todas las ventajas de formar parte de Avanis.</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="Miperfil" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cómo puedo editar mi perfil de Avanis?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>¡Es muy fácil! Solo tienes que acceder a "Mi perfil" en la parte superior derecha, y acceder a las diferentes secciones para editar la información que quieras. ¡No olvides guardar los cambios antes de salir!</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="Miperfil" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cómo puedo eliminar mi cuenta en Avanis?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Si has decidido dejar de formar parte de la plataforma, solo tienes que enviar un email al correo soporte@avanis.es con el asunto "BAJA". A partir de ese momento, nuestro equipo se encargará de procesar tu solicitud lo más rápido posible. ¡Y si quieres volver a unirte, te estaremos esperando con los brazos bien abiertos!</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="Miperfil" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Por qué tengo que completar mi perfil en Avanis?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Porque, de esta manera, nos ayudarás a conocerte mejor para poder ofrecerte una experiencia completamente personalizada y que te resulte realmente útil. Para completarlo, solo tienes que acceder a "Mi perfil" en la parte superior derecha e ir añadiendo los datos en los campos que aparezcan sin rellenar.</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="Miperfil" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cómo puedo dejar de recibir comunicaciones comerciales de Avanis?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Solo tienes que acceder a "Mi perfil" &gt; "Mis preferencias" y, abajo del todo, deslizar el botón "Permitir comunicaciones de Avanis" hasta verlo desactivado. Una vez que lo hayas hecho, no olvides guardar los cambios.</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="Alertasmetereolgicas" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cómo puedo agregar una parcela a mi explotación?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>¡Es muy sencillo! Solo tienes que acceder a la sección "Tu explotación" del menú, pulsar en "Añadir parcela" y aceptar el mensaje del navegador en el que te pedimos permiso para conocer tu ubicación. Una vez que lo hayas hecho, te enviaremos una estimación del lugar en el que se encuentra tu parcela:</p>
                    <ul>
                        <li>1. Si es correcto, te pediremos algunos datos más sobre tu parcela para que la personalices.</li>
                        <li>2. Si no es correcto, pulsa en "Es otra dirección" y señala en el mapa el lugar en el que se encuentra tu parcela. Una vez que lo hayas hecho, te pediremos algunos datos más sobre tu parcela para que la personalices.</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question" id="Alertasmetereolgicas" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Qué son "Mi explotación" y "Mis parcelas"?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Consideramos tu explotación el conjunto de parcelas que gestionas en tu día a día. Es decir: si tienes una finca de olivos y otra de cerezos, tienes dos parcelas y esas dos parcelas forman tu explotación.</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question " id="ComunidadAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Quién puede formar parte de la comunidad?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--active fcl__question-arrow--more"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Cualquier persona que tenga una cuenta en Avanis, ya forma parte de la comunidad. En nuestra comunidad podrás conectar con otros profesionales del sector, comentar, dar tu apoyo a sus comentarios... Es un foro en el que compartir tus opiniones y retos diarios con personas que viven lo mismo que tú en su día a día. ¿Aún no te has unido? Crea tu cuenta ahora.</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question " id="ComunidadAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cómo puedo añadir una publicación en la comunidad?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Es muy sencillo. Solo tienes que pulsar en "Añadir publicación" en la parte superior de la comunidad y añadir la información que te pedimos: tipo de publicación (aviso, anuncio, colaboración, novedad, pregunta o recomendación), escribir un título y el contenido y elegir la temática de tu publicación. ¡Y ya estará lista para que otros la puedan leer y comentar!</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question " id="ComunidadAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cómo puedo responder a una publicación en la comunidad?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Solo tienes que pulsar en la publicación que quieras responder, y escribir en el campo "Escribe tu respuesta". También podrás ver todos los comentarios que hay y darle a "me gusta".</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question " id="ComunidadAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Qué diferencia hay entre ocultar y borrar una publicación en la comunidad?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>Cuando ocultas una publicación o comentario, te dejará de aparecer en el muro pero seguirá en la comunidad, otros podrán seguir leyéndola. Sin embargo, cuando la eliminas, esa publicación dejará de existir en la comunidad Avanis.</p>
                </div>
            </div>
        </div>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade fcl__tab-question " id="ComunidadAvanis" role="tabpanel" aria-labelledby="home-tab">
                <div class="fcl__tab-question-top"><!-- Pregunta -->
                    <h3 class="fcl__question">¿Cómo puedo limitar el tipo de publicaciones que me aparecen?</h3> <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>
                </div> <!-- Respuesta -->
                <div class="fcl__answer fcl__answer--collapsed">
                    <p>¡Es sencillo! En la parte superior encontrarás una sección llamada "Filtros". Ahí podrás filtrar por temática, y por tipo de publicación para que solo te aparezca aquello que te interesa.</p>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    // Añadir o quitar la clase "hidden" al contenedor de pestañas en funcion de si hay una o más de una.
    function initializeTabViewer() {
        var tabs = document.querySelectorAll('.fcl__tabs-li');
        var tabContainer = document.querySelector('.fcl__tab-container');

        if (tabContainer) {
            if (tabs.length <= 1) {
                tabContainer.classList.add('hidden');
            } else {
                tabContainer.classList.remove('hidden');
            }
        }
    }

    // Función para inicializar los eventos de las pestañas.
    function initializeTabEvents() {
        // Seleccionar todos los elementos con la clase "fcl__tab-btn".
        var tabButtons = document.querySelectorAll('.fcl__tab-btn');

        // Función para manejar los clics en los botones de las pestañas.
        function handleTabClick(event) {
            // Obtener el botón clickado.
            var clickedButton = event.currentTarget;

            // Remover la clase "active" del botón "fcl__tab-btn" que la tiene actualmente.
            document
                .querySelector('.fcl__tab-btn.active')
                ?.classList.remove('active');

            // Añadir la clase "active" al botón clickado.
            clickedButton.classList.add('active');

            // Obtener el valor de "data-target" del botón clickado.
            var targetId = clickedButton.getAttribute('data-target').substring(1);

            // Remover las clases "show" y "active" de los elementos "fcl__tab-question".
            document
                .querySelectorAll('.fcl__tab-question.show, .fcl__tab-question.active')
                .forEach(function (element) {
                    element.classList.remove('show', 'active');
                });

            // Añadir las clases "show" y "active" a todos los elementos "fcl__tab-question" cuyo id corresponde al "data-target".
            document
                .querySelectorAll('.fcl__tab-question[id="' + targetId + '"]')
                .forEach(function (element) {
                    element.classList.add('show', 'active');
                });
        }

        // Añadir el event listener a cada botón.
        tabButtons.forEach(function (button) {
            button.addEventListener('click', handleTabClick);
        });

        // Activar el primer botón y su correspondiente contenido al cargar la página.
        if (tabButtons.length > 0) {
            tabButtons[0].classList.add('active');
            var firstDataTarget = tabButtons[0]
                .getAttribute('data-target')
                .substring(1);
            document
                .querySelectorAll('.fcl__tab-question[id="' + firstDataTarget + '"]')
                .forEach(function (element) {
                    element.classList.add('show', 'active');
                });
        }
    }

    // Función para inicializar los eventos de las preguntas.
    function initializeQuestionEvents() {
        document.querySelectorAll('.fcl__tab-question').forEach(function (tabQuestion) {
            tabQuestion.addEventListener('click', function (event) {
                const answerElement = tabQuestion.querySelector('.fcl__answer');
                const arrowElement = tabQuestion.querySelector('.fcl__question-arrow');

                if (answerElement) {
                    answerElement.classList.toggle('fcl__answer--collapsed');
                }

                if (arrowElement) {
                    arrowElement.classList.toggle('fcl__question-arrow--more');
                    arrowElement.classList.toggle('fcl__question-arrow--minus');
                }
            });
        });
    }

    // Función principal para inicializar todo.
    function initializeFaqs() {
        initializeTabViewer();
        initializeTabEvents();
        initializeQuestionEvents();
    }

    // Inicializar los eventos cuando todos los portlets estén listos.
    Liferay.on('allPortletsReady', function () {
        initializeFaqs();
    });

    // Detectar cambios de página y reinicializar los eventos.
    Liferay.on('singlePageAppViewLoaded', function (event) {
        // Verificar si estamos en la página de FAQs.
        if (event.path.includes('/faqs')) {
            initializeFaqs();
        }
    });

</script>