package ru.exam;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.exam.dataConnection.VocDaoImpl;

import java.util.List;

public class Solution {
    public static void main(String[] arg){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VocDaoImpl daoImpl = context.getBean("dao", VocDaoImpl.class);
        System.out.println(daoImpl.getUser(1));

        //System.out.println(daoImpl.getUser(1));
        //daoImpl.setUser(new Users("John"));
        //System.out.println(daoImpl.getUser(2));
        //System.out.println(daoImpl.getUsersList("John"));
        //System.out.println(daoImpl.getUsersNativList("IUser"));
    }
}
