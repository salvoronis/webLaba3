package com.laba3;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.ManagedProperty;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.hibernate.Session;


@ManagedBean
@ViewScoped
@Data
public class LabaBean implements Serializable{
	private MenuItem menuItem = new MenuItem();
	private MenuItem imageItem = new MenuItem();

	private Integer radius = 1;

	private List<MenuItem> items = new ArrayList<MenuItem>();

	public LabaBean(){
		menuItem.setSlider(0);
		menuItem.setSelect(this.radius);
		imageItem.setSelect(this.radius);

		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            items =  (List<MenuItem>)session.createQuery("From MenuItem").list();
            System.out.println(items);
        } catch (Exception e){
            e.printStackTrace();
        }
	}

	public void change(ValueChangeEvent event){
		String value = event.getNewValue().toString();
		this.radius = Integer.parseInt(value);
		System.out.println(this.radius);
	}

	public void addItem(){
		menuItem.setSelect(this.radius);
		menuItem.normalizeForm();
		items.add(menuItem);
		menuItem = new MenuItem();
		menuItem.setSlider(0);
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
            System.out.println(imageItem);
            session.save(imageItem);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка парсинга");
        }

		imageItem = new MenuItem();
		
	}
}