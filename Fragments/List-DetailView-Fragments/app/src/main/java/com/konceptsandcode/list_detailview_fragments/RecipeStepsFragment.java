package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecipeStepsFragment extends Fragment {
    public static final String TAG = "RecipeStepsFragment";
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
        Log.v(TAG, "onInflate");
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity)
    {
        Log.v(TAG, "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        selectedItemIndex = getArguments().getInt("selectedItemIndex", 0);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        Log.v(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.v(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.v(TAG, "onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(TAG, "onCreateView");
        if(container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.recipe_steps, container, false);
        TextView stepsTextView = (TextView) view.findViewById(R.id.steps);
        stepsTextView.setText(RecipesModel.STEPS[selectedItemIndex]);

        return view;
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
    public void onSaveInstanceState(Bundle outState) {
        Log.v(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        Log.v(TAG, "onStop");
        super.onStop();
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
    }
}
