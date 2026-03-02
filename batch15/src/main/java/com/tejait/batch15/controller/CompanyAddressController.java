package com.tejait.batch15.controller;

import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.service.CompanyAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("CompanyAddress")
public class CompanyAddressController {

    CompanyAddressService service;

    @PostMapping("save")
    public ResponseEntity<CompanyAddress> saveAddress(@RequestBody CompanyAddress cadds){
        CompanyAddress savedAddress=service.saveAddress(cadds);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);


    }
    @GetMapping("getCompany/{appId}")
    public ResponseEntity<CompanyAddress> getCompanyAddress(@PathVariable Integer appId){
        CompanyAddress getCompany=  service.getAdress(appId);
        return ResponseEntity.ok(getCompany);
    }

}
