package avanis.listener.util;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(
    immediate = true,
    service = AvanisListenerUtil.class
)
public class AvanisListenerUtil {

    private static final Log _log = LogFactoryUtil.getLog(AvanisListenerUtil.class);

    public String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return normalized.toLowerCase(Locale.ROOT);
    }

    public String getFieldValueJournalArticle(JournalArticle article, String fieldName)  {
        String fieldValue = "";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new java.io.ByteArrayInputStream(article.getContent().getBytes("UTF-8")));

            Element rootElement = document.getDocumentElement();
            NodeList dynamicElements = rootElement.getElementsByTagName("dynamic-element");

            Map<String, Object> articleData = new HashMap<>();

            for (int i = 0; i < dynamicElements.getLength(); i++) {
                Node dynamicElement = dynamicElements.item(i);

                if (dynamicElement.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) dynamicElement;
                    String fieldReference = element.getAttribute("field-reference");
                    if (fieldReference.equals(fieldName)) {
                        Node dynamicContentNode = element.getElementsByTagName("dynamic-content").item(0);
                        if (dynamicContentNode != null) {
                            fieldValue = dynamicContentNode.getTextContent();
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            _log.error("Error en el parser de documento y recogiendo campo " + fieldName);
        }
        return fieldValue;
    }

}
