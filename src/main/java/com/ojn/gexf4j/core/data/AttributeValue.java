package com.ojn.gexf4j.core.data;

public interface AttributeValue<T extends Object> {

	Attribute<T> valueFor();
	
	T getValue();
	void setValue(T value);
	
	String toStringValue();
}