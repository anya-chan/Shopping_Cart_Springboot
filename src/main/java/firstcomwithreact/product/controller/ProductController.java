package firstcomwithreact.product.controller;

import firstcomwithreact.product.ResourceNotFoundException;
import firstcomwithreact.product.dao.ProductDao;
import firstcomwithreact.product.model.Product;
import firstcomwithreact.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductDao productDao;

    @GetMapping("all")
    public ResponseEntity<List<Product>> getAllProduct(){
        return productService.findAllProducts();
    }

    @PostMapping("saveAll")
    public ResponseEntity<String> saveAllProduct(@RequestBody List<Product> productList) {
        return productService.saveAllProducts(productList);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable Long id, @RequestBody Product product){
        Product ProductById = productDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not found"));

        ProductById.setName(product.getName());
        ProductById.setPrice(product.getPrice());
        ProductById.setImage(product.getImage());
        ProductById.setDescription(product.getDescription());

        return productService.saveProduct(ProductById);
    }

}
