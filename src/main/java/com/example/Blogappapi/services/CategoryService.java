package com.example.Blogappapi.services;

import com.example.Blogappapi.payloads.Categorydto;
import com.example.Blogappapi.payloads.Userdt;

import java.util.List;

public interface CategoryService {
    Categorydto createCategory(Categorydto categorydto);
    Categorydto updateCategory(Categorydto categorydto,Integer categoryId);
    Categorydto getCategoryById(Integer categoryId);
    List<Categorydto> getAllCategory();
    void deleteCategory(Integer categoryId);

}
