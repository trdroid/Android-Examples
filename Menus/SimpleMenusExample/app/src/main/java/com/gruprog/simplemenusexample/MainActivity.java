package com.gruprog.simplemenusexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        Every Activity in Android is associated with one menu object of type android.view.Menu.
        In an Activity's life cycle, Android calls a method onCreateOptionsMenu() on the Activity to populate its Menu object

        so, within the onCreateOptionsMenu() method, the Menu object is populated by loading an XML Menu resource into it.

        XML Menu Resource files reside in /res/menu/
        eg. /res/menu/custom_menu.xml

        Android automatically generates a resource ID for these resource files
        eg. R.menu.custom_menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        /*
            Get the menu inflater from the Activity
         */
        MenuInflater menuInflater = getMenuInflater();

        /*
            Load the XML Menu Resource to the Menu object, menu
         */
        menuInflater.inflate(R.menu.custom_menu, menu);

        /*
            returning true makes the menu visible
            returning false makes the menu invisible
         */
        return true;
    }

    /*
        Interaction with Menu items can be responded in onOptionsItemSelected() callback method.

        The callback method is passed the MenuItem that is interacted with.

        A MenuItem can be identified by the id that the Android generates based on the value of the
            MenuItem's android:id attribute specified in the XML Menu Resource file.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_item1) {
            Toast.makeText(getApplicationContext(), "Item 1 Clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if(item.getItemId() == R.id.menu_item2) {
            Toast.makeText(getApplicationContext(), "Item 2 Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        /*
            Handle rest of the menu items
         */
        return super.onOptionsItemSelected(item);
    }

    public void menuItem3ClickHandler(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Item 3 Clicked", Toast.LENGTH_SHORT).show();
    }
}
