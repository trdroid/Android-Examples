# Preferences

Android provides the Preferences system as a way of persisting simple key/value pairs across Activity lifecyles. 

The key values MUST be strings, and the values MUST be one of the Java's primitive data types such as

* int
* boolean

A subclass of *PreferenceActivity* 

* loads preferences from resource XML files

Changes made with Android 3.0 (Honeycomb)

*PreferenceActivity* and *PreferenceFragment*

* loads preference headers from resource XML files

The Android support library for older versions does not provide support for the changes made with Android 3.0. 
The support library does not mimic the new changes to Preferences introduced with Android 3.0 on older Android versions.

**System-wide Preferences**

*PreferenceManager* instance

*getDefaultSharedPreferences()* method which takes a context

Returns a *SharedPreferences* object.

**Application-level Preferences**

*PreferenceManager* instance

*getSharedPreferences()* method

It takes a privacy marker and the name of the preference set. This allows multiple preference sets to be created at the application level.

Returns a *SharedPreferences* object.

**Actvity-level Preferences**

*PreferenceManager* instance

*getPreferences()* method

Returns a *SharedPreferences* object.

### Persisting Preferences

Calling the *edit()* method on a *SharedPreferences* object returns an instance of *SharedPreferences.Editor*, which acts as an editor for the preferences.

The *SharedPreferences.Editor* instance has

* setter methods like *setBoolean()*, *setString()*
* *commit()*: saves the changes made to preferences by the setter methods. It returns a Boolean indicating success or failure.
* *apply()*: is a fire-and-forget *commit()* that does not return the success/failure status. 
* *remove()*: purges a single preference key/value pair.
* *clear()*: deletes all of the preference key/value pairs.

The call to *commit()* or *apply()* is instant. 
The preferences set and committed in a fragment of a visible activity are instantly visible in other fragments of the same activity.

### Incorporating Preferences

The preferred way of using preferences is through the use of *PreferenceActivity* and *PreferenceFragment* contexts. 
This makes the interface of preferences and their usage consistent to the users across the apps in the system. 
