package crudexample.demo.controller;

import crudexample.demo.entity.Product;
import crudexample.demo.service.productSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private productSerivce service;
    //post method
        @PostMapping("/addProduct")
        public Product addProduct(@RequestBody Product product){
            return  service.saveProduct(product);
        }
        /// to save list of products
        @PostMapping("/addProducts")
        public List<Product>  addProducts(@RequestBody List<Product> products){
            return service.saveProducts(products);
        }
    // getAPI methods
         @GetMapping("/product")
         public List<Product> findAllProducts(){
            return service.getProduct();
         }
         @GetMapping("/product/{id}")
         public Product findProductsByID(@PathVariable int  id){
            return service.getProductByID(id);
        }
        @GetMapping("/product/{name}")
        public Product findProductByName(@PathVariable String  name){
            return service.getProductByName(name);
        }
    // put and Delete
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return  service.updateProduct(product);
    }
    @DeleteMapping("/DeleteProduct")
    public String deleteProduct(@PathVariable int id){
            return service.deleteProduct(id);
    }



}
