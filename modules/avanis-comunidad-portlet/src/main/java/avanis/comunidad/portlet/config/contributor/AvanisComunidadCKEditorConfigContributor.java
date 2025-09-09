package avanis.comunidad.portlet.config.contributor;

import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

@Component(
        immediate = true,
        property = {
                "editor.name=ckeditor_bbcode",
                "editor.name=ckeditor",
                "editor.name=ckeditor_classic",
                "editor.name=tinymce",
                "javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD
        },

        service = EditorConfigContributor.class
)
public class AvanisComunidadCKEditorConfigContributor extends BaseEditorConfigContributor {
        @Override
        public void populateConfigJSONObject(JSONObject jsonObject, Map<String, Object> map, ThemeDisplay themeDisplay, RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

                String extraPlugins = jsonObject.getString("extraPlugins");

                extraPlugins = extraPlugins.concat(",smiley");

                jsonObject.put(
                        "extraPlugins", extraPlugins
                );
                jsonObject.put("shiftLineBreaks", false);
        }

}

