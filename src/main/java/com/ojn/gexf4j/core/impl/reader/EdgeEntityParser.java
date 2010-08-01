package com.ojn.gexf4j.core.impl.reader;

import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.impl.EdgeImpl;

public class EdgeEntityParser extends AbstractEntityParser<Edge> {
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	private static final String ATTRIB_SOURCE = "source";
	private static final String ATTRIB_TARGET = "target";
	private static final String ATTRIB_WEIGHT = "weight";
	private static final String ATTRIB_TYPE = "type";
	private static final String ENTITY_ATTVALUES = "attvalues";
	
	private Map<String, Node> nodeMap = null;
	private List<Attribute> attributes = null;
	private List<AttributeValue> attributeValues = null;
	private String id = "";
	private String label = "";
	private Node source = null;
	private Node target = null;
	private float weight = 0.0f;
	private EdgeType type = EdgeType.NOTSET;
	
	public EdgeEntityParser(XMLStreamReader reader, Map<String, Node> nodeMap, List<Attribute> attributes) {
		super(reader);
		this.nodeMap = nodeMap;
		this.attributes = attributes;
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
			source = nodeMap.get(value);
			
		} else if (ATTRIB_TARGET.equalsIgnoreCase(name)) {
			target = nodeMap.get(value);
			
		} else if (ATTRIB_WEIGHT.equalsIgnoreCase(name)) {
			weight = Float.parseFloat(value);
			
		} else if (ATTRIB_TYPE.equalsIgnoreCase(name)) {
			type = EdgeType.valueOf(value);
		}
			
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_ATTVALUES.equalsIgnoreCase(reader.getLocalName())) {
			AttValuesEntityParser avep = new AttValuesEntityParser(reader, attributes);
			attributeValues = avep.getEntity();
		}
	}

	@Override
	public Edge getEntity() {
		Edge rv = new EdgeImpl(id, source, target);
		
		rv.setEdgeType(type);
		rv.setLabel(label);
		rv.setWeight(weight);
		rv.getAttributeValues().addAll(attributeValues);
		
		return rv;
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