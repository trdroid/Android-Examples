package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class RecipesActivity extends Activity
{
    public static final String TAG = "RecipesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        /*
            Benefit of inflating from a layout file is that the system is involved in finding the resource (layout) file
            so the system chooses an appropriate resource file based on device configuration

            For RecipesActivity, the system chooses from either
            layout/activity_main.xml (or)
            layout-land/activity_main.xml

            based on the orientation (a configuration type) of the device
         */
        setContentView(R.layout.activity_main);
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

    private boolean isInLandscapeMode() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public void showRecipeDetails(int selectedItemIndex) {
        if(isInLandscapeMode()) {
            /*
                Get the instance of RecipeStepsFragment, if any, with fragment id R.id.recipe_steps_container
             */
            RecipeStepsFragment recipeStepsFragment =
                    (RecipeStepsFragment) getFragmentManager().findFragmentById(R.id.recipe_steps_container);

            /*
                Create an instance of RecipeStepsFragment ONLY
                if no instance has been created and associated with the FragmentManager
                or
                if an instance already exists but DOES NOT correspond to the recipe tapped

                so this makes it important to save the index of the selected recipe in the fragment
                which can be retrieved with the custom fragment method getSelectedItemIndex()
             */
            if(recipeStepsFragment == null || recipeStepsFragment.getSelectedItemIndex() != selectedItemIndex) {
                recipeStepsFragment = RecipeStepsFragment.newFragmentInstance(selectedItemIndex);

                /*
                    attach the fragment to the container with id R.id.recipe_steps_container
                 */
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.recipe_steps_container, recipeStepsFragment)
                        .commit();
            }
        }
        else {
            Intent intent = new Intent();

            intent.setClass(getApplicationContext(), RecipeStepsActivity.class);
            intent.putExtra("selectedItemIndex", selectedItemIndex);
            startActivity(intent);
        }
    }
}
