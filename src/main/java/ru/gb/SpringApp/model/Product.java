package ru.gb.SpringApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    private Long id;
    private String title;
    private float cost;

}
