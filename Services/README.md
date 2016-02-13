# Services

A Service is an Android component that runs invisibly in the background without a user interface. It has its own life cycle separate from other components. Services are similar in spirits to services in Windows or daemons in Linux, which means they can be available at all times without necessarily doing anything actively, just waiting to serve.

### Types of services

1) Local Services
  
  Local services are a great model for implementing background tasks. By default, a service runs on the main thread, so threading capabilities have to be augmented explicitly. 
  
  A local service is accessible ONLY to the application hosting the service.
  
  A local service gets initialized when a client starts it using <i>startService()</i> or binds to it using <i>bindService()</i>

  A service started using <i>startService()</i> is great for performing background tasks as it keeps running even after the Activity/Broadcast Receiver which started it goes away. It runs until it stops itself or is asked by a client to stop. To regain control of the service after the Activity/Broadcast Receiver goes away, implement the <i>onBind()</i>  method in the service so that a new Activity can bind to the service and invoke methods on it.  

### Priority of a Service

*The priority of a started Service is greater than the priority of an Activity which is inactive*

A Service's priority can be raised to be the same as the priority of a foreground Activity in cases when the termination of a Service is unacceptable. 

The Runtime could terminate a Service prematurely to provide additional resources to a foreground component (like an Activity). A Service can be configured to restart as soon as the resources become available.

### Creating a Service

The *onBind()* method allows the service to be bound to an activity which allows the activity to directly access members and methods of the service.

The *onStartCommand()* method is called when the service is explicitly started using the *startService()* method

The *onDestroy()* method is called when the service is stopped using the stopService() method

### Execution

A service runs on the main thread of the application process. It should not run for more than 5 seconds. 

## NonSticky Services

When a Service returns the nonsticky flag, Service.START_NOT_STICKY, from its onStartCommand() method, Android does not restart the Service ONLY if there are no pending intents. This means to say that Android will restart the Service if there are any pending intents for the Service. 



## Sticky Services

When a Service returns the sticky flag, Service.START_STICKY, from its *onStartCommand()* method, Android restarts the service even if there are no pending intents.

When a service is restarted, the onCreate() and onStartCommand() methods are called with a null intent.

> Executing a long running task

If the service has to execute a task that runs for more than 5 seconds, it should dispatch the task to a worker thread. A partial wake lock has to be obtained for the duration of the worker thread's execution so that the device does not go to sleep. A partial wake lock allows the code to run without turning on the screen of the device, which does not deter the battery life. 

A partial wake lock has to be obtained before the execution of the onStartCommand() method of the implemented Service component. It cannot be obtained from within the Service as the device might go to sleep immediately after the call to the service (for example, a Broadcast Receiver calling startService() method) and before the code that obtains the partial wake lock is run. 

If a service is torn-down and recreated, the wake lock has to be obtained again. 

After the worker thread completes its task, it can intimate the service to stop either directly or through a handler.

### Scenarios

1) On pausing, stopping or destroying an Activity, any outstanding processing that has to be continued can be delegated to a service.

