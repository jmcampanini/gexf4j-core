package com.ojn.gexf4j.core.impl.reader;

import static com.google.common.base.Preconditions.checkNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import com.ojn.gexf4j.core.dynamic.TimeType;

public abstract class AbstractEntityParser<T extends Object> {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	protected static TimeType writerTimeType = TimeType.DATE;
	protected static Date fromDateString(String s) {
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("String '" + s + "' is not a valid date format: yyyy-MM-dd.", e);
		}
	}
	
	private XMLStreamReader reader = null;
	private boolean foundEnd = false;
	
	protected T entity = null;
	
	protected abstract void onStartElement(String name, XMLStreamReader reader);
	protected abstract void onAttribute(String name, String value);
	
	public AbstractEntityParser(XMLStreamReader reader, T entity) {
		checkNotNull(reader);
		this.reader = reader;
		this.entity = entity;
	}
	
	public T getEntity() {
		return entity;
	}
		
	protected void parse() {
		try {
			if (reader.getEventType() == XMLEvent.START_ELEMENT && reader.getAttributeCount() > 0) {
				for (int i = 0; i < reader.getAttributeCount(); i++) {
					onAttribute(reader.getAttributeLocalName(i),reader.getAttributeValue(i));
				}
				buildEntity();
			}
			
			while (!foundEnd && reader.hasNext()) {
				switch (reader.next()) {
					case XMLEvent.START_ELEMENT:
						System.out.print("START_ELEMENT\t");
						System.out.print(reader.getLocalName() + "\t");
						System.out.println("AttribCount: " + reader.getAttributeCount());
						onStartElement(reader.getLocalName(), reader);
						break;
						
					case XMLEvent.CHARACTERS:
						System.out.print("CHARACTERS\t");
						System.out.println("CHARS: " + reader.getText());
						onCharacters(reader);
						break;
						
					case XMLEvent.END_ELEMENT:
						System.out.println("END ELEMENT\t");
						foundEnd = true;
						break;
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	protected void buildEntity() {
		// do nothing
	}
		
	protected void onCharacters(XMLStreamReader reader) {
		// do nothing
	}
}