package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;

public class IntegerAttribute extends BaseAttribute<Integer> {

	public IntegerAttribute(String id) {
		super(id);
	}

	public IntegerAttribute(String id, Integer defaultValue) {
		super(id, defaultValue);
	}

	@Override
	public AttributeValue<Integer> createValue(Integer value) {
		return new IntegerAttributeValue(this, value);
	}

	@Override
	public AttributeType getAttributeType() {
		return AttributeType.Integer;
	}
}