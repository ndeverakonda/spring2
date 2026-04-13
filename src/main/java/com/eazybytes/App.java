package com.eazybytes;

import com.eazybytes.beans.Bar;
import com.eazybytes.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Bar bar = context.getBean(Bar.class);
        bar.execute();
        context.close();
    }
}
