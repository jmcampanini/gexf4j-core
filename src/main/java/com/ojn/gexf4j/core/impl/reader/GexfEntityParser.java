package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.impl.GraphImpl;

public class GexfEntityParser extends AbstractEntityParser<Graph> {
	private static final String ATTRIB_VERSION = "version";
	private static final String ENTITY_META = "meta";
	private static final String ENTITY_GRAPH = "graph";
	
	public GexfEntityParser(XMLStreamReader reader) {
		super(reader);
	}
	
	@Override
	protected Graph newEntity() {
		return new GraphImpl();
	}
	
	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_VERSION.equalsIgnoreCase(name)) {
			// ensure it is version 1.1
		}
	}
	
	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_META.equalsIgnoreCase(reader.getLocalName())) {
			new MetaEntityParser(reader, entity);
			
		} else if (ENTITY_GRAPH.equalsIgnoreCase(reader.getLocalName())) {
			new GraphEntityParser(reader, entity);
		}
	}
	
	@Override
	protected void onCharacters(XMLStreamReader reader) {
		// do nothing
	}
	
	@Override
	protected void onOther(XMLStreamReader reader, int eventType) {
		// do nothing
	}

	@Override
	protected void onEndElement() {
		// do nothing
	}
}