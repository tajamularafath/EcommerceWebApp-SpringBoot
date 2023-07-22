package com.qci.ecommercewebapp.JoinEntity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.qci.ecommercewebapp.Model.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class CategorySubcategoryJoin {

	private int id; 
	
	private String title;

	private String category;
	
	private Date created_date;
	
	private Date updated_date;
	
	private int status = 0;

	public CategorySubcategoryJoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorySubcategoryJoin(int id, String title, String category, Date created_date, Date updated_date,
			int status) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
