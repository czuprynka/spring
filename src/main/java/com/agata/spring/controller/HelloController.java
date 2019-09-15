package com.agata.spring.controller;

import com.agata.spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.List;

//@RestController
public class HelloController {

    @Autowired
    private ClientRepository clientRepository;

    @Path(value = "/listClient")
    public List listClient() {
         return clientRepository.listClient();
    }
//    http://localhost:8080/listClient
}
