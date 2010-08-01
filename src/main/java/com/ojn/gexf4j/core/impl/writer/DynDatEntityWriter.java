package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.DynamicDatum;

public abstract class DynDatEntityWriter<T extends DynamicDatum<?>> extends DynamicEntityWriter<T>{

	public DynDatEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected void write() {
		try {
			writer.writeStartElement(getElementName());
			
			writeAttributes();
			writeDynamicAttributes();
			writeDatumAttributes();
			
			writeElements();
			writeDynamicElements();
			writeDatumElements();
			
			writer.writeEndElement();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	protected void writeDatumElements() {
		if (!entity.getAttributeValues().isEmpty()) {
			new AttValuesEntityWriter(writer, entity.getAttributeValues());
		}
	}
	
	protected void writeDatumAttributes() {
		// do nothing
	}
}