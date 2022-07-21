package org.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
//        System.setProperty("m_type", "remote");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("org.conditional");

        Mess mess = context.getBean(Mess.class);
        mess.tak();
        context.close();
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("user.home"));
    }
}
