package ua.issoft.store.helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser {

    public XMLParser(String pathnameXML) {
        this.pathnameXML = pathnameXML;
    }

    String pathnameXML;

    public Map<String, String> getConfigMap() {
        Map<String, String> sortMap = new LinkedHashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = dbf.newDocumentBuilder().parse(new File(pathnameXML));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
        Node softNode = document.getFirstChild();
        NodeList softChildNodes = softNode.getChildNodes();
        for (int i = 0; i < softChildNodes.getLength(); i++) {
            if (softChildNodes.item(i).getNodeType() == Node.ELEMENT_NODE)
                sortMap.put(softChildNodes.item(i).getNodeName(), softChildNodes.item(i).getTextContent());
        }
        return sortMap;
    }
}
