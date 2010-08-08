package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

public class StringEntityParser extends AbstractEntityParser<String> {

	public StringEntityParser(XMLStreamReader reader) {
		super(reader, "");
		parse();
	}

	@Override
	protected void onCharacters(XMLStreamReader reader) {
		entity = reader.getText();
	}

	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
	}
	
	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		// do nothing
	}
}