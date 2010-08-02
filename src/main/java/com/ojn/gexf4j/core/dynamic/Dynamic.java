package com.ojn.gexf4j.core.dynamic;

import java.util.Date;


public interface Dynamic<T extends Object> {

	boolean hasStartDate();
	T clearStartDate();
	Date getStartDate();
	T setStartDate(Date startDate);
	
	boolean hasEndDate();
	T clearEndDate();
	Date getEndDate();
	T setEndDate(Date endDate);
}