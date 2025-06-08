package com.example.controller;

import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;

    @GetMapping("/admin/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/user-list";
    }
}
