package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Configuration // аналог ApplicationContext.xml
//@ComponentScan("org.example") // путь к классам
@PropertySource("classpath:muzicProp.properties") // путь к файлу muzicProp.properties
public class SpringConfig {
    @Bean
    public testBean testBean() {
        return new testBean();
    }
    @Bean
    public RockMuzik rockMuzik() {
        return new RockMuzik();
    }
    @Bean
    public ClassikMuzik classikMuzik() {
        return new ClassikMuzik();
    }
    @Bean
    public MetalMuzik metalMuzik() {
        return new MetalMuzik();
    }
    @Bean
    public List<Muzik> muzikList2() { // так же как и в сеттер
        return Arrays.asList(rockMuzik(), classikMuzik(), metalMuzik());
    }
    @Bean
    public MuzikPlayer muzikPlayer() {
      return new MuzikPlayer(muzikList2());
    }
//    @Bean
//    public MuzikPlayer muzikPlayer() {
//        return new MuzikPlayer(classikMuzik(), rockMuzik());
//    }
    @Bean
    public Computer computer() {
        return new Computer(muzikPlayer());
    }
}
