package com.laba3;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
@Data
public class LabaBean implements Serializable{
	private MenuItem menuItem = new MenuItem();

	private List<MenuItem> items = new ArrayList<MenuItem>();

	public void addItem(){
		items.add(menuItem);
		menuItem = new MenuItem();
	}
}