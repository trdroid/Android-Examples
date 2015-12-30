# Activity Life Cycle

### On Application Launch

12-25 16:31:26.569 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onCreate(Bundle savedInstanceState)

12-25 16:31:26.573 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-25 16:31:26.573 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()


### Pressing Back Button

12-24 00:21:16.080 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-24 00:21:17.425 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

12-24 00:21:17.425 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onDestroy()

> On pressing the back button, Android destroys the Activity. The onDestroy() method is not necessarily called at all times. However, the onPause() method is always called reliably.

    ~~~~Question~~~~
> The app still shows in the recent apps. What does it mean? When an Activity is destroyed, should it not be removed from the Activity stack? Does the list of recent apps reflect the activities on the Activity stack?

### Launch the App again

12-25 16:32:05.913 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onCreate(Bundle savedInstanceState)

12-25 16:32:05.915 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-25 16:32:05.915 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()


### Pressing Home Button

12-25 16:32:37.429 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-25 16:32:37.436 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onSaveInstanceState(Bundle outState)

12-25 16:32:37.436 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: Saving data, IS_SAVED to true

12-25 16:32:37.436 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

> On pressing the home button, Android pauses and stops the activity and tries not to destroy it in case if the user decides to come back to the app again. However if the system needs to reclaim memory, stopped activities might be destroyed because they are further down in the Activity stack.


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

# Saving State

## Retaining state between Activity destruction and reconstruction

<b><i>Implementing onSaveInstanceState() callback</i></b>

Since an activity is destroyed and recreated on runtime device configuration changes, the onSaveInstanceState() method can be implemented to retain the state across activity destruction and reconstruction. However, the onSaveInstanceState() method is not helpful for saving state when an activity is paused or stopped. onSaveInstanceState() is only useful when an activity instance is reconstructed, not when an activity is paused and resumed. 

When an activity is destroyed, the onPause() method is reliably called. The onDestroy() method may not be called at all times.

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

<b><i> Where is the Bundle stored? </b></i>

Android stashes the Bundle in the the Activity's <b><i>Activity Record</i></b>. The Activity Record for an activity lives on beyond the activity instance and even beyond the app process. 

<b><i> When are Activity Records discarded? </b></i>

Activity Records are discarded when 
* the user presses the back button
* the device is rebooted
* unused for a long time

<b><i> The state can be retained on onSaveInstanceState() when </b></i>
 
 1) the runtime device configuration changes, where the Activity is destroyed and recreated
    
    ~~~~~~~Question~~~~~~~~~~~~
 2) Android kills the application process and the user relaunches the app??


### On a device orientation change, where the Activity is destroyed and recreated </i></b>

12-25 16:34:01.287 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-25 16:34:01.287 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onSaveInstanceState(Bundle outState)

12-25 16:34:01.287 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: Saving data, IS_SAVED to true

12-25 16:34:01.287 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

12-25 16:34:01.288 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onDestroy()

12-25 16:34:01.335 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onCreate(Bundle savedInstanceState)

12-25 16:34:01.337 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: Retrieving data in onCreate(), IS_SAVED istrue

12-25 16:34:01.338 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-25 16:34:01.339 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onRestoreInstanceState(Bundle savedInstanceState)

12-25 16:34:01.339 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: Retrieving data in onRestoreInstanceState(), IS_SAVED istrue

12-25 16:34:01.339 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()


## Retaining state when Activity pauses and resumes

When an activity is paused or stopped, the Android system could possibly destroy the activity to reclaim memory because as the activity would be deep in the stack. That said, a running activity is never destroyed by the Android system to reclaim memory. 

In such cases, the onPause() method is reliably called. The onDestroy() method may not be called at all times. 

As there is a chance for the activity to be destroyed, it makes sense to save the state or stop tasks like playing music in the onPause() method. The state can be retained by any of the following means
 * Shared Preferences
 * Files
 * Databases
 * Content Providers

The saved state can be retrieved in the onResume() method

<b><i> Save state in onPause() and retrieve the saved state in onResume() when </b></i>

 1) The home button is pressed where the Activity is only paused and stopped but not destroyed


### The home button is pressed where the Activity is only paused and stopped but not destroyed

12-25 16:43:46.415 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-25 16:43:46.426 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onSaveInstanceState(Bundle outState)

12-25 16:43:46.426 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: Saving data, IS_SAVED to true

12-25 16:43:46.426 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()


### Launch the App again

12-25 16:44:49.935 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-25 16:44:49.935 8751-8751/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()


