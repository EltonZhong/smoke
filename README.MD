# Smoke [![Build Status](https://travis-ci.org/EltonZhong/smoke.svg?branch=master)](https://travis-ci.org/EltonZhong/smoke)
A declarative validator framework for dtos and beans.

## Install [ ![Download](https://api.bintray.com/packages/ez/tools/smoke/images/download.svg) ](https://bintray.com/ez/tools/smoke/_latestVersion)
Get the latest version at [Jcenter](https://bintray.com/ez/tools/smoke/_latestVersion)
```grovvy
// For gradle
repositories {
    jcenter()
}

dependencies {
    compile 'com.ez.tools:smoke:3.0.2'
}
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
