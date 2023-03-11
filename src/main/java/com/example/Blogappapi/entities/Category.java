package com.example.Blogappapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CategoryId;
    @Column(nullable = false)
    private String CategoryTitle;
    @Column(name = "CatDescription" ,nullable = false)
    private String CategoryDes;

}
