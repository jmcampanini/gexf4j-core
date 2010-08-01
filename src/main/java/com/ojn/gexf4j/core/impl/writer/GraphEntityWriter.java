package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphMode;

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
		
		if (entity.getGraphMode() != GraphMode.NOTSET) {
			writer.writeAttribute(
					ATTRIB_MODE,
					entity.getGraphMode().toString().toLowerCase());
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		new NodesEntityWriter(writer, entity);
		new EdgesEntityWriter(writer, entity);
	}
}