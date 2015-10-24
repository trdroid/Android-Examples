# Broadcast Receivers

A Broadcast Receiver is a component that can respond to a broadcast message from a client.
More than one Broadcast Receiver could respond to a message. 

A client component such as an Activity or a Service uses sendBroadcast(intent) method of the Context class 
to send a broadcast message.

A Broadcast Receiver inherits from BroadcastReceiver available in Android SDK and registers itself in the 
manifest file through a *receiver* tag.

A *receiver* tag is way that a component (a Broadcast Receiver) advertises to the Android system that it can 
handle messages of a certain type.
