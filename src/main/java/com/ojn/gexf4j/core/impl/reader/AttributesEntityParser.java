package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.impl.data.AttributeListImpl;

public class AttributesEntityParser extends DynamicEntityParser<AttributeList> {
	private static final String ATTRIB_CLASS = "class";
	private static final String ATTRIB_MODE = "mode";
	private static final String ENTITY_ATTRIBUTE = "attribute";
	
	private Mode mode = Mode.STATIC;
	AttributeClass attrClass = AttributeClass.NODE;
	
	public AttributesEntityParser(XMLStreamReader reader, AttributeList entity) {
		super(reader, entity);
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		super.onAttribute(name, value);
		
		if (ATTRIB_CLASS.equalsIgnoreCase(name)) {
			attrClass = AttributeClass.valueOf(value.toUpperCase());
						
		} else if (ATTRIB_MODE.equalsIgnoreCase(name)) {
			mode = Mode.valueOf(value.toUpperCase());
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		super.onStartElement(name, reader);
		
		if (ENTITY_ATTRIBUTE.equalsIgnoreCase(name)) {
			new AttributeEntityParser(reader, entity);
		}
	}

	@Override
	protected void buildEntity() {
		entity = new AttributeListImpl(attrClass);
		entity.setMode(mode);
		super.buildEntity();
	}
}