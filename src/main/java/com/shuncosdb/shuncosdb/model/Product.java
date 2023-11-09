package com.shuncosdb.shuncosdb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "model", nullable = false, length = 50)
    private String model;
    
    @Column(name = "image_url", nullable = false, length = 500)
    private String image_url;
    
    @Column(name = "sleeve_type", nullable = false, length = 45)
    private String sleeve_type;
    
    @Column(name = "genre", nullable = false, length = 45)
    private String genre;
    
    @Column(name = "is_adult_size", nullable = false, columnDefinition = "TINYINT")
    private boolean is_adult_size;
    
    @Column(name = "size_list", nullable = false, length = 100)
    private String size_list;
    
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    
    @Column(name = "price", nullable = false)
    private Double price;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderHasProduct> orderHasProduct = new HashSet<>();

    public Product() {
    }

    public Product(Long product_id, String model, String image_url, String sleeve_type, String genre,
            boolean is_adult_size, String size_list, String color, Double price) {
        this.product_id = product_id;
        this.model = model;
        this.image_url = image_url;
        this.sleeve_type = sleeve_type;
        this.genre = genre;
        this.is_adult_size = is_adult_size;
        this.size_list = size_list;
        this.color = color;
        this.price = price;
    }



    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSleeve_type() {
        return sleeve_type;
    }

    public void setSleeve_type(String sleeve_type) {
        this.sleeve_type = sleeve_type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isIs_adult_size() {
        return is_adult_size;
    }

    public void setIs_adult_size(boolean is_adult_size) {
        this.is_adult_size = is_adult_size;
    }

    public String getSize_list() {
        return size_list;
    }

    public void setSize_list(String size_list) {
        this.size_list = size_list;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

	public Set<OrderHasProduct> getOrderHasProduct() {
		return orderHasProduct;
	}

	public void setOrderHasProduct(Set<OrderHasProduct> orderHasProduct) {
		this.orderHasProduct = orderHasProduct;
	}
   
}

