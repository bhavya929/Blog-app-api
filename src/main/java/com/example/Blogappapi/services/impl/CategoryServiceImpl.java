package com.example.Blogappapi.services.impl;

import com.example.Blogappapi.entities.Category;
import com.example.Blogappapi.exceptions.ResourseNotFoundException;
import com.example.Blogappapi.payloads.Categorydto;
import com.example.Blogappapi.repositories.CategoryRepo;
import com.example.Blogappapi.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Categorydto createCategory(Categorydto categorydto) {
        Category category = modelMapper.map(categorydto, Category.class);
        Category save = categoryRepo.save(category);
        return modelMapper.map(save,Categorydto.class);
    }

    @Override
    public Categorydto updateCategory(Categorydto categorydto, Integer categoryId) {
        Optional<Category> byId = categoryRepo.findById(categoryId);
        if (byId.isPresent()){
            Category saved = categoryRepo.save(modelMapper.map(categorydto, Category.class));
            Categorydto map = modelMapper.map(saved, Categorydto.class);
            return map;
        }
        return null;
    }

    @Override
    public Categorydto getCategoryById(Integer categoryId) {
        Optional<Category> byId = categoryRepo.findById(categoryId);
        Category category = byId.get();
        if (byId.isPresent()){
            Categorydto map = modelMapper.map(category, Categorydto.class);
            return map;
        }
        throw new ResourseNotFoundException(String.format("User not found for id %s",categoryId));
    }

    @Override
    public List<Categorydto> getAllCategory() {
        List<Category> categoryList = categoryRepo.findAll();
        List<Categorydto> collect = categoryList.stream().map(all -> modelMapper.map(categoryList, Categorydto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepo.deleteById(categoryId);

    }
}
