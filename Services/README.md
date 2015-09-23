A service is an Android component that runs in the background without any user interaction. 

onBind() allows an activity to bind to a service. This allows the activity to directly access members and methods of the service.

onStartCommand() is called when the service is explicitly started using the startService() method

onDestroy() is called when the service is stopped using the stopService() method
