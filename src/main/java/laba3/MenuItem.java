package com.laba3;

import lombok.Data;
import java.lang.Math;
import javax.persistence.*;
import oracle.jdbc.driver.OracleDriver;


@Data
@Entity
@Table(name = "ITEMS")
public class MenuItem{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "X")
	private Integer slider = 0;
	@Column(name = "Y")
	private Integer input;
	@Column(name = "R")
	private Double select;

	@Column(name = "XPIX")
	private double x;
	@Column(name = "YPIX")
	private double y;
	@Column(name = "RPIX")
	private double r;
	@Column(name = "RESULT")
	private String result;

	public MenuItem(){

	}
	public MenuItem(Integer id, Integer slider, Integer input, Double select, double x, double y, double r, String result){
		this.id = id;
		this.slider = slider;
        this.input = input;
        this.select = select;
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
	}

	public void normalizeItems(){
		this.x = ((double)slider-270.0)/50.0;
		this.y = -((double)input-270.0)/50.0;
		this.r = (double)select;
		checkIt();
	}

	public void normalizeForm(){
		System.out.println(slider);
		this.y = (double)input;
		this.x = slider.equals(null) ? 0.0 : (float)slider;
		this.r = (double)select;
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

	@Override
	public String toString(){
		return "id "+id+" slider "+slider+" input "+input+" select "+select+" x "+x+" y "+y+" r "+r+" result "+result;
	}
}