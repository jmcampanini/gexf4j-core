package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.data.AttributeValueList;

public class AttValuesEntityParser extends AbstractEntityParser<AttributeValueList>{
	private static final String ENTITY_ATTVALUE = "attvalue";
	
	private Graph graph = null;
	
	public AttValuesEntityParser(XMLStreamReader reader, AttributeValueList entity, Graph graph) {
		super(reader, entity);
		this.graph = graph;
		parse();
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		if (ENTITY_ATTVALUE.equalsIgnoreCase(name)) {
			AttValueEntityParser avep = new AttValueEntityParser(reader, graph);
			entity.add(avep.getEntity());
		}
	}

	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
	}
}