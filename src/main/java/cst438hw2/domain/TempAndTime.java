package cst438hw2.domain;

import java.text.DecimalFormat;

public class TempAndTime {
	public double temp;
	public long time;
	public int timezone;
	//private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public TempAndTime(double temp, long time, int timezone){
		this.temp = temp;
		this.time = time;
		this.timezone = timezone;
	}
 }
