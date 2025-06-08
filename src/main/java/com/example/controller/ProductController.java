package com.example.controller;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    @PostMapping
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/form";
        }
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow();
        model.addAttribute("product", product);
        return "product/form";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/form";
        }
        product.setId(id);
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
