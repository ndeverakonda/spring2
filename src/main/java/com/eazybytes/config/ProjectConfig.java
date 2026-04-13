package com.eazybytes.config;

import com.eazybytes.beans.Foo;
import com.eazybytes.beans.FooImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.eazybytes.beans")
public class ProjectConfig {

    @Bean("foo1")
    public Foo foo() {
        return new FooImpl();
    }

    // Uncomment this to create ambiguity for the exercise
    @Bean
    public FooImpl fooImpl() {
        return new FooImpl();
    }

}
