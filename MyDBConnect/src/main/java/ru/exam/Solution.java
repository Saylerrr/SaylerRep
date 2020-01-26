package ru.exam;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Solution {
    public static void main(String[] arg) throws ParserConfigurationException, SQLException, ClassNotFoundException {
        UserDAOImpl daoImpl = new UserDAOImpl();
        Users us = daoImpl.getUser(1);
        System.out.println(us);
        Users us2 = new Users("John");
        daoImpl.setUser(us2);
        Users us3 = daoImpl.getUser(2);
        System.out.println(us3);
        List<Users> listUs = daoImpl.getUsersList("John");
        System.out.println(listUs);
    }
}
