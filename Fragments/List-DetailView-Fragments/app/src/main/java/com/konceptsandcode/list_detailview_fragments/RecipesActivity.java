package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
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

                Retrieve a FragmentManager by calling getFragmentManager() on an Activity or an attached fragment.
                getFragmentManager() cannot be used on a Fragment which is not attached to an activity yet. However,
                it can be used on fragment that is attached but not visible to the user.

                By the time the variable tries to dereference a fragment, the fragment might not be in memory.

                A fragment can be retrieved from the FragmentManager using either
                    a) the fragment's id
                        fragment's resource ID (findFragmentById()) if inflated from XML with <fragment> tag
                        using
                        (or)
                        container's resource ID (findFragmentByTag()) if fragment is placed in the view hierarchy
                        with a fragment transaction
                    b) fragment's tag
                        String that can be assigned in the fragment's XML definition
                        (or) when placed in the view hierarchy using a fragment transaction
                    c) a combination of bundle and key
                        a fragment persisted with putFragment() method can be retrieved using getFragment().
                        Usually a fragment reference is stored.
                        Trying to access a fragment by saving its reference should be handled by being aware of the
                        times that fragments could get saved away by the Android platform and do not exist in memory.
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

                    Use FragmentTransaction to swap one fragment with another

                    But why use many Fragments?
                    ---------------------------

                    A single fragment could just have been used to display content of the selected item, but
                        by using multiple fragments with a FragmentTransaction we get the following benefits:

                           a) Fragments can be added to the back stack just like Activities, so pressing back button
                              enables rolling back fragments while staying within the Activity
                              (although it is not required to add fragments to the back stack, in which case
                              pressing back button pops an Activity from the back stack)
                           b) Can perform transitions from an old fragment to a new one using transitions and animations
                           c) Can save transition details in a fragment transaction that can be reversed later

                    When popping fragment transactions off the back stack, data changes, say, in the activity are not
                    undone. Pressing back button just steps back through the views but does not cause the data changes
                    of the Activity to revert back.

                    The inner state of a restored fragment depends on the way they are saved and restored.

                    You could choose to implement to restore Activity state when restoring a fragment.

                    FragmentManager can enable debugging messages to LogCat() using enableDebugLogging()
                    FragmentManager's current state can be dumped to a stream using dump()
                 */

                FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();

                /*
                    can use transition with setTransition method as:
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                    fragmentTransaction.hide() and show() can be used to hide and show fragments after they are
                    attached to the view hierarchy of an Activity
                 */

                /*
                    arg1: applies to fragment entering
                    arg2: applies to fragment exiting
                 */
                fragmentTransaction.setCustomAnimations(R.animator.fade_in, R.animator.fade_out);

                /*
                    fragmentTransaction.replace() is same as
                        fragmentTransaction.remove() followed by fragmentTransaction.add()

                    NOTE: Even though FragmentTransaction is used to place fragment onto back stack, a
                     FragmentManager can take fragments off the back stack.

                     FragmentManager does it by
                        1) using fragment's TAG or ID
                        2) fragment's position in the back stack
                        3) popping the topmost fragment on the back stack

                    fragmentTransaction.commit() schedules the work to be executed on the UI thread when it is ready
                    to do it

                    A fragment can be attached without it being visible by using the add method of FragmentTransaction
                        public FragmentTransaction add(Fragment fragment, String tag)
                    and associating a String tag to the fragment so it can be retrieved later.
                    Such invisible fragments can just contain certain logic without having any view at all.
                    It can be made to persist configuration changes by retaining it using setRetainInstance() method.
                 */
                fragmentTransaction.replace(R.id.recipe_steps_container, recipeStepsFragment)
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
