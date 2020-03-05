package com.laba3;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@ViewScoped
@Data
public class LabaBean implements Serializable{
	private MenuItem menuItem = new MenuItem();
	private MenuItem imageItem = new MenuItem();

	private String radius = "1";

	private List<MenuItem> items = new ArrayList<MenuItem>();

	public LabaBean(){
		menuItem.setSlider(0);
		menuItem.setSelect(this.radius);
		imageItem.setSelect(this.radius);
	}

	public void change(ValueChangeEvent event){
		String value = event.getNewValue().toString();
		this.radius = value;
		System.out.println(this.radius);
	}

	public void addItem(){
		menuItem.setSelect(this.radius);
		menuItem.normalizeForm();
		items.add(menuItem);
		menuItem = new MenuItem();
		menuItem.setSlider(0);
	}

	public void suka(){
		System.out.println(this.radius);
		imageItem.setSelect(this.radius);
		System.out.println(imageItem.getSlider() +" "+ imageItem.getInput()+" "+imageItem.getSelect());
		System.out.println();
		imageItem.normalizeItems();
		items.add(imageItem);
		imageItem = new MenuItem();
	}
}