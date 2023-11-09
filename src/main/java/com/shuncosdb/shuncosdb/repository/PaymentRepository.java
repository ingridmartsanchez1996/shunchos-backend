package com.shuncosdb.shuncosdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shuncosdb.shuncosdb.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
