package com.example.databindingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.databindingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MyClickHandler myClickHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Person person1 = new Person("Jack", "jack@gmai.com");

        //For the textview
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPerson(person1);

        //For the button
        myClickHandler = new MyClickHandler(this);
        binding.setClickHandler(myClickHandler);


        //Two Way Binding



    }
    /*
     Data Binding


        findViewById() - finds the first descendant view with the given id
        the view itself if the ID matches getId(), or null if the ID is invalid
        or there is no matching view in the layout hierarchy

        when we use findViewById() to get reference to a view, android system must go
        through the view hierarchy and find it a runtime.

        if a mobile have refresh rate of 60hz per 1 milsec, the android sysem creates
        layout with all its views every 16.1667 milsec. This is taxing for other mobiles with 90hz above
        causing memory leaks and missing views

        Solution - Data Binding

        data binding library - support library that allows you to bind UI components
        in our layouts to data sources in your app using declarative format rather than programmatically

        databinding - process of integrating views in an XML layout with data objects
        the databinding library is responsible for generating classes required for this

        Using data binding, a binding object will be created, the contains a reference to each view of a lyout
        so the android system will not go and search the views every time and enhance performance

        Using DATA Binding
        if we have an xml layout named activity_main.xml
        our data binding name will be ActivityMainBinding

        STEPS:
        1. declare library in the build.gradle.kts
            add this   buildFeatures {dataBinding = true viewBinding = true}

        2. convert layout to data binding layout
            see activity_main.xml

        3. use variable tag and element in the xml; variables that will bind the data to the layout
            see activity_main.xml
                create a class for the variable ("Person.java")
        4. Bind the views with the variables of the data binding
            see activity_main.xml


    TWO WAY DATA BINDING - binding objects to xml layout so that the layout can send data to the binding object
        for accepting inputs from edit text from the user and sending to the person.java class
            extend the person.java with BaseObservable to implement automatic property

     */

    /*
    Android JetPack - is a suite of libraries help developers follow best practrices
    reduce boilerplate code, and write code that works consistently across andreoid versions and devices

    helps solve major problems such as managing activity life cycles, configuration changes
    and preventing memory leaks

    jetpack components - bring together the existing supp library and architecture components

    4 categories
        Architecture
            Data mining
            Lifecycles
            LiveData
            Navigation
            Paging
            Room
            ViewModel
            Work Manager

         User interface
            animation & transition
            wear os by google
            auto
            emoji
            fragment
            layout
            palette
            tv
         Foundation
            Appcompat
            Android KTX
            Multidex
            Test
          Behavior
            Download manager
            Media and playback
            Notifs
            Permissions
            Sharing
            Slices
     */
}