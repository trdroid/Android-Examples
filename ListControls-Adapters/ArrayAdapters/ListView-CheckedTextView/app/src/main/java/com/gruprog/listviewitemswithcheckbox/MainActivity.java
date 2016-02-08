package com.gruprog.listviewitemswithcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.listview);

        // data source
        String[] makes = new String[] {
                "Lexus", "Hyundai", "Toyota", "BMW"
        };

        final ArrayList<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(makes));

        /*
            Create an adapter

            The responsibility of an adapter is to manage data and provide child views to the list control

            android.R.layout.simple_list_item_1 is a predefined layout for the child layout

            list is the data source
         */
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, list);

    }

    public void onSubmitClick(View view) {

    }
}
