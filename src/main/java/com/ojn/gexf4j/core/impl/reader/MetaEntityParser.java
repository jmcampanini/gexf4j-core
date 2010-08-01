package com.ojn.gexf4j.core.impl.reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.stream.XMLStreamReader;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.ojn.gexf4j.core.GraphMetadata;
import com.ojn.gexf4j.core.impl.GraphMetadataImpl;

public class MetaEntityParser extends AbstractEntityParser<GraphMetadata> {
	private static final String ENTITY_CREATOR = "creator";
	private static final String ENTITY_DESCRIPTION = "description";
	private static final String ENTITY_KEYWORDS = "keywords";
	private static final String ATTRIB_LASTMODIFIED = "lastmodifieddate";
	
	public MetaEntityParser(XMLStreamReader reader) {
		super(reader);
	}

	@Override
	protected GraphMetadata newEntity() {
		return new GraphMetadataImpl();
	}

	@Override
	protected void onCharacters(XMLStreamReader reader) {
		// do nothing
	}

	@Override
	protected void onOther(XMLStreamReader reader, int eventType) {
		// do nothing
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		StringEntityParser sep = new StringEntityParser(reader);
		
		if (ENTITY_CREATOR.equalsIgnoreCase(sep.getName())) {
			entity.setCreator(sep.getEntity());
			
			
		} else if (ENTITY_DESCRIPTION.equalsIgnoreCase(sep.getName())) {
			entity.setDescription(sep.getEntity());
			
		} else if (ENTITY_KEYWORDS.equalsIgnoreCase(sep.getName())) {
			Iterables.addAll(entity.getKeywords(),
					Splitter
						.on(',')
						.trimResults()
						.omitEmptyStrings()
						.split(sep.getEntity()));
		}
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_LASTMODIFIED.equalsIgnoreCase(name)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				entity.setLastModified(sdf.parse(value));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}