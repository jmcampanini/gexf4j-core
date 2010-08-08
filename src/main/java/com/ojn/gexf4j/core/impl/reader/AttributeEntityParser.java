package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.data.AttributeType;

public class AttributeEntityParser extends AbstractEntityParser<Attribute> {
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_TITLE = "title";
	private static final String ATTRIB_TYPE = "type";
	private static final String ENTITY_DEFAULT = "default";
	private static final String ENTITY_OPTIONS = "options";
	
	private AttributeList attribList = null;
	private String id = "";
	private String title = "";
	private AttributeType type = AttributeType.STRING;
		
	public AttributeEntityParser(XMLStreamReader reader, AttributeList attribList) {
		super(reader, null);
		this.attribList = attribList;
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_ID.equalsIgnoreCase(name)) {
			id = value;
			
		} else if (ATTRIB_TITLE.equalsIgnoreCase(name)) {
			title = value;
			
		} else if (ATTRIB_TYPE.equalsIgnoreCase(name)) {
			type = AttributeType.valueOf(value.toUpperCase());
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		if (ENTITY_DEFAULT.equalsIgnoreCase(name)) {
			String defaultValue = new StringEntityParser(reader).getEntity();
			entity.setDefaultValue(defaultValue);
			
		} else if (ENTITY_OPTIONS.equalsIgnoreCase(name)) {
			String options = new StringEntityParser(reader).getEntity();
			Iterables.addAll(
					entity.getOptions(),
					Splitter
						.on(',')
						.omitEmptyStrings()
						.trimResults()
						.split(options));
		}
	}

	@Override
	protected void buildEntity() {
		entity = attribList.createAttribute(id, type, title);
		super.buildEntity();
	}
}