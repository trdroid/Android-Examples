package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecipesFragment extends ListFragment {
    public static final String TAG = "RecipesFragment";
    private RecipesActivity recipesActivity = null;
    private int selectedItemIndex = 0;

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState)
    {
        Log.v(TAG, "onInflate");
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity)
    {
        Log.v(TAG, "onAttach");
        super.onAttach(activity);
        this.recipesActivity = (RecipesActivity)activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        /*
            Restore the index of item last selected
         */
        if(savedInstanceState != null) {
            selectedItemIndex = savedInstanceState.getInt("selectedItemIndex", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(TAG, "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.v(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        Log.v(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                RecipesModel.RECIPES));

        ListView listView = getListView();

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setSelection(selectedItemIndex);
    }

    @Override
    public void onStart() {
        Log.v(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.v(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.v(TAG, "onPause");
        super.onPause();
    }

    /*
        Save what index has been selected so that it can be retrieved when the fragment is recreated

        QUESTION
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Why is it necessary to store the item selected?
        Is it because of listView.setSelection(selectedItemIndex);?
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.v(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        outState.putInt("selectedItemIndex", selectedItemIndex);
    }

    @Override
    public void onStop() {
        Log.v(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.v(TAG, "onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Log.v(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.v(TAG, "onDetach");
        super.onDetach();
        recipesActivity = null;
    }

    /*
        QUESTION
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        On clicking an item in the RecipesFragment (which is in the RecipesActivity),
        the RecipesActivity sends an intent to RecipeStepsActivity which launches that Activity.

        But what if the user presses home button before RecipeStepsActivity launches?
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.v(TAG, "onListItemClick");
        recipesActivity.showRecipeDetails(position);
        selectedItemIndex = position;
    }
}
