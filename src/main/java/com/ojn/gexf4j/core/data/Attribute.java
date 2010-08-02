package com.ojn.gexf4j.core.data;

import java.util.List;

public interface Attribute {

	String getId();
	
	String getTitle();
	void setTitle(String title);
	
	AttributeType getAttributeType();
	Attribute setAttributeType(AttributeType attrType);
	
	boolean hasDefaultValue();
	String getDefaultValue();
	Attribute setDefaultValue(String defaultValue);
	
	List<String> getOptions();
	
	AttributeValue createValue(String value);
}