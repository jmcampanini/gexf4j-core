package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.List;

import com.ojn.gexf4j.core.SlicableDatum;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.impl.dynamic.SlicableBase;

public abstract class SliceableDatumBase<T extends Object> extends SlicableBase<T> implements SlicableDatum<T> {

	private List<AttributeValue> attributes = null;
	
	public SliceableDatumBase() {
		attributes = new ArrayList<AttributeValue>();
	}

	@Override
	public List<AttributeValue> getAttributeValues() {
		return attributes;
	}
}