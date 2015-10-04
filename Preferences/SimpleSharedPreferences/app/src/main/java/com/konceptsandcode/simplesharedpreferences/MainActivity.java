package com.konceptsandcode.simplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static final String MY_PREFERENCES_1 = "preference_file1";
    private static final String MY_PREFERENCES_2 = "preference_file2";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            MODE_PRIVATE:
            MODE_WORLD_READABLE:
            MODE_WORLD_WRITEABLE:
            MODE_MULTI_PROCESS:
         */

        SharedPreferences sharedPreferences1 = getSharedPreferences(MY_PREFERENCES_1, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor1 = sharedPreferences1.edit();

        editor1.putBoolean("hasSignedUp", true);

        editor1.commit();


        SharedPreferences sharedPreferences2 = getSharedPreferences(MY_PREFERENCES_2, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor2 = sharedPreferences2.edit();

        editor2.putString("name", "Keith");

        editor2.commit();

        Toast.makeText(getBaseContext(),
                Boolean.toString(sharedPreferences1.getBoolean("hasSignedUp", false)),
                Toast.LENGTH_LONG).show();

        Toast.makeText(getBaseContext(),
                sharedPreferences2.getString("name", ""),
                Toast.LENGTH_LONG).show();
    }
}

/*
    Preferences are saved in:

    File:
    data/data/com.konceptsandcode.simplesharedpreferences/shared_prefs/preference_file1.xml

    Data:
    <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
    <map>
        <boolean name="hasSignedUp" value="true" />
    </map>

   File:
   data/data/com.konceptsandcode.simplesharedpreferences/shared_prefs/preference_file2.xml

   Data:
   <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
   <map>
        <string name="name">Keith</string>
   </map>


   Extending from PreferenceActivity follows a similar approach.

    A PreferenceActivity is provided an xml file that contains UI elements that the user can interact with.

    These values of these UI elements are saved to a preference file, just like how the values are saved
    in a preference file in this example.
 */