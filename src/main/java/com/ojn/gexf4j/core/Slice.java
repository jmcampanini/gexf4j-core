package com.ojn.gexf4j.core;

import java.util.Date;

public interface Slice {

	Date getStartDate();
	void setStartDate(Date startDate);
	
	Date getEndDate();
	void setEndDate(Date endDate);
}