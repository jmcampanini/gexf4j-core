package com.ojn.gexf4j.core.impl.dynamic;

import static com.google.common.base.Preconditions.*;

import java.util.Date;

import com.ojn.gexf4j.core.dynamic.Dynamic;

public abstract class DynamicBase<T extends Object> implements Dynamic<T> {

	private Date endDate = null;
	private Date startDate = null;
	protected double startDatedouble;
	protected double endDatedouble ;

	protected abstract T getSelf();
	
	
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
	public boolean hasEndDatedouble() {
		return (endDatedouble != 0.0);
	}

	public boolean hasStartDatedouble() {
		return (startDatedouble != 0.0);
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
		this.startDatedouble = startDateint;
	}

	public double getStartDatedouble() {
		return startDatedouble;
	}
	public T setStartDatedouble(double startDatedouble) {
		this.startDatedouble = startDatedouble;
		return getSelf();
	}
	public T setEndDatedouble(double endDateint) {
		this.endDatedouble = endDateint;
		return getSelf();
	}

	public double getEndDatedouble() {
		return endDatedouble;
	}
	
}