package com.twintea.spacehr.controller;

import com.twintea.spacehr.model.Hr;
import com.twintea.spacehr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private HrService hrService;
    @GetMapping("/hrs")
    public List<Hr> getHrsExcludeCurrentHr(){
        return hrService.getHrsExcludeCurrentHr();
    }
}
