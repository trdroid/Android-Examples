# Broadcast Receivers

A Broadcast Receiver is a component that can respond to a broadcast message from a client.

> Broadcast Receiver

A Broadcast Receiver inherits from BroadcastReceiver of the Android SDK and registers itself in the 
manifest file through a *receiver* tag. A *receiver* tag is way that a component (a Broadcast Receiver) advertises to the Android system that it can handle messages of a certain type.

A message can be responded by more than one Broadcast Receiver if they register to respond to messages of that type.

> Client

A client component such as an Activity or a Service uses *sendBroadcast(intent)* method of the Context class 
to send a broadcast message.

### Execution

The Broadcast Receivers that belong to a process are executed in the main thread.

A client calls sendBroadcast() to broadcast a message which is enqueued in a queue. The messages in the queue are processed by one or more registered Broadcast Receivers that run on the main thread.

If more than one Broadcast Receiver responds to a message, the order of execution of the Broadcast Receivers (i.e. their onReceive() methods) is not certain. 
