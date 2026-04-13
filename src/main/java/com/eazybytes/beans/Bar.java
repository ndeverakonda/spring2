package com.eazybytes.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bar {

    private final Foo foo;

    @Autowired
    public Bar(@Qualifier("foo1") Foo foo) {
        this.foo = foo;
    }

    public void execute() {
        foo.doSomething();
    }
}
