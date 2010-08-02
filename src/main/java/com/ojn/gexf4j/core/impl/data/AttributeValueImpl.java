package com.ojn.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.dynamic.Slice;

public class AttributeValueImpl implements AttributeValue {

	private Attribute attribute = null;
	private String value = null;
	private Date startDate = null;
	private Date endDate = null;
	private List<Slice> slices = null;
	
	public AttributeValueImpl(Attribute attribute, String value) {
		this.attribute = attribute;
		this.value = value;
		
		slices = new ArrayList<Slice>();
	}
	
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		if (value == null) {
			throw new IllegalArgumentException("Value cannot be null.");
		}
		this.value = value;
	}

	@Override
	public Attribute getAttribute() {
		return attribute;
	}

	@Override
	public List<Slice> getSlices() {
		return slices;
	}

	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}
	
	@Override
	public AttributeValue clearStartDate() {
		startDate = null;
		return this;
	}
	
	@Override
	public Date getStartDate() {
		checkState(hasStartDate(), "Start Data has not been set.");
		return startDate;
	}
	
	@Override
	public AttributeValue setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be set to null.");
		this.startDate = startDate;
		return this;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}
	
	@Override
	public AttributeValue clearEndDate() {
		endDate = null;
		return this;
	}
	
	@Override
	public Date getEndDate() {
		checkState(hasEndDate(), "End Data has not been set.");
		return endDate;
	}

	@Override
	public AttributeValue setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be set to null.");
		this.endDate = endDate;
		return this;
	}
}