package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLFileParsing {
    public static void main(String[] args) throws Exception {
        File file = new File("example.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        System.out.println("Root: " + doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("employee");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                System.out.println(el.getElementsByTagName("name").item(0).getTextContent()); //moze zwracac wiecej el ale my mamy tylko jedno name w employee
                System.out.println("surname: " + el.getElementsByTagName("name").item(0).getAttributes().getNamedItem("surname").getTextContent());
                System.out.println(el.getElementsByTagName("jobtitle").item(0).getTextContent());
                System.out.println("id: " + el.getElementsByTagName("id").item(0).getTextContent());
            }
        }

    }
}
