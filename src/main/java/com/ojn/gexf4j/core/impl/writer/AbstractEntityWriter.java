package com.ojn.gexf4j.core.impl.writer;

import static com.google.common.base.Preconditions.*;

import java.text.SimpleDateFormat;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public abstract class AbstractEntityWriter<T extends Object> {
	protected static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	protected XMLStreamWriter writer = null;
	protected T entity = null;

	protected abstract String getElementName();
	protected abstract void writeAttributes() throws XMLStreamException;
	protected abstract void writeElements() throws XMLStreamException;
	
	public AbstractEntityWriter(XMLStreamWriter writer, T entity) {
		checkArgument(writer != null, "XML Writer cannot be null.");
		checkArgument(entity != null, "Entity cannot be null.");
		
		this.writer = writer;
		this.entity = entity;
	}
	
	protected void write() {
		try {
			writer.writeStartElement(getElementName());
			
			writeAttributes();
			writeElements();
			
			writer.writeEndElement();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}