package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.data.AttributeValue;

public class AttValueEntityParser extends DynamicEntityParser<AttributeValue> {
	private static final String ATTRIB_FOR = "for";
	private static final String ATTRIB_VALUE = "value";
	
	private Graph graph = null;
	private String forId = "";
	private String value = "";
	
	public AttValueEntityParser(XMLStreamReader reader, Graph graph) {
		super(reader, null);
		this.graph = graph;
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		super.onAttribute(name, value);
		
		if (ATTRIB_FOR.equalsIgnoreCase(name)) {
			forId = value;
			
		} else if (ATTRIB_VALUE.equalsIgnoreCase(name)) {
			this.value = value;
		}
	}
	
	@Override
	protected void buildEntity() {
		entity = graph.getAttributeById(forId).createValue(value);
		super.buildEntity();
	}
}