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

Register an id for a Loader that would be created in the future, when the LoaderManager calls onCreateLoader() callback. 
Also pass in args bundle that would be passed to the Loader when it is created and a reference to an object that implements the callbacks of the LoaderManager that conveys data loading events. 

```java
    /*
        Return a SimpleCursorAdapter with a null cursor
        Once the CursorLoader is used to load data into a cursor, the null cursor can be swapped with the populated one
     */
    private SimpleCursorAdapter getSimpleCursorAdapter() {
        Cursor cursor = null;

        /*
            Map columns with views; the data from the columns go into those views
         */
        String[] fromColumns = {
                ContactsContract.Data.DISPLAY_NAME
        };

        int[] toViews = {
                //The TextView in simple_list_item_1
                android.R.id.text1
        };

        return new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                fromColumns,
                toViews);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        if(Build.VERSION.SDK_INT < 23) {
            Log.d(TAG, "SDK < 23");

            setContentView(R.layout.activity_main);
            this.mSimpleCursorAdapter = getSimpleCursorAdapter();
            this.setListAdapter(mSimpleCursorAdapter);

            //start by displaying the ProgressBar
            showProgressBar(true);

            this.initializeLoader();
        }
        else {
            //For API >= 23, request permissions at runtime to be able to read CONTACTS
            Log.d(TAG, "SDK >= 23; Yet to be handled");

            /*
                String[] permissions = {"android.permission.READ_CONTACTS"};
                this.requestPermissions(permissions, 0);
             */
        }
    }


    private void initializeLoader() {
        Bundle args = null;
        /*
            Indicate that this Activity would implement necessary callbacks that would be invoked by the LoaderManager when events related to data loading occur
         */
        LoaderManager.LoaderCallbacks<Cursor> callback = this;

        /*
            The ID is an important attribute that the LoaderManager would cache and use to uniquely identify a Loader.
            It is based on this Id that a LoaderManager determines whether a new Loader has to be created or an existing one has to be used.

            Initialize and Register a Loader using the LoaderManager() instance inherent to an Activity

            NOTE: The loader DOES NOT EXIST yet.
            You are just registering an id for the Loader that would be created later, the arguments that should be passed to it when it is created,
                and the component that is interested in getting notified of various events generated by the LoaderManager based on data loading performed by the loader

            After this step, the LoaderManager schedules a call to onCreateLoader() to get the Loader from the component that implemented the callbacks,
                which is this Activity in this case.

            Once the LoaderManager gets the Loader, it associates it with the id that was registered earlier.

            If a Loader for this id was already available, then the LoaderManager DOES NOT schedule a call to onCreateLoader() method.
            i.e. When an Activity is recreated due to any configuration change, the onCreate() method of the Activity is re-invoked,
                      and the initLoader() method is re-invoked as well, but this time the LoaderManager would use the Loader against the Id, LOADER_ID that it cached earlier
                      , instead of scheduling a call to onCreateLoader() method with id LOADER_ID for a second time.

            If it is surely known that the data source associated with a loader has changed, then the method LoaderManager.restartLoader() can be called.

            When the method LoaderManager.restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) is invoked,
                the LoaderManager schedules a call to onLoaderCreate() method to get a hold of the new Loader. Once the LoaderManager receives the new Loader,
                it destroys the old Loader associated with the id, and caches the new Loader against the id.
         */
        this.getLoaderManager().initLoader(LOADER_ID, args, callback);   <-----------------------
    }

```

We have decided to implement the LoaderManager callbacks within the Activity as implied by the following line in our custom initializeLoader() method.

```java
LoaderManager.LoaderCallbacks<Cursor> callback = this;
```

Therefore, add the implements to MyActivity definition, as shown below

```java
public class MainActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {  <------------------------
```

### Implement the Interface methods (callbacks)

```java
    /*
        Implementing LoaderManager callbacks.

        All callbacks run on the main thread
     */

    /*
        The LoaderManager schedules a call to this method and with the arguments: id and args bundle passed to it in the call
            this.getLoaderManager().initLoader(LOADER_ID, args, callback);

        Therefore, the onCreateLoader() method receives two arguments: id and the args bundle and returns a Loader to the LoaderManager

        The inference here is, the component that registers with the LoaderManager's events by implementing the callbacks is responsible for creating
            and returning a loader to the LoaderManager from its onCreateLoader() method's implementation.

        Once a CursorLoader is returned to the LoaderManager, it caches the Loader and asks it to start loading data on a worker thread.

        Once the data loading is finished, the LoaderManager invokes the callback method, onLoadFinished()
     */
    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        Log.d(TAG, "onCreateLoader() for id:" + id);

        /*
            Use the content URIs provided by the Contacts content provider.
         */
        Uri baseUri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = new String[] {
                ContactsContract.Data._ID,
                ContactsContract.Data.DISPLAY_NAME
        };

        String selection = "((" + ContactsContract.Data.DISPLAY_NAME + " NOTNULL ) AND (" +
                ContactsContract.Data.DISPLAY_NAME + " != ''))";

        String[] selectionArgs = null;
        String sortOrder = null;

        /*
            CursorLoader(
                Context context,
                Uri uri,
                String[] projection,
                String selection,
                String[] selectionArgs,
                String sortOrder)

            It could be noticed that the CursorLoader requires arguments similar to that of a database query method.
            The arguments provide details to identify the data source and to perform queries against the data source.

            The CursorLoader uses the URI to identify a database and a table within it to perform the queries against.
         */
        return new CursorLoader(this, baseUri, projection, selection, selectionArgs, sortOrder);
    }

    /*
        This callback is called
            when the loader finishes loading the data.
            anytime the data underneath changes, which implies that this callback can be called multiple times
            after a rotation, without having to re-query the cursor

        Once the onCreateLoader() method returns a CursorLoader to the LoaderManager, it caches the Loader and asks it to start loading data on a worker thread.

        Once the data loading is finished, the LoaderManager invokes the callback method, onLoadFinished() with the populated cursor.

        In the method, the null cursor that was initially assigned to the SimpleCursorAdapter is swapped out with the populated one.

        As the CursorLoader registers itself with the data source, it will be notified whenever the data source changes, which results in the LoaderManager invoking this callback method.
        Therefore, any time the underlying data source changes, the Loader gets notified which results in the LoaderManager invoking this callback with the cursor pointing to the updated
            data source.

        Whenever the underlying data source changes, the old cursor is swapped out with the new cursor, which displays up-to-date information in the ListView.

        When the device configuration changes, the Activity is recreated, which results in the calling of the onCreate() method, which ends up reinitializing the loader. The LoaderManager
            silently ignores this request (and does not schedule a call to onCreateLoader() method) as there is a loader already associated with the id, however it calls the onLoadFinished() callback.
            As the LoaderManager does not call onCreateLoader(), RE-QUERYING THE DATA SOURCE IS AVOIDED.

        So a configuration change DOES NOT RE-QUERY THE DATA SOURCE but just ends up calling onLoadFinished()
     */
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        Log.d(TAG, "onLoadFinished() for id: " + loader.getId() + ", Cursor:" + cursor + ", Count:" + (cursor == null ? 0 : cursor.getCount()));
        showProgressBar(false);
        this.mSimpleCursorAdapter.swapCursor(cursor);
    }

    /*
        This callback is called
            when the loader is about to be destroyed, say when the Activity is about to be taken down (for eg. when hitting the back button or by calling finish() in the code)
            or by calling LoaderManager.destroyLoader(loaderId) explicitly

        This callback is NOT called
            because of loader restart i.e. the call, LoaderManager.restartLoader(), makes the LoaderManager schedule a call to onCreateLoader() to get a new Loader.
            Once it gets the new loader, it destroys the old loader. Destroying the old loader DOES NOT INVOKE the onLoaderReset() callback

        Any resources can be closed with the exception of cursors. Cursors SHOULD NOT be closed as they are managed by the loaders and are closed by the framework.
     */
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.d(TAG, "onLoaderReset() for id: " + loader.getId());
        showProgressBar(true);
        this.mSimpleCursorAdapter.swapCursor(null);
    }
```

### Add permission to read Contacts in AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.gruprog.simplecursorloader" >

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme" >
        <activity android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
    <uses-permission android:name="android.permission.READ_CONTACTS"/>    ------------------------
</manifest>
```



### Snapshots and Log Messages

**On Launch**

Notice the cursor instance is *android.content.ContentResolver$CursorWrapperInner@387b8d67*

```
03-08 11:26:25.832 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreate()
03-08 11:26:25.832 20058-20058/com.gruprog.simplecursorloader D/MainActivity: SDK < 23
03-08 11:26:25.873 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreateLoader() for id:1
03-08 11:26:26.005 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@387b8d67, Count:5
```
![](_misc/Displaying%20Contacts.png)

**After adding a contact**

Click home, browse to the Phone app and add a new contact. Then go back to the home screen and hit the recent Activities button and select this app, which prints the following to the log.
This implies that adding a new contact triggerred the CursorLoader to requery the data source and pass in the new cursor to the LoaderManager. 
The LoaderManager then made a call to onLoadFinished() callback and passed in the cursor. In the onLoadFinished() callback, the old cursor is swapped out with the new one, thereby the ListView displaying 
the updated data source.

Notice the cursor instance is *android.content.ContentResolver$CursorWrapperInner@3da74080*, which is different from above, implying that a change in the data source has caused the CursorLoader to requery it,
resulting in a new cursor instance that the LoaderManager passes to the callback.

```
03-08 11:31:55.655 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@3da74080, Count:6
```

![](_misc/New%20Contact%20Displayed.png)

**Change Orientation**

Changing Orientation is one of the configuration changes that causes an Activity to be reconstructed, which calls the Activiti's onCreate() method. The following log is printed. 
Notice, that the LoaderManager did not issue a call to onCreateLoader() method.

Notice that the cursor instance is *android.content.ContentResolver$CursorWrapperInner@3da74080*, which is same as above, implying that a configuration change DOES NOT cause the CursorLoader to requery 
the data source and generate a new cursor.

```
03-08 11:42:47.567 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreate()
03-08 11:42:47.567 20058-20058/com.gruprog.simplecursorloader D/MainActivity: SDK < 23
03-08 11:42:47.570 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@3da74080, Count:6
```

![](_misc/display%20in%20landscape%20mode.png)

**Hitting back button**

Hitting back button destroys the Activity which prints the following to the log. Just before the Activity was destroyed, the LoaderManager invoked onLoaderReset() callback.

```
03-08 11:46:00.426 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoaderReset() for id: 1
```

**Relaunch app after deleting all contacts**

```
03-08 11:56:38.513 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreate()
03-08 11:56:38.513 20058-20058/com.gruprog.simplecursorloader D/MainActivity: SDK < 23
03-08 11:56:38.594 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onCreateLoader() for id:1
03-08 11:56:38.826 20058-20058/com.gruprog.simplecursorloader D/MainActivity: onLoadFinished() for id: 1, Cursor:android.content.ContentResolver$CursorWrapperInner@287d3fe6, Count:0
```

![](_misc/No%20Contacts%20Available.png)


### Block Diagram

![](_misc/High%20Level%20Block%20Diagram.png)

