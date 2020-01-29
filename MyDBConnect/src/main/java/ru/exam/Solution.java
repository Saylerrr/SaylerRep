package ru.exam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Solution {
    public static void main(String[] arg){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAOImpl daoImpl = context.getBean("dao", UserDAOImpl.class);

        System.out.println(daoImpl.getUser(1));
        //daoImpl.setUser(new Users("John"));
        System.out.println(daoImpl.getUser(2));
        System.out.println(daoImpl.getUsersList("John"));
        System.out.println(daoImpl.getUsersNativList("IUser"));
    }
}
