package com.wallmart.challenge.dto;


public class ProductDTO {
    private Integer id;
    private String brand;
    private String description;
    private String image;
    private Integer price;
    private Integer percentajeDiscount;
    private Integer originalPrice;

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getPercentajeDiscount() {
        return percentajeDiscount;
    }

    public void setPercentajeDiscount(Integer percentajeDiscount) {
        this.percentajeDiscount = percentajeDiscount;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getBrand() {
	return brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public Integer getPrice() {
	return price;
    }

    public void setPrice(Integer price) {
	this.price = price;
    }

    public ProductDTO() {
	super();
    }

    public ProductDTO(Integer id, String brand, String description, String image, Integer price) {
	super();
	this.id = id;
	this.brand = brand;
	this.description = description;
	this.image = image;
	this.price = price;
    }
}
