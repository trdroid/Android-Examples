# MVC Components

### Activity 

An activity is an instance of the Activity class offered by the Android SDK. It acts as a controller 
as it manages user interactions with the View.

### Layout

A layout file defines the view of an application. It is an XML file that defines a set of UI objects (buttons, images, text) and their layouts. The building blocks of the UI are referred to as Widgets. 

A Widget is an instance of the <b>View<b> class or one of its subclasses.

The following layout contains 5 widgets; 2 LinearLayouts, 2 Buttons and a TextView

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="@string/quote1" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/previous_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/previous" />

        <Button
            android:id="@+id/next_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/next" />
    </LinearLayout>
</LinearLayout>
```

As of ADT 21, the following line is not required in the layout files

```xml
<?xml version="1.0" encoding="utf-8"?> 
```

# Block Diagram

<img src="https://github.com/konceptsandcode/Android/blob/master/_misc/Basics/BrowseQuotes/_misc/MVC.png">

