package com.ojn.gexf4j.core.impl.reader;

import java.util.List;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Graph;

public class EdgesEntityParser extends AbstractEntityParser<List<Edge>> {
	private static final String ENTITY_EDGE = "edge";
	
	private Graph graph = null;
	
	public EdgesEntityParser(XMLStreamReader reader, Graph graph) {
		super(reader);
		this.graph = graph;
	}

	@Override
	protected List<Edge> newEntity() {
		return null;
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_EDGE.equalsIgnoreCase(reader.getLocalName())) {
			new EdgeEntityParser(reader, graph);
		}
	}

	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
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