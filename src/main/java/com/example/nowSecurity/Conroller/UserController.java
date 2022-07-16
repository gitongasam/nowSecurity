package com.example.nowSecurity.Conroller;

import com.example.nowSecurity.Entity.User;
import com.example.nowSecurity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processSignUpForm(User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encodedPassWord=encoder.encode(user.getPassword());
        user.setPassword(encodedPassWord);
        userRepository.save(user);
        return "register_success";
    }
    @GetMapping("/tenant")
    public String products(Model model){
        return "tenant";
    }
}