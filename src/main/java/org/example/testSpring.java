package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        // этот класс обращается к файлу ApplicationContext.xml, и помещает все bean в ApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "ApplicationContext.xml"
        );

        // получим bean из ApplicationContext
        testBean testBean1 = context.getBean("testBean", testBean.class);
        System.out.println(testBean1.getName());

        // Способ без установки конструктора в bean-e
//        Muzik muzik = context.getBean("MuzBean", Muzik.class); // указываем интерфейс
//        MuzikPlayer muzikPlayer = new MuzikPlayer(muzik);

        // C установкой конструктора в bean-e, больше не нужно перекомпилировать(изменять код)
//        MuzikPlayer muzikPlayer = context.getBean("MuzPlayer", MuzikPlayer.class);

        // Установка поля через сеттер, в классе должен быть пустой конструктор
        MuzikPlayer muzikPlayer = context.getBean("MuzPlayerS", MuzikPlayer.class);
        System.out.println(muzikPlayer.getMuzik().getSong());
        System.out.println(muzikPlayer.getName());
        System.out.println(muzikPlayer.getVolume());
        System.out.println();
        muzikPlayer.playMuzList();

        context.close(); // всегда нужно закрывать
    }
}
