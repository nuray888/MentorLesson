package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.dto.feign.KnowledgeResponse;
import com.example.studentmanagmentsystem.service.KnowledgeService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnowledgeController {
    private final KnowledgeService service;


    public KnowledgeController(KnowledgeService service) {
        this.service = service;
    }
    @GetMapping("/knowledge")
    public KnowledgeResponse getController(){
       return  service.getChemicalKnowledge();
    }

}
