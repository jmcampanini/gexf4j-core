package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;

public class NodesEntityWriter extends AbstractEntityWriter<Graph> {
	private static final String ENTITY = "nodes";
	
	public NodesEntityWriter(XMLStreamWriter writer, Graph entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		for (Node n : entity.getNodeMap().values()) {
			new NodeEntityWriter(writer, n);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}