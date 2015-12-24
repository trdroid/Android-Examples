# Activity Life Cycle

### On Application Launch

12-23 23:57:49.756 17670-17670/? D/MainActivity: onCreate()

12-23 23:57:49.791 17670-17670/? D/MainActivity: onStart()

12-23 23:57:49.791 17670-17670/? D/MainActivity: onResume()


### Pressing Back Button

12-24 00:21:16.080 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-24 00:21:17.425 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

12-24 00:21:17.425 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onDestroy()

> On pressing the back button, Android destroys the Activity.


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

> On a device configuration change, the activity is destroyed and a new activity is created.

<b><i> On Device Rotation </i></b>

12-24 01:11:14.047 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onPause()

12-24 01:11:14.047 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStop()

12-24 01:11:14.047 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onDestroy()


12-24 01:11:14.084 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onCreate()

12-24 01:11:14.106 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onStart()

12-24 01:11:14.106 17670-17670/com.lifecycle.activity.droid.activitylifecycle D/MainActivity: onResume()

> On device rotation, the Activity is destroyed and a new Activity is created. On setContentView(R.layout.activity_main) call in the onCreate() method, Android attempts to inflate the view from res/layout-land/activity_main.xml. If it is not found, then res/layout/activity_main.xml is inflated as usual. 



