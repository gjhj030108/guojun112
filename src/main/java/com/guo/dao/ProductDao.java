package com.guo.dao;


import com.guo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    //增加产品
    void insertProduct(Product product);

    //根据id删除一个Product
    int deleteProductById(int id);

    //通过id查产品，用于更新产品
    Product queryProductById(int id);

    //更新Product
    int updateProduct(Product product);

    //获取总交易额
    Double selectTurnover(String date);

    //查询所有产品
    List<Product> selectAllProducts();

    //通过name查产品
    List<Product> selectProductsByName(String name);
}
