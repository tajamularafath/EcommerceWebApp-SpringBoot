package com.qci.ecommercewebapp.Model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "item_title")
	private String item_title;
	
	//Join the category table title
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category")
	private Category category;
	
	//Join the subcategory tale title
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subcategory")
	private Subcategory subcategory;
	
	@Transient
	@Column(name = "image_name")
	private MultipartFile image_name;
	
	@Column(name = "image_Filename")
	private String image_Filename;
	
	@Column(name = "price")
	private Long price;
	
	@Column(name = "description")
	private String description;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false)
	private Date updated_date;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "status")
	private String status="1";

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String item_title, Category category, Subcategory subcategory, MultipartFile image_name,
			String image_Filename, Long price, String description, Date updated_date, Date created_date,
			String status) {
		super();
		this.id = id;
		this.item_title = item_title;
		this.category = category;
		this.subcategory = subcategory;
		this.image_name = image_name;
		this.image_Filename = image_Filename;
		this.price = price;
		this.description = description;
		this.updated_date = updated_date;
		this.created_date = created_date;
		this.status = status;
	}

	public String getImage_Filename() {
		return image_Filename;
	}

	public void setImage_Filename(String image_Filename) {
		this.image_Filename = image_Filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public MultipartFile getImage_name() {
		return image_name;
	}

	public void setImage_name(MultipartFile image_name) {
		this.image_name = image_name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
