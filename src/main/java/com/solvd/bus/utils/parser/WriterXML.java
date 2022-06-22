package com.solvd.bus.utils.parser;

import com.solvd.bus.domain.Trip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class WriterXML {

    public static final String xmlFilePath = "src/main/resources/xml/trip.xml";
    Trip trip;

    private static final Logger LOGGER = LogManager.getLogger(WriterXML.class);

    public WriterXML(Trip trip) {
        this.trip = trip;
    }

    public void writeXML() {

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // Element
            Element root = document.createElement("Trip");
            document.appendChild(root);

            // Trip
            Attr attribute = document.createAttribute("PathNode");
            attribute.setValue(this.trip.toString());

            // create the xml file
            //transform the DOM Object to an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

        } catch (ParserConfigurationException e) {
            LOGGER.error(e);
        } catch (TransformerException te) {
            LOGGER.error(te);
        }
    }
}