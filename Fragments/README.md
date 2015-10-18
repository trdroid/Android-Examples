# Fragments

Fragments allow for the creation of the user interface for an Android application in a versatile way.

A Fragment has an associated view hierarchy just like an Activity. It can be inflated from an XML file or created in code. 

A Fragment has a bundle that can be assigned its initialization arguments. This should be done before it is attached to the Activity that it is bound to i.e. immediately after constructing the fragment. These arguments are retained across fragment tear-down and recreation. 

An Activity specifies Fragments as containers in its layout. The internal structure of each Fragment is laid out in its own layout file that specifies the Fragment's view hierarchy, which has to be attached to the view hiearchy of the enclosing Activity.

Fragments are contained within an activity and only exist within the context of an activity. 
Fragments could be thought of as "fragmented" or "mini" activities. 
A Fragment is extended from android.app.Object.

A Fragment has access to the Activity it is tied to and its resources. A Fragment also has access to its FragmentManager through the Activity. 

Fragments have a life cycle like any other Android component. 

Fragments were released in Android 3.0. A fragment SDK that works on older Android devices was also released by Google.

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
   

### Benefits

Activities are killed and recreated on configuration changes. This requires their state to be saved before termination and restored on recreation. 

The saving and restoration can be overcome with Fragments as they can be retained across orientation changes.

Fragments can be added to the backstack in a way that pressing the Back button steps backward through the fragments while saying inside the current activity. 

# Creation

STEP A: Instantiating a Fragment

STEP B: Inflating Fragment's view

STEP C: Where in the enclosing Activity should the Fragment be attached? i.e. Attaching the Fragment with its Activity's view hierarchy


### Declaring \<fragment\> tag

* An Activity's layout has a \<fragment\> tag with a class attribute specifying a class that extends any Fragment class. The position of the \<fragment\> tag in the Activity's layout addresses STEP C.
* When the Activity's layout is inflated, the fragment's class (as specified in the class attribute) is instantiated. This addresses STEP A.
* The Fragment's lifecycle starts as soon as it is instantiated and its callbacks are called. Its view should be inflated from a layout file (or by code) and returned from one of these callbacks. This addresses STEP B.

### Instantiating in code
* A Fragment can be dynamically created by instantiating it in code (STEP A)
* Its lifecycle starts. Its view should be inflated from a layout file (or by code) and returned from one of these callbacks (STEP B)
* Where a Fragment should be attached inside its enclosing Activity is specified in a FragmentTransaction

# Questions

What is container ViewGroup in onCreateView? If it represents the immediate parent of the Fragment, then why is it invalid to attach the Fragment to ViewGroup explicitly. How is it different than specifying the view hierarchy in a FragmentTransaction?

What does it mean to say that Android takes care of attaching the fragments for us?




