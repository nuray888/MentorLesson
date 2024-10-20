package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.feign.KnowledgeResponse;
import com.example.studentmanagmentsystem.feign.KnowledgeFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KnowledgeService {
    private final KnowledgeFeign knowledgeFeign;



    private final String host="daily-knowledge.p.rapidapi.com";
    private final String key="6f258057f6msh074a7dddfbf024bp11274cjsn5a6548e1ed45";


    public KnowledgeResponse getChemicalKnowledge(){
        KnowledgeResponse chemicalKnowledge = knowledgeFeign.getKnowledge(host,key);
        return chemicalKnowledge;
    }

}
