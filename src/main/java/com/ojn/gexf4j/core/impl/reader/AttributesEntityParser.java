package com.ojn.gexf4j.core.impl.reader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;

public class AttributesEntityParser extends AbstractEntityParser<List<Attribute>>{
	private static final String ATTRIB_CLASS = "class";
	private static final String ENTITY_ATTRIBUTE = "attribute";
	
	private AttributeClass attClass = AttributeClass.NODE;
	
	public AttributesEntityParser(XMLStreamReader reader) {
		super(reader);
	}

	@Override
	protected List<Attribute> newEntity() {
		return new ArrayList<Attribute>();
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_CLASS.equalsIgnoreCase(name)) {
			attClass = AttributeClass.valueOf(value.toUpperCase());
		}
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_ATTRIBUTE.equalsIgnoreCase(reader.getLocalName())) {
			AttributeEntityParser aep = new AttributeEntityParser(reader, attClass);
			entity.add(aep.getEntity());
		}
	}
	
	public AttributeClass getAttClass() {
		return attClass;
	}

	@Override
	protected void onCharacters(XMLStreamReader reader) {
		// do nothing
	}

	@Override
	protected void onOther(XMLStreamReader reader, int eventType) {
		// do nothing
	}
}