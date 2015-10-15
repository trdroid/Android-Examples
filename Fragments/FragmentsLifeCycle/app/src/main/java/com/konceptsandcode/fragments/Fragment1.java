package com.konceptsandcode.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class Fragment1 extends android.support.v4.app.Fragment
{
    /*
        A nice pattern that creates an instance of the Fragment
        and attaches a bundle to the Fragment with initialization arguments

        The initialization arguments should be attached before the Fragment is attached to the Activity,
        so attach the arguments immediately after creating a Fragment instance

        These arguments are retained across fragment tear-down and recreation.

        If this fragment is saved and reconstructed, the system will call its default constructor and
        reattaches the initialization arguments, just like how its done in this method

     */
    public static Fragment1 newInstance() {
        Fragment1 fragment1 = new Fragment1();

        Bundle initArgs = new Bundle();
        initArgs.putInt("key", 0);

        /*
            Attach initialization arguments to a Fragment instance
         */
        fragment1.setArguments(initArgs);

        return fragment1;
    }

    public Fragment1()
    {
        // Required empty public constructor
        Log.d("Fragment1", "in Constructor");
    }

    /*
        If the fragment is defined by a <fragment> tag, the onInflate() callback will be called.

        The arguments to onInflate() are
            a reference to the enclosing Activity
            attributes specified in the <fragment> tag
            a saved bundle (used to save the current state of the fragment in onSaveInstanceState() method
            and is different from the initialization bundle)

            The current state of the fragment is saved in a bundle in onSaveInstanceState() method
            so that when the fragment is being recreated, the saved bundle is passed
     */
    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState)
    {
        super.onInflate(activity, attrs, savedInstanceState);
        Log.d("Fragment1", "onInflate");
    }

    /*
        onAttach() is called after fragment is associated with its Activity.

        The reference to the enclosing Activity is passed to it.
        Alternatively, the getActivity() method of the Fragment class can be used to get the reference of the enclosing
        Activity

        The initialization arguments are available here through getArguments() method
        The initialization arguments cannot be set here, so setArguments() should not be called
    */
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        Log.d("Fragment1", "onAttach");
    }

    /*
        onCreate() method get a saved bundle (saved in onSaveInstanceState() method)

        This method does not guarantee the completion of the enclosing Activity's onCreate() method,
         as a result code that relies on the enclosing Activity's view hierarchy should not be placed here

        A background thread can be created at this point, if the fragment needs some data and has to make a blocking
        call.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d("Fragment1", "onCreate");
    }


    /*
        onCreateView() should return the view hierarchy of the fragment

        Arguments are:
            LayoutInflater which can be used to inflate a layout for the fragment
            ViewGroup parent
            saved bundle

        The view hierarchy should not be attached to the ViewGroup parent explicitly. It happens later automatically.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.d("Fragment1", "onCreateView");
        return inflater.inflate(R.layout.fragment1, container, false);
    }


    /*
        onViewCreated() is called right after onCreateView() and is passed the view returned by onCreateView()
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }


    /*
        Called after the completion of the enclosing Activity's onCreate() callback

        The Activity's view hierarchy is ready and available and so is the Fragment's view hierarchy if one is returned
         before

        Additional UI changes can be done here before displaying the UI to the user
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment1", "onCreate");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d("Fragment1", "onStart");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d("Fragment1", "onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d("Fragment1", "onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d("Fragment1", "onStop");
    }


    /*
        onDestroyView() is called after the view hierarchy created in onCreateView() method
        has been detached from the fragment
     */
    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        Log.d("Fragment1", "onDestroyView");
    }


    /*
        onDestroy() is called when the fragment is no longer in use
        It is still attached to its enclosing activity.
     */
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d("Fragment1", "onDestroy");
    }


    /*
        The invocation of this method implies that the fragment is not tied to its enclosing Activity.
        Its view hierarchy and all of its resources are released
     */
    @Override
    public void onDetach()
    {
        super.onDetach();
        Log.d("Fragment1", "onDetach");
    }

    /*
        Specifies if the Fragment should be completely destroyed on Activity recreation

        The question becomes:
        Do you want to use the same Fragment instance on Activity recreation or create a new one from scratch?

        If you choose to retain the Fragment, it has to be detached from this Activity and attached to the new one

        Since the Fragment is being retained, its onDestroy() method is not called on the Activity tear-down
        and because the same Fragment is attached to a new Activity, its onCreate() method is not called on
        reattachment

        When a Fragment is retained, its callbacks should take into consideration the reasons for the Activity recreation

        For example, say if the Activity is recreated because of a configuration change, appropriate actions must be
        taken in the Fragment, like inflating a new view hierarchy in the onCreateView() method

        setRetainInstance can be called from
        onCreate() or onCreateView() or onActivityCreated()
     */
    @Override
    public void setRetainInstance(boolean retain)
    {
        super.setRetainInstance(retain);
    }
}
