package com.qci.ecommercewebapp.JoinEntity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class CategorySubcategoryItem {

	private int id;
	
	private String itemtitle;
	
	private Date created_date;
	
	private Date updated_date;
	
//	private String category;
	
	private String subcategory;
	
	private String status;

	public CategorySubcategoryItem() {
		super();
	}

	public CategorySubcategoryItem(int id, String itemtitle, Date created_date, Date updated_date, String status,
			String category, String subcategory) {
		super();
		this.id = id;
		this.itemtitle = itemtitle;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.status = status;
//		this.category = category;
		this.subcategory = subcategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemTitle() {
		return itemtitle;
	}

	public void setItemtitle(String itemtitle) {
		this.itemtitle = itemtitle;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
