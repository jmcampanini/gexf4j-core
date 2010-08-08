package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.IDType;
import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.dynamic.TimeType;

public class GraphEntityParser extends DynamicEntityParser<Graph> {
	private static final String ATTRIB_EDGETYPE = "defaultedgetype";
	private static final String ATTRIB_MODE = "mode";
	private static final String ATTRIB_IDTYPE = "idtype";
	private static final String ATTRIB_TIMETYPE = "timetype";
	private static final String ENTITY_NODES = "nodes";
	private static final String ENTITY_EDGES = "edges";
	private static final String ENTITY_ATTRIBUTES = "attributes";
	
	public GraphEntityParser(XMLStreamReader reader, Graph entity) {
		super(reader, entity);
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		super.onAttribute(name, value);
		
		if (ATTRIB_EDGETYPE.equalsIgnoreCase(name)) {
			entity.setDefaultEdgeType(EdgeType.valueOf(value.toUpperCase()));
			
		} else if (ATTRIB_MODE.equalsIgnoreCase(name)) {
			entity.setMode(Mode.valueOf(value.toUpperCase()));
			
		} else if (ATTRIB_IDTYPE.equalsIgnoreCase(name)) {
			entity.setIDType(IDType.valueOf(value.toUpperCase()));
			
		} else if (ATTRIB_TIMETYPE.equalsIgnoreCase(name)) {
			entity.setTimeType(TimeType.valueOf(value.toUpperCase()));
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		super.onStartElement(name, reader);
		
		if (ENTITY_NODES.equalsIgnoreCase(name)) {
			// new NodesEntityParser(reader, entity);
			
		} else if (ENTITY_EDGES.equalsIgnoreCase(name)) {
			// new EdgesEntityParser(reader, entity);
			
		} else if (ENTITY_ATTRIBUTES.equalsIgnoreCase(name)) {
			AttributesEntityParser aep = new AttributesEntityParser(reader, null);
			entity.getAttributeLists().add(aep.getEntity());
		}
	}
}