package com.laba3;

import lombok.Data;
import java.lang.Math;


@Data
public class MenuItem{
	private Integer slider = 0;
	private String input = "0";
	private String select;

	private double x;
	private double y;
	private double r;
	private String result;

	public void normalizeItems(){
		this.x = ((double)slider-282.0)/50.0;
		this.y = -(Float.parseFloat(input)-282.0)/50.0;
		this.r = Float.parseFloat(select);
		checkIt();
	}

	public void normalizeForm(){
		System.out.println(slider);
		this.y = Float.parseFloat(input);
		this.x = slider.equals(null) ? 0.0 : (float)slider;
		this.r = Float.parseFloat(select);
		checkIt();
	}

	public void checkIt(){
		if ((this.x >= 0.0) && (this.y >= 0.0) && (this.y <= -this.x/2.0 + this.r/2)) {
			this.result = "Попадание";
		} else if ((this.y <= 0.0) && (this.x >= 0.0) && (this.x <= this.r) && (this.y >= -this.r/2)){
			this.result = "Попадание";
		} else if ((y <= 0.0) && (x <= 0.0) && ((Math.pow((Math.abs(this.x)), 2) + Math.pow((Math.abs(this.y)), 2))<=Math.pow(this.r/2, 2))){
			this.result = "Попадание";
		} else {
			this.result = "Промах";
		}
	}
}