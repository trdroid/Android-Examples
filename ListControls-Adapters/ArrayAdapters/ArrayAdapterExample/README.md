## Steps to follow

### Define a data source

```java
        // data source
        String[] makes = new String[] {
                "Lexus", "Hyundai", "Toyota", "BMW"
        };
        
        final ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(makes));
```

### Create an adapter

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

<i>sdk/platforms/\<platform-version\>/res/layout/simple_list_item_1.xml</i>

```xml
<?xml version="1.0" encoding="utf-8"?>

<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@android:id/text1"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textAppearance="?android:attr/textAppearanceListItemSmall"
    android:gravity="center_vertical"
    android:paddingStart="?android:attr/listPreferredItemPaddingStart"
    android:paddingEnd="?android:attr/listPreferredItemPaddingEnd"
    android:minHeight="?android:attr/listPreferredItemHeightSmall" />

```

The Adapter maps each data element from the data source to each instantiation of the child view. In this case, each data element is set to the TextView (android.R.id.text1) of the ChildView.

### Get a reference to ListView

The Main Activity Layout's file res/layout/activity_main.xml is:

```xml
<ListView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/listview"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content" />
```

Notice, ListView is the root element (not LinearLayout). Also, adding xmlns:android="http://schemas.android.com/apk/res/android" to the root element is a MUST.

Get a reference to ListView

```java
final ListView listview = (ListView) findViewById(R.id.listview);
```

### Set the adapter

```java
/*
The list control calls getView() method of the adapter by passing in the index of the row that it wants to display
*/

listview.setAdapter(adapter1);
```

### Block Diagram

<img src="_misc/ArrayAdapter.png"/>


### Set Event Handler

```java
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /*
                view: the view that received the click
                position: the position of item clicked in the ListView
                id: id of the data which depends on the adapter and the data source
                    In this case of using an array of strings, it would just be the index of the data element in the array
                    In case of a SimpleCursorAdapter that has read its values from the system's Contacts database, the id would
                        be the _ID of the record
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) listview.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }
        });
```



<hr>

### Using a custom layout with ArrayAdapter

Define a custom layout (res/layout/custom_list_row.xml)

```xml
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/rowText"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:textSize="20sp">
</TextView>
```
Notice that the root element is a TextView.

### Create an adapter

```java
        /*
            Create an adapter

            The responsibility of an adapter is to manage data and provide child views to the list control

            R.layout.custom_list_row is a custom layout for the child layout

            list is the data source
         */

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                R.layout.custom_list_row, carsList);
```

### Set the adapter

```java
/*
The list control calls getView() method of the adapter by passing in the index of the row that it wants to display
*/

listview.setAdapter(adapter1);
```
