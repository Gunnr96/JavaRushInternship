package com.internship.springBootInternship;

import com.internship.springBootInternship.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class InternshipController {

    private PartService partService;

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping("/")
    public ModelAndView helloPage() {
        ModelAndView model = new ModelAndView("helloPage");
        model.addObject("list", partService.getAll());
        return model;
    }
}
