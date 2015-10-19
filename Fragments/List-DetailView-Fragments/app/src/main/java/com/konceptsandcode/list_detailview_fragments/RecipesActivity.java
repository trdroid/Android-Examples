package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class RecipesActivity extends Activity
{
    public static final String TAG = "RecipesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
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

    public void showRecipeDetails(int indexOfSelectedRecipe) {
        Intent intent = new Intent();

        intent.setClass(getApplicationContext(), RecipeStepsActivity.class);
        intent.putExtra("selectedItemIndex", indexOfSelectedRecipe);
        startActivity(intent);
    }
}
