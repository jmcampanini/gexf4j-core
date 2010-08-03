package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.Slicable;

public abstract class SlicableEntityWriter<T extends Slicable<?>> extends DynamicEntityWriter<T> {

	public SlicableEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
		super.writeAttributes();
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		if (!entity.getSlices().isEmpty()) {
			new SlicesEntityWriter(writer, entity.getSlices());
		}
		super.writeElements();
	}	
}