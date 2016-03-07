package com.gruprog.simplecursorloader;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = "MainActivity";

    /*
        Adapter to provide child views configured with data to the Parent ListView of this ListActivity.
     */
    private SimpleCursorAdapter mSimpleCursorAdapter;

    private static final String[] PROJECTION = new String[] {
            ContactsContract.Data._ID,
            ContactsContract.Data.DISPLAY_NAME
    };

    private static final String SELECTION = "((" + ContactsContract.Data.DISPLAY_NAME + " NOTNULL ) AND (" +
            ContactsContract.Data.DISPLAY_NAME + " != ''))";

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

    private void initializeLoader() {
        Bundle args = null;
        LoaderManager.LoaderCallbacks<Cursor> callback = this;

        this.getLoaderManager().initLoader(0, args, callback);
    }

    private void handleUIOnDataLoadingStatus(boolean isDataLoading) {
        /*
            if the data is being loaded,

                display the progress bar,
                hide the ListViews

            else
                hide the progress bar,
                display the ListView
         */
        if(isDataLoading) {
            View progressBar = this.getProgressBar();

            progressBar.setVisibility(View.VISIBLE);

            this.getListView().setVisibility(View.GONE);
            this.getEmptyListView().setVisibility(View.GONE);
        } else {
            View progressBar = this.getProgressBar();

            progressBar.setVisibility(View.GONE);

            this.getListView().setVisibility(View.VISIBLE);
        }

    }

    private View getProgressBar() {
        return findViewById(R.id.progress_bar);
    }

    private View getEmptyListView() {
        return findViewById(android.R.id.empty);
    }

    /*
        Implementing LoaderManager callbacks.

        All callbacks run on the main thread
     */

    /*
        Create and return a loader
     */
    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        Uri baseUri = ContactsContract.Contacts.CONTENT_URI;
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
        return new CursorLoader(this, baseUri, PROJECTION, SELECTION, selectionArgs, sortOrder);
    }

    /*
        This callback is called
            when the loader finishes loading the data.
            anytime the data underneath changes.
            after a rotation, without having to re-query the cursor
     */
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        handleUIOnDataLoadingStatus(false);
        this.mSimpleCursorAdapter.swapCursor(cursor);
    }

    /*
        This callback is called
            when the loader is about to be destroyed, say when the Activity is about to be taken down

        This callback is NOT called
            because of loader restart
     */
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        handleUIOnDataLoadingStatus(true);
        this.mSimpleCursorAdapter.swapCursor(null);
    }
}
