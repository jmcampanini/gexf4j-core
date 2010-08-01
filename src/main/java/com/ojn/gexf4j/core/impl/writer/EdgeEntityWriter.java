package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;

public class EdgeEntityWriter extends AbstractEntityWriter<Edge> {
	private static final String ENTITY = "edge";
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	private static final String ATTRIB_SOURCE = "source";
	private static final String ATTRIB_TARGET = "target";
	private static final String ATTRIB_WEIGHT = "weight";
	private static final String ATTRIB_TYPE = "type";
	
	public EdgeEntityWriter(XMLStreamWriter writer, Edge entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_ID,
				entity.getId());
		
		writer.writeAttribute(
				ATTRIB_SOURCE,
				entity.getSource().getId());
		
		writer.writeAttribute(
				ATTRIB_TARGET,
				entity.getTarget().getId());
		
		if (entity.hasLabel()) {
			writer.writeAttribute(
					ATTRIB_LABEL,
					entity.getLabel());
		}
		
		if (entity.hasWeight()) {
			writer.writeAttribute(
					ATTRIB_WEIGHT,
					Float.toString(entity.getWeight()));
		}
		
		if (entity.getEdgeType() != EdgeType.NOTSET) {
			writer.writeAttribute(
					ATTRIB_TYPE,
					entity.getEdgeType().toString().toLowerCase());
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}