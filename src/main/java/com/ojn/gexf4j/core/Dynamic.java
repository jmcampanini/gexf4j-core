package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

public interface Dynamic<T extends Object> {

	boolean hasStartDate();
	T clearStartDate();
	Date getStartDate();
	T setStartDate(Date startDate);
	
	boolean hasEndDate();
	T clearEndDate();
	Date getEndDate();
	T setEndDate(Date endDate);
	
	List<Slice> getSlices();
}