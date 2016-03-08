# Implementation

### Define the Layout

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
    <ListView android:id="@android:id/list"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawSelectorOnTop="false"/>


    <!-- Empty List: The id used is a standard id required by ListView -->
    <TextView android:id="@android:id/empty"
        android:text="No Contacts Available!"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:visibility="gone"/>

    <ProgressBar
        android:id="@+id/progress_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:indeterminate="true"/>
</LinearLayout>
```

### Initialize the Loader

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT < 23) {
            Log.d(TAG, "SDK < 23");

            setContentView(R.layout.activity_main);
            this.mSimpleCursorAdapter = getSimpleCursorAdapter();
            this.setListAdapter(mSimpleCursorAdapter);

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
        LoaderManager.LoaderCallbacks<Cursor> callback = this;

        this.getLoaderManager().initLoader(LOADER_ID, args, callback);
    }

```