package com.konceptsandcode.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment
{


    public Fragment2()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        /*
            container is the parent ViewGroup i.e. the activity that the fragment is being embedded in
         */
        return inflater.inflate(R.layout.fragment2, container, false);
    }
}
