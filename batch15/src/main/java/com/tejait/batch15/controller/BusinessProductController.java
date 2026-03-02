package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("business")
public class BusinessProductController {

    BusinessProductService service;

    @PostMapping("businessProductSave")
    public ResponseEntity<BusinessProduct> saveProduct(@RequestBody BusinessProduct Bprod){
        BusinessProduct  saveProd= service.saveProduct(Bprod);
        return new ResponseEntity<>(saveProd, HttpStatus.CREATED);

    }
    @GetMapping("getBusinessproducts/{appId}")
    public ResponseEntity<List<BusinessProduct>> getAllProducts(@PathVariable Integer appId){
        List<BusinessProduct> allProducts= service.getAllProducts(appId);
        return ResponseEntity.ok(allProducts);
    }
}
