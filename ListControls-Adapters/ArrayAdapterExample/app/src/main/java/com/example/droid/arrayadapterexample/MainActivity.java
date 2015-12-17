package com.example.droid.arrayadapterexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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
        for (int i = 0; i < makes.length; ++i) {
            list.add(makes[i]);
        }

        /*
            Create an adapter

            The responsibility of an adapter is to manage data and provide child views to the list control

            android.R.layout.simple_list_item_1 is a predefined layout for the child layout

            list is the data source
         */
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        String[] cars = new String[] {
                "NX", "Sonata", "Camry", "X8"
        };

        final ArrayList<String> carsList = new ArrayList<>();

        for (int i = 0; i < cars.length; ++i) {
            carsList.add(cars[i]);
        }

        /*
            Create an adapter

            The responsibility of an adapter is to manage data and provide child views to the list control

            R.layout.custom_list_row is a custom layout for the child layout

            list is the data source
         */

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                R.layout.custom_list_row, carsList);

        /*
            The list control calls getView() method of the adapter by passing in the index of the row that it wants to display
         */

        //listview.setAdapter(adapter1);
        listview.setAdapter(adapter2);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) listview.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }
        });
    }
}
