package com.example.microserviceclient.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBean {

    private int id;

    private String titre;

    private String description;

    private String image;

    private Double prix;

}
