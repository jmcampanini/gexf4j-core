package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;

public class IntegerAttributeValue extends BaseAttributeValue<Integer> {

	public IntegerAttributeValue(Attribute<Integer> attribute, Integer value) {
		super(attribute, value);
	}

	@Override
	public String toStringValue() {
		return getValue().toString();
	}
}