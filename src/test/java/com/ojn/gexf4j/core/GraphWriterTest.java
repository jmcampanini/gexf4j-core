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

import com.ojn.gexf4j.core.testgraphs.BasicGraphBuilder;
import com.ojn.gexf4j.core.testgraphs.DataGraphBuilder;
import com.ojn.gexf4j.core.testgraphs.GraphBuilder;
import com.ojn.gexf4j.core.testgraphs.MetaDataGraphBuilder;

@RunWith(Parameterized.class)
public abstract class GraphWriterTest {

	protected abstract String getFileNamePrefix();
	protected abstract GraphWriter newGraphWriter();

	protected GraphBuilder builder = null;
	
	@Parameters
	public static List<Object[]> getData() {
		List<Object[]> rv = new ArrayList<Object[]>();
		
		rv.add(new GraphBuilder[] { new BasicGraphBuilder() });
		rv.add(new GraphBuilder[] { new DataGraphBuilder() });
		rv.add(new GraphBuilder[] { new MetaDataGraphBuilder() });
		
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
}