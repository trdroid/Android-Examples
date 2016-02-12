package com.gruprog.gridview_textview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        // data source
        String[] makes = new String[] {
                "Lexus", "Hyundai", "Toyota", "BMW", "VW", "Kia", "Ford", "Tesla"
        };

        final ArrayList<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(makes));

        /*
            Create an adapter

            The responsibility of an adapter is to manage data and provide child views to the list control

            android.R.layout.simple_list_item_checked is a predefined layout for the child layout

            list is the data source
         */
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        gridView.setAdapter(adapter);
    }
}
