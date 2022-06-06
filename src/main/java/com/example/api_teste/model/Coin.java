package com.example.api_teste.model;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Coin {
    @Id
    private String id;
    private String name;
    private String symbol;
    private String type;
}
