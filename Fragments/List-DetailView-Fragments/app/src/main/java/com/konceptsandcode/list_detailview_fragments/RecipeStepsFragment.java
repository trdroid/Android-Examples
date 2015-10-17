package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecipeStepsFragment extends Fragment {
    private int selectedItemIndex = 0;

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

        selectedItemIndex = getArguments().getInt("selectedItemIndex", 0);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.recipe_steps, container, false);
        TextView stepsTextView = (TextView) view.findViewById(R.id.steps);
        stepsTextView.setText(RecipesModel.STEPS[selectedItemIndex]);

        return view;
    }
}
