package com.ojn.gexf4j.core.impl;

import java.util.Date;

import com.ojn.gexf4j.core.Slice;

public class SliceImpl implements Slice {

	private Date startDate = null;
	private Date endDate = null;

	public SliceImpl() {
		// empty constructor
	}
	
	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public Slice setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	@Override
	public Slice setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
}