package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
    public List<Product> getAllProducts(){
        List<Product> p = productRepository.findAll();
        return p;
    }
    
    public List<ProductType> findAllProductTypes(){
        List<ProductType> p = productRepository.findAllProductTypes();
        return p;
    }
    
    public List<Product> getProductsCheaperThan(double price) {
    	List<Product> p = productRepository.findByPriceLessThan(price);
        return p;
    }

    public ProductType getProductType(String name){
        ProductType productType = productRepository.findProductType(name);
        return productType;
    }

    public Product save(Product p){
        return null;       
    }

    
}
