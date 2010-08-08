package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.viz.Position;

public class PositionEntityParser extends AbstractEntityParser<Position> {
	private static final String ATTRIB_X = "x";
	private static final String ATTRIB_Y = "y";
	private static final String ATTRIB_Z = "z";
	
	public PositionEntityParser(XMLStreamReader reader, Position entity) {
		super(reader, entity);
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_X.equalsIgnoreCase(name)) {
			entity.setX(Float.parseFloat(value));
			
		} else if (ATTRIB_Y.equalsIgnoreCase(name)) {
			entity.setY(Float.parseFloat(value));
		
		} else if (ATTRIB_Z.equalsIgnoreCase(name)) {
			entity.setZ(Float.parseFloat(value));
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		// do nothing
	}
}