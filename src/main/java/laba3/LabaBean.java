package com.laba3;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.ManagedProperty;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import java.util.Collections;
import org.primefaces.context.RequestContext;


@ManagedBean
@ApplicationScoped
@Data
public class LabaBean implements Serializable{
	private MenuItem menuItem = new MenuItem();
	private MenuItem imageItem = new MenuItem();

	private String ytext;

	private Double radius = 1.0;

	private List<MenuItem> items = new ArrayList<MenuItem>();

	public LabaBean(){
		menuItem.setSlider(0);
		menuItem.setSelect(this.radius);
		imageItem.setSelect(this.radius);

		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            items =  (List<MenuItem>)session.createQuery("From MenuItem").list();
        } catch (Exception e){
            e.printStackTrace();
        }
	}

	public void change(ValueChangeEvent event){
		String value = event.getNewValue().toString();
		this.radius = Double.parseDouble(value);
	}

	public void addItem(){
		menuItem.setSelect(this.radius);
		menuItem.normalizeForm();
		items.add(menuItem);

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(menuItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка парсинга");
        }

        RequestContext rc = RequestContext.getCurrentInstance();
        String color = menuItem.getResult().equals("Попадание") ? "green" : "black";
        rc.addCallbackParam("color", color);
        rc.addCallbackParam("x", menuItem.getX()*50+270);
        rc.addCallbackParam("y", -menuItem.getY()*50+270);
		
		menuItem = new MenuItem();
		menuItem.setSlider(0);
	}

	public void formListener(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String x = params.get("xform");
		String y = params.get("yform");
	}

	public void imgListener(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param1 = params.get("ximg");
		String param2 = params.get("suka");
		imageItem.setSlider(Integer.parseInt(param1));
		imageItem.setInput(Integer.parseInt(param2));
		imageItem.setSelect(this.radius);
		imageItem.normalizeItems();
		items.add(imageItem);

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(imageItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка парсинга");
        }

        RequestContext rc = RequestContext.getCurrentInstance();
        String color = imageItem.getResult().equals("Попадание") ? "green" : "black";
        rc.addCallbackParam("color", color);
        rc.addCallbackParam("x", imageItem.getX()*50+270);
        rc.addCallbackParam("y", -imageItem.getY()*50+270);

		imageItem = new MenuItem();
		
	}
}