package com.example.microserviceclient.controller;

import com.example.microserviceclient.bean.ProductBean;
import com.example.microserviceclient.exception.ProductNotFoundException;
import com.example.microserviceclient.proxies.MicroserviceProduitsProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @CircuitBreaker(name = "ProductCircuitBreaker", fallbackMethod = "fallbackList")
    public String productList(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Logger logger = LoggerFactory.getLogger(ClientController.class);
        logger.info("Envoi requête vers microservice-produits");
        List<ProductBean> productBeanList = produitsProxy.productBeanList();
        if(productBeanList.isEmpty()){
            throw new ProductNotFoundException("Products not found");
        }
        logger.info("Réponse reçue ! : " + mapper.writeValueAsString(productBeanList));
        model.addAttribute("produits",productBeanList);
        return "accueil";
    }
    public String fallbackList(Exception e){
        Logger logger = LoggerFactory.getLogger(ClientController.class);
        logger.error("Erreur le circuit breaker est déclenché !");
        logger.error("Erreur : "+e.getMessage());
        return "Products not available, please try again later";
    }

    @GetMapping("/details-produit/{id}")
    @CircuitBreaker(name = "ProductCircuitBreaker", fallbackMethod = "fallbackDetails")
    public String ficheProduit(@PathVariable int id, Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Logger logger = LoggerFactory.getLogger(ClientController.class);
        logger.info("Recue Requete avec id :"+id);
        logger.info("Envoi requête vers microservice-produits");

        ProductBean produit = produitsProxy.productBeanById(id);
        if (produit == null) {
            throw new ProductNotFoundException("Product not found");
        }
        logger.info("Réponse reçue ! : " + mapper.writeValueAsString(produit));
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }
    public String fallbackDetails(int id,Model model, Exception e){
        return "FicheProduitFail";
    }
}
