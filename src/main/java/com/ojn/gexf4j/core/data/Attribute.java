package com.ojn.gexf4j.core.data;

public interface Attribute {

	String getId();
	AttributeType getAttributeType();
	AttributeClass getAttributeClass();
	
	String getTitle();
	void setTitle(String title);
	
	AttributeValue createValue(String value);
	
	String getDefaultValue();
	void setDefaultValue(String defaultValue);
}