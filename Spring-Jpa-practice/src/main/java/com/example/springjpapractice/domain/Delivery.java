package com.example.springjpapractice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "delivery")
@Getter
@Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private Address address;


}
