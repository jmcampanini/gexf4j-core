package com.ojn.gexf4j.core.impl.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;

public class EdgesEntityParser extends AbstractEntityParser<List<Edge>> {
	private static final String ENTITY_EDGE = "edge";
	
	private Map<String, Node> nodeMap = null;
	private List<Attribute> attributes = null;
	
	public EdgesEntityParser(XMLStreamReader reader, Map<String, Node> nodeMap, List<Attribute> attributes) {
		super(reader);
		this.nodeMap = nodeMap;
		this.attributes = attributes;
	}

	@Override
	protected List<Edge> newEntity() {
		return new ArrayList<Edge>();
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_EDGE.equalsIgnoreCase(reader.getLocalName())) {
			EdgeEntityParser eep = new EdgeEntityParser(reader, nodeMap, attributes);
			entity.add(eep.getEntity());
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
}