package com.ojn.gexf4j.core.impl.writer;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.Slice;

public class SlicesEntityWriter extends AbstractEntityWriter<List<Slice>> {
	private static final String ENTITY = "slices";
	
	public SlicesEntityWriter(XMLStreamWriter writer, List<Slice> entity) {
		super(writer, entity);
		
		if (!entity.isEmpty()) {
			write();
		}
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		for (Slice s : entity) {
			new SliceEntityWriter(writer, s);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}