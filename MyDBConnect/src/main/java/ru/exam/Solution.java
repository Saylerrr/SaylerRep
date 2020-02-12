package ru.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.exam.dataConnection.VocDaoImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@SpringBootApplication
@EnableSwagger2
public class Solution {
    public static void main(String[] args){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        VocDaoImpl daoImpl = context.getBean("dao", VocDaoImpl.class);
//        System.out.println(daoImpl.getUser(1));
        SpringApplication.run(Solution.class, args);

        //System.out.println(daoImpl.getUser(1));
        //daoImpl.setUser(new Users("John"));
        //System.out.println(daoImpl.getUser(2));
        //System.out.println(daoImpl.getUsersList("John"));
        //System.out.println(daoImpl.getUsersNativList("IUser"));
    }
}
