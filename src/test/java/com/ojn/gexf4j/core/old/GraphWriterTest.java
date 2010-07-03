package com.ojn.gexf4j.core.old;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.ojn.gexf4j.core.GraphWriter;

public abstract class GraphWriterTest {

	protected abstract GraphWriter newInstance();
	protected abstract String getFilename();
	
	protected GraphImpl generateGraph() {
		GraphImpl g = new GraphImpl();
		
		NodeImpl n1 = g.createNode();
		NodeImpl n2 = g.createNode();
		NodeImpl n3 = g.createNode();

		n1.connectTo(n2);
		n2.connectTo(n3);
		
		return g;
	}
	
	@Test
	public void generateGexf() throws IOException {
		GraphWriter gw = newInstance();
		
		File f = new File("target/" + getFilename());
		FileOutputStream fos = new FileOutputStream(f);
		
		gw.write(generateGraph(), fos);
		
		fos.close();
	}
	
	@Test
	public void validateGexf() throws SAXException, IOException {
		URL schemaFile = new URL("http://gexf.net/1.1draft/gexf.xsd");
		Source xmlFile = new StreamSource(new File("target/" + getFilename()));
		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		
		validator.validate(xmlFile);
	}
}