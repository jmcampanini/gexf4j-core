package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

public interface Dynamic<T extends Object> {

	Date getStartDate();
	T setStartDate(Date startDate);
	
	Date getEndDate();
	T setEndDate(Date endDate);
	
	List<Slice> getSlices();
}