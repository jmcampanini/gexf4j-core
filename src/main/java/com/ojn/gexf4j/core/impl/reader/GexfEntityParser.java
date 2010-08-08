package com.ojn.gexf4j.core.impl.reader;

import static com.google.common.base.Preconditions.checkState;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Gexf;

public class GexfEntityParser extends AbstractEntityParser<Gexf> {
	private static final String ATTRIB_VERSION = "version";
	private static final String ATTRIB_VARIANT = "variant";
	private static final String ENTITY_META = "meta";
	private static final String ENTITY_GRAPH = "graph";
	
	private static final String VERSION = "1.1";
	
	public GexfEntityParser(XMLStreamReader reader, Gexf entity) {
		super(reader, entity);
		parse();
	}
	
	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_VARIANT.equalsIgnoreCase(name)) {
			entity.setVariant(value);
		} else if (ATTRIB_VERSION.equalsIgnoreCase(name)) {
			checkState(VERSION.equals(value), "Version must be 1.1.");
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		if (ENTITY_META.equalsIgnoreCase(name)) {
			new MetadataEntityParser(reader, entity.getMetadata());
			
		} else if (ENTITY_GRAPH.equalsIgnoreCase(name)) {
			new GraphEntityParser(reader, entity.getGraph());
		}
	}
}