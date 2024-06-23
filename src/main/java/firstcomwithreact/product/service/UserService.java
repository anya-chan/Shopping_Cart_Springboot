package firstcomwithreact.product.service;

import firstcomwithreact.product.dao.ProductDao;
import firstcomwithreact.product.dao.UserDao;
import firstcomwithreact.product.model.Product;
import firstcomwithreact.product.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> saveAllUsers(List<User> userList) {
        userDao.saveAll(userList);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> saveUser(User user) {
        userDao.save(user);
        return new ResponseEntity<>("update success", HttpStatus.OK);
    }

    public User findByUsername(String userName) {
        return userDao.findUserByName(userName);
    }
}
