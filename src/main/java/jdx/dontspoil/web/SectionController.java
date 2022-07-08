package jdx.dontspoil.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SectionController {
    @GetMapping("/section/insert")
    public String insertSection() {
        return "insertSection";
    }
}
