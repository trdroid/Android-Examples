# Implementation

### Define the Layout

Declare a **ListView** where the list of contacts would be displayed. The ListView should be declared to have a special Id **@android:id/list** as is required by the ListActivity class. 

Also, declare a TextView with id **@android:id/empty** that the ListView uses when it is empty i.e. in this case when there are no contacts to display.

Declare a ProgressBar that would be used to indicate that the data is still being loaded. This is required due to the asynchronous nature of the data loaders in loading data. 
While the data is being loaded asynchronously, a ProgressBar is displayed to the user while hiding the ListView, until the data is loaded and ready to be displayed. 

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <!-- ListView uses a standard id as needed by a list view -->
    <ListView android:id="@android:id/list"  -----------------
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawSelectorOnTop="false"/>


    <!-- Empty List: The id used is a standard id required by ListView -->
    <TextView android:id="@android:id/empty"  -----------------
        android:text="No Contacts Available!"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:visibility="gone"/>

    <ProgressBar   -----------------
        android:id="@+id/progress_bar"  
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:indeterminate="true"/>
</LinearLayout>
```

### Initialize the Loader

```java

```

### Snapshots and Log Messages

**On Launch**

![](_misc/Displaying%20Contacts.png)

```
03-08 11:26:25.832 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreate()
03-08 11:26:25.832 20058-20058/com.gruprog.simplecursorloader D/MainActivity: SDK < 23
03-08 11:26:25.873 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreateLoader() for id:1
03-08 11:26:26.005 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@387b8d67, Count:5
```

**After adding a contact**

![](_misc/New%20Contact%20Displayed.png)

Click home, browse to the Phone app and add a new contact. Then go back to the home screen and hit the recent Activities button and select this app, which prints the following to the log.
This implies that adding a new contact triggerred the CursorLoader to requery the data source and pass in the new cursor to the LoaderManager. 
The LoaderManager then made a call to onLoadFinished() callback and passed in the cursor. In the onLoadFinished() callback, the old cursor is swapped out with the new one, thereby the ListView displaying 
the updated data source.

```
03-08 11:31:55.655 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@3da74080, Count:6
```

**Change Orientation**

![](_misc/display%20in%20landscape%20mode.png)

Changing Orientation is one of the configuration changes that causes an Activity to be reconstructed, which calls the Activiti's onCreate() method. The following log is printed. 
Notice, that the LoaderManager did not issue a call to onCreateLoader() method.

```
03-08 11:42:47.567 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreate()
03-08 11:42:47.567 20058-20058/com.gruprog.simplecursorloader D/MainActivity: SDK < 23
03-08 11:42:47.570 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@3da74080, Count:6
```

**Hitting back button**

Hitting back button destroys the Activity which prints the following to the log. Just before the Activity was destroyed, the LoaderManager invoked onLoaderReset() callback.

```
03-08 11:46:00.426 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoaderReset() for id: 1
```

**Relaunch app after deleting all contacts**

![](_misc/No%20Contacts%20Available.png)

```
03-08 11:56:38.513 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreate()
03-08 11:56:38.513 20058-20058/com.gruprog.simplecursorloader D/MainActivity: SDK < 23
03-08 11:56:38.594 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreateLoader() for id:1
03-08 11:56:38.826 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@287d3fe6, Count:0
```