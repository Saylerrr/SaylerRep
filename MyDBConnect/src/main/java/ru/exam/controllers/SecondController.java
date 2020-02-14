package ru.exam.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.exam.dataConnection.VocDaoImpl;
import ru.exam.dictionaries.VocSecond;

import java.util.List;

@Controller
@RequestMapping(value = "/editSecondVoc")
public class SecondController implements BaseController {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    VocDaoImpl daoImpl = context.getBean("dao", VocDaoImpl.class);

    @PostMapping
    public String add(String wordOne, String wordTwo) {
        VocSecond voc = new VocSecond();
        voc.setWord_first(wordOne);
        voc.setWord_second(wordTwo);
        daoImpl.setVoc(voc);
        return "viewVoc";
    }

    @PostMapping("/editSecondVoc/get")
    public ModelAndView getBykey(String key){
        return new ModelAndView("result", "command", daoImpl.<VocSecond>getWordByKey(key, VocSecond.class));
    }

    @PostMapping("/editSecondVoc/getall")
    public ModelAndView getAllVoc(){
        return new ModelAndView("result", "command", daoImpl.getAllVoc(VocSecond.class, "voc_second"));
    }

    @PostMapping("/editSecondVoc/del")
    public String delete(String word) {
        VocSecond voc = new VocSecond();
        voc.setWord_first(word);
        // Находит в БД запись по первому слову
        List<VocSecond> list = daoImpl.<VocSecond>getWordByKey(word, VocSecond.class);
        // добавляет в voc id и второе слово из БД
        voc.setId(list.get(0).getId());
        voc.setWord_second(list.get(0).getWord_second());
        daoImpl.delVoc(voc);
        return "result";
    }
}
