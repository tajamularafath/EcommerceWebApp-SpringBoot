package com.qci.ecommercewebapp.Model;


public class CartPojo {

	private Integer id;
	private String item_title;
	private int quantity;
	private int price;
	private String image_name;
	public CartPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartPojo(Integer id, String item_title, int quantity, int price, String image_name) {
		super();
		this.id = id;
		this.item_title = item_title;
		this.quantity = quantity;
		this.price = price;
		this.image_name = image_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem_title() {
		return item_title;
	}
	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	
	
}
