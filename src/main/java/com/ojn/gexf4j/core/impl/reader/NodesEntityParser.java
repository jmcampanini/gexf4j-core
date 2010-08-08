package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;

public class NodesEntityParser extends AbstractEntityParser<Graph> {
	private static final String ATTRIB_COUNT = "count";
	private static final String ENTITY_NODE = "node";
	
	private int count = Integer.MIN_VALUE;
	
	public NodesEntityParser(XMLStreamReader reader, Graph entity) {
		super(reader, entity);
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_COUNT.equalsIgnoreCase(name)) {
			count = Integer.parseInt(value, 10);
			count += 0;
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		if (ENTITY_NODE.equalsIgnoreCase(name)) {
			new NodeEntityParser(reader, entity);
		}
	}
}