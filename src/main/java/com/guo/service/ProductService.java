package com.guo.service;

import com.guo.pojo.Product;

import java.util.List;

public interface ProductService {
    //增加产品
    void saveProduct(Product product);

    //根据id删除一个Product
    int deleteProductById(int id);

    //更新Product
    int updateProduct(Product product);

    //通过id查产品，用于更新产品
    Product queryProductById(int id);

    //获取总交易额
    Double findTurnover();

    //查询所有产品
    List<Product> findAllProducts();

    //通过name查产品
    List<Product> findProductsByName(String name);


}
