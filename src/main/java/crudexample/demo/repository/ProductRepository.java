package crudexample.demo.repository;

import crudexample.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// repositort talks to database
public interface ProductRepository extends JpaRepository<Product,Integer> {


}
