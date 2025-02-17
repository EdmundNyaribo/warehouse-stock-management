package com.warehouse.stock.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "WH-SUPPLIERS")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "SPLR_NAME")
    private String name;

    @Column(name = "SPLR_EMAIL")
    private String email;

    @Column(name = "SPLR_PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "SPLR_ADDRESS")
    private String address;

    @Column(name = "SPLR_CITY")
    private String city;

    @Column(name = "SPLR_STATE")
    private String state;

    @Column(name = "SPLR_ZIPCODE")
    private  String zipcode;

}
