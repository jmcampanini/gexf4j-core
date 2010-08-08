package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.viz.Color;

public class ColorEntityParser extends AbstractEntityParser<Color> {
	private static final String ATTRIB_R = "r";
	private static final String ATTRIB_G = "g";
	private static final String ATTRIB_B = "b";
	
	public ColorEntityParser(XMLStreamReader reader, Color entity) {
		super(reader, entity);
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_R.equalsIgnoreCase(name)) {
			entity.setR(Integer.parseInt(value, 10));
			
		} else if (ATTRIB_G.equalsIgnoreCase(name)) {
			entity.setG(Integer.parseInt(value, 10));
		
		} else if (ATTRIB_B.equalsIgnoreCase(name)) {
			entity.setB(Integer.parseInt(value, 10));
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		// do nothing
	}
}