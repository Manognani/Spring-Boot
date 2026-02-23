package com.tejait.batch15.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejait.batch15.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
