package com.eazybytes.beans;

public class FooImpl implements Foo {
    private final String label;

    public FooImpl(String label) {
        this.label = label;
    }

    @Override
    public void doSomething(String msg) {
        System.out.println(label + " " + msg);
    }
}
