package com.ojn.gexf4j.core.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GexfReader;
import com.ojn.gexf4j.core.impl.reader.GexfEntityParser;

public class StaxGraphReader implements GexfReader {

	@Override
	public Graph readFromStream(InputStream in) throws IOException {
		
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			XMLStreamReader reader = inputFactory.createXMLStreamReader(in);
			
			GexfEntityParser gexfParser = new GexfEntityParser(reader);
			
			return gexfParser.getGraph();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
			return null;
		}
	}
}