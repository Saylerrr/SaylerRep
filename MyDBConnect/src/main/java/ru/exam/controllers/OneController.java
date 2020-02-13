package ru.exam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.exam.dictionaries.ChoiceVoc;
import ru.exam.dictionaries.VocFirst;
import ru.exam.dictionaries.VocSecond;

@Controller
public class OneController {
    @RequestMapping(value = "/viewVoc", method = RequestMethod.GET)
    public ModelAndView viewVoc() {
        //ModelAndView model = new ModelAndView("viewVoc");
        return new ModelAndView("viewVoc", "command", new ChoiceVoc());
    }

    @RequestMapping(value = "/editVoc", method = RequestMethod.POST)
    public ModelAndView editVoc(ChoiceVoc voc, ModelMap model) {
        model.addAttribute("numVoc", voc.getNumVoc());
        if (voc.getNumVoc()==1){
            return new ModelAndView("editFirstVoc", "command", new VocFirst());
        } else {
            return new ModelAndView("editSecondVoc", "command", new VocSecond());
        }
    }
}
