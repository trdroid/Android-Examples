# Steps to use Data Binding

## Changes to the layout file

1. Enclose the layout file in <layout></layout> tags

2. Create a Data element and declare a variable to bind the data against 
```xml
    <data>
        <variable
            name="studentModel"
            type="com.konceptsandcode.basicdatabinding.StudentModel" />
    </data>
```

3. Use a property from the data class

```xml
  <TextView
      android:layout_width="fill_parent"
      android:layout_height="wrap_content"
      android:text="@{studentModel.firstName}" />
```

The Binding Library attempts to find the first public member in the following order:

```java
public String getFirstName();

public String firstName();

public String firstName;
```

If none of the above matches, a data binding error occurs on compilation indicating that it cannot find an accessor

## Changes to the main Activity

1) Inflate the layout
```java
        /*
            Inflate the layout using DataBindingUtil class to create a binding class instance. 
            
            The binding class ActivityMainBinding is generated and its name is inferred from the layout file name 
            (activity_main, in this case)

            As the layout file name is called "activity_main", the binding class generated is called ActivityMainBinding

            DataBindingUtil.setContentView() returns the ViewDataBinding base class,
            but the generated class name should be used here
         */
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
```


2) Get the data (in this case, lets just initiaialize a model)

```java
        StudentModel studentModel = new StudentModel("Keith", "Koncepts", 12);
```

3) Binding the data to the view

```java
        binding.setStudentModel(studentModel);
```
