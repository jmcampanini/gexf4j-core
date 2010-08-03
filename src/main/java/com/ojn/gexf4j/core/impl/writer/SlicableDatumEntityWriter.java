package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.SlicableDatum;

public abstract class SlicableDatumEntityWriter<T extends SlicableDatum<?>> extends SlicableEntityWriter<T> {

	public SlicableDatumEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		super.writeElements();
		new AttValuesEntityWriter(writer, entity.getAttributeValues());
	}	
}