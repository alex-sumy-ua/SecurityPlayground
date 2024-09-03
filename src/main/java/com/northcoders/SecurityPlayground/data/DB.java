package com.northcoders.SecurityPlayground.data;

import java.util.Arrays;
import java.util.List;
//import org.example.db.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.hibernate.cfg.JdbcSettings.*;


public class DB {

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:h2:mem:db1")
                .setProperty("hibernate.connection.username", "sa")
                .setProperty("hibernate.connection.password", "")
                .setProperty("hibernate.agroal.maxSize", "20")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                .setProperty(HIGHLIGHT_SQL, TRUE.toString())
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

//    static void seed() {
//        var sessionFactory = getSessionFactory();
//        // TODO
//        Category sweets = new Category("Sweets");
//        Category savoury = new Category("Savoury");
//        Ingredient sugar = new Ingredient("Sugar");
//        Ingredient apple = new Ingredient("Apple");
//
//        sessionFactory.inTransaction(session -> {
//            session.persist(sugar);
//            session.persist(apple);
//            session.persist(new Ingredient("Salt"));
//            session.persist(new Recipe("Cupcake", Arrays.asList(sugar, apple), List.of(sweets)));
//        });
//    }

}