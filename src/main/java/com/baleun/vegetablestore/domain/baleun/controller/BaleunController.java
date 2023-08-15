package com.baleun.vegetablestore.domain.baleun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baleun.vegetablestore.domain.baleun.dto.ResBaleunDTO;
import com.baleun.vegetablestore.domain.baleun.service.BaleunService;

@Controller
public class BaleunController {
    
    private final BaleunService baleunService;

    @Autowired
    public BaleunController(BaleunService baleunService) {
        this.baleunService = baleunService;
    }
    
    @GetMapping("/")
    public ModelAndView baleunPage() {
        ModelAndView modelAndView = new ModelAndView();
        ResBaleunDTO dto = baleunService.getMainData();
        modelAndView.addObject("dto", dto);
        modelAndView.setViewName("baleun");
        return modelAndView;
    }
    
}