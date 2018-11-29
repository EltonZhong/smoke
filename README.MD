# Smoke

A declarative validator framework for dtos and beans.

## Install

```bash
$ npm install koa-better-http-proxy --save
```

## Basic Usage
```java
class UserDto {
    @VString(shouldBe = {"John1", "John2"})
    @VNotNull
    String name = null;
}

// Will throw java.lang.IllegalStateException when field is null
com.ez.tools.validator.core.Validator.validate(new UserDto())
```

Go to package `com.ez.tools.validator.annotations` to find other features.

Add additional rule:
```java
com.ez.tools.validator.core.Validator.validate(new UserDto(), Rule...)
```
or:
```java
/**
* Add your rule class
**/
@VRule("com.ez.tools.validator.core.rules.****")
class UserDto {}

// Will validate using the rule specified in VRule value.
com.ez.tools.validator.core.Validator.validate(new UserDto())
```

Write Additional rules:

```java
class YourRule implements IRule { ... }
```
