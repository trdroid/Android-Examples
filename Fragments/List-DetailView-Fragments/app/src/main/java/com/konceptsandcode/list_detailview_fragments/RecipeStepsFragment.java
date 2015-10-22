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

    public int getSelectedItemIndex() {
        return selectedItemIndex;
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

    /*
        Question
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Can Android just kill the Fragment, but NOT its enclosing Activity?

        If that is the case it makes sense to save the selectedItemIndex in the bundle,
        because if Android has to recreate this fragment, it would do so by calling its default constructor,
        and attaches the initialization bundle (just like how its done in our custom defined newFragmentInstance())

        so Android would call .. onCreate(), onCreateView() and so on .. when recreating the fragment
        and in onCreateView(), selectedItemIndex is used to display the steps for a selected recipe
        so it is important to store selectedItemIndex for retrieving it on recreation

        say if selectedItemIndex is 4 before the fragment is torn-down
        if selectedItemIndex is not saved and retrieved, its value will be 0 and on recreation the steps for
        recipe[0] will be displayed which is undesired.

        so shouldn't selectedItemIndex be saved in onSaveInstanceState?
     */
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

        /*
            if the parent ViewGroup container is null, this fragment is not displayed as it does not have a
            view hierarchy for the fragment to attach to, so return null
         */
        if(container == null) {
            return null;
        }

        /*
            Inflate the view for this fragment from a layout file.

            It can also be created in code, but by using the following approach, the fragment uses systems logic
            to find resources. The system chooses the appropriate layout file based on the device configuration
            rather having to detect and implement this in code.
         */
        View view = inflater.inflate(R.layout.recipe_steps, container, false);

        /*
            After inflating the layout, any specific view from the layout can be accessed.
         */
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
