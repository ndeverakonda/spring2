
# Spring Core Questions and Answers

## 1. What is the ApplicationContext?
ApplicationContext is the core container of the Spring Framework. It creates, configures, and manages beans, performs dependency injection, and handles the bean lifecycle. It also provides features like AOP, event handling, and internationalization.


## 2. What are the tradeoffs of different approaches to injecting beans?

**Constructor Injection**
- Pros: Immutable, explicit dependencies, easy to test
- Cons: Verbose with many dependencies

**Field Injection**
- Pros: Simple
- Cons: Hard to test, hidden dependencies, no immutability

**Setter Injection**
- Pros: Allows optional dependencies
- Cons: Object can be partially initialized

Conclusion: Prefer constructor injection.


## 3. Why do we need to use @Qualifier when multiple beans of the same type are defined?
Spring resolves dependencies by type. If multiple beans of the same type exist, it cannot decide which one to inject, causing a `NoUniqueBeanDefinitionException`.

`@Qualifier` is used to specify the exact bean to use:
```java
@Autowired
@Qualifier("foo1")
private Foo foo;
````


## 4. How to avoid loading heavy beans on startup and decrease startup time?

By default, Spring uses eager initialization for singleton beans, meaning all beans are created at application startup. If some beans involve heavy operations (like caches, large data loads, or external connections), this can slow down startup significantly.

To avoid this, Spring provides lazy initialization.
```java
@Bean
@Lazy
public Cache cache() {
return new HeavyCache();
}
````
This ensures the bean is created only when it is first requested, not at startup.



## 5. What are Spring lifecycle stages and methods?

**Lifecycle Stages:**

1. Instantiation
2. Dependency Injection
3. Initialization
4. Ready for use
5. Destruction

**Initialization Methods:**

* `@PostConstruct`
* `InitializingBean.afterPropertiesSet()`
* Custom init method

**Destruction Methods:**

* `@PreDestroy`
* `DisposableBean.destroy()`
* Custom destroy method

