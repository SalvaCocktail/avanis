package avanis.listener.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "other", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "avanis.listener.configuration.AvanisListenerConfiguration", localization = "content/Language", name = "Listener Config")
public interface AvanisListenerConfiguration {

    @Meta.AD(name = "CRON EXPRESION NOTIFICACIONES AYUDAS", deflt="0 0 7 1/1 * ? *")
    String cronExpressionNotificacionesAyudas();

    @Meta.AD(name = "Dias Vencimiento", deflt="7")
    long getDiasVencimientos();

    @Meta.AD(name = "Url Sitio", deflt="https://www.avanis.es/es/")
    String urlSitio();

    @Meta.AD(name = "Titulo", deflt="Hay una nueva ayuda que afecta a tu explotación")
    String getTitulo();

    @Meta.AD(name = "Subtitulo", deflt="¿Ya has solicitado [title] ? Está hecha a tu medida.")
    String getSubtitulo();

    @Meta.AD(name = "Titulo", deflt="Ayuda [title] está a punto de vencer")
    String getTituloVencimiento();

    @Meta.AD(name = "Subtitulo", deflt="¿Aún no la has solicitado? ¡Estás a tiempo! Quedan [tiempo] días")
    String getSubtituloVencimiento();

    @Meta.AD(name = "idEstructuraAyudas", deflt="123704")
    long getIdEstructuraAyuda();

    @Meta.AD(name = "groupIdPortal", deflt="20117")
    long getGroupIdPortal();

}