package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

public class StringEntityParser extends AbstractEntityParser<String> {

	private String name = "";
	
	public StringEntityParser(XMLStreamReader reader) {
		super(reader);
		name = reader.getLocalName();
	}

	@Override
	protected String newEntity() {
		return "";
	}

	@Override
	protected void onCharacters(XMLStreamReader reader) {
		entity = reader.getText();
	}

	public String getName() {
		return name;
	}
	
	@Override
	protected void onOther(XMLStreamReader reader, int eventType) {
		// do nothing
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		// do nothing
	}

	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
	}
}