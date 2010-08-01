package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphMode;

public class GraphEntityParser extends AbstractEntityParser<Graph> {
	private static final String ATTRIB_EDGETYPE = "defaultedgetype";
	private static final String ATTRIB_MODE = "mode";
	private static final String ENTITY_ATTRIBUTES = "attributes";
	private static final String ENTITY_NODES = "nodes";
	private static final String ENTITY_EDGES = "edges";
	
	private Graph graph = null;
	
	public GraphEntityParser(XMLStreamReader reader, Graph graph) {
		super(reader);
		this.graph = graph;
	}

	@Override
	protected Graph newEntity() {
		return graph;
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_EDGETYPE.equalsIgnoreCase(name)) {
			entity.setDefaultEdgeType(EdgeType.valueOf(value.toUpperCase()));
			
		} else if (ATTRIB_MODE.equalsIgnoreCase(name)) {
			entity.setGraphMode(GraphMode.valueOf(value.toUpperCase()));
		}
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_ATTRIBUTES.equalsIgnoreCase(reader.getLocalName())) {
			/*AttributesEntityParser aep = new AttributesEntityParser(reader);
			if (aep.getAttClass() == AttributeClass.NODE) {
				attribsNodes = aep.getEntity();
			} else if (aep.getAttClass() == AttributeClass.EDGE) {
				attribsEdges = aep.getEntity();
			}*/
			
		} else if (ENTITY_NODES.equalsIgnoreCase(reader.getLocalName())) {
			new NodesEntityParser(reader, entity);
			
		} else if (ENTITY_EDGES.equalsIgnoreCase(reader.getLocalName())) {
			new EdgesEntityParser(reader, entity);
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