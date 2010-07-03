package com.ojn.gexf4j.core;

public interface Attribute {

	String getId();
	AttributeType getAttributeType();
	
	String getTitle();
	void setTitle(String title);
	
	AttributeValue createValue(String value);
	
	AttributeValue getDefaultValue();
}