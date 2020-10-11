package com.wallmart.challenge.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Product implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    private ObjectId _id;
    private Integer id;
    private String brand;
    private String description;
    private String image;
    private Integer price;

    public Product() {
	super();
    }

    public ObjectId get_id() {
	return _id;
    }

    public void set_id(ObjectId _id) {
	this._id = _id;
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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((_id == null) ? 0 : _id.hashCode());
	result = prime * result + ((brand == null) ? 0 : brand.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((image == null) ? 0 : image.hashCode());
	result = prime * result + ((price == null) ? 0 : price.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Product other = (Product) obj;
	if (_id == null) {
	    if (other._id != null)
		return false;
	} else if (!_id.equals(other._id))
	    return false;
	if (brand == null) {
	    if (other.brand != null)
		return false;
	} else if (!brand.equals(other.brand))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (image == null) {
	    if (other.image != null)
		return false;
	} else if (!image.equals(other.image))
	    return false;
	if (price == null) {
	    if (other.price != null)
		return false;
	} else if (!price.equals(other.price))
	    return false;
	return true;
    }

}
