package com.ojn.gexf4j.core.impl.dynamic;

import com.ojn.gexf4j.core.dynamic.Slice;

public class SliceImpl extends DynamicBase<Slice> implements Slice {

	
	
	@Override
	protected Slice getSelf() {
		return this;
	}



	public Slice setEndDate(double endDate) {
		// TODO Auto-generated method stub
		this.setEndDatedouble(endDate);
		return this;
	}


	@Override
	public boolean hasEndDatedouble() {
		// TODO Auto-generated method stub
		return this.hasEndDatedouble();
	}

	@Override
	public boolean hasStartDatedouble() {
		// TODO Auto-generated method stub
		return this.hasEndDatedouble();
	}



	@Override
	public Slice setStartDatedouble(double startDate) {
		this.startDatedouble = startDate;
		return this;
	}

	
}