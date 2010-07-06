package com.ojn.gexf4j.core.data;

public interface Attribute<T extends Object> {

	String getId();
	AttributeType getAttributeType();
	
	String getTitle();
	void setTitle(String title);
	
	AttributeValue<T> createValue(T value);
	
	T getDefaultValue();
	void setDefaultValue(T defaultValue);
}