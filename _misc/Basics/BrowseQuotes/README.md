# MVC Components

### Activity 

An activity is an instance of the Activity class offered by the Android SDK. It acts as a controller 
as it manages user interactions with the View.

### Layout

A layout file defines the view of an application. It is an XML file that defines a set of UI objects (buttons, images, text) and their layouts commonly referred to as Widgets. 

A Widget is an instance of the <b>View</b> class or one of its subclasses.

<img src="https://github.com/konceptsandcode/Android/blob/master/_misc/Basics/BrowseQuotes/_misc/ViewClassGeneralHierarchy.png">

Some examples of Widgets are ListView, TableLayout, LinearLayout, FrameLayout, RelativeLayout, TextView, Button etc.

The following layout file contains 5 widgets; 2 LinearLayouts, 2 Buttons and a TextView

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

Every widget has a corresponding XML element in the layout file where the name of the element is the widget type. Each widget could be configured with a set of XML attributes.

<img src="https://github.com/konceptsandcode/Android/blob/master/_misc/Basics/BrowseQuotes/_misc/layout_file.png">

### View Hierarchy

The widgets provided in the layout file exist in a hierarchy of View objects, referred to as the view hierarchy. 

<img src="https://github.com/konceptsandcode/Android/blob/master/_misc/Basics/BrowseQuotes/_misc/ViewHierarchy.png">

<img src="https://github.com/konceptsandcode/Android/blob/master/_misc/Basics/BrowseQuotes/_misc/layout_to_view_objects.png">

# Block Diagram

<img src="https://github.com/konceptsandcode/Android/blob/master/_misc/Basics/BrowseQuotes/_misc/MVC.png">

