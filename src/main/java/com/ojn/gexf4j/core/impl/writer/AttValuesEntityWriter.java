package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.data.AttributeValueList;

public class AttValuesEntityWriter extends AbstractEntityWriter<AttributeValueList>{
	private static final String ENTITY = "attvalues";
	
	public AttValuesEntityWriter(XMLStreamWriter writer, AttributeValueList entity) {
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
		for (AttributeValue attval : entity) {
			new AttValueEntityWriter(writer, attval);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}