package com.qci.ecommercewebapp.Model;

//import java.util.Date;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.qci.ecommercewebapp.alterEntity.AlterSubcategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="subcategory")
public class Subcategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "subcategory",nullable = false)
	private String subcategory;
	 
	//JOining the category_title 
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "category")
	private Category category;
	
	//Joining the subcategory_title
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subcategory"  )
	private Set<Item> items = new HashSet<Item>(0);
	
	
	@CreationTimestamp
	@Column(name = "created_date", nullable=false, updatable = false )
	private Date created_date;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false)
	private Date updated_date;
	
	@Column(name = "status",nullable = false)
	private String status="1";

	public Subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subcategory(int id, String subcategory_title, Category category, Date created_date, Date updated_date,
			String status) {
		super();
		this.id = id;
		this.subcategory = subcategory_title;
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

	public String getSubcategory_title() {
		return subcategory;
	}

	public void setSubcategoryTitle(String subcategory_title) {
		this.subcategory = subcategory_title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	
	
	
}
