package com.tejait.batch15.repository;

import com.tejait.batch15.model.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Integer> {

    List<SalesReport> findAllByAppId(Integer appId);
}