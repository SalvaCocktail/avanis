package avanis.comunidad.portlet.config.contributor;

import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import com.liferay.petra.string.StringBundler;
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
                "editor.name=ckeditor_classic",
                "javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD
        },

        service = EditorConfigContributor.class
)
public class AvanisComunidadTinyMceEditorConfigContributor extends BaseEditorConfigContributor {
        @Override
        public void populateConfigJSONObject(JSONObject jsonObject, Map<String, Object> map, ThemeDisplay themeDisplay, RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

                String extraPlugins = jsonObject.getString("extraPlugins");

                extraPlugins = extraPlugins.concat(",smiley");

                jsonObject.put(
                        "extraPlugins", extraPlugins
                );

                String removePlugins = jsonObject.getString("removePlugins");

                //removePlugins = removePlugins.concat(",table,video");

                jsonObject.put(
                        /*
                        "removePlugins",
                        StringBundler.concat(
                                removePlugins, ",",
                                StringBundler.concat(
                        "bidi,div,font,forms,indentblock,keystrokes,maximize,",
                        //"newpage,pagebreak,preview,print,save,showblocks,smiley,",
                        "stylescombo,templates,video,table,image")))
                .put( */
                "extraPlugins", extraPlugins
                );
        }

}

