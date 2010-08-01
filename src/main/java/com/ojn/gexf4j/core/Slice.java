package com.ojn.gexf4j.core;

import java.util.Date;

public interface Slice {

	Date getStartDate();
	Slice setStartDate(Date startDate);
	
	Date getEndDate();
	Slice setEndDate(Date endDate);
}