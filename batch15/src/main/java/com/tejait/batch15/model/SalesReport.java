package com.tejait.batch15.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales_report")
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "app_id")
    private Integer appId;

    @Column(name = "date")
    private String date;

    @Column(name = "order_no")
    private String orderno;

    @Column(name = "invoice_no")
    private String invoiceno;

    @Column(name = "party_name")
    private String partyName;

    @Column(name = "party_phone_num")
    private String partyPhoneNum;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "recieved_or_paid_amount")
    private Double recievedOrPaidAmount;

    @Column(name = "balance_amount")
    private Double balanceAmount;
}