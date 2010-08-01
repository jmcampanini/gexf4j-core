package com.ojn.gexf4j.core.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphReader;
import com.ojn.gexf4j.core.impl.reader.GexfEntityParser;

public class StaxGraphReader implements GraphReader {

	@Override
	public Graph readFromStream(InputStream in) throws IOException {
		
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			XMLStreamReader reader = inputFactory.createXMLStreamReader(in);
			
			GexfEntityParser gexfParser = new GexfEntityParser(reader);
			gexfParser.parse();
			
			return gexfParser.getGraph();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	@Override
	public Graph readFromStream(InputStream in) throws IOException {
		
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			XMLStreamReader reader = inputFactory.createXMLStreamReader(in);
			
			while (reader.hasNext()) {
				switch (reader.next()) {
					case XMLEvent.START_ELEMENT:
						System.out.print("START_ELEMENT\t");
						System.out.print(reader.getLocalName() + "\t");
						System.out.println("AttribCount: " + reader.getAttributeCount());
						
						if (reader.getLocalName().equalsIgnoreCase("meta")) {
							GraphMetadata m = new MetaEntityParser(reader).getEntity();
							System.out.println(m.getCreator());
							System.out.println(m.getDescription());
							System.out.println(m.getKeywords().size());
							System.out.println(m.getLastModified());
						}
						
						break;
						
					case XMLEvent.ATTRIBUTE:
						System.out.print("ATTRIBUTE\t");
						System.out.println("AttribCount: " + reader.getAttributeCount());
						break;
						
					case XMLEvent.CHARACTERS:
						System.out.print("CHARACTERS\t");
						System.out.println("CHARS: " + reader.getText());
						break;
						
					case XMLEvent.END_ELEMENT:
						System.out.println("END ELEMENT\t");
						break;
				}
			}
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	*/
}