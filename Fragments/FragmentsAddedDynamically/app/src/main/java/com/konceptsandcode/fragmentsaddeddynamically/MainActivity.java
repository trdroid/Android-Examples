package com.konceptsandcode.fragmentsaddeddynamically;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /*
            getFragmentManager()
            Requires min API level 11
         */
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();

        boolean isLandscapeMode = display.getWidth() > display.getHeight();

        if(isLandscapeMode) {
            Fragment2 fragment2 = new Fragment2();

            /*
                android.R.id.content is the content view of this activity

                replace(<>, android.support.v4.app.Fragment instance) is not supported
                replace(<>, android.app.Fragment instance) is supported

                so fragment1 should be an instance of android.app.Fragment;
             */

            fragmentTransaction.replace(android.R.id.content, fragment2);
        } else {
            //portrait mode
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(android.R.id.content, fragment1);
        }

        fragmentTransaction.commit();
    }
}
