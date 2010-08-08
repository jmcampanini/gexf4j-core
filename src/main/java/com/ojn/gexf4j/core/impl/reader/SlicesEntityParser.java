package com.ojn.gexf4j.core.impl.reader;

import java.util.List;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.dynamic.Slice;
import com.ojn.gexf4j.core.impl.dynamic.SliceImpl;

public class SlicesEntityParser extends AbstractEntityParser<List<Slice>> {
	private static final String ENTITY_SLICE = "slice";
	
	public SlicesEntityParser(XMLStreamReader reader, List<Slice> entity) {
		super(reader, entity);
		parse();
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		if (ENTITY_SLICE.equalsIgnoreCase(name)) {
			SliceEntityParser sep = new SliceEntityParser(reader, new SliceImpl());
			entity.add(sep.getEntity());
		}
	}

	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
	}
}