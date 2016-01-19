# Dialogs

A Dialog is a smaller window that appears on top of the active window to display an urgent message or to prompt the user 
for an input (text, time, date and the like), or to report statuses like the progress of a file download. 

Dialogs in Android are asynchronous. The code following the line that causes a dialog to appear executes immediately. 
Any user interaction with the dialogs has to be handled by implementing respective callbacks.

Custom Dialogs can be coded apart from the built-in dialogs, a few of which are:
* Alert
* Prompt
* Time Picker
* Date Picker
* Single Choice
* Multiple Choice
* Pick List

Dialog based fragments were added in Android 3.0. However, they are made available for pre-Android 3.0 by the Fragment-Compatibility library.



