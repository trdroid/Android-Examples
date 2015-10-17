package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;

public class RecipeStepsFragment extends Fragment {
    //private int selectedItemIndex = 0;

    public static RecipeStepsFragment newFragmentInstance(int selectedItemIndex) {
        RecipeStepsFragment recipeDetailsFragment = new RecipeStepsFragment();

        Bundle initialArguments = new Bundle();

        initialArguments.putInt("selectedItemIndex", selectedItemIndex);

        recipeDetailsFragment.setArguments(initialArguments);

        return recipeDetailsFragment;
    }

    public static RecipeStepsFragment newFragmentInstance(Bundle bundle) {
        int selectedItemIndex = bundle.getInt("selectedItemIndex", 0);
        return newFragmentInstance(selectedItemIndex);
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState)
    {
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }
}
