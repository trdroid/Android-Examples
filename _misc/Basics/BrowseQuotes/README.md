# MVC Components

### Activity 

An activity is an instance of the Activity class offered by the Android SDK. It acts as a controller 
as it manages user interactions with the View.

### Layout

A layout file defines the view of an application. It is an XML file that defines a set of UI objects (buttons, images, text) and their layouts commonly referred to as Widgets. 

A Widget is an instance of the <b>View</b> class or one of its subclasses.

<img src="https://github.com/gruprog/Android-Examples/blob/master/_misc/Basics/BrowseQuotes/_misc/ViewClassGeneralHierarchy.png">

Some examples of Widgets are ListView, TableLayout, LinearLayout, FrameLayout, RelativeLayout, TextView, Button etc.

The following layout file contains 5 widgets; 2 LinearLayouts, 2 Buttons and a TextView

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="@string/quote1" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/previous_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/previous" />

        <Button
            android:id="@+id/next_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/next" />
    </LinearLayout>
</LinearLayout>
```
As of ADT 21, the following line is not required in the layout files

```xml
<?xml version="1.0" encoding="utf-8"?> 
```

Every widget has a corresponding XML element in the layout file where the name of the element is the widget type. Each widget could be configured with a set of XML attributes.

<img src="https://github.com/gruprog/Android-Examples/blob/master/_misc/Basics/BrowseQuotes/_misc/layout_file.png">

### View Hierarchy

The widgets provided in the layout file exist in a hierarchy of View objects, referred to as the view hierarchy. 

<img src="https://github.com/gruprog/Android-Examples/blob/master/_misc/Basics/BrowseQuotes/_misc/ViewHierarchy.png">

### Inflating a View

<img src="https://github.com/gruprog/Android-Examples/blob/master/_misc/Basics/BrowseQuotes/_misc/layout_to_view_objects.png">

# Block Diagram

<img src="https://github.com/gruprog/Android-Examples/blob/master/_misc/Basics/BrowseQuotes/_misc/MVC.png">

# Running the app

1) Navigate to the root of the project directory

2) Give execute permission to gradle

```sh
chmod +x gradlew
```

3) Compile the code

```sh
./gradlew assembleDebug
```

4) Install the apk using ADB

```
adb install -r app/build/outputs/apk/app-debug-unaligned.apk
```

The -r switch will overwrite on an existing app

5) Run the app

```
adb shell am start -n <package name>/<fully qualified class name of the main activity>
```

Use adb with the Activity Manager (am) tool to run the main activity

### The Manifest File

<i>app/src/main/AndroidManifest.xml</i>

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.droid.browsequotes" >

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme" >
        <activity android:name="com.example.droid.browsequotes.MainActivity" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```



<b> Significance of the package name </b>

The .apk file is uniquely identified by the package name that follows java's package naming convention. The package name defines the application's identity and cannot be changed once the app is published.

The package name gets reserved for a developer when the developer signs and registers the app with various app publishers. 
This implies that the developer alone can update the app once it is deployed.

<b> Process name and User ID </b>

Android assigns a process to run the components of an app (an apk package) and names it after the package name.

Android assigns a unique user ID for the process/apk package (used interchangeably, as the apk package is associated with a process), which is the user ID for the underlying Linux OS. The user ID is determined when the app is installed on a device and needless to say the user ID could be different on each device where it is installed. Any resources created by the process/apk package are secured under the assigned Linux user ID. 

The process name and the user id of an app can be found from Dev Tools as shown below.

Notice how the process name matches the package name given in the manifest file. The package summary also displays the components inside the package (apk package). 

<img src="_misc/package%20summary.png"/>


### Deployment

The .apk file of this app is signed and deployed to a device/emulator. The signature is associated with the package name and secures data that belongs to the package. 

A package is generally signed with a self-signed PKI (Public Key Infrastructure) certificate, which identifies the author of the package. 

