package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.dynamic.Slicable;

public class SlicableEntityParser<T extends Slicable<?>> extends DynamicEntityParser<T> {
	private static final String ENTITY_SLICES = "slices";
	
	public SlicableEntityParser(XMLStreamReader reader, T entity) {
		super(reader, entity);
	}
	
	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		super.onStartElement(name, reader);
		
		if (ENTITY_SLICES.equalsIgnoreCase(name)) {
			new SlicesEntityParser(reader, entity.getSlices());
		}
	}
}