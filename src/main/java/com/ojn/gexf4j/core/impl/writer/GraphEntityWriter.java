package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.data.AttributeClass;

public class GraphEntityWriter extends DynamicEntityWriter<Graph> {
	private static final String ENTITY = "graph";
	private static final String ATTRIB_EDGETYPE = "defaultedgetype";
	private static final String ATTRIB_MODE = "mode";
	
	public GraphEntityWriter(XMLStreamWriter writer, Graph entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		if (entity.getDefaultEdgeType() != EdgeType.NOTSET) {
			writer.writeAttribute(
					ATTRIB_EDGETYPE,
					entity.getDefaultEdgeType().toString().toLowerCase());
		}
		
		if (entity.getMode() != Mode.NOTSET) {
			writer.writeAttribute(
					ATTRIB_MODE,
					entity.getMode().toString().toLowerCase());
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		if (!entity.getNodeAttributes().isEmpty()) {
			new AttributesEntityWriter(writer, entity.getNodeAttributes(), AttributeClass.NODE);
		}
		
		if (!entity.getEdgeAttributes().isEmpty()) {
			new AttributesEntityWriter(writer, entity.getEdgeAttributes(), AttributeClass.EDGE);
		}
		
		new NodesEntityWriter(writer, entity);
		new EdgesEntityWriter(writer, entity);
	}
}