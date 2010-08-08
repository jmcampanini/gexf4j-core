package com.ojn.gexf4j.core.impl.writer;

import static com.google.common.base.Preconditions.checkArgument;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.TimeType;

public abstract class AbstractEntityWriter<T extends Object> {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	protected static TimeType writerTimeType = TimeType.DATE;
	protected static String toDateString(Date d) {
		return sdf.format(d);
	}
	
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
			writeStartElement();
			
			writeAttributes();
			writeElements();
			
			writer.writeEndElement();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	protected void writeStartElement() throws XMLStreamException {
		writer.writeStartElement(getElementName());
	}
}