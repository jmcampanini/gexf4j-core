package com.ojn.gexf4j.core.impl;

import com.ojn.gexf4j.core.SlicableDatum;
import com.ojn.gexf4j.core.data.AttributeValueList;
import com.ojn.gexf4j.core.impl.data.AttributeValueListImpl;
import com.ojn.gexf4j.core.impl.dynamic.SlicableBase;

public abstract class SliceableDatumBase<T extends Object> extends SlicableBase<T> implements SlicableDatum<T> {

	private AttributeValueList attributes = null;
	
	public SliceableDatumBase() {
		attributes = new AttributeValueListImpl();
	}

	@Override
	public AttributeValueList getAttributeValues() {
		return attributes;
	}
}