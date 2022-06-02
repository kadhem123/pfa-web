package com.wedtect.wedtectback.controller;


import com.wedtect.wedtectback.entities.Product;
import com.wedtect.wedtectback.product.FileUploadUtil;
import com.wedtect.wedtectback.product.ProductNotFoundException;

import com.wedtect.wedtectback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String showProductList(Model model){
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "products";
}
    @GetMapping("/products/new")
    public String showNewForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("pageTitle", "Add new Article");
        return "ProductForm";
    }
    @PostMapping("/products/save")
    public String saveProduct(Product prod,
                              @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        prod.setPhoto(fileName);
        service.save(prod);

        String uploadDir = "user-photos/" + prod.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "redirect:/users";
    }


    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Product prod = service.get(id);
            model.addAttribute("product", prod);
            model.addAttribute("pageTitle", "Edit product(ID:" + id + ")");
            return "ProductForm";
        }catch(ProductNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            //"Product has been saved successfully"
            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete/{id}")
    public String DeleteUser(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            service.delete(id);
            ra.addFlashAttribute("message","User with ID" + id + "has been deleted successfully");
        }catch(ProductNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            //"User deleted successfully"
        }
        return "redirect:/products";
    }

}
