package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;

public class StringAttribute extends BaseAttribute<String> {

	public StringAttribute(String id) {
		super(id);
	}
	
	public StringAttribute(String id, String defaultValue) {
		super(id, defaultValue);
	}

	@Override
	public AttributeValue<String> createValue(String value) {
		return new StringAttributeValue(this, value);
	}

	@Override
	public AttributeType getAttributeType() {
		return AttributeType.String;
	}
}