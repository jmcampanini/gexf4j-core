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
	protected void write() {
		try {
			writer.writeStartElement(getElementName());
			
			writeAttributes();
			writeDynamicAttributes();
			
			writeElements();
			writeDynamicElements();
			
			writer.writeEndElement();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	protected void writeDynamicAttributes() throws XMLStreamException {
		if (entity.hasStartDate()) {
			writer.writeAttribute(
					ATTRIB_START,
					sdf.format(entity.getStartDate()));
		}
		
		if (entity.hasEndDate()) {
			writer.writeAttribute(
					ATTRIB_END,
					sdf.format(entity.getEndDate()));
		}
	}
	
	protected void writeDynamicElements() throws XMLStreamException {
		if (!entity.getSlices().isEmpty()) {
			new SlicesEntityWriter(writer, entity.getSlices());
		}
	}
}