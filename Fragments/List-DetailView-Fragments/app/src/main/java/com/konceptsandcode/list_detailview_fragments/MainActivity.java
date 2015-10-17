package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showRecipeDetails(int indexOfSelectedRecipe) {
        Intent intent = new Intent();

        intent.setClass(getApplicationContext(), RecipeStepsActivity.class);
        intent.putExtra("indexOfSelectedRecipe", indexOfSelectedRecipe);
        startActivity(intent);
    }
}
