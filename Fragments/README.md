# Fragments

### Why Fragments?

More than one activtiy is needed to accommodate user interfaces for a wide variety of device form factors. The device form factors could be categorized into subset of devices with similar user interface requirements. The user inteface for each subset of devices can be handled by an activity, resulting in multiple activities to cover the whole range of user interface requirements. This could possibly result in duplication of business logic across all these activities, or an effort in factoring out the common code and making it available across these activities. 

A better solution is to use Fragments which allow for the creation of the user interfaces in a modular way. A user interface can be modularized with fragments, with each fragment encapsulating a portion of the user interface along with the control logic. The modularity implies that the fragments can be arranged in an Activity as needed. 

### Availability

The Fragment class was released with Android 3.0 (API Level 11). The Activity class in and above API Level 11 is aware of the Fragment class. 

Android provided a <b><i>support library</b></i> to make the Fragments available to devices running Android 1.6 (API Level 4) or higher. The Activity class (android.app.Activity) below API Level 11 has no knowledge of the Fragment class. Therefore to use Fragments in devices running API Level < 11, including API Level > 11, Android provided a Fragment-aware Activity class in the support library called FragmentActivity (android.support.v4.app.FragmentActivity). 

To use Fragments in devices running API Level > 4, including API Level > 11, the activity class should extend FragmentActivity (android.support.v4.app.FragmentActivity) rather than Activity (andoird.app.Activity). 

### Containing Activity

Fragments are contained within an activity and only exist within the context of an activity. 
Fragments could be thought of as "fragmented" or "mini" activities. 

An Activity specifies Fragments as containers in its layout. The internal structure of each Fragment is laid out in its own layout file that specifies the Fragment's view hierarchy, which has to be attached to the view hiearchy of the enclosing Activity.

A Fragment has access to the Activity it is tied to and its resources. A Fragment also has access to its FragmentManager through the Activity. 

A Fragment have a life cycle like any other Android component and its lifecycle is tightly coupled with the lifecyle of the containing Activity. 


### Fragment's View

A Fragment has an associated view hierarchy just like an Activity. It can be inflated from an XML file or created in code. 


### Initial Arguments

A Fragment has a bundle that can be assigned as its initialization arguments. This should be done before it is attached to the Activity that it is bound to i.e. immediately after constructing the fragment. These arguments are retained across fragment tear-down and recreation. 


### A Scenario for using Fragments

Consider a scenario:

a) Portrait Mode on a Phone:

  Screen1: A List View
  
  Screen2: Clicking on each item transitions to a Details View

b) Landscape Mode on a Tablet: 

  Screen1: A List View to the left, a Details View to the right

c) Portrait Mode on a Tablet:

  Screen1: A List View on the top, a Details View on the bottom

> *Trying to achieve this just by designing layouts for various configurations would be a "messy" solution. An easier approach is to use Fragments.*

a) Screen1: Entire Screen1, Fragment A displays a List (Clicking on an element leads to Screen2)

   Screen2: Entire Screen2, Fragment B shows Details 

b) Screen1: Left of Screen1, Fragment A displays a List (Clicking on an element shows details)

   Screen1: Right of Screen1, Fragment B shows Details
   
c) Screen1: Top of Screen1, Fragment A displays a List (Clicking on an element shows details)

   Screen1: Bottom of Screen1, Fragment B shows Details
   

<i>Tips</i>

Assess if the scenario actually needs Fragments. Adding Fragments 'later' is not a good idea. 

Do not use Fragments just for the sake of using them. 

DO NOT overuse Fragments. 

### Benefits

Fragments simplify the creation of the UI across various form factors.

Activities are killed and recreated on configuration changes. This requires their state to be saved before termination and restored on recreation. 

The saving and restoration can be overcome with Fragments as they can be retained across orientation changes.

Fragments can be added to the backstack in a way that pressing the Back button steps backward through the fragments while saying inside the current activity. 

Fragments provide a consistent way to create built-in Android UI components which prior to Fragments had to be created in disparate ways. These UI components include lists, dialog boxes, tabs etc.

# Creation

STEP A: Instantiating a Fragment

STEP B: Inflating Fragment's view

STEP C: Where in the enclosing Activity should the Fragment be attached? i.e. Attaching the Fragment with its Activity's view hierarchy


### Declaring \<fragment\> tag

* An Activity's layout has a \<fragment\> tag with a class attribute specifying a class that extends any Fragment class.
* When the Activity's layout is inflated, the fragment's class (as specified in the class attribute) is instantiated (STEP A)
* The Fragment's lifecycle starts as soon as it is instantiated and its callbacks are called. Its view should be inflated from a layout file (or by code) and returned from one of these callbacks (STEP B)
* The position of the \<fragment\> tag in the Activity's layout addresses (STEP C)

### Instantiating in code
* A Fragment can be dynamically created by instantiating it in code (STEP A)
* Its lifecycle starts. Its view should be inflated from a layout file (or by code) and returned from one of these callbacks (STEP B)
* Where a Fragment should be attached in its enclosing Activity's view hierarchy is specified in a FragmentTransaction (STEP C)

# Questions

What is container ViewGroup in onCreateView? If it represents the immediate parent of the Fragment, then why is it invalid to attach the Fragment to ViewGroup explicitly. How is it different than specifying the view hierarchy in a FragmentTransaction?

What does it mean to say that Android takes care of attaching the fragments for us?

https://github.com/konceptsandcode/Android/blob/master/Fragments/FragmentsLifeCycle/app/src/main/java/com/konceptsandcode/fragments/Fragment1.java

https://github.com/konceptsandcode/Android/blob/master/Fragments/List-DetailView-Fragments/app/src/main/java/com/konceptsandcode/list_detailview_fragments/RecipeStepsFragment.java




