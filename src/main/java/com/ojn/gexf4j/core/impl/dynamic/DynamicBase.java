package com.ojn.gexf4j.core.impl.dynamic;

import static com.google.common.base.Preconditions.*;

import java.util.Date;

import com.ojn.gexf4j.core.dynamic.Dynamic;

public abstract class DynamicBase<T extends Object> implements Dynamic<T> {

	private Date endDate = null;
	private Date startDate = null;
	protected int startDateint = - 1;
	protected int endDateint = -1 ;

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
	public Date getEndDate() {
		checkState(hasEndDate(), "End Date has not been set.");
		return endDate;
	}

	@Override
	public Date getStartDate() {
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
	public boolean hasEndDateint() {
		return (endDateint != -1);
	}

	public boolean hasStartDateint() {
		return (startDateint != -1);
	}

	@Override
	public T setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be null.");
		this.endDate = endDate;
		return getSelf();
	}

	@Override
	public T setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be null.");
		this.startDate = startDate;
		return getSelf();
	}

	public void setStartDateint(int startDateint) {
		this.startDateint = startDateint;
	}

	public int getStartDateint() {
		return startDateint;
	}

	public void setEndDateint(int endDateint) {
		this.endDateint = endDateint;
	}

	public int getEndDateint() {
		return endDateint;
	}
	
}