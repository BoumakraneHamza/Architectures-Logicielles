package com.example.microserviceclient.proxies;

import com.example.microserviceclient.bean.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "MicroserviceProduits" , url = "localhost:9001")
@RibbonClient(name = "MicroserviceProduits")
public interface MicroserviceProduitsProxy {

    @RequestMapping(method = RequestMethod.GET , value = "/Produits")
    List<ProductBean> productBeanList();

    @RequestMapping(method = RequestMethod.GET , value = "/Produits/{id}")
    ProductBean productBeanById(@PathVariable int id);
}
