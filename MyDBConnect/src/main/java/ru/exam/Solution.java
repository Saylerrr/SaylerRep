package ru.exam;

import java.util.List;

public class Solution {
    public static void main(String[] arg){
        UserDAOImpl daoImpl = new UserDAOImpl();
        Users us = daoImpl.getUser(1);
        System.out.println(us);
        //Users us2 = new Users("John");
        //daoImpl.setUser(us2);
        Users us3 = daoImpl.getUser(2);
        System.out.println(us3);
        List<Users> listUs = daoImpl.getUsersList("John");
        System.out.println(listUs);
    }
}
