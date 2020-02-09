package ru.exam.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.exam.dataConnection.VocDaoImpl;
import ru.exam.dictionaries.VocFirst;
import ru.exam.dictionaries.Vocabulary;

@Controller
@RequestMapping(value = "/editFirstVoc")
public class FirstController implements BaseController {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    VocDaoImpl daoImpl = context.getBean("dao", VocDaoImpl.class);

    @RequestMapping(method = RequestMethod.POST)
    public String add(VocFirst voc, ModelMap model) {
        daoImpl.setVoc(voc);
        return "viewVoc";

    }

    public void edit() {

    }

    public void delete() {

    }

    public VocFirst view() {
        return null;
    }
}
