package com.eazybytes.config;

import com.eazybytes.beans.Foo;
import com.eazybytes.beans.FooImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.eazybytes.beans")
public class ProjectConfig {

    @Bean
    public Foo foo() {
        System.out.println("Wrong bean created");
        return new FooImpl("Wrong bean");
    }

    // Uncomment this to create ambiguity for the exercise
    @Bean("foo1")
    public FooImpl fooImpl() {
        System.out.println("Correct Bean created");
        return new FooImpl("Correct bean");
    }

}
