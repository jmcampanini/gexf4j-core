package com.ojn.gexf4j.core.impl.reader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;

public class NodesEntityParser extends AbstractEntityParser<List<Node>> {
	private static final String ENTITY_NODE = "node";
	
	private List<Attribute> attributes = null;
	private Graph graph = null;
	
	public NodesEntityParser(XMLStreamReader reader, List<Attribute> attributes, Graph graph) {
		super(reader);
		this.attributes = attributes;
		this.graph = graph;
	}

	@Override
	protected List<Node> newEntity() {
		return new ArrayList<Node>();
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_NODE.equalsIgnoreCase(reader.getLocalName())) {
			new NodeEntityParser(reader, attributes, graph);
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
	protected void onAttribute(String name, String value) {
		// do nothing
	}
}