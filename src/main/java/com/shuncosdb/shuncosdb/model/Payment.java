package com.shuncosdb.shuncosdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long payment_id;
	
	@Column(name ="card_number", nullable = false, length = 25)
	private String card_number;

	@Column(name ="owner_name", nullable = false, length = 100)
	private String owner_name;

	@Column(name ="expiration_date", nullable = false, length = 15)
	private String expiration_date;

	@Column(name ="pin", nullable = false, length = 5)
	private String pin;
	
	@OneToOne(mappedBy = "payment")
	private Order order;

	
	public Payment() {
	}

	public Payment(Long payment_id, String card_number, String owner_name, String expiration_date, String pin) {
		this.payment_id = payment_id;
		this.card_number = card_number;
		this.owner_name = owner_name;
		this.expiration_date = expiration_date;
		this.pin = pin;
	}


	public Long getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}


	public String getCard_number() {
		return card_number;
	}


	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}


	public String getOwner_name() {
		return owner_name;
	}


	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}


	public String getExpiration_date() {
		return expiration_date;
	}


	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


//	@Override
//	public String toString() {
//		return "Payment [payment_id=" + payment_id + ", card_number=" + card_number + ", owner_name=" + owner_name
//				+ ", expiration_date=" + expiration_date + ", pin=" + pin + "]";
//	}
//

}

