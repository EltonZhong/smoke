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
    compile 'com.ez.tools:smoke:5.0.0'
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
com.ez.tools.validator.Smoke.validate(new UserDto())
```

Go to package `com.ez.tools.validator.annotations` to find other features.

Add additional rule:
```java
com.ez.tools.validator.Smoke.validate(new UserDto(), IRule...rules)
```
or:
```java
/**
* Add your rule class
**/
@VRule(com.ez.tools.validator.core.rules.AllFieldsShouldNotBeNull.class)
class UserDto {}

// Will validate using the rule specified in VRule value.
com.ez.tools.validator.Smoke.validate(new UserDto())
```

Also you can write Additional rules:

```java
class YourRule implements IRule {
    @Override
    public void validate(Object o) {
        if (!o instanceof UserDto) {
            throw new IllegalArgumentException();
        }
        UserDto dto = (UserDto) o;
        if(dto.name == "elton" && dto.age > 100) {
            throw new Exception("Elton is dead after at 99 years old.")
        }
    }
}

// Use it in your common interface:
@VRule(YourRule.class)
interface SatisfyYourRule {}

// Implements the interface:
class YourDto implements SatisfyYourRule {}

// When validate your dto, the rule will be invoked. And as rule above, Exception("Elton is dead after at 99 years old.") will be thrown
Smoke.validate(new UserDto("elton", 100))
```

## Advance features
### VRecursive
Wanna validate details of a field with smoke? Try VRecursive:
```java
class UserDto {
    @VRecursive
    AddressDto address = new AddressDto(this);
}

class AddressDto {
    public AddressDto(UserDto dto) {
        user = dto;
    }

    @VNotNull
    String a = null;

    @VRecursive
    UserDto user = null;
}

// Will validate userDto's address.
// And don't worry that it might cause stackoverflow exception:
// smoke will not validate same object twice.
com.ez.tools.validator.Smoke.validate(new UserDto())
```

***`Remeber! When field is null, smoke will ignore this field's validation.`***

***`You can use VNotNull to handle this situation`***
```java
class UserDto {
    @VString(shouldMatch = "^elton.+")
    String name = null;
}

// Will not validate when name is null. If you want to, add @VNotNull annotation
com.ez.tools.validator.Smoke.validate(new UserDto())
```

### VString
The regex feature has been released! Use regex:
```java
class UserDto {

    @VString(shouldMatch = {Regexps.EMAIL})
    String email;

    // Custom regex: Name should match all values in should match
    // And name should not match any values in should not match
    @VString(shouldMatch = {".+", "..."})
    @VString(shouldNotMatch = {"..."})
    String name;
}
```