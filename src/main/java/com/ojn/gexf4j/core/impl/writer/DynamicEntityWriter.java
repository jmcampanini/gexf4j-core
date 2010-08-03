package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.Dynamic;

public abstract class DynamicEntityWriter<T extends Dynamic<?>> extends AbstractEntityWriter<T> {
	private static final String ATTRIB_START = "start";
	private static final String ATTRIB_END = "end";
	
	public DynamicEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		if (entity.hasStartDate()) {
			writer.writeAttribute(
					ATTRIB_START,
					AbstractEntityWriter.toDateString(entity.getStartDate()));
		}
		
		if (entity.hasEndDate()) {
			writer.writeAttribute(
					ATTRIB_END,
					AbstractEntityWriter.toDateString(entity.getEndDate()));
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}