### Handler

A handler 

### Looper

A looper of a consumer thread is associated with a MessageQueue. It has a One-to-One relationship with the MessageQueue. 

### MessageQueue


### Message

A producer thread inserts a message for the consumer thread to process by means of the consumer thread's handler. 

The consumer thread's handler inserts the message in the MessageQueue associated with the consumer thread's looper.

A consumer thread's handler could be exposed to the producer thread directly or is hidden behind an API call. 

A Message in a MessageQueue could be a 
* data message (or)
* a task message

but never both. 

**Data Message**

A data message is received by the consumer thread in its *Handler.handleMessage(Message)*

**Task Message**

A task message is just executed on the consumer thread.

**Message Lifecycle**



### Consumer Thread



