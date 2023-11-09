package com.shuncosdb.shuncosdb.repository;

import com.shuncosdb.shuncosdb.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
