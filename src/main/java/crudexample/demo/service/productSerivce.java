package crudexample.demo.service;

import crudexample.demo.entity.Product;
import crudexample.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productSerivce {
    @Autowired
    private ProductRepository repository;
    public Product saveProduct(Product product){
         return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
    public List<Product> getProduct(){
        return repository.findAll();
    }
    public Product getProductByID(int id){
        return repository.findById(id).orElse(null);

    }
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //method for put and delete
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed sucessfully";
    }
    //method for update product
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setId(product.getId());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
