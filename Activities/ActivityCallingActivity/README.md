### Code Snippet

> MainActivity.java

```java
            @Override
            public void onClick(View v) {
                /*
                    Intent(Context packageContext, Class<?> cls)

                    The following is an explicit intent:

                    Context informs the ActivityManager the package that the class object (SecondActivity) is in
                    cls informs the ActivityManager which class to start i.e. the class to instantiate and call onCreate() method on

                    An explicit intent is used to start an Activity within the application

                    In contrast, an Implicit intent is used to start an Activity in another application
                 */
                Intent startSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startSecondActivityIntent.putExtra(SecondActivity.EXTRA_MESSAGE, R.string.message1);
                startSecondActivityIntent.putExtra(SecondActivity.INFORM_MESSAGE, R.string.inform_message);

                /*
                    When startActivity(intent) is called, the call is sent to the ActivityManager of Android OS.

                    The ActivityManager creates an instance of the called Activity (SecondActivity, in this case)
                     and calls its onCreate() method
                 */
                startActivity(startSecondActivityIntent);

                /*
                    startActivity() method is an asynchronous call i.e.
                    the execution continues after the method call
                 */
                Log.d(TAG, "startActivity() is a is an ASYNCHRONOUS call");
            }
        });

        launchButtonForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSecondActivityForResultIntent = new Intent(MainActivity.this, SecondActivity.class);

                /*
                    For the key in putExtra() method, the convention is to use a constant from the Child Activity class
                    which receives and processes the data

                    Question
                    ~~~~~~~~~~~~~~~~~~

                    What if an Explicit Intent is used to invoke an Activity from another application package?

                    Say, if MainActivity invokes an Activity called ExternalActivity from a different application package
                    In that case, how can a constant defined in ExternalActivity be accessed? for eg. ExternalActivity.EXTRA_MESSAGE
                    defined in ExternalActivity
                 */
                startSecondActivityForResultIntent.putExtra(SecondActivity.EXTRA_MESSAGE, R.string.message2);
                startSecondActivityForResultIntent.putExtra(SecondActivity.INFORM_MESSAGE, R.string.inform_message);

                /*
                    startActivityForResult(intent, requestCode)

                    is used when the Parent Activity expects the Child Activity to send it results,
                    which is handled by

                        protected void onActivityResult(int requestCode, int resultCode, Intent data)

                    callback defined below

                    The requestCode is sent to the child activity which returns it back to the parent Activity
                        when sending the results

                    It is used when the parent Activity starts more than one Child Activity to
                        identify which child activity is responding with the results
                 */
                startActivityForResult(startSecondActivityForResultIntent, 0);

                /*
                    startActivityForResult() method is an asynchronous call i.e.
                    the execution continues after the method call
                 */
                Log.d(TAG, "startActivityForResult() is an ASYNCHRONOUS call");
            }
        });
```

### Flow Diagram

<img src="https://github.com/gruprog/Android-Examples/blob/master/Activities/ActivityCallingActivity/_misc/block%20diagram.png"/>
