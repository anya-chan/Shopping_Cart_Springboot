package firstcomwithreact.product.controller;

import firstcomwithreact.product.model.Product;
import firstcomwithreact.product.model.User;
import firstcomwithreact.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("saveAll")
    public ResponseEntity<String> saveAllProduct(@RequestBody List<User> userList) {
        return userService.saveAllUsers(userList);
    }
    @PostMapping("register")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        User usr = new User();
        usr.setUserId(user.getUserId());
        usr.setName(user.getName());
        usr.setAddress(user.getAddress());

        String plainPassword = user.getPassword(); // The plain password entered by the user
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(plainPassword);

        usr.setPassword(hashedPassword);
        return userService.saveUser(usr);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllProduct(){
        return userService.findAllUsers();
    }

}
