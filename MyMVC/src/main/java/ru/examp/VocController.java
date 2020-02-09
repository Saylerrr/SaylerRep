package ru.examp;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import java.util.List;

@Controller
public class VocController {
    @RequestMapping(value = "/viewVoc", method = RequestMethod.GET)
    public ModelAndView viewVoc() {
        return new ModelAndView("viewVoc", "command", new СhoiceVoc());
    }

    @RequestMapping(value = "/editVoc", method = RequestMethod.POST)
    public ModelAndView editVoc(СhoiceVoc voc, ModelMap model) {
        model.addAttribute("numVoc", voc.getNumVoc());
        ModelAndView model2 = new ModelAndView("editVoc", "command", voc.createVoc(voc.getNumVoc()));
        return model2;
    }

    @RequestMapping(value = "/setVoc", method = RequestMethod.POST)
    public String setVoc(VocFirst voc, ModelMap model){ //Если вместо Vocabulary поставить например VocFirst и ввести в форму "1", то работает
        model.addAttribute("word_first", voc.getWord_first());
        model.addAttribute("word_second", voc.getWord_second());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VocDaoImpl daoImpl = context.getBean("dao", VocDaoImpl.class);
        VocFirst list = daoImpl.getId(1);
        System.out.println(list.getWord_first());
        return "result";
    }

}
