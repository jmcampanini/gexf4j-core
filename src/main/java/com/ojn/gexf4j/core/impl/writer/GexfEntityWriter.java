package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Graph;

public class GexfEntityWriter extends AbstractEntityWriter<Graph> {
	private static final String ENTITY = "gexf";
	private static final String ATTRIBUTE_VERSION = "version";
	private static final String VALUE_VERSION = "1.1";
	private static final String ATTRIBUTE_XMLNS = "xmlns";
	private static final String VALUE_XMLNS = "http://www.gexf.net/1.1draft";
	
	public GexfEntityWriter(XMLStreamWriter writer, Graph entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(ATTRIBUTE_VERSION, VALUE_VERSION);
		writer.writeAttribute(ATTRIBUTE_XMLNS, VALUE_XMLNS);
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		new MetadataEntityWriter(writer, entity.getMetadata());
		new GraphEntityWriter(writer, entity);
	}
}