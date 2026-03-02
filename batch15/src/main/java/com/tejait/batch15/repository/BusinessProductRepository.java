package com.tejait.batch15.repository;

import com.tejait.batch15.model.BusinessProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessProductRepository extends JpaRepository<BusinessProduct,Integer> {

    BusinessProduct findByAppId(Integer appId);
}
