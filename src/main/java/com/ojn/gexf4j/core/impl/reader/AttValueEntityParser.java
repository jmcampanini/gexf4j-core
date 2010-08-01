package com.ojn.gexf4j.core.impl.reader;

import java.util.List;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.impl.data.AttributeValueImpl;

public class AttValueEntityParser extends AbstractEntityParser<AttributeValue> {
	private static final String ATTRIB_FOR = "for";
	private static final String ATTRIB_VALUE = "value";
	
	private List<Attribute> attributes = null;
	private String value = "";
	private Attribute valueFor = null;
	
	public AttValueEntityParser(XMLStreamReader reader, List<Attribute> attributes) {
		super(reader);
		this.attributes = attributes;
	}

	@Override
	protected AttributeValue newEntity() {
		return null;
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_FOR.equalsIgnoreCase(name)) {
			valueFor = attributes.get(Integer.parseInt(value, 10));
			
		} else if (ATTRIB_VALUE.equalsIgnoreCase(name)) {
			this.value = value;
		}
	}

	@Override
	public AttributeValue getEntity() {
		AttributeValue rv = new AttributeValueImpl(valueFor, value);
		return rv;
	}

	@Override
	protected void onCharacters(XMLStreamReader reader) {
		// do nothing
	}

	@Override
	protected void onOther(XMLStreamReader reader, int eventType) {
		// do nothing
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		// do nothing
	}
}