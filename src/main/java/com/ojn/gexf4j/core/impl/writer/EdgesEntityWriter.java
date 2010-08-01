package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;

public class EdgesEntityWriter extends AbstractEntityWriter<Graph> {
	private static final String ENTITY = "edges";
	
	public EdgesEntityWriter(XMLStreamWriter writer, Graph entity) {
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
			for (Edge e : n.getEdges()) {
				new EdgeEntityWriter(writer, e);
			}
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}