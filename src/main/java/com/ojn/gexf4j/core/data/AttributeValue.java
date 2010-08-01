package com.ojn.gexf4j.core.data;

import com.ojn.gexf4j.core.Dynamic;

public interface AttributeValue extends Dynamic<AttributeValue> {

	Attribute getAttribute();
	
	String getValue();
	void setValue(String value);
}