# Activity Life Cycle

### On Application Launch

12-23 23:57:49.756 17670-17670/? D/MainActivity: onCreate()

12-23 23:57:49.791 17670-17670/? D/MainActivity: onStart()

12-23 23:57:49.791 17670-17670/? D/MainActivity: onResume()


### Pressing Back Button

12-24 00:21:16.080 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-24 00:21:17.425 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

12-24 00:21:17.425 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onDestroy()

> On pressing the back button, Android destroys the Activity. The onDestroy() method is not necessarily called at times. However, the onPause() method is always called.


### Launch the App again

12-24 00:55:44.551 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onCreate()

12-24 00:55:44.557 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-24 00:55:44.557 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()


### Pressing Home Button

12-24 00:56:00.510 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-24 00:56:00.532 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

> On pressing the home button, Android pauses and stops the activity and tries not to destroy it in case if the user decides to come back to the app again. However if the system needs to reclaim memory, stopped activities might be destroyed.


### Launch the App again

12-24 00:59:30.112 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-24 00:59:30.112 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()

> NOTICE: the onCreate() method is not called, as the app need not be created


### On a pop-up

When a pop-up appears, the Activity is partially obscured, in which case it is paused. After the pop-up is dismissed, the Activity is resumed.


### On Device Configuration Changes

> Android destroys the activity and creates a new one when the device configuration changes at "runtime".

<b><i> On Device Rotation </i></b>

12-24 01:11:14.047 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-24 01:11:14.047 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

12-24 01:11:14.047 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onDestroy()


12-24 01:11:14.084 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onCreate()

12-24 01:11:14.106 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-24 01:11:14.106 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()

> On device rotation, from portrait to landscape, the Activity is destroyed and a new Activity is created. On setContentView(R.layout.activity_main) call in the onCreate() method, Android attempts to inflate the view from res/layout-land/activity_main.xml. If it is not found, then res/layout/activity_main.xml is inflated as usual. 

Applications can provide different resources for different device configurations. 

Device configuration includes
* Screen Orientation, which is not fixed and can change at runtime
* Screen Size
* Screen Density, which is fixed for a device
* Language, which could be changed at runtime
* Keyboard type, which could be chagned at runtime
* Dock Mode


### Implementing onSaveInstanceState() callback

Since an activity is destroyed and recreated on runtime device configuration changes, the onSaveInstanceState() method can be implemented to retain the state across activity destruction and recreation. The onSaveInstanceState() method can also be implemented to save state when an activity is paused or stopped. 

When an activity is paused or stopped, the Android system could possibly destroy the activity to reclaim memory, if needed. That said, a running activity is never destroyed by the Android system to reclaim memory. 

In such cases, the onPause() method is reliably called. The onDestroy() method may not be called at all times. Usually, the onSaveInstanceState() method is used to save and stash the state and the onPause() method to pausing tasks.

```java
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
```

The state can be saved in the Bundle argument outState which is handed back to the onCreate() method as savedInstanceState argument when the activity is recreated.

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
```
> When an activity is , onSaveInstanceState() method is called to save the state

<b><i> On screen rotation after implementing onSaveInstanceState() </i></b>

12-24 02:57:45.205 8816-8816/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-24 02:57:45.205 8816-8816/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onSaveInstanceState()

12-24 02:57:45.205 8816-8816/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

12-24 02:57:45.205 8816-8816/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onDestroy()

12-24 02:57:45.265 8816-8816/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onCreate()

12-24 02:57:45.270 8816-8816/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-24 02:57:45.270 8816-8816/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()

### Where is the Bundle stored?

Android stashes the Bundle in the the Activity's <b><i>Activity Record</i></b>. The Activity Record for an activity lives on beyond the activity instance.  



