package com.ojn.gexf4j.core.dynamic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GexfTime {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static GexfTime fromDate(Date d) {
		return new GexfTime(sdf.format(d));
	}
	
	public static GexfTime fromFloat(float f) {
		return new GexfTime(Float.toString(f));
	}
	
	public static GexfTime fromString(String s) {
		return new GexfTime(s);
	}
	
	private String time = "";
	
	GexfTime(String time) {
		this.time = time;
	}
	
	public String toTimeString() {
		return time;
	}
}