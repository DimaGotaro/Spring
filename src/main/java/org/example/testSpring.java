package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testSpring {
    public static void main(String[] args) {
        // этот класс обращается к файлу ApplicationContext.xml, и помещает все bean в ApplicationContext
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "ApplicationContext.xml"
//        ); // через отдельный файл ApplicationContext.xml

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        ); // через класс

        // получим bean из ApplicationContext
        testBean testBean1 = context.getBean("testBean", testBean.class);
        System.out.println(testBean1.getName());

        // Способ без установки конструктора в bean-e
//        Muzik muzik = context.getBean("MuzBean", Muzik.class); // указываем интерфейс
//        MuzikPlayer muzikPlayer = new MuzikPlayer(muzik);

        // C установкой конструктора в bean-e, больше не нужно перекомпилировать(изменять код)
//        MuzikPlayer muzikPlayer = context.getBean("MuzPlayer", MuzikPlayer.class);

        // Установка поля через сеттер, в классе должен быть пустой конструктор
//        MuzikPlayer muzikPlayer = context.getBean("MuzPlayerS", MuzikPlayer.class);
//        System.out.println(muzikPlayer.getMuzik().getSong());
//        System.out.println(muzikPlayer.getName());
//        System.out.println(muzikPlayer.getVolume());
//        muzikPlayer.playMuzList();
//        muzikPlayer.playMuz();
//        muzikPlayer.playMuzR(); // через аннотации
//        System.out.println();

        // prototype
//        MuzikPlayer muzikPlayer2 = context.getBean("MuzPlayerS", MuzikPlayer.class);
//        boolean a1 = muzikPlayer == muzikPlayer2;
//        System.out.println(a1); // true, scope = singleton
//        System.out.println(muzikPlayer);
//        System.out.println(muzikPlayer2);
//        muzikPlayer.setVolume(66);
//        System.out.println(muzikPlayer2.getVolume()); // singleton = 66, prototype = 25
        // singleton - все вызовы getBean с одинаковыми объектами, prototype - все разные

//        Muzik muzik = context.getBean("RockBean", RockMuzik.class);
//        System.out.println(muzik.getSong());
//
//        Muzik muzik1 = context.getBean("classikMuzik", ClassikMuzik.class);
//        System.out.println(muzik1.getSong());
//
//        MuzikPlayer muzikPlayer1 = new MuzikPlayer((muzik1));
//        muzikPlayer1.playMuz();

//        Computer computer = context.getBean("computer", Computer.class);
//        System.out.println(computer.toString());
//        System.out.println(computer); // то же что и при выводе toString
//        System.out.println();

        MuzikPlayer muzikPlayer3 = context.getBean("muzikPlayer", MuzikPlayer.class);
        // через аннотацию, без прописывания bean в ApplicationContext.xml
//        muzikPlayer3.playMuz();
//        System.out.println(muzikPlayer3.playMuzR());
//        muzikPlayer3.playMuzMass();
//        System.out.println();
//        muzikPlayer3.playType(muzikType.CLASSIC);
//        System.out.println(muzikPlayer3.getName());
//        System.out.println(muzikPlayer3.getVolume());
        muzikPlayer3.playT();

        context.close(); // всегда нужно закрывать

        // Рефлексия
        Myclass myclass = new Myclass();
        int numb = myclass.getNumber();
        String name = null;
        System.out.println(numb + name);
        try {
            // для поля
            Field name1 = myclass.getClass().getDeclaredField("name");
            name1.setAccessible(true); // разрешили доступ для работы
            name1.set(myclass, "new vallue");
            name = (String) name1.get(myclass);

            // для метода
            Method method = myclass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myclass); // вызов метода, первый
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(numb + name); // второй
        printData(myclass); // третий
        System.out.println(Myclass.class.getName());

        // для класса
//        Myclass myclass1 = null;
//        try {
//            Class<?> aClass = Class.forName(Myclass.class.getName());
//            myclass1 = (Myclass) aClass.newInstance();
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(myclass1);
    }
    public static void printData(Object myclass) {
        Method method = null;
        try {
            method = myclass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myclass); // третий
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
