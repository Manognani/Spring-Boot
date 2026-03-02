package com.tejait.batch15.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appId;
    private String fname;
    private String lname;
    private String customerName;
    private String mailId;
    private String city;
    private Long mobile;
}
