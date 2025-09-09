<%@ include file="./init.jsp" %>
<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<portlet:renderURL var="mailSent">
  <portlet:param
    name="mvcPath"
    value="/register_acount_mail_sent.jsp"
  />
</portlet:renderURL>
<portlet:actionURL
  name="/register"
  var="registerURL"
>
  <portlet:param
    name="mvcPath"
    value="/register_acount_mail_sent.jsp"
  />
</portlet:actionURL>

  <!-- region Form -->
  <div class="av-content-form">
    <div class="av-content-right">
      <!-- Form -->
      <div id="loginCount">
        <h2>Crear mi cuenta</h2>

        <div class="my-3">
          <div class="av-social-login">
            <div>
              <div class="av-social-login-google">
                <button
                  type="button"
                  class="google mb-2 undefined"
                  style="
                    background-color: rgb(255, 255, 255);
                    display: inline-flex;
                    align-items: center;
                    color: rgba(0, 0, 0, 0.54);
                    box-shadow: rgba(0, 0, 0, 0.24) 0px 2px 2px 0px,
                      rgba(0, 0, 0, 0.24) 0px 0px 1px 0px;
                    padding: 0px;
                    border-radius: 2px;
                    border: 1px solid transparent;
                    font-size: 14px;
                    font-weight: 500;
                    font-family: Roboto, sans-serif;
                  "
                >
                  <div
                    style="
                      margin-right: 10px;
                      background: rgb(255, 255, 255);
                      padding: 10px;
                      border-radius: 2px;
                    "
                  >
                    <svg
                      width="18"
                      height="18"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <g
                        fill="#000"
                        fill-rule="evenodd"
                      >
                        <path
                          d="M9 3.48c1.69 0 2.83.73 3.48 1.34l2.54-2.48C13.46.89 11.43 0 9 0 5.48 0 2.44 2.02.96 4.96l2.91 2.26C4.6 5.05 6.62 3.48 9 3.48z"
                          fill="#EA4335"
                        ></path>
                        <path
                          d="M17.64 9.2c0-.74-.06-1.28-.19-1.84H9v3.34h4.96c-.1.83-.64 2.08-1.84 2.92l2.84 2.2c1.7-1.57 2.68-3.88 2.68-6.62z"
                          fill="#4285F4"
                        ></path>
                        <path
                          d="M3.88 10.78A5.54 5.54 0 0 1 3.58 9c0-.62.11-1.22.29-1.78L.96 4.96A9.008 9.008 0 0 0 0 9c0 1.45.35 2.82.96 4.04l2.92-2.26z"
                          fill="#FBBC05"
                        ></path>
                        <path
                          d="M9 18c2.43 0 4.47-.8 5.96-2.18l-2.84-2.2c-.76.53-1.78.9-3.12.9-2.38 0-4.4-1.57-5.12-3.74L.97 13.04C2.45 15.98 5.48 18 9 18z"
                          fill="#34A853"
                        ></path>
                        <path
                          fill="none"
                          d="M0 0h18v18H0z"
                        ></path>
                      </g>
                    </svg>
                  </div>
                  <span style="padding: 10px 10px 10px 0px; font-weight: 500"
                    ><a href="${urlsessionGoogle}"
                      ><liferay-ui:message key="avanis.acceder.google" /></a
                  ></span>
                </button>
              </div>
            </div>
          </div>
          <p class="mb-2">
            <strong>
              <liferay-ui:message key="avanis.siloprefieres" />
            </strong>
          </p>

          <div class="av-buttons-fixed av-buttons-tipo-registro">
            <aui:button
              label=""
              href="/tipo-registro"
              type="button"
              name="btnenvioregistro"
              cssClass=""
              value="Regístrate con tu email"
            >
            </aui:button>
          </div>
        </div>
        <p class="av-info-txt">
          <liferay-ui:message key="avanis.politica.privacidad.tipo.registro" />
        </p>
      </div>

      <!-- Creo el modal -->
      <div class="modal-privacity">
        <div
          class="modal fade"
          id="cookiePolicyModal"
          tabindex="-1"
          aria-labelledby="cookiePolicyModalLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button
                  type="button"
                  class="close"
                  data-dismiss="modal"
                  aria-label="Cerrar"
                >
                  <span
                    class="avanis-mdoal-span"
                    aria-hidden="true"
                    >&times;</span
                  >
                </button>
              </div>
              <div class="modal-body">
                <liferay-ui:message key="avanis.politica.privacidad.modal" />
              </div>
              <div class="modal-footer">
                <button
                  type="button"
                  class="btn btn-secondary"
                  data-dismiss="modal"
                >
                  Aceptar y cerrar
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="modal-use-cases">
        <div
          class="modal fade"
          id="conditionCasesModal"
          tabindex="-1"
          aria-labelledby="conditionCasesLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button
                  type="button"
                  class="close"
                  data-dismiss="modal"
                  aria-label="Cerrar"
                >
                  <span
                    class="avanis-mdoal-span"
                    aria-hidden="true"
                    >×</span
                  >
                </button>
              </div>
              <div class="modal-body">
                <div class="av-content">
                  <h1>CONDICIONES DE USO</h1>
                  <p>
                    Las presentes Condiciones Generales de Contratación (en
                    adelante, las Condiciones de Uso) regulan las relaciones
                    entre los Usuarios de Internet (en adelante, el Usuario o
                    los Usuarios) y
                    <strong>SANTANDER NEW BUSINESS, S.A.</strong>, con email de
                    contacto legal@avanis.es, con domicilio social en Calle Juan
                    Ignacio Luca de Tena 11, 28027 - Madrid y con NIF A56392350
                    (en adelante, <strong>AVANIS</strong>) en lo que se refiere
                    al acceso y la utilización de la Plataforma Avanis (en
                    adelante, <strong>PLATAFORMA</strong>).
                  </p>
                  <p>
                    Las Condiciones de Uso que aquí se recogen son aplicables a
                    todas las formas de acceso que se hagan a LA PLATAFORMA,
                    incluyendo Internet, vía móvil o cualquier otro dispositivo
                    y serán de aplicación de forma conjunta con el Aviso Legal,
                    la Política de Privacidad y la Política de Cookies y
                    cualquier otro documento que regule aspectos de LA
                    PLATAFORMA.
                  </p>
                  <p>
                    LA PLATAFORMA es una comunidad dirigida a los profesionales
                    del sector agropecuario en la que estos pueden acceder a
                    contenidos de interés del sector, interactuar con otros
                    Usuarios y subir contenidos.
                  </p>
                  <h2>Formalización</h2>
                  <p>
                    El registro y la creación de un Perfil de Usuario en LA
                    PLATAFORMA constituye la formalización de un contrato con
                    AVANIS para el uso de LA PLATAFORMA. El registro por parte
                    de los Usuarios en LA PLATAFORMA es gratuito y está sujeto a
                    la previa aceptación de forma expresa de todas las
                    Condiciones de Uso vigentes en cada momento.
                  </p>
                  <p>
                    Si algún Usuario no estuviese de acuerdo con el contenido o
                    parte del contenido de las presentes Condiciones de Uso no
                    podrá registrarse en LA PLATAFORMA, no pudiendo acceder ni
                    disponer de los servicios que en esta se ofrecen. Se
                    recomienda que el Usuario lea atentamente las presentes
                    Condiciones de Uso cada vez que acceda o utilice algún
                    servicio a través de LA PLATAFORMA, ya que podrían sufrir
                    modificaciones.
                  </p>
                  <p>
                    Cuando los Usuarios realizan el registro en LA PLATAFORMA
                    recibirán un e-mail de confirmación.
                  </p>
                  <p>
                    El Usuario declara y garantiza ser mayor de edad y disponer
                    de la capacidad jurídica suficiente para vincularse por las
                    Condiciones de Uso y que toda la información proporcionada
                    es verdadera, precisa, actual y completa. Igualmente, acepta
                    de forma expresa y sin excepciones que el acceso y la
                    utilización de LA PLATAFORMA y de los contenidos tiene lugar
                    bajo su única y exclusiva responsabilidad.
                  </p>
                  <p>
                    AVANIS se reserva el derecho de efectuar los cambios y las
                    modificaciones que considere oportunas en LA PLATAFORMA y en
                    las presentes Condiciones de Uso. Las modificaciones de las
                    Condiciones de Uso se notificarán a los Usuarios en un
                    soporte duradero con un plazo de antelación mínimo de quince
                    (15) días. Por ello, AVANIS avisará a los Usuarios sobre
                    cambios sustanciales en estas Condiciones de Uso, ya sea
                    enviando un aviso a la dirección de correo electrónico que
                    los Usuarios hayan facilitado o colocando un aviso en LA
                    PLATAFORMA.
                  </p>
                  <h2>Perfil de Usuario</h2>
                  <p>
                    Para crear un Perfil de Usuario, el Usuario debe
                    proporcionar información relativa a su email, nombre,
                    apellidos, teléfono, país, localidad y provincia, así como
                    crear una contraseña. Opcionalmente, podrá subir una imagen
                    a su Perfil de Usuario.
                  </p>
                  <p>
                    Los datos solicitados son necesarios para poder finalizar el
                    proceso de registro con éxito, por lo que, si no se
                    cumplimentan todos los apartados obligatorios, el Usuario no
                    podrá registrarse. Los Usuarios también podrán seleccionar
                    los sectores de interés a los que se dedican para que AVANIS
                    pueda ofrecerles contenido personalizado.
                  </p>
                  <p>
                    Cuando el Usuario se registra cumplimentando el Formulario
                    de Registro reconoce haber tenido conocimiento del contenido
                    de las presentes Condiciones de Uso y declara expresamente
                    que las acepta.
                  </p>
                  <p>
                    Cada Usuario solo podrá tener un Perfil de Usuario en LA
                    PLATAFORMA y no podrá ser compartida con terceros,
                    alquilada, cedida o transmitida ni de forma gratuita ni de
                    forma onerosa.
                  </p>
                  <p>
                    Los Usuarios serán responsables de la adecuada custodia y
                    confidencialidad de cualquier contraseña y se comprometen a
                    no ceder su uso a terceros, ni a permitir su acceso a
                    personas ajenas. Será responsabilidad de los Usuarios la
                    utilización ilícita de LA PLATAFORMA por cualquier tercero
                    ilegítimo que emplee una contraseña a causa de una
                    utilización no diligente o de la pérdida de la misma por el
                    Usuario.
                  </p>
                  <p>
                    El Usuario tiene la obligación de notificar de forma
                    inmediata a AVANIS cualquier hecho que conlleve el uso
                    indebido de las contraseñas, tales como el extravío o el
                    acceso no autorizado con el fin de proceder a su inmediata
                    cancelación.
                  </p>
                  <h2>Contenido de Usuario</h2>
                  <p>
                    Los Usuarios son los únicos responsables sobre los
                    contenidos, información, comentarios y/o mensajes (en
                    adelante, el Contenido) que puedan realizar, compartir y/o
                    subir en su Perfil, en el Perfil de otros Usuarios y/o al
                    interactuar a través de los servicios de LA PLATAFORMA, así
                    como en los mensajes que pudieran intercambiar con otros
                    Usuarios. Por lo tanto, los Usuarios garantizan a AVANIS que
                    ostentan los permisos, títulos y las autorizaciones de todos
                    los derechos sobre dicho Contenido, así como la autorización
                    de los titulares de los datos de carácter personal y/o de
                    las imágenes que puedan incluirse en dicho Contenido,
                    manteniendo por lo tanto indemne a AVANIS por cualquier
                    reclamación. Los Usuarios tendrán la posibilidad de
                    establecer la configuración en su Perfil de Usuario para
                    decidir quien puede ver su Contenido y la información de su
                    Perfil.
                  </p>
                  <p>
                    Los Usuarios se comprometen a que el Contenido subido,
                    compartido y/o publicado en LA PLATAFORMA no será
                    discriminatorio y no incluirá terminología sobre drogas o de
                    carácter sexual; ni atentará contra la dignidad de cualquier
                    persona por razón de raza, religión, etnia, país de origen,
                    sexo, identidad sexual, orientación sexual, enfermedad y/o
                    discapacidad. Tampoco podrán justificar, enaltecer y/o negar
                    delitos de terrorismo, genocidio, de lesa humanidad o
                    relacionados con conflictos armados y, en general,
                    garantizan que el Contenido no vulnerará los derechos al
                    honor, intimidad e imagen, de Propiedad Intelectual o
                    Industrial de AVANIS, ni de los Usuarios de LA PLATAFORMA
                    y/o cualquier tercero.
                  </p>
                  <p>
                    Los Usuarios serán propietarios de todo el Contenido que
                    suban a LA PLATAFORMA y de los datos personales que
                    faciliten a AVANIS, pero conceden una cesión y/o licencia no
                    exclusiva, gratuita, perpetua (es decir, hasta el paso al
                    dominio público), transferible, irrevocable y totalmente
                    sublicenciable a AVANIS, para que pueda usar, reproducir,
                    modificar, adaptar, traducir, distribuir, transformar,
                    difundir y comunicar públicamente dicho Contenido en todo el
                    mundo, en cualquier medio, modalidad y formato, ahora
                    conocido o inventado en el futuro, para cualquier propósito
                    relacionado con las actividades de AVANIS y LA PLATAFORMA,
                    incluyendo fines publicitarios y para uso comercial, por lo
                    que no será necesario consentimiento adicional, notificación
                    o compensación para el Usuario y/o ningún tercero. Dicha
                    cesión y/o licencia sobre el Contenido de los Usuarios
                    finalizará cuando el Usuario eliminase el Contenido o cuando
                    eliminase su Perfil de Usuario de LA PLATAFORMA.
                  </p>
                  <p>
                    Los Usuarios quedan informados de que AVANIS recopila los
                    datos personales que proporcione al realizar publicaciones,
                    generar contenido, comentarios e interactuar en LA
                    PLATAFORMA. AVANIS también podrá recopilar las interacciones
                    de los Usuarios cuando pulsen el botón “Me gusta” en
                    cualquier publicación. Por ello, las publicaciones,
                    comentarios e interacciones en LA PLATAFORMA, así como los
                    datos incluidos en el Perfil de Usuario estarán accesibles y
                    podrán ser vistos por el resto de los Usuarios de LA
                    PLATAFORMA y/o de forma anonimizada en el Área Pública,
                    según AVANIS decida en cada momento respetando las
                    preferencias sobre el Contenido del Perfil de Usuario.
                  </p>
                  <h2>Uso de Inteligencia Artificial (IA)</h2>
                  <p>
                    Los Usuarios quedan informados de que AVANIS emplea
                    tecnologías de Inteligencia Artificial (IA) para generar
                    contenido especializado. La IA puede crear perfiles de
                    Usuarios especialistas y contenidos con los que los Usuarios
                    podrían interactuar. LA PLATAFORMA se compromete a
                    identificar claramente cuando se trate de un perfil de
                    Usuario generado por IA o de contenido creado mediante esta
                    tecnología. Esta identificación se realizará de manera
                    transparente y accesible para los Usuarios. La finalidad de
                    esta práctica es mejorar la experiencia del Usuario y
                    brindar un servicio más eficiente. AVANIS se compromete a
                    cumplir con la normativa europea de IA vigente y a respetar
                    los derechos y la privacidad de los Usuarios en todo
                    momento.
                  </p>
                  <h2>Derecho de Desistimiento</h2>
                  <p>
                    Sin perjuicio de la posibilidad de dar de baja el Perfil de
                    Usuario en cualquier momento, una vez aceptadas las
                    presentes Condiciones de Uso, los Usuarios entienden y
                    aceptan que no existirá derecho de desistimiento en virtud
                    de lo establecido en el artículo 103, letra m), del Real
                    Decreto Legislativo 1/2007, de 16 de noviembre, por el que
                    se aprueba el texto refundido de la Ley General para la
                    Defensa de los Consumidores y Usuarios.
                  </p>
                  <h2>Promociones, eventos y ofertas</h2>
                  <p>
                    En su caso, AVANIS podrá realizar promociones, eventos y/u
                    ofertas a los que se les aplicarán sus propias bases,
                    condiciones y términos adicionales, que AVANIS pondrá a
                    disposición de los Usuarios antes de dicha contratación. En
                    caso de que un Usuario quiera participar en una promoción,
                    un evento y/u oferta, deberá leer y estar conforme con sus
                    bases, condiciones y términos. Las ofertas, eventos y
                    promociones disponibles para los Usuarios serán válidos
                    hasta la fecha indicada en LA PLATAFORMA en cada momento y,
                    en su caso, de forma individualizada sobre los servicios o
                    productos indicados, sin que sean aplicables a otros
                    productos o servicios ofrecidos en LA PLATAFORMA.
                  </p>
                  <h2>Garantías y obligaciones de los Usuarios</h2>
                  <p>
                    Los Usuarios garantizan y quedan obligados a que toda la
                    información de su Perfil de Usuario es veraz, cierta y
                    completa, por lo que serán responsables frente a terceros de
                    la información que proporcionen. Asimismo, los Usuarios no
                    podrá registrarse con información falsa, utilizando nombres
                    o incluir términos en su Perfil de Usuario que pretendan
                    suplantar la identidad de un tercero, incluyan identidades
                    falsas, injurien, vejen, amenacen o vulnerar los derechos al
                    honor, intimidad e imagen de cualquier tercero.
                  </p>
                  <p>
                    Los Usuarios entienden y aceptan que AVANIS es titular o
                    cesionario de todos los derechos de Propiedad Intelectual e
                    Industrial sobre los elementos y el contenido de LA
                    PLATAFORMA. Por ello, todos los contenidos, imágenes,
                    fotografías vídeos, diseños, marcas, rótulos, signos
                    distintivos, nombres comerciales y/o logos de AVANIS y/o de
                    LA PLATAFORMA, así como los banners, el software y sus
                    distintos códigos, fuente y objeto, algoritmos, medidas
                    tecnológicas y/o cualesquiera otros elementos de naturaleza
                    análoga y/o propios de LA PLATAFORMA son titularidad de
                    AVANIS o AVANIS es cesionario de los mismos.
                  </p>
                  <p>
                    Los Usuarios garantizan que no cometerán actos y/o que no
                    realizarán acciones dirigidas a romper las medidas
                    tecnológicas de protección y antipiratería que hubiesen sido
                    implantadas en LA PLATAFORMA, entendiéndose por tales
                    aquellos procedimientos, técnicas, dispositivos,
                    componentes, o la combinación de éstos, cuya función es
                    controlar, impedir o restringir el acceso o la utilización
                    de los elementos y/o el contenido de LA PLATAFORMA. De lo
                    contrario, AVANIS procederá a resolver de inmediato la
                    relación con el Usuario infractor, así como que podrá tomar
                    las medidas legales pertinentes.
                  </p>
                  <p>
                    Asimismo, todos los Usuarios garantizan expresamente que no
                    infringirán derechos de Propiedad Intelectual o Industrial
                    de terceros, los derechos de terceros de ninguna naturaleza,
                    ni infringirán el derecho al honor, la intimidad o la propia
                    imagen de AVANIS, así como de cualquier otra persona o de
                    terceros y que son los únicos responsables, con completa
                    indemnidad a AVANIS, de cualquier reclamación (judicial o
                    extrajudicial) que surja o pudiera surgir en tal supuesto.
                  </p>
                  <p>
                    Los Usuarios garantizan y quedan obligados a cumplir estas
                    Condiciones de Uso, el Aviso Legal y la Política de
                    Privacidad y de Cookies de LA PLATAFORMA, respetando el
                    interés público, la legalidad vigente y las exigencias de la
                    buena fe.
                  </p>
                  <h2>Responsabilidad de AVANIS</h2>
                  <p>
                    AVANIS es considerado como un proveedor de un servicio de
                    intermediación, en los términos de la Ley 34/2002, de 11 de
                    julio, de servicios de la sociedad de la información y de
                    comercio electrónico (LSSI). Por ello, AVANIS no tiene
                    obligación y no controla la utilización que los Usuarios
                    hacen de LA PLATAFORMA y/o de los contenidos disponibles en
                    LA PLATAFORMA. AVANIS no garantiza que los Usuarios utilicen
                    LA PLATAFORMA, los contenidos y los servicios ofrecidos de
                    conformidad con estas Condiciones de Uso, ni que lo hagan de
                    forma diligente y prudente o cumpliendo la legalidad.
                  </p>
                  <p>
                    AVANIS tiene el derecho de oponerse y/o eliminar cualquier
                    contenido o actividad que infrinja estas Condiciones de Uso
                    y cualquiera de sus Políticas, desde el momento en el que
                    tenga conocimiento efectivo, así como de denegar o cancelar
                    el acceso a LA PLATAFORMA a cualquier persona o entidad
                    según lo establecido en estas Condiciones de Uso y la
                    normativa aplicable. Por ello, AVANIS pone a disposición de
                    los Usuarios y de terceros un sistema de denuncia
                    unilateral, por el que estos podrán notificar cualquier
                    infracción de las presentes Condiciones de Uso, de sus
                    Políticas y/o de la legislación en la siguiente dirección:
                    datos@avanis.es
                  </p>
                  <p>
                    AVANIS se reserva el derecho a denegar en cualquier momento,
                    sin necesidad de aviso previo y sin derecho a indemnización,
                    el acceso a LA PLATAFORMA en caso de que&nbsp;AVANIS
                    considere que algún Usuario está utilizando o ha utilizado
                    LA PLATAFORMA incumpliendo las presentes Condiciones de Uso
                    o la legislación y normativa aplicables. AVANIS notificará
                    tal supuesto mediante el envío de un correo electrónico a la
                    dirección que figure en su Perfil de Usuario. No obstante,
                    AVANIS no tendrá que realizar esta notificación al Usuario
                    infractor cuando esté sujeta a una obligación legal o
                    reglamentaria relativa a no indicar los hechos o
                    circunstancias específicos.
                  </p>
                  <p>
                    Por lo tanto, AVANIS podrá cancelar el Perfil de Usuario por
                    causas justificadas, como son, a título meramente
                    enunciativo, cuando (i) AVANIS considere razonablemente que
                    un Usuario está incumpliendo las Condiciones de Uso o la
                    legislación; (ii) se han vulnerado los derechos de AVANIS,
                    de otros Usuarios y/o de terceros, como el derecho al honor,
                    a la intimidad o a la propia imagen; (iii) se infrinjan los
                    derechos de propiedad intelectual e industrial de AVANIS, de
                    terceros y/o de cualquier Usuario; (iv) un Perfil de Usuario
                    se crease de forma fraudulenta o se utilizase para cometer
                    fraude; (v) se vulneren las medidas técnicas de protección,
                    medidas de seguridad y/o se incluyan virus u otros archivos
                    maliciosos en LA PLATAFORMA.
                  </p>
                  <p>
                    AVANIS no será responsable de aquellas obligaciones asumidas
                    y/o derechos que hubiesen adquirido por la relación
                    establecida y/o cualquier contratación realizada entre los
                    Usuarios de LA PLATAFORMA por su cuenta, pues como
                    intermediario, serán los propios Usuarios los responsables
                    del cumplimiento de los compromisos asumidos y adquiridos a
                    estos efectos en cada momento. Asimismo, AVANIS no se
                    responsabiliza del incumplimiento, ni total ni parcial, de
                    cualquier cuestión relativa a los posibles acuerdos
                    alcanzados entre los Usuarios, sus condiciones y/o
                    cualesquiera otros extremos en los que no interviene.
                  </p>
                  <p>
                    AVANIS tiene el derecho de suspender temporalmente y sin
                    preaviso la accesibilidad a LA PLATAFORMA, como por ejemplo
                    en el caso de necesidad urgente para el mantenimiento de LA
                    PLATAFORMA, actualizaciones de la misma o por razones de
                    seguridad de LA PLATAFORMA, así como a reservarse el derecho
                    de prestación o cancelación de los servicios, contenidos o
                    de LA PLATAFORMA de forma permanente, intentando ponerlo
                    previamente en conocimiento de los Usuarios, siempre que las
                    circunstancias así se lo permitan.
                  </p>
                  <p>
                    AVANIS no será responsable por los daños y perjuicios que
                    puedan producirse por el uso, la imposibilidad de uso y/o de
                    posibles fallos en LA PLATAFORMA debidos a la configuración
                    errónea o insuficiente del sistema informático de los
                    Usuarios, ni será responsable por daños provocados por virus
                    como troyanos o programas similares, ni por programas o
                    códigos que provoquen un daño, destrucción o inactividad
                    similar del sistema informático de los Usuarios. Por ello,
                    cada Usuario deberá adoptar por su cuenta las medidas
                    necesarias para protegerse de virus y de otros programas
                    maliciosos, instalando por ejemplo un antivirus y/o
                    cualesquiera otras medidas que considere para su protección.
                  </p>
                  <h2>Disposiciones Generales</h2>
                  <p>
                    Las presentes Condiciones de Uso constituyen el acuerdo
                    total entre los Usuarios y AVANIS. Estas Condiciones de Uso
                    solo se podrán modificar mediante una corrección escrita
                    firmada por una persona autorizada de AVANIS o a través de
                    la publicación de una versión revisada de estas.
                  </p>
                  <p>
                    Si cualquier cláusula de las presentes Condiciones de Uso
                    fuese declarada total o parcialmente nula o ineficaz
                    afectará tan solo a esa disposición o parte de la misma que
                    resulte nula o ineficaz, subsistiendo en todo lo demás el
                    resto de las Condiciones de Uso y teniéndose tal disposición
                    o la parte de la misma que resulte afectada por no puesta
                    salvo que, por resultar esencial a las presentes Condiciones
                    de Uso, hubiese de afectarlas de manera integral.
                  </p>
                  <p>
                    Los Usuarios podrán dar de baja el Perfil de Usuario de LA
                    PLATAFORMA en cualquier momento, sin perjuicio de aquellas
                    obligaciones que hubiesen adquirido y/o que pudiesen
                    continuar vigentes en su caso, mediante el envío de una
                    comunicación a la dirección de correo electrónico
                    soporte@avanis.es, o a través de la sección
                    <a
                      href="/profile"
                      target="_blank"
                      >“Mi perfil”.</a
                    >
                  </p>
                  <p>
                    La baja del Perfil de Usuario conllevará el cierre del
                    Perfil y no da derecho al Usuario a indemnización alguna.
                  </p>
                  <p>
                    LA PLATAFORMA y sus contenidos se ofrecen en lengua
                    española, aunque podrán estar disponibles en otros idiomas,
                    por lo que, ante cualquier conflicto en la aplicación o
                    interpretación de estas Condiciones de Uso, el Aviso Legal,
                    las Políticas de Privacidad y/o la Política de Cookies de
                    AVANIS, siempre prevalecerá la versión en lengua española
                    sobre cualquier otra.
                  </p>
                  <p>
                    Las Condiciones de Uso tendrán vigencia a partir del momento
                    en que el Usuario cree su Perfil de Usuario por tiempo
                    indefinido en lo que se refiere al uso de LA PLATAFORMA de
                    AVANIS, hasta que el Usuario diese de baja su Perfil de
                    Usuario o, por cualquier circunstancia, LA PLATAFORMA se
                    cerrase.
                  </p>
                  <p>
                    Ni AVANIS ni los Usuarios serán responsables o incumplidores
                    de las presentes Condiciones de Uso en caso de retraso o
                    incumplimiento por causas de fuerza mayor, en los supuestos
                    contemplados en la legislación.
                  </p>
                  <p>
                    Los Usuarios no podrán ceder total o parcialmente, ni
                    onerosa ni gratuitamente, los derechos u obligaciones
                    adquiridos en las presentes Condiciones de Uso. Si se
                    incumple esta prohibición, se podrá cancelar el Perfil del
                    Usuario, sin perjuicio del derecho de AVANIS a ejercitar las
                    acciones judiciales que en su caso procedan, así como las
                    correspondientes por daños y perjuicios que pudieran
                    producirse por esa causa.
                  </p>
                  <h2>Ley aplicable y Jurisdicción</h2>
                  <p>
                    Estas Condiciones de Uso, las Políticas de Privacidad y
                    Cookies y el Aviso Legal de LA PLATAFORMA, así como
                    cualquier relación entre los Usuarios y AVANIS, se regirán
                    por la legislación española. En caso de conflicto en la
                    aplicación o interpretación de dichos documentos, las partes
                    se someten a los Juzgados y Tribunales de Madrid.
                  </p>
                  <p>
                    Sin perjuicio de lo anterior, cuando el Usuario sea
                    considerado como Consumidor podrá reclamar sus derechos como
                    tal en relación con las Condiciones de Uso, el Aviso Legal y
                    las Políticas de Privacidad y Cookies tanto ante los órganos
                    jurisdiccionales en España en que esté domiciliado el
                    Consumidor como ante los órganos jurisdiccionales en su
                    Estado Miembro de residencia en la Unión Europea. Asimismo,
                    en cumplimiento de lo establecido en el artículo 14.1 del
                    Reglamento (UE) 524/2013 del Parlamento Europeo y del
                    Consejo de 21 de mayo de 2013, el Usuario queda informado de
                    la existencia de una plataforma de resolución extrajudicial
                    de litigios online puesta a disposición por la Comisión
                    Europea, disponible en:
                    <a
                      href="http://ec.europa.eu/consumers/odr/"
                      target="_blank"
                      >http://ec.europa.eu/consumers/odr/</a
                    >y a través de la cual los Consumidores podrán someter sus
                    reclamaciones.
                  </p>
                </div>
              </div>
              <div class="modal-footer">
                <button
                  type="button"
                  class="btn btn-secondary"
                  data-dismiss="modal"
                >
                  Cerrar
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

