package ru.examp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("user", new Users());
        return "hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String methodPost(@ModelAttribute Users user, Model model){
        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());
        return "hellosec";
    }
}
