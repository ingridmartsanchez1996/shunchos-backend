package com.shuncosdb.shuncosdb.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long order_id;

    @Column(name="create_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date create_at;

    @Column(name="status", nullable = false)
    private Long status;

    @Column(name="subtotal_price", nullable = false)
    private Double subtotal_price;

    @Column(name="has_coupon", columnDefinition = "TINYINT")
    private Boolean has_coupon;

    @Column(name="coupon_text", nullable = true, length = 50)
    private String coupon_text;

    @Column(name="discount_applied", nullable = true)
    private Double discount_applied;

    @Column(name="coupon_percentage", nullable = true)
    private Double coupon_percentage;

    @Column(name="shipment_price", nullable = false)
    private Double shipment_price;

    @Column(name="total_price", nullable = false)
    private Double total_price;

    // Relaciones de la tabla Order

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Address_address_id", referencedColumnName = "address_id")
    private Address address;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Payment_payment_id", referencedColumnName = "payment_id")
    private Payment payment;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderHasProduct> orderHasProduct = new HashSet<>();



    // Constructores tabla Order
    public Order() {

    }


	public Order(Long order_id, Date create_at, Long status, Double subtotal_price, Boolean has_coupon,
			String coupon_text, Double discount_applied, Double coupon_percentage, Double shipment_price,
			Double total_price, User user, Address address, Payment payment, Set<OrderHasProduct> orderHasProduct) {
		this.order_id = order_id;
		this.create_at = create_at;
		this.status = status;
		this.subtotal_price = subtotal_price;
		this.has_coupon = has_coupon;
		this.coupon_text = coupon_text;
		this.discount_applied = discount_applied;
		this.coupon_percentage = coupon_percentage;
		this.shipment_price = shipment_price;
		this.total_price = total_price;
		this.user = user;
		this.address = address;
		this.payment = payment;
		this.orderHasProduct = orderHasProduct;
	}


	public Long getOrder_id() {
		return order_id;
	}

    // Method to add a book to the order
    public void addAddress(HashMap<String, Object> json) {
        Address address = new Address();
        address.setCountry((String)json.get("country"));
        address.setState((String)json.get("state"));
        address.setCity((String)json.get("city"));
        address.setColony((String)json.get("colony"));
        address.setStreet((String)json.get("street"));
        address.setZip_code((String)json.get("zip_code"));
        address.setPhone((String)json.get("phone"));
        this.setAddress(address);
    }


    public void addPayment(HashMap<String, Object> json) {
        Payment payment = new Payment();
        payment.setCard_number((String)json.get("card_number"));
        payment.setOwner_name((String)json.get("owner_name"));
        payment.setExpiration_date((String)json.get("expiration_date"));
        payment.setPin((String)json.get("pin"));
        this.setPayment(payment);
    }

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}


	public Date getCreate_at() {
		return create_at;
	}


	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}


	public Long getStatus() {
		return status;
	}


	public void setStatus(Long status) {
		this.status = status;
	}


	public Double getSubtotal_price() {
		return subtotal_price;
	}


	public void setSubtotal_price(Double subtotal_price) {
		this.subtotal_price = subtotal_price;
	}


	public Boolean getHas_coupon() {
		return has_coupon;
	}


	public void setHas_coupon(Boolean has_coupon) {
		this.has_coupon = has_coupon;
	}


	public String getCoupon_text() {
		return coupon_text;
	}


	public void setCoupon_text(String coupon_text) {
		this.coupon_text = coupon_text;
	}


	public Double getDiscount_applied() {
		return discount_applied;
	}


	public void setDiscount_applied(Double discount_applied) {
		this.discount_applied = discount_applied;
	}


	public Double getCoupon_percentage() {
		return coupon_percentage;
	}


	public void setCoupon_percentage(Double coupon_percentage) {
		this.coupon_percentage = coupon_percentage;
	}


	public Double getShipment_price() {
		return shipment_price;
	}


	public void setShipment_price(Double shipment_price) {
		this.shipment_price = shipment_price;
	}


	public Double getTotal_price() {
		return total_price;
	}


	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public Set<OrderHasProduct> getOrderHasProduct() {
		return orderHasProduct;
	}


	public void setOrderHasProduct(Set<OrderHasProduct> orderHasProduct) {
		this.orderHasProduct = orderHasProduct;
	}

   
}