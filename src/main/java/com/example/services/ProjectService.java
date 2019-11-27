package com.example.services;

import com.example.domain.Project;

//alt enter implements the methods


//public interface ProductService {
//    List<Product> listAllProducts();
//
//    Product getProductById(Integer id);
//
//    Product saveOrUpdateProduct(Product product);
//
//    void deleteProduct(Integer id);
//}


public interface ProjectService extends CRUDService<Project> {
//this just specifies the type
}

