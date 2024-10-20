package com.example.studentmanagmentsystem.feign;

import com.example.studentmanagmentsystem.dto.feign.KnowledgeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
@FeignClient(name = "knowledge-server",url = "https://daily-knowledge.p.rapidapi.com/chemical-elements-en.json")

public interface KnowledgeFeign {
    @GetMapping()
    KnowledgeResponse getKnowledge(@RequestHeader("x-rapidapi-host") String host,
                                   @RequestHeader("x-rapidapi-key") String key);
}
