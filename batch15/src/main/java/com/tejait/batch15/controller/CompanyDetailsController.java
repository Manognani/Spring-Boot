package com.tejait.batch15.controller;

import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("companydetails")
public class CompanyDetailsController {

    CompanyDetailsService service;

    @PostMapping("save")
    public ResponseEntity<CompanyDetails> saveDetails(@RequestBody CompanyDetails cdetails){
        CompanyDetails  savedDetails =service.saveDetails(cdetails);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);

    }

    @GetMapping("getByCompanyDetails/{appId}")
    public ResponseEntity<CompanyDetails> getByEmpId(@PathVariable Integer appId) {
        CompanyDetails company = service.getCompanyDetails(appId);
        return ResponseEntity.ok(company);

    }

}
