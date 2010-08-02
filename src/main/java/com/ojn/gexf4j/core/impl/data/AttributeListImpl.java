package com.ojn.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.Date;

import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeList;

public class AttributeListImpl extends ArrayList<Attribute> implements AttributeList {
	private static final long serialVersionUID = 8240096318919688740L;
	
	private Date endDate = null;
	private Date startDate = null;
	private AttributeClass attrClass = AttributeClass.NODE;
	private Mode mode = Mode.STATIC;
	
	public AttributeListImpl(AttributeClass attrClass) {
		this.attrClass = attrClass;
	}
	
	@Override
	public AttributeClass getAttributeClass() {
		return attrClass;
	}

	@Override
	public Mode getMode() {
		return mode;
	}

	@Override
	public AttributeList setMode(Mode mode) {
		if (mode == Mode.STATIC) {
			clearStartDate();
			clearEndDate();
		}
		this.mode = mode;
		return this;
	}

	@Override
	public AttributeList clearEndDate() {
		endDate = null;
		return this;
	}

	@Override
	public AttributeList clearStartDate() {
		startDate = null;
		return this;
	}

	@Override
	public Date getEndDate() {
		checkState(endDate != null, "End Date has not been set.");
		return endDate;
	}

	@Override
	public Date getStartDate() {
		checkState(startDate != null, "Start Date has not been set.");
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
	public AttributeList setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be null.");
		this.endDate = endDate;
		return this;
	}

	@Override
	public AttributeList setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be null.");
		this.endDate = startDate;
		return this;
	}
}