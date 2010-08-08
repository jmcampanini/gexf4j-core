package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.ojn.gexf4j.core.Metadata;

public class MetadataEntityParser extends AbstractEntityParser<Metadata>{
	private static final String ATTRIB_LASTMODIFIED = "lastmodifieddate";
	private static final String ENTITY_CREATOR = "creator";
	private static final String ENTITY_KEYWORDS = "keywords";
	private static final String ENTITY_DESCRIPTION = "description";
	
	public MetadataEntityParser(XMLStreamReader reader, Metadata entity) {
		super(reader, entity);
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_LASTMODIFIED.equalsIgnoreCase(name)) {
			entity.setLastModified(fromDateString(value));
		}
	}

	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		if (ENTITY_CREATOR.equalsIgnoreCase(name)) {
			String creator = new StringEntityParser(reader).getEntity();
			entity.setCreator(creator);
		
		} else if (ENTITY_DESCRIPTION.equalsIgnoreCase(name)) {
			String description = new StringEntityParser(reader).getEntity();
			entity.setDescription(description);
			
		} else if (ENTITY_KEYWORDS.equalsIgnoreCase(name)) {
			String keywords = new StringEntityParser(reader).getEntity();
			Iterables.addAll(
					entity.getKeywords(),
					Splitter
						.on(',')
						.omitEmptyStrings()
						.trimResults()
						.split(keywords));
		}
	}
}