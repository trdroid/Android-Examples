# Logging

Log.e(String tag, String msg)

A good practice is to use either the application name or the class name as a constant for the tag argument. 

### Log Levels 

The log levels in order of severity are:

ERROR - compiled into the app
 
WARN - compiled into the app

INFO - compiled into the app

DEBUG - are compiled in and are stripped out at runtime

VERBOSE - Should be compiled into the app ONLY during development time

Selecting a log level displays messages of the same severe level or higher. 
