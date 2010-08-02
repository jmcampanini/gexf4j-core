package com.ojn.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.Date;

import com.ojn.gexf4j.core.dynamic.Slice;

public class SliceImpl implements Slice {

	private Date startDate = null;
	private Date endDate = null;

	public SliceImpl() {
		// empty constructor
	}

	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}
	
	@Override
	public Slice clearStartDate() {
		startDate = null;
		return this;
	}
	
	@Override
	public Date getStartDate() {
		checkState(hasStartDate(), "Start Data has not been set.");
		return startDate;
	}
	
	@Override
	public Slice setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be set to null.");
		this.startDate = startDate;
		return this;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}
	
	@Override
	public Slice clearEndDate() {
		endDate = null;
		return this;
	}
	
	@Override
	public Date getEndDate() {
		checkState(hasEndDate(), "End Data has not been set.");
		return endDate;
	}

	@Override
	public Slice setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be set to null.");
		this.endDate = endDate;
		return this;
	}
}