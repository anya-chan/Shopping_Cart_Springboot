package firstcomwithreact.product.service;

import firstcomwithreact.product.dao.ProductDao;
import firstcomwithreact.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public ResponseEntity<List<Product>> findAllProducts() {
        return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> saveAllProducts(List<Product> productList) {
        productDao.saveAll(productList);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> saveProduct(Product product) {
        productDao.save(product);
        return new ResponseEntity<>("update success", HttpStatus.OK);
    }

}
