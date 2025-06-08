package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "product/register";
    }

    @PostMapping("/register")
    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of("ROLE_USER")); // 기본 권한
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/register-admin")
    public String showAdminRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "product/register";  // 일반 회원가입 폼 재사용
    }

    @PostMapping("/register-admin")
    public String registerAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of("ROLE_ADMIN"));  // ✅ 관리자 권한 부여
        userRepository.save(user);
        return "redirect:/login";
    }

}
