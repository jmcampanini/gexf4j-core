package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.SlicableDatum;

public class SliceableDatumEntityParser<T extends SlicableDatum<?>> extends SlicableEntityParser<T> {
	private static final String ENTITY_ATTVALUES = "attvalues";
	
	protected Graph graph = null;
	
	public SliceableDatumEntityParser(XMLStreamReader reader, T entity, Graph graph) {
		super(reader, entity);
		this.graph = graph;
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		super.onStartElement(name, reader);
		
		if (ENTITY_ATTVALUES.equalsIgnoreCase(name)) {
			new AttValuesEntityParser(reader, entity.getAttributeValues(), graph);
		}
	}
}