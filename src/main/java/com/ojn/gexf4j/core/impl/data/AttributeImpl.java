package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;

public class AttributeImpl implements Attribute {

	private String id = "";
	private String title = "";
	private AttributeType type = AttributeType.String;
	private String defaultValue = null;
	
	public AttributeImpl(AttributeType type, String id) {
		this.type = type;
		this.id = id;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public AttributeType getAttributeType() {
		return type;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String getDefaultValue() {
		return defaultValue;
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	@Override
	public AttributeValue createValue(String value) {
		return new AttributeValueImpl(this, value);
	}
}