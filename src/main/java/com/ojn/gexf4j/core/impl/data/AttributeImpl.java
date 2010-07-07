package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;

public class AttributeImpl implements Attribute {

	private String id = "";
	private String title = "";
	private AttributeType type = AttributeType.String;
	private String defaultValue = null;
	private AttributeClass attribClass = AttributeClass.Node;
	
	public AttributeImpl(AttributeType type, String id, AttributeClass attribClass) {
		this.type = type;
		this.id = id;
		this.attribClass = attribClass;
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
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		this.title = title;
	}
	
	@Override
	public String getDefaultValue() {
		return defaultValue;
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		if (defaultValue == null) {
			throw new IllegalArgumentException("Default Value cannot be null.");
		}
		this.defaultValue = defaultValue;
	}
	
	@Override
	public AttributeValue createValue(String value) {
		if (value == null) {
			throw new IllegalArgumentException("Value cannot be null.");
		}
		return new AttributeValueImpl(this, value);
	}

	@Override
	public AttributeClass getAttributeClass() {
		return attribClass;
	}
}