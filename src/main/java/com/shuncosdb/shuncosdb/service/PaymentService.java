package com.shuncosdb.shuncosdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuncosdb.shuncosdb.model.Payment;
import com.shuncosdb.shuncosdb.repository.PaymentRepository;



@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	//Get
	public Payment gePaymentById(Long id){
		return paymentRepository.findById(id).orElse(null);
	}
	
	//Post
	public Payment createPayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	//Put
	public Payment updateBook(Long id, Payment paymentDetails) {
		Payment payment = paymentRepository.findById(id).orElse(null);
		
		payment.setCard_number(paymentDetails.getCard_number());
		payment.setOwner_name(paymentDetails.getOwner_name());
		payment.setExpiration_date(paymentDetails.getExpiration_date());
		payment.setPin(paymentDetails.getPin());
		
		return paymentRepository.save(payment);
		}
	
	//Delete
	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}
	
}
