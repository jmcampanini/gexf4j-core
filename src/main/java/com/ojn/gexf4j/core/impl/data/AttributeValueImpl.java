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
		if (value == null) {
			return attribute.getDefaultValue();
		}
		return null;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Attribute valueFor() {
		return attribute;
	}
}