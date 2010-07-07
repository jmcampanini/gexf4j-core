package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;

public class AttributeValueImpl implements AttributeValue {

	private Attribute attribute = null;
	private String value = null;
	
	AttributeValueImpl(Attribute attribute, String value) {
		this.attribute = attribute;
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		if (value == null) {
			throw new IllegalArgumentException("Value cannot be null.");
		}
		this.value = value;
	}

	@Override
	public Attribute valueFor() {
		return attribute;
	}
}