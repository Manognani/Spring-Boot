package com.tejait.batch15.service;

import com.tejait.batch15.model.SalesReport;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service

public interface SalesReportService {

    void uploadExcel(Integer appId, MultipartFile file);

    void saveAll(Integer appId, List<SalesReport> list);

    List<SalesReport> getAllByAppId(Integer appId);
}