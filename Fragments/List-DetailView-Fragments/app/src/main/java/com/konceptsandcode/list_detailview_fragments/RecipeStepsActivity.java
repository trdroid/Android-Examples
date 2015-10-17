package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.os.Bundle;

public class RecipeStepsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if(getIntent() != null) {
            RecipeStepsFragment recipeStepsFragment =
                    RecipeStepsFragment.newFragmentInstance(getIntent().getExtras());

            getFragmentManager().
                    beginTransaction().
                    add(android.R.id.content, recipeStepsFragment).
                    commit();
        }
    }
}
