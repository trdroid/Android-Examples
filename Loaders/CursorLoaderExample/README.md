# Implementation

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