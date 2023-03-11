package com.example.Blogappapi.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@NoArgsConstructor
@Getter
@Setter
public class Categorydto {
    private Integer CategoryId;
    private String CategoryTitle;
    private String CategoryDes;
}
