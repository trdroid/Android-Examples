# Activity

An Activity is a class offered by the Android SDK. 
Every Activity instance has a lifecycle implemented as a set of methods in the Activity class. 

A custom Activity class can override the lifecycle methods as needed to perform actions based 
on the state of the Activity.

The lifecycle methods are called by Android and should not be called explicitly. 

```java
  class MyActivity extends Activity {
    @Override
    //lifecycle methodA() {}
    
    @Override
    //lifecycle methodB() {}
    
    @Override
    //lifecycle methodC() {}
    
    //..
  }
```
