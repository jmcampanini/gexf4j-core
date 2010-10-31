package com.ojn.gexf4j.core.dynamic;

public interface Dynamic<T extends Object> {

	boolean hasStartDate();
	T clearStartDate();
	GexfTime getStartDate();
	T setStartDate(GexfTime startDate);
	
	boolean hasEndDate();
	T clearEndDate();
	GexfTime getEndDate();
	T setEndDate(GexfTime endDate);
}