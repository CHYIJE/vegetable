package com.baleun.vegetablestore.domain.baleun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baleun.vegetablestore.domain.baleun.dto.ResBaleunDTO;
import com.baleun.vegetablestore.domain.baleun.service.BaleunService;


@Controller
public class BaleunController {
    
    @GetMapping("/")
    public ModelAndView baleunPage() {
        ModelAndView modelAndView = new ModelAndView();
        ResBaleunDTO dto = BaleunService.getMainData();
        modelAndView.addObject("dto", dto);
        modelAndView.setViewName("baleun");
        return modelAndView;
    }
    
}
