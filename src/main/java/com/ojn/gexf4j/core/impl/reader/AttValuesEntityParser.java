package com.ojn.gexf4j.core.impl.reader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;

public class AttValuesEntityParser extends AbstractEntityParser<List<AttributeValue>> {
	private static final String ENTITY_ATTVALUE = "attvalue";
	
	private List<Attribute> attributes = null;
	
	public AttValuesEntityParser(XMLStreamReader reader, List<Attribute> attributes) {
		super(reader);
		this.attributes = attributes;
	}

	@Override
	protected List<AttributeValue> newEntity() {
		return new ArrayList<AttributeValue>();
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_ATTVALUE.equalsIgnoreCase(reader.getLocalName())) {
			AttValueEntityParser avep = new AttValueEntityParser(reader, attributes);
			entity.add(avep.getEntity());
		}
	}
	
	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
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