package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class BusinessProductController {

    BusinessProductService service;

    @PostMapping("saveProductDetails")
    public ResponseEntity<BusinessProduct> saveProduct(@RequestBody BusinessProduct Bprod){
        BusinessProduct  saveProd= service.saveProduct(Bprod);
        return new ResponseEntity<>(saveProd, HttpStatus.CREATED);

    }
    @GetMapping("getProductDetails/{appId}")
    public ResponseEntity<BusinessProduct> getAllProducts(@PathVariable Integer appId){
        BusinessProduct allProducts= service.getAllProducts(appId);
        return ResponseEntity.ok(allProducts);
    }
}
