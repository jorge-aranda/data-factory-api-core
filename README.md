# DATA FACTORY API
Makes your Java Collections using a DSL language provided by this library on an easy way

For example:
```
    List<String> helloWorld = DataFactory
        .item("Hello")
        .item(" ")
        .item("World")
        .item("!")
    .toList();  // you can use .toCollection() or what else instead of
    
    // shows 'Hello World!' into standard output
    System.out.println(
        StringUtils.join(helloWorld, StringUtils.EMPTY)
    );
```

** Java Compatibility version: ** You can use this library from JRE 6. But you required JDK 8 to compile library