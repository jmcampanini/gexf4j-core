package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;

public abstract class BaseAttributeValue<T extends Object> implements AttributeValue<T> {

	private Attribute<T> attribute = null;
	private T value = null;
	
	public BaseAttributeValue(Attribute<T> attribute, T value) {
		this.attribute = attribute;
		this.value = value;
	}
	
	@Override
	public T getValue() {
		if (value == null) {
			return attribute.getDefaultValue();
		}
		return value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public Attribute<T> valueFor() {
		return attribute;
	}
}