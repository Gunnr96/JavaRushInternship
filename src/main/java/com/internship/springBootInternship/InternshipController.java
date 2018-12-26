package com.internship.springBootInternship;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InternshipController {

    @GetMapping("/")
    public String helloPage() {
        return "helloPage";
    }
}
