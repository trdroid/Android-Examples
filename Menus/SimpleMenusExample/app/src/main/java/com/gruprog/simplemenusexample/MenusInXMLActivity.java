package com.gruprog.simplemenusexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenusInXMLActivity extends AppCompatActivity {

    private static final String TAG = "MenusInXMLActivity";
    private Menu menu = null;
    private boolean group2CheckableToggle;
    private boolean group2VisibilityToggle = true;
    private boolean group2EnabledToogle = true;
    private boolean group2IsRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_in_xml);
    }

    /*
        Every Activity in Android is associated with one menu object of type android.view.Menu.
        In an Activity's life cycle, Android calls a method onCreateOptionsMenu() on the Activity to populate its Menu object

        so, Android calls the onCreateOptionsMenu() method by passing it the Activity's Menu object, which is populated by loading an XML Menu resource into it.

        XML Menu Resource files reside in /res/menu/
        eg. /res/menu/custom_menu.xml

        Android automatically generates a resource ID for these resource files
        eg. R.menu.custom_menu

        A Menu could contain menu items and submenus.

        In Anrdoid, a Menu is represented by android.view.Menu class;
            a menu item is represented by android.view.MenuItem class;
            Submenus are represented by android.view.SubMenu class
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        /*
            Get the menu inflater from the Activity
         */
        MenuInflater menuInflater = getMenuInflater();

        /*
            Load the XML Menu Resource into the Menu object, menu
         */
        menuInflater.inflate(R.menu.custom_menu, menu);

        this.setMenuItemClickListeners(menu);

        /*
            Save a reference to the menu instance of this Activity so it could be used outside of this method,
                say to respond to button clicks
         */
        this.menu = menu;

        /*
            returning true makes the menu visible
            returning false makes the menu invisible
         */
        return true;
    }

    private void setMenuItemClickListeners(Menu menu) {
        MenuItemClickListener menuItemClickListener = new MenuItemClickListener("Clicked");

        MenuItem group2MenuItem1 = menu.findItem(R.id.group2_menu_item1);
        group2MenuItem1.setOnMenuItemClickListener(menuItemClickListener);

        MenuItem group2MenuItem2 = menu.findItem(R.id.group2_menu_item2);
        group2MenuItem2.setOnMenuItemClickListener(menuItemClickListener);

        MenuItem group2MenuItem3 = menu.findItem(R.id.group2_menu_item3);
        group2MenuItem3.setOnMenuItemClickListener(menuItemClickListener);

        Intent intent = new Intent(this, MenusInCodeActivity.class);
        group2MenuItem3.setIntent(intent);

        MenuItem group1MenuItem2 = menu.findItem(R.id.group2_menu_item3);
        group1MenuItem2.setIntent(intent);
    }

    /*
        Interaction with Menu items can be responded in

        1) onOptionsItemSelected() callback method.

            The callback method is passed the MenuItem that is interacted with.

            A MenuItem can be identified by the id that the Android generates based on the value of the
                MenuItem's android:id attribute specified in the XML Menu Resource file.

        2) Specifying an onClick handler defined in the Activity for the android:onClick attribute of a MenuItem in the Resource XML file
            An onClick Handler defined in this Activity should accept MenuItem as an argument
            The return type can either be void or boolean.
            In case of void, the response to a click on the MenuItem would just execute the handler and return.

            i.e. In case of void, onOptionsItemSelected() is ignored

            In case of a boolean, if true is returned then the handler is executed and the control returns;
                if false is returned, then onOptionsItemSelected() is called

            i.e. In case of a boolean, if true is returned then onOptionsItemSelected() is ignored;
                if false is returned, then onOptionsItemSelected() is also executed
        (or)

        2) Interaction with MenuItems could be also be handled by registering event handlers in the following way:
                Implement MenuItem.OnMenuItemClickListener interface (by providing implementation for onMenuItemClick() method) &
                Assign an instance of the class that implements MenuItem.OnMenuItemClickListener interface as a MenuItem click listener
                    using setOnMenuItemClickListener() method

                If onMenuItemClick() method returns true, then onOptionsItemSelected() is ignored
                If onMenuItemClick() method returns false, then onOptionsItemSelected() method is also executed

        If both are provided i.e. if both android:onClick and an instance of MenuItem.OnMenuItemClickListener is set on a MenuItem, then
            the onClick Handler specified with android:onClick is ignored.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "In onOptionsItemSelected() method");

        if(item.getGroupId() == R.id.menu_group1) {
            if(item.getItemId() == R.id.group1_menu_item1) {
                Toast.makeText(getApplicationContext(), "Group1 Item 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if(item.getItemId() == R.id.group1_menu_item2) {
                Toast.makeText(getApplicationContext(), "Group1 Item 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if(item.getItemId() == R.id.group1_menu_item4) {
                Intent intent = new Intent(this, MenusInCodeActivity.class);
                this.startActivity(intent);
            }
        }
        else if(item.getGroupId() == R.id.menu_group2) {
            if(item.getItemId() == R.id.group2_menu_item1) {
                Toast.makeText(getApplicationContext(), "Group2 Item 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if(item.getItemId() == R.id.group2_menu_item2) {
                Toast.makeText(getApplicationContext(), "Group2 Item 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

        /*
            Handle rest of the menu items
         */
        return super.onOptionsItemSelected(item);
    }

    /*
        MenuItem argument is mandatory for an onClick event handler of a MenuItem

        The return type void indicates that that a click event executes the handler and terminates
            without executing onOptionsItemSelected()

        So is the case with a boolean return type when the handler returns true
     */
    /*
        public void group1MenuItem3ClickHandler(MenuItem item) {
            Toast.makeText(getApplicationContext(), "Group1 Item 3 Clicked", Toast.LENGTH_SHORT).show();
        }

        public void group2MenuItem3ClickHandler(MenuItem item) {
            Toast.makeText(getApplicationContext(), "Group2 Item 3 Clicked", Toast.LENGTH_SHORT).show();
        }
     */

    public boolean group1MenuItem2ClickHandler(MenuItem item) {
        Log.d(TAG, "in group1MenuItem2ClickHandler(), " + item.getTitle() + " Clicked");
        Toast.makeText(getApplicationContext(), "Group1 Item 2 Clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    /*
        Returning true implies that the control is NOT transferred to onOptionsItemSelected() after executing this event handler
     */
    public boolean group1MenuItem3ClickHandler(MenuItem item) {
        Log.d(TAG, "in group1MenuItem3ClickHandler(), " + item.getTitle() + " Clicked");
        Toast.makeText(getApplicationContext(), "Group1 Item 3 Clicked", Toast.LENGTH_SHORT).show();
        return true;
    }

    public boolean group2MenuItem2ClickHandler(MenuItem item) {
        Log.d(TAG, "in group2MenuItem2ClickHandler(), " + item.getTitle() + " Clicked");
        Toast.makeText(getApplicationContext(), "Group2 Item 2 Clicked", Toast.LENGTH_SHORT).show();
        return true;
    }

    /*
        Returning false implies that the control IS transferred to onOptionsItemSelected() after executing this event handler
     */
    public boolean group2MenuItem3ClickHandler(MenuItem item) {
        Log.d(TAG, "in group2MenuItem3ClickHandler(), " + item.getTitle() + " Clicked");
        Toast.makeText(getApplicationContext(), "Group2 Item 3 Clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

     /*
        Button onClick Handlers
     */

    public void group2CheckableClickHandler(View view) {
        group2CheckableToggle = !group2CheckableToggle;

        menu.setGroupCheckable(R.id.menu_group2, group2CheckableToggle, false);
    }

    public void group2RadioButtonClickHandler(View view) {
        group2IsRadio = !group2IsRadio;

        menu.setGroupCheckable(R.id.menu_group2, true, group2IsRadio);
    }

    public void group2EnabledClickHandler(View view) {
        group2EnabledToogle = !group2EnabledToogle;

        menu.setGroupEnabled(R.id.menu_group2, group2EnabledToogle);
    }

    public void group2VisibleClickHandler(View view) {
        group2VisibilityToggle = !group2VisibilityToggle;

        menu.setGroupVisible(R.id.menu_group2, group2VisibilityToggle);
    }

    public void group2RemoveClickHandler(View view) {
        Log.d(TAG, "in group2RemoveClickHandler()");

        menu.removeGroup(R.id.menu_group2);
    }

    /*

     */
    private class MenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private String actionPerformed;

        public MenuItemClickListener(String actionPerformed) {
            this.actionPerformed = actionPerformed;
        }

        /*
            Returning false => onOptionsItemSelected() method would be called after
         */
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Log.d(TAG, "in onMenuItemClick(), " + item.getTitle() + " " + actionPerformed);
            return false;
        }
    }
}