package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="salesReport")
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderNo;
    private String invoiceNo;
    private String partyName;
    private Long partyPhoneNo;
    private Long totalAmount;
    private Long paidAmount;
    private Long balanceAmount;



}
