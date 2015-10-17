package com.konceptsandcode.list_detailview_fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecipesFragment extends ListFragment {
    private MainActivity mainActivity = null;
    private int selectedItemIndex = 0;

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState)
    {
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.mainActivity = (MainActivity)activity;
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

        setListAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                RecipesModel.RECIPES));

        ListView listView = getListView();

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setSelection(selectedItemIndex);

        //mainActivity.showRecipeDetails(selectedItemIndex);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mainActivity.showRecipeDetails(selectedItemIndex);
        selectedItemIndex = position;
    }
}
