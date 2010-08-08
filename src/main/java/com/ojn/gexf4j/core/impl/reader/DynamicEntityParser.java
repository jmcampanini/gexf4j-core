package com.ojn.gexf4j.core.impl.reader;

import java.util.Date;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.dynamic.Dynamic;

public abstract class DynamicEntityParser<T extends Dynamic<?>> extends AbstractEntityParser<T> {
	private static final String ATTRIB_START = "start";
	private static final String ATTRIB_END = "end";
	
	private Date startDate = null;
	private Date endDate = null;
	
	public DynamicEntityParser(XMLStreamReader reader, T entity) {
		super(reader, entity);
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_START.equalsIgnoreCase(name)) {
			startDate = fromDateString(value);
			
		} else if (ATTRIB_END.equalsIgnoreCase(name)) {
			endDate = fromDateString(value);
		}
	}
	
	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		// do nothing
	}

	@Override
	protected void buildEntity() {
		entity.setStartDate(startDate);
		entity.setEndDate(endDate);
		
		super.buildEntity();
	}
}