package com.ojn.gexf4j.core;

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

public abstract class GraphWriterTest {

	protected abstract GraphWriter newInstance();
	protected abstract String getFilename();
	
	protected Graph generateGraph() {
		Graph g = new Graph();
		
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();

		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n2, n3);
		
		n1.getEdges().add(e1);
		n2.getEdges().add(e2);
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		
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