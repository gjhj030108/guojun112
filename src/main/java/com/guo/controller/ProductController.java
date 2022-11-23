package com.guo.controller;

import com.guo.pojo.Product;
import com.guo.pojo.User;
import com.guo.service.ProductService;
import com.guo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private UserService userservice;

    //主页
    @RequestMapping("/product")
    public String index(Model model) {
        // 查询平台总交易额
        Double turnover = service.findTurnover();
        model.addAttribute("turnover", turnover);
        // 查询所有产品
        List<Product> products = service.findAllProducts();
        model.addAttribute("allProducts", products);
        return "/allProduct.jsp";
    }

    @RequestMapping("/toAddProduct")
    public String toAddProduct() {
        return "/addProduct.jsp";
    }
    // 处理新产品上架请求
    @RequestMapping("/addProduct")
    public String registerProduct(Product product, Model model) {
        // 将新产品写入到数据库
        service.saveProduct(product);
        // 查询所有产品
        List<Product> products = service.findAllProducts();
        model.addAttribute("allProducts", products);
        return "redirect:/product";
    }

    // 处理产品删除请求
    @RequestMapping("/del/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        service.deleteProductById(id);
        return "redirect:/toManager";
    }

    // 处理产品更新请求
    @RequestMapping("/toUpdateProduct")
    public String toUpdateProduct(Model model, int id) {
        Product product = service.queryProductById(id);
        model.addAttribute("product", product);
        return "/updateProduct.jsp";
    }
    @RequestMapping("/updateProduct")
    public String updateBook(Model model, Product product) {
        service.updateProduct(product);
        return "redirect:/toManager";
    }

    // 处理根据产品名称查询请求
    @RequestMapping("/product/name")
    public String listProducts(String name, Model model) {
        // 根据产品名称查询产品
        List<Product> result = service.findProductsByName(name);
        model.addAttribute("result", result);
        model.addAttribute("name", name);

        return "/result.jsp";
    }

    // 管理页面
    @RequestMapping("/toManager")
    public String manager(Model model) {
        // 查询所有产品
        List<Product> products = service.findAllProducts();
        model.addAttribute("allProducts", products);
        return "/manager.jsp";
    }

    //登录页面
    @RequestMapping("/login")
    public String login(){
        return "/login.jsp";
    }
    @RequestMapping("/tologin")
    public String login(String username, String password, Model model, HttpSession httpSession){
        //查询用户，为空则用户名或密码错误，反则正确
        User user = userservice.login(username,password);
        if (user == null){
            //登录失败
            model.addAttribute("msg","密码错误");
            return "/login";
        }
        //将user存入session
        httpSession.setAttribute("user", user);
        return "/product";
    }

    //处理登出请求
    @RequestMapping("/toLoginout")
    public String goOut(HttpSession session){
        //移除session
        session.removeAttribute("user");
        return "/login";
    }
}