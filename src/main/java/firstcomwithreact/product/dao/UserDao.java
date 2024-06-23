package firstcomwithreact.product.dao;

import firstcomwithreact.product.model.Product;
import firstcomwithreact.product.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByName(String name);
}
