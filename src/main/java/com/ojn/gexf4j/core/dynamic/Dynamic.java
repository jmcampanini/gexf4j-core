package com.ojn.gexf4j.core.dynamic;

import java.util.Date;

public interface Dynamic<T extends Object> {

	boolean hasStartDate();
	T clearStartDate();
	Date getStartDate();
	T setStartDate(Date startDate);
	T setStartDatedouble(double startDate);
	
	boolean hasEndDate();
	T clearEndDate();
	Date getEndDate();
	T setEndDate(Date endDate);
	T setEndDatedouble(double endDate);
	boolean hasEndDatedouble();
	boolean hasStartDatedouble();
	double getStartDatedouble();
	double getEndDatedouble();
}