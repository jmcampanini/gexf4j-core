package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.Slice;

public class SliceEntityWriter extends DynamicEntityWriter<Slice> {
	private static final String ENTITY = "slice";
	
	public SliceEntityWriter(XMLStreamWriter writer, Slice entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}
}