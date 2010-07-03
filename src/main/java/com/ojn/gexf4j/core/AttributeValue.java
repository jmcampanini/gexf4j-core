package com.ojn.gexf4j.core;

public interface AttributeValue {

	Attribute valueFor();
	
	String getValue();
	void setValue(String value);
}