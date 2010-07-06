package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;

public abstract class BaseAttribute<T extends Object> implements Attribute<T> {

	private String id = "";
	private String title = "";
	private T defaultValue = null;

	public BaseAttribute(String id) {
		this(id, null);
	}
	
	public BaseAttribute(String id, T defaultValue) {
		this.id = id;
		this.defaultValue = defaultValue;
	}
	
	@Override
	public String getId() {
		return id;
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
	public void setDefaultValue(T defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public T getDefaultValue() {
		return defaultValue;
	}
}