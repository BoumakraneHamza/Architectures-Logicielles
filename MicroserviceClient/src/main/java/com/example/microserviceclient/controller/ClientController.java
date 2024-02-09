package com.example.microserviceclient.controller;

import com.example.microserviceclient.bean.ProductBean;
import com.example.microserviceclient.exception.ProductNotFoundException;
import com.example.microserviceclient.proxies.MicroserviceProduitsProxy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Controller
public class ClientController {

    private final MicroserviceProduitsProxy produitsProxy;

    @GetMapping("/")
    public String productList(Model model){
        List<ProductBean> productBeanList = produitsProxy.productBeanList();
        if(productBeanList.isEmpty()){
            throw new ProductNotFoundException("Products not found");
        }
        model.addAttribute("produits",productBeanList);
        return "accueil";
    }

    @GetMapping("/details-produit/{id}")

    public String ficheProduit(@PathVariable int id, Model model){
        ProductBean produit = produitsProxy.productBeanById(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }

}
