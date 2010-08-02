package com.ojn.gexf4j.core.dynamic;

import java.util.Date;

public interface Slice {

	boolean hasStartDate();
	Slice clearStartDate();
	Date getStartDate();
	Slice setStartDate(Date startDate);
	
	boolean hasEndDate();
	Slice clearEndDate();
	Date getEndDate();
	Slice setEndDate(Date endDate);
}