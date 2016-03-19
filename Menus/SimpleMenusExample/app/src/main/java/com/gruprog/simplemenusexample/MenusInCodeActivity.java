package com.gruprog.simplemenusexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class MenusInCodeActivity extends AppCompatActivity {

    private Menu menu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_in_code);
    }

    /*
        In Android SDK < 3.0, onCreateOptionsMenu() method is called the first time an Activity's options menu is accessed

        Starting with Android SDK >= 3.0, onCreateOptionsMenu() method is called ONLY ONCE while creating the Activity.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
            Call the base class method to allow the system to populate the menu with system menu items, if any were defined
         */
        super.onCreateOptionsMenu(menu);

        /*
            Add MenuItems to the Menu of this Activity
         */
        int group = 1;
        int itemId = 1;
        int order = 0;
        String title = "Item 1";

        /*
            Arguments to create a MenuItem are self-explanatory.

            The last argument is the title of the MenuItem, which could a String or a Resource Id of a String
         */
        menu.add(group,
                itemId,
                order,
                title);

        itemId = 2;
        order = 1;
        title = "Item 2";

        menu.add(group,
                itemId,
                order,
                title);

        title = "Item 3";

        /*
            Group, Item Id, and Order arguments are optional; They could be provided with Menu.NONE

            Menu.NONE for group => item is outside of any group
            Menu.NONE for item => might be a submenu or a separator
            Menu.NONE for order => Android chooses some mechanism to order item
         */
        menu.add(Menu.NONE,
                Menu.NONE,
                Menu.NONE,
                title);

        /*
            Specifying just the item with no group, item Id and order
         */
        title = "Item 4";

        menu.add(title);

        /*
            Using a string resource to set the title of a menu item and adding it to the Menu
         */

        menu.add(Menu.NONE,
                Menu.NONE,
                Menu.NONE,
                R.string.item5);

        menu.add(R.string.item6);

        group = 2;
        title = "Group2 Item 1";

        menu.add(group,
                Menu.NONE,
                Menu.NONE,
                title);

        menu.add(group,
                Menu.NONE,
                Menu.NONE,
                R.string.item2);

        /*
            android.view.Menu has a set of methods that act on a group based on the group Id provided.

            These methods are
                setGroupCheckable()
                setGroupEnabled()
                setGroupVisible()
                removeGroup()
         */
        menu.setGroupCheckable(group, true, false);

        /*
            Save a reference to the menu instance of this Activity so it could be used outside of this method,
                say to respond to button clicks
         */
        this.menu = menu;

        /*
            Return true to make the Menu visible
         */
        return true;
    }

    /*
        To add Menus dynamically, use the method onPrepareOptionsMenu()
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


}
