# String Version Operator

[![Release](https://jitpack.io/v/lionants02/VersionOperator.svg)](https://jitpack.io/#lionants02/VersionOperator) 

```$xslt
Normal
    VersionOperator("1.1") == VersionOperator("1.1.0-Main") is true

Kotlin style
    "1.1".VersionOp() == "1.1.0-Main".VersionOp() is true
    
```

Add JitPack repository in Gradle
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add dependency
```
dependencies {
    implementation "com.github.lionants02:VersionOperator:$latestVersion"
}
```

Use see in test
```
    \\ Example 1
    val a = "1.1".VersionOp()
    val b = "1.1.0.0".VersionOp()
    
    a == b is true
    a > b is false
    a < b is false
    a <= b is true
    a >= b is true

    \\ Example 2 don't care string.
    val a = "1.1TestDev".VersionOp()
    val b = "1.1MainDev".VersionOp()
    val c = "1.1.0.0Production".VersionOp()
    val d = "1.1".VersionOp()
    
    a == b == c == d is true

    \\ Example 3
    val a = "1.1TestDev".VersionOp()
    val b = "1.1.1".VersionOp()
    
        a == b is false
        a > b is false
        a < b is true
        a <= b is true
        a >= b is false
```
