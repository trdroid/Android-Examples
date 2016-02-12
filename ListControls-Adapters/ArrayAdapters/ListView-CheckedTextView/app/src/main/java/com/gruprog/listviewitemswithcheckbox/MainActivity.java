package com.gruprog.listviewitemswithcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private ArrayAdapter<String> adapter1;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        // data source
        String[] makes = new String[] {
                "Lexus", "Hyundai", "Toyota", "BMW"
        };

        final ArrayList<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(makes));

        /*
            Create an adapter

            The responsibility of an adapter is to manage data and provide child views to the list control

            android.R.layout.simple_list_item_checked is a predefined layout for the child layout

            list is the data source
         */
        adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, list);

        listview.setAdapter(adapter1);

        /*
            Set the choice mode to CHOICE_MODE_MULTIPLE to enable selection of multiple items

            By default, the choice mode is CHOICE_MODE_NONE
            Another possible value is CHOICE_MODE_SINGLE
         */
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);

        //listview.setChoiceMode(listview.CHOICE_MODE_SINGLE);



        /*
               Using android.R.layout.simple_list_item_single_choice
               an apt choice for this would be to use listview.setChoiceMode(listview.CHOICE_MODE_SINGLE);
         */

        /*
            adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice, list);

            listview.setChoiceMode(listview.CHOICE_MODE_SINGLE);
         */




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
    }

    /*
    >=Android 1

        supports ListView:getCheckedItemPositions()

    >=Android 1.6 - \<Android 2.2

        supports ListView:getCheckItemIds()

    >=Android 2.2

        supports ListView:getCheckedItemIds()
     */
    public void onSubmitClicked(View view) {
        /*int numElements  = listview.getCount();

        //Get indices of selected items
        SparseBooleanArray selectedIndices = listview.getCheckedItemPositions();

        //Read items from the ListView based on indices of selected items
        for(int iter = 0; iter < numElements; iter++) {
            if(selectedIndices.get(iter)) {
                String carSelected = (String) listview.getItemAtPosition(iter);

                Log.v(TAG, carSelected + " at position " + iter + " is selected");
            }
        }*/

        //~~~~Question~~~~ hasStableIds always returns false?
        if(!adapter1.hasStableIds()) {
            Log.v(TAG, "Data is unstable");
            return;
        }

        /*
            returns an array of ids of the records from the adapter that were checked in the ListView.
            The ids can be directly used to take actions, bypassing ListView and cursor
         */
        long[] itemIds = listview.getCheckedItemIds();

        for(int iter = 0; iter < itemIds.length; iter++) {
            String carSelected = (String) listview.getItemAtPosition((int)itemIds[iter]);

            Log.v(TAG, carSelected + " at position " + iter + " is selected");
        }

    }
}
