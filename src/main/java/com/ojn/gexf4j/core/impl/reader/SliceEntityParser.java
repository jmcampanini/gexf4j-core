package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.dynamic.Slice;

public class SliceEntityParser extends DynamicEntityParser<Slice> {

	public SliceEntityParser(XMLStreamReader reader, Slice entity) {
		super(reader, entity);
		parse();
	}
}