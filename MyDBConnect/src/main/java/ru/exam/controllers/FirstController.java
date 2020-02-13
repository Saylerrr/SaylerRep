package ru.exam.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.exam.dataConnection.VocDaoImpl;
import ru.exam.dictionaries.VocFirst;

import java.util.List;

@Controller
@RequestMapping(value = "/editFirstVoc")
public class FirstController implements BaseController {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    VocDaoImpl daoImpl = context.getBean("dao", VocDaoImpl.class);

    @RequestMapping(method = RequestMethod.POST)
    public String add(String wordOne, String wordTwo) {
        VocFirst voc = new VocFirst();
        voc.setWord_first(wordOne);
        voc.setWord_second(wordTwo);
        daoImpl.setVoc(voc);
        return "viewVoc";
    }

    @RequestMapping(value = "/editFirstVoc/get", method = RequestMethod.POST)
    public ModelAndView getBykey(String key){
        return new ModelAndView("result", "command", daoImpl.<VocFirst>getWordByKey(key, VocFirst.class));
    }

    @RequestMapping(value = "/editFirstVoc/getall", method = RequestMethod.POST)
    public ModelAndView getAllVoc(){
        return new ModelAndView("result", "command", daoImpl.getAllVoc(VocFirst.class, "voc_first"));
    }

    @RequestMapping(value = "/editFirstVoc/del", method = RequestMethod.POST)
    public String delete(String word) {
        VocFirst voc = new VocFirst();
        voc.setWord_first(word);
        // Находит в БД запись по первому слову
        List<VocFirst> list = daoImpl.<VocFirst>getWordByKey(word, VocFirst.class);
        // добавляет в voc id и второе слово из БД
        voc.setId(list.get(0).getId());
        voc.setWord_second(list.get(0).getWord_second());
        daoImpl.delVoc(voc);
        return "result";
    }
}
