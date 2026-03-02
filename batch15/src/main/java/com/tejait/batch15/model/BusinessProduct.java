package com.tejait.batch15.model;
import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="business_product")
public class BusinessProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer appId;
    private String purposeOfLoan;
    private String natureOfBusiness;
    private int tenure;
    private long loanAmount;

}
