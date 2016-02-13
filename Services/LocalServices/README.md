  Local services are a great model for implementing background tasks. By default, a service runs on the main thread, so threading capabilities have to be augmented explicitly. 
  
  A local service is accessible ONLY to the application hosting the service.
  
  A local service is instantiated when a client starts it by calling <i>Context.startService()</i> or binds to it by calling <i>bindService()</i>

 <b> Services started by <i>startService()</i> </b>
 
  A local service is instantiated on a client's first call to <i>Context.startService()</i>. On instantiation, the service's <i>onStartCommand()</i> method is called. 
  
  Any subsequent client's call to <i>Context.startService()</i> DOES NOT create a new service instance, but instead reinvoke the <i>onStartCommand()</i> method of the running service.
  
  A service started using <i>startService()</i> is great for performing background tasks as it keeps running even after the Activity/Broadcast Receiver which started it goes away. It runs until it stops itself by calling <i>stopSelf()</i> or is asked by a client to stop by calling <i>Context.stopService()</i>. To regain control of the service after the Activity goes away, implement the <i>onBind()</i> method in the service so that a new Activity can bind to the service and invoke methods on it.    

<b> Services that gets bound by <i>bindService()</i> </b>

 A service that gets bound is instantiated when the first client binds to it by calling <i>bindService()</i> and is destroyed when the last client unbinds from it.
 
 Binding to a service is allowed only from 
 * An Activity
 * Another Service
 * A Content Provider
 * An Application Context
 
but not from
 * A Fragment
 * A Broadcast Receiver
