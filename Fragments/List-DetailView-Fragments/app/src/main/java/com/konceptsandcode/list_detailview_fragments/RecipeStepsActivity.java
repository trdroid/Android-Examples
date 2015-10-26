package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class RecipeStepsActivity extends Activity {
    public static final String TAG = "RecipeStepsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            /*
                When in portrait mode, if an item is tapped, the details of the item are shown in another activity
                (RecipeStepsActivity), different from the main activity (RecipesActivity)

                If the device is changed to be in landscape mode, close this activity and let the MainActivity
                take care of the landscape orientation
             */
            finish();
            return;
        }

        /*
            Question (I think I have an answer):

            Is it really necessary to create a new fragment per item click?
            Once a fragment is created, can't we just use it for subsequent item clicks by changing it selectedItemIndex

            Since this is used only in Portrait mode where this RecipeStepsFragment is only displayed after
            tapping an item in RecipesFragment, we have to exit RecipeStepsFragment to be able to tap another item
            from the list.

            Its a question of .. Should we just use one fragment the first time its created and reuse the same just
            by changing its text (or)
            Should we just created a new fragment per click and on returning to the main list, we leave the fragment
            instance to be garbage collected

            But here lies the answer .. How can you retain a RecipeStepsFragment and hold it in memory to be used
            the next time.
         */
        if(getIntent() != null) {
            RecipeStepsFragment recipeStepsFragment =
                    RecipeStepsFragment.newFragmentInstance(getIntent().getExtras());

            /*
                android.R.id.content is the top-level view container for an activity
                add the fragment view hierarchy to the top-level view container of this activity making the
                fragment's view hierarchy the only view hierarchy for this activity
             */
            getFragmentManager().
                    beginTransaction().
                    add(android.R.id.content, recipeStepsFragment).
                    commit();
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.v(TAG, "onAttachFragment");
        super.onAttachFragment(fragment);
    }

    @Override
    protected void onStart() {
        Log.v(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.v(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG, "onDestroy");
        super.onDestroy();
    }
}
