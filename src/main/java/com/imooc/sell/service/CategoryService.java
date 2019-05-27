package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categroyTypeList);

    ProductCategory save(ProductCategory productCategory);
}
