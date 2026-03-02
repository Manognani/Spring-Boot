package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="/assurence")
public class Assurence {

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
    private int id;
    private String ename;
    private String nationality;
    private  String age;
    private String gender;
    private String mail;







}
