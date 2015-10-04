# Fragments

Fragments allow for the creation of the user interface for an Android application in a versatile way.

A Fragment has an associated view hierarchy just like an Activity. 

An Activity specifies Fragments as containers in its layout. The internal structure of each Fragment is laid out in its own layout file that specifies the Fragment's view hierarchy, which has to be attached to the view hiearchy of the enclosing Activity.

Fragments are contained within an activity and only exist within the context of an activity. 
Fragments could be thought of as "fragmented" or "mini" activities. 
A Fragment is extended from android.app.Object where as an Activity from Context.

Fragments have a life cycle like any other Android component. 

Fragments were released in Android 3.0. A fragment SDK that works on old Android devices was also released by Google.

Consider a scenario:

a) Portrait Mode on a Phone:
  Screen1: A List View
  
  Screen2: Clicking on each item transitions to a Details View

b) Landscape Mode on a Tablet: 

  Screen1: A List View to the left, a Details View to the right

c) Portrait Mode on a Tablet:

  Screen1: A List View on the top, a Details View on the bottom

Trying to achieve this just by designing layouts for various configurations would be a "messy" solution.

An easier approach is to use Fragments.

a) Screen1: Entire Screen1, Fragment A displays a List (Clicking on an element leads to Screen2)

   Screen2: Entire Screen2, Fragment B shows Details 

b) Screen1: Left of Screen1, Fragment A displays a List (Clicking on an element shows details)

   Screen1: Right of Screen1, Fragment B shows Details
   
c) Screen1: Top of Screen1, Fragment A displays a List (Clicking on an element shows details)

   Screen1: Bottom of Screen1, Fragment B shows Details
   
