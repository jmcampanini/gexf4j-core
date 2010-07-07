package com.ojn.gexf4j.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.impl.GraphImpl;
import com.ojn.gexf4j.core.impl.data.AttributeImpl;

@RunWith(Parameterized.class)
public abstract class GraphWriterTest {

	protected abstract String getFileNamePrefix();
	protected abstract GraphWriter newGraphWriter();

	protected GraphBuilder builder = null;
	
	@Parameters
	public static List<Object[]> getData() {
		List<Object[]> rv = new ArrayList<Object[]>();
		
		rv.add(new GraphBuilder[] { basicGraph });
		rv.add(new GraphBuilder[] { dataGraph });
		
		return rv;
	}
	
	public GraphWriterTest(GraphBuilder builder) {
		this.builder = builder;
	}

	@Test
	public void writeToStream() throws SAXException, IOException {
		Graph g = builder.buildGraph();
		GraphWriter gw = newGraphWriter();
		String fileName = "target/" + getFileNamePrefix() + "_" + builder.getSuffix() + ".gexf";
		File f = new File(fileName);
		FileOutputStream fos = new FileOutputStream(f);
		
		gw.writeToStream(g, fos);
		
		URL schemaFile = new URL(builder.getXsdUrl());
		Source xmlFile = new StreamSource(f);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();

		validator.validate(xmlFile);
	}
	
	protected interface GraphBuilder {
		Graph buildGraph();
		String getSuffix();
		String getXsdUrl();
	}
	
	private static GraphBuilder basicGraph = new GraphBuilder() {
		
		@Override
		public String getSuffix() {
			return "basic";
		}
		
		@Override
		public String getXsdUrl() {
			return "http://gexf.net/1.1draft/gexf.xsd";
		}
		
		@Override
		public Graph buildGraph() {
			Graph g = new GraphImpl();
			
			Node n1 = g.createNode();
			Node n2 = g.createNode();
			Node n3 = g.createNode();
			
			n1.connectTo(n2);
			n1.connectTo(n3);
			
			return g;
		}
	};
	
	private static GraphBuilder dataGraph = new GraphBuilder() {
		
		@Override
		public String getSuffix() {
			return "data";
		}
		
		@Override
		public String getXsdUrl() {
			return "http://gexf.net/1.1draft/gexf.xsd";
		}
		
		@Override
		public Graph buildGraph() {
			Graph rv = new GraphImpl();
			
			Attribute attribUrl = new AttributeImpl(AttributeType.String, "0", AttributeClass.Node);
			Attribute attribInDegree = new AttributeImpl(AttributeType.String, "1", AttributeClass.Node);
			Attribute attribFrog = new AttributeImpl(AttributeType.String, "2", AttributeClass.Node);
			
			attribUrl.setTitle("url");
			attribInDegree.setTitle("indegree");
			attribFrog.setTitle("frog");
			
			rv.getAttributes().add(attribUrl);
			rv.getAttributes().add(attribInDegree);
			rv.getAttributes().add(attribFrog);
			
			Node nGephi = rv.createNode("0");
			nGephi.setLabel("Gephi");
			nGephi.getAttributeValues().add(attribUrl.createValue("http://gephi.org"));
			nGephi.getAttributeValues().add(attribInDegree.createValue("1"));
			
			Node nWebatlas = rv.createNode("1");
			nWebatlas.setLabel("Webatlas");
			nWebatlas.getAttributeValues().add(attribUrl.createValue("http://webatlas.fr"));
			nWebatlas.getAttributeValues().add(attribInDegree.createValue("2"));
			
			Node nRTGI = rv.createNode("2");
			nRTGI.setLabel("RTGI");
			nRTGI.getAttributeValues().add(attribUrl.createValue("http://rtgi.fr"));
			nRTGI.getAttributeValues().add(attribInDegree.createValue("1"));
			
			Node nBar = rv.createNode("3");
			nBar.setLabel("BarabasiLab");
			nBar.getAttributeValues().add(attribUrl.createValue("http://barabasilab.com"));
			nBar.getAttributeValues().add(attribInDegree.createValue("1"));
			nBar.getAttributeValues().add(attribFrog.createValue("false"));
			
			nGephi.connectTo("0", nWebatlas);
			nGephi.connectTo("1", nRTGI);
			nWebatlas.connectTo("2", nGephi);
			nRTGI.connectTo("3", nWebatlas);
			nGephi.connectTo("4", nBar);
			
			return rv;
		}
	};
}