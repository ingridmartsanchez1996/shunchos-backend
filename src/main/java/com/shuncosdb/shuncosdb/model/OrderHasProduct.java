package com.shuncosdb.shuncosdb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Order_has_Product")
public class OrderHasProduct {
	
	@EmbeddedId
    private OrderProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "Order_order_id")
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "Product_product_id")
    private Product product;
    
    @Column(name = "quantity")
    private Long quantity;
    
    @Column(name = "size")
    private Long size;

    // Default constructor
 	public OrderHasProduct() {
 	}
    
 	// Constructor with parameters
    public OrderHasProduct(OrderProductId id, Order order, Product product, Long quantity, Long size) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.size = size;
	}

	
	// Embeddable key class
	@Embeddable
	public static class OrderProductId implements Serializable {

		@Column(name = "Order_order_id")
		private Long orderId;
		
		@Column(name = "Product_product_id")
		private Long productId;
		
		// Default constructor
		public OrderProductId() {
		}

		
		// Constructor with parameters
		public OrderProductId(Long orderId, Long productId) {
			this.orderId = orderId;
			this.productId = productId;
		}
		
		// Override equals and hashCode
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderProductId other = (OrderProductId) obj;
			return Objects.equals(orderId, other.orderId) && Objects.equals(productId, other.productId);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(orderId, productId);
		}
	}

	//Getters and setters
	public OrderProductId getId() {
		return id;
	}

	public void setId(OrderProductId id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
		
}

