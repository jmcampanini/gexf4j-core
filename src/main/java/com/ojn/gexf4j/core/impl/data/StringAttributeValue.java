package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;

public class StringAttributeValue extends BaseAttributeValue<String> {

	public StringAttributeValue(Attribute<String> attribute, String value) {
		super(attribute, value);
	}

	@Override
	public String toStringValue() {
		return getValue();
	}
}