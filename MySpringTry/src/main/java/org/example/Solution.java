package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Solution {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRoom room = context.getBean("room", ClassRoom.class);
        room.studDo();
    }
}
