package com.konceptsandcode.basicdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.konceptsandcode.basicdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    /*
        setContentView(R.layout.activity_main);
    */

        /*
            Inflate the layout and create a binding class using DataBindingUtil class

            The binding class name is inferred from the layout file name and is generated.

            In this case the layout file name is "activity_main", so the binding class name
            would be ActivityMainBinding

            i.e. the ActivityMainBinding class is generated

            DataBindingUtil.setContentView returns the ViewDataBinding base class,
            but the generated class name should be used here

         */
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        StudentModel studentModel = new StudentModel("Keith", "Koncepts", 12);

        /*
            There is no need to find views from the layout
            All it takes is one line to bind the data to the view

            In traditional binding, references for all three views should be obtained

            TextView firstName = findViewById(R.id.firstName)
            firstName.setText(studentModel.getFirstName());

            TextView lastName = findViewById(R.id.lastName)
            lastName.setText(studentModel.getLastName());

            TextView grade = findViewById(R.id.grade)
            grade.setText(studentModel.getGrade());

            All this is replaced with a single line

            binding.setStudentModel(studentModel);
         */
        /*
            Bind the data to the view

            The method setAStudentModelInstance is created by the plugin
            based on the name of the data variable in the layout file

            The data variable used in the layout file is: aStudentModelInstance
         */

        binding.setAStudentModelInstance(studentModel);
    }
}
