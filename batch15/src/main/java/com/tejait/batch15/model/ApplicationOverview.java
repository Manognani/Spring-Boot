package com.tejait.batch15.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ApplicationOverview {

    private Integer appId;
    private String companyName;
    private String city;
    private Long mobile;
    private String mail;
    private Long loanAmt;
    private int tenure;
    private String companyPan;

}

