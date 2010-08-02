package com.ojn.gexf4j.core.impl.writer;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;

public class AttributesEntityWriter extends AbstractEntityWriter<List<Attribute>> {
	private static final String ENTITY = "attributes";
	private static final String ATTRIB_CLASS = "class";
	private static final String ATTRIB_MODE = "mode";
	
	private AttributeClass attClass = AttributeClass.NODE;
	
	public AttributesEntityWriter(XMLStreamWriter writer, List<Attribute> entity, AttributeClass attClass) {
		super(writer, entity);
		this.attClass = attClass;
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_CLASS,
				attClass.toString().toLowerCase());
		
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// TODO Auto-generated method stub
		
	}

}