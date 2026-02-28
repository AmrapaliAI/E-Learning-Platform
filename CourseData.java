package User;


import java.util.ArrayList;
import java.util.List;

public class CourseData {

    public static List<Course_Content> getAllData() {
        List<Course_Content> data = new ArrayList<>();

        // ---------------- Java ----------------
        data.add(new Course_Content("Java", "Basics", "Java is a high-level, object-oriented programming language. It runs on JVM."));
        data.add(new Course_Content("Java", "OOP", "Java supports classes, objects, inheritance, polymorphism, abstraction, and encapsulation."));
        data.add(new Course_Content("Java", "Advanced", "Advanced topics include multithreading, collections, generics, JDBC, and Java 8 features."));

        // ---------------- Python ----------------
        data.add(new Course_Content("Python", "Basics", "Python is an interpreted, high-level, dynamically typed language."));
        data.add(new Course_Content("Python", "OOP", "Python supports classes, objects, inheritance, polymorphism, and encapsulation."));
        data.add(new Course_Content("Python", "Advanced", "Advanced Python includes modules, decorators, generators, and web frameworks like Django and Flask."));

        // ---------------- AI ----------------
        data.add(new Course_Content("AI", "Basics", "Artificial Intelligence is the simulation of human intelligence by machines."));
        data.add(new Course_Content("AI", "Machine Learning", "ML is a subset of AI where machines learn patterns from data."));
        data.add(new Course_Content("AI", "Deep Learning", "DL uses neural networks with multiple layers to model complex data."));

        // ---------------- HTML ----------------
        data.add(new Course_Content("HTML", "Basics", "HTML is used to structure web pages with tags like <html>, <head>, <body>, <h1> etc."));
        data.add(new Course_Content("HTML", "Forms", "Forms collect user input using <form>, <input>, <textarea>, <button> etc."));

        // ---------------- CSS ----------------
        data.add(new Course_Content("CSS", "Basics", "CSS styles HTML elements. You can set colors, fonts, layouts, and responsive design."));
        data.add(new Course_Content("CSS", "Advanced", "Advanced CSS includes Flexbox, Grid, animations, and media queries for responsive design."));

        // ---------------- JavaScript ----------------
        data.add(new Course_Content("JavaScript", "Basics", "JS is a scripting language for web pages. It manipulates HTML and CSS dynamically."));
        data.add(new Course_Content("JavaScript", "Advanced", "Advanced JS includes ES6 features, asynchronous programming, promises, and DOM manipulation."));

        // ---------------- DBMS ----------------
        data.add(new Course_Content("DBMS", "Basics", "Database Management System stores and manages data efficiently."));
        data.add(new Course_Content("DBMS", "SQL", "SQL is used to query databases: SELECT, INSERT, UPDATE, DELETE."));
        data.add(new Course_Content("DBMS", "Advanced", "Advanced topics include normalization, transactions, indexing, and joins."));

        // ---------------- Indian Constitution ----------------
        data.add(new Course_Content("Indian Constitution", "Basics", "The Constitution of India lays down the framework of the political principles and powers."));
        data.add(new Course_Content("Indian Constitution", "Fundamental Rights", "These include Right to Equality, Freedom, Education, and Constitutional remedies."));
        data.add(new Course_Content("Indian Constitution", "Directive Principles", "Guidelines for the government to ensure social and economic democracy."));

        return data;
    }
}
