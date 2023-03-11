package com.example.Blogappapi.controllers;

import com.example.Blogappapi.payloads.Categorydto;
import com.example.Blogappapi.payloads.Userdt;
import com.example.Blogappapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public Categorydto createCategory(@RequestBody Categorydto categorydto) {
        Categorydto categorydto1 = categoryService.createCategory(categorydto);
        return categorydto1;
    }

    @PutMapping("/{id}")
    public Categorydto updateCategory( @RequestBody Categorydto categorydto , @PathVariable Integer id){
        Categorydto updateCategory = categoryService.updateCategory(categorydto, id);
        return updateCategory;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categorydto> getCategory(@PathVariable Integer id) {
        Categorydto categoryById = categoryService.getCategoryById(id);
        return new ResponseEntity<Categorydto>(categoryById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Categorydto>> getAllCategory() {
        List<Categorydto> allCategory = categoryService.getAllCategory();

        return new ResponseEntity<List<Categorydto>>(allCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }


}
