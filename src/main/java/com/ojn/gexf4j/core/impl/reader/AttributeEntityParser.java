package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.impl.data.AttributeImpl;

public class AttributeEntityParser extends AbstractEntityParser<Attribute> {
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_TITLE = "title";
	private static final String ATTRIB_TYPE = "type";
	private static final String ENTITY_DEFAULT = "default";
	
	private String id = "";
	private String title = "";
	private AttributeType attType = AttributeType.STRING;
	private AttributeClass attClass = AttributeClass.NODE;
	private String defaultValue = "";
	
	public AttributeEntityParser(XMLStreamReader reader, AttributeClass attClass) {
		super(reader);
		this.attClass = attClass;
	}

	@Override
	protected Attribute newEntity() {
		return null;
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_ID.equalsIgnoreCase(name)) {
			id = value;
			
		} else if (ATTRIB_TITLE.equalsIgnoreCase(name)) {
			title = value;
			
		} else if (ATTRIB_TYPE.equalsIgnoreCase(name)) {
			attType = AttributeType.valueOf(value.toUpperCase());
		} 
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_DEFAULT.equalsIgnoreCase(reader.getLocalName())) {
			StringEntityParser sep = new StringEntityParser(reader);
			defaultValue = sep.getEntity();
		}
	}
	
	@Override
	public Attribute getEntity() {
		Attribute rv = new AttributeImpl(attType, id, attClass);
		
		rv.setDefaultValue(defaultValue);
		rv.setTitle(title);
		
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
}