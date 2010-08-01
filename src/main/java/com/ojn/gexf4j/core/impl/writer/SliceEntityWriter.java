package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Slice;

public class SliceEntityWriter extends AbstractEntityWriter<Slice> {
	private static final String ENTITY = "slice";
	private static final String ATTRIB_START = "start";
	private static final String ATTRIB_END = "end";
	
	public SliceEntityWriter(XMLStreamWriter writer, Slice entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		if (entity.hasStartDate()) { 
			writer.writeAttribute(
					ATTRIB_START,
					sdf.format(entity.getStartDate()));
		}
		
		if (entity.hasStartDate()) { 
			writer.writeAttribute(
					ATTRIB_END,
					sdf.format(entity.getEndDate()));
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}