# Services

A service is an Android component that runs in the background without any user interaction. 

onBind() allows to bind an activity to a service. This allows the activity to directly access members and methods of the service.

onStartCommand() is called when the service is explicitly started using the startService() method

onDestroy() is called when the service is stopped using the stopService() method

The service code runs in the main thread.

### Execution

A service runs on the main thread. It should not run for more than 5 seconds. If the service has to execute a task that for more than 5 seconds, it should dispatch the task to a worker thread. A partial wake lock has to be obtained for the duration of the worker thread's execution so that the device does not go to sleep. A partial wake lock allows the code to run without turning on the screen of the device, which does not deter the battery life. 
