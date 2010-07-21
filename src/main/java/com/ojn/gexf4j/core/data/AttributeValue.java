package com.ojn.gexf4j.core.data;

import java.util.Date;

public interface AttributeValue {

	Attribute valueFor();
	
	String getValue();
	void setValue(String value);
	
	Date getStartDate();
	void setStartDate(Date startDate);
	
	Date getEndDate();
	void setEndDate(Date endDate);
}