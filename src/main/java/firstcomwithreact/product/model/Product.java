package firstcomwithreact.product.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.core.SpringVersion;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String image;
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<CartItem> cartItems = new ArrayList<>();

}
