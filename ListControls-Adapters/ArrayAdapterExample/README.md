### ArrayAdapter

http://developer.android.com/reference/android/widget/ArrayAdapter.html

Define a data source

```java
        // data source
        String[] makes = new String[] {
                "Lexus", "Hyundai", "Toyota", "BMW"
        };
```

Create an adapter

```java
        /*
            Create an adapter

            The responsibility of an adapter is to manage data and provide child views to the list control

            android.R.layout.simple_list_item_1 is a predefined layout for the child layout

            list is the data source
         */
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

```

The resource ID for the Child Layout is <i>android.R.layout.simple_list_item_1</i>, which is one of the predefined layouts 
in Android (it could be said from the prefix "android"). 

Instead of finding the resource files from local res/ directory, the predefined layouts are searched for in Android's 
res/ directory.

<img src="_misc/Android%20predefined%20layouts.png"/>





