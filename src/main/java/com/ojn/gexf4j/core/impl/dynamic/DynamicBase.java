package com.ojn.gexf4j.core.impl.dynamic;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import com.ojn.gexf4j.core.dynamic.Dynamic;
import com.ojn.gexf4j.core.dynamic.GexfTime;

public abstract class DynamicBase<T extends Object> implements Dynamic<T> {

	private GexfTime endDate = null;
	private GexfTime startDate = null;

	protected abstract T getSelf();
	
	public DynamicBase() {
		// empty
	}

	@Override
	public T clearEndDate() {
		endDate = null;
		return getSelf();
	}

	@Override
	public T clearStartDate() {
		startDate = null;
		return getSelf();
	}

	@Override
	public GexfTime getEndDate() {
		checkState(hasEndDate(), "End Date has not been set.");
		return endDate;
	}

	@Override
	public GexfTime getStartDate() {
		checkState(hasStartDate(), "Start Date has not been set.");
		return startDate;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}

	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}

	@Override
	public T setEndDate(GexfTime endDate) {
		checkArgument(endDate != null, "End Date cannot be null.");
		this.endDate = endDate;
		return getSelf();
	}

	@Override
	public T setStartDate(GexfTime startDate) {
		checkArgument(startDate != null, "Start Date cannot be null.");
		this.startDate = startDate;
		return getSelf();
	}
}