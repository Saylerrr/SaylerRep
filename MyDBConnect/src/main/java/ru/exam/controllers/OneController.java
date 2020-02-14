package ru.exam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.exam.dictionaries.ChoiceVoc;
import ru.exam.dictionaries.VocFirst;
import ru.exam.dictionaries.VocSecond;

@Controller
public class OneController {
    @GetMapping("/viewVoc")
    public ModelAndView viewVoc() {
        //ModelAndView model = new ModelAndView("viewVoc");
        return new ModelAndView("viewVoc", "command", new ChoiceVoc());
    }

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @PostMapping("/editVoc")
    public ModelAndView editVoc(ChoiceVoc voc, ModelMap model) {
        model.addAttribute("numVoc", voc.getNumVoc());
        if (voc.getNumVoc()==1){
            return new ModelAndView("editFirstVoc", "command", new VocFirst());
        } else {
            return new ModelAndView("editSecondVoc", "command", new VocSecond());
        }
    }
}
