package com.guo.service.impl;

import com.guo.pojo.Product;
import com.guo.dao.ProductDao;
import com.guo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao dao;

    /*//总交易额
    @Override
    @Cacheable(value = "guojun", key = "'turnover'")
    public Double findTurnover() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return dao.selectTurnover(sdf.format(date));
    }*/

    @Autowired
    private RedisTemplate<Object, Object> template;

    @Override
    public Double findTurnover() {
        // 获取Redis操作对象
        BoundValueOperations<Object, Object> ops = template.boundValueOps("turnover");
        // 从缓存获取turnover
        Object turnover = ops.get();
        // 双重检测锁
        if (turnover == null) {
            synchronized (this) {
                turnover = ops.get();
                // 若缓存中没有，则从DB中查询
                if (turnover == null) {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    turnover = dao.selectTurnover(sdf.format(date));
                    // 将从DB中查询的结果写入到缓存，并指定过期时间
                    ops.set(turnover, 100, TimeUnit.SECONDS);
                }
            }
        }
        return (Double)turnover;
    }

    //更新产品
    @Override
    /*清除缓存是清除当前value值空间下的所有缓存数据*/
    @CacheEvict(value = "guojun", allEntries = true)
    public int updateProduct(Product product) {
        return dao.updateProduct(product);
    }

    //删除产品
    @Override
    /*清除缓存是清除当前value值空间下的所有缓存数据*/
    @CacheEvict(value = "guojun", allEntries = true)
    public int deleteProductById(int id) {
        return dao.deleteProductById(id);
    }

    //查找所有产品
    @Override
    @Cacheable(value = "guojun", key = "'allproducts'")
    public List<Product> findAllProducts() {
        return dao.selectAllProducts();
    }

    //根据name查产品
    @Override
    @Cacheable(value = "guojun", key = "'name'")
    public List<Product> findProductsByName(String name) {
        return dao.selectProductsByName(name);
    }

    //插入产品
    @Override
    /*清除缓存是清除当前value值空间下的所有缓存数据*/
    @CacheEvict(value = "guojun", allEntries = true)
    public void saveProduct(Product product) {
        dao.insertProduct(product);
    }

    //通过id查找产品
    @Override
    @Cacheable(value = "guojun", key = "'id'")
    public Product queryProductById(int id) {
        return dao.queryProductById(id);
    }

}
