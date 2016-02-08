### ArrayAdapter

http://developer.android.com/reference/android/widget/ArrayAdapter.html

Define a data source

```java
        // data source
        String[] makes = new String[] {
                "Lexus", "Hyundai", "Toyota", "BMW"
        };
        
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < makes.length; ++i) {
            list.add(makes[i]);
        }
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


<b>Get a reference to ListView from the Main Activity's layout file</b>

The Main Activity Layout's file res/layout/activity_main.xml is:

```xml
<ListView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/listview"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content" />
```

Get a reference to ListView

```java
final ListView listview = (ListView) findViewById(R.id.listview);
```

<b>Set the adapter</b>

```java
listview.setAdapter(adapter1);
```

<img src="_misc/ArrayAdapter.png"/>

