package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;

public class FlexAttribute extends BaseAttribute<String> {

	private AttributeType type = null;
	
	public FlexAttribute(AttributeType type, String id) {
		this(type, id, null);
	}
	
	public FlexAttribute(AttributeType type, String id, String defaultValue) {
		super(id, defaultValue);
		this.type = type;
	}

	@Override
	public AttributeValue<String> createValue(String value) {
		return new FlexAttributeValue(this, value);
	}

	@Override
	public AttributeType getAttributeType() {
		return type;
	}
}