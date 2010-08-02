package com.ojn.gexf4j.core.impl.dynamic;

import java.util.ArrayList;
import java.util.List;

import com.ojn.gexf4j.core.dynamic.Slicable;
import com.ojn.gexf4j.core.dynamic.Slice;

public abstract class SlicableBase<T extends Object> extends DynamicBase<T> implements Slicable<T> {

	private List<Slice> slices = null;
	
	public SlicableBase() {
		slices = new ArrayList<Slice>();
	}
	
	@Override
	public List<Slice> getSlices() {
		return slices;
	}
}