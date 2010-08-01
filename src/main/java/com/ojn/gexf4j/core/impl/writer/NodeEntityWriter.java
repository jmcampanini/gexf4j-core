package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Node;

public class NodeEntityWriter extends AbstractEntityWriter<Node> {
	private static final String ENTITY = "node";
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	
	public NodeEntityWriter(XMLStreamWriter writer, Node entity) {
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
				ATTRIB_LABEL,
				entity.getLabel());
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}