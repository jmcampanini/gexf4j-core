package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;

public class EdgeEntityParser extends AbstractEntityParser<Edge> {
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	private static final String ATTRIB_SOURCE = "source";
	private static final String ATTRIB_TARGET = "target";
	private static final String ATTRIB_WEIGHT = "weight";
	private static final String ATTRIB_TYPE = "type";
	// private static final String ENTITY_ATTVALUES = "attvalues";
	
	private Graph graph = null;
	private String id = "";
	private String label = "";
	private String source = null;
	private String target = null;
	private float weight = 0.0f;
	private EdgeType type = EdgeType.NOTSET;
	
	public EdgeEntityParser(XMLStreamReader reader, Graph graph) {
		super(reader);
		this.graph = graph;
	}

	@Override
	protected Edge newEntity() {
		return null;
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_ID.equalsIgnoreCase(name)) {
			id = value;
			
		} else if (ATTRIB_LABEL.equalsIgnoreCase(name)) {
			label = value;
			
		} else if (ATTRIB_SOURCE.equalsIgnoreCase(name)) {
			source = value;
			
		} else if (ATTRIB_TARGET.equalsIgnoreCase(name)) {
			target = value;
			
		} else if (ATTRIB_WEIGHT.equalsIgnoreCase(name)) {
			weight = Float.parseFloat(value);
			
		} else if (ATTRIB_TYPE.equalsIgnoreCase(name)) {
			type = EdgeType.valueOf(value);
		}
			
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		/*if (ENTITY_ATTVALUES.equalsIgnoreCase(reader.getLocalName())) {
			AttValuesEntityParser avep = new AttValuesEntityParser(reader, attributes);
			attributeValues = avep.getEntity();
		}*/
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
		Node ns = graph.getNodeMap().get(source);
		Node nt = graph.getNodeMap().get(target);
		
		Edge e = ns.connectTo(id, nt);
		e.setEdgeType(type);
		e.setLabel(label);
		e.setWeight(weight);
	}
}