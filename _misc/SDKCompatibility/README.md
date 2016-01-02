# Platform Versions and Compatibilities

http://developer.android.com/about/dashboards/index.html

NOTE: Android uses "SDK Versions" and "API Levels" interchangeably.

Consider the following gradle file for a sample app module:

> app/build.gradle

```groovy
apply plugin: 'com.android.application'

android {
    compileSdkVersion 23
    buildToolsVersion "23.0.2"

    defaultConfig {
        applicationId "com.example.droid.browsetext"
        minSdkVersion 16
        targetSdkVersion 23
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.1.1'
}
```

> <i> Minimum SDK Version </i>

If a device runs on Android of API level x, then an app set to a minimum SDK version of y cannot be installed on the device,
where x < y

An app with a minimum SDK version of 16 cannot be installed on devices running Android of API level < 16

Choose a minimum SDK that allows your app to be available for a wider audience. 

For example, choosing Minimum SDK Version to be 16, ensures that the app runs on API levels 4.1.x or higher. 

> <i>How about setting Minimum SDK to 1?</i>

Cost of creating the app to support different execution paths suitable for all API levels would be higher. 

Also, if your app relies on a hardware feature that only a later API level of Android supports, it is not possible to support the prior versions.

> <i> Target SDK Version </i>

Target SDK specifies the API level that the app is designed to run on and tested against. 

Apps with a certain target SDK are forward compatible with the future SDK versions of Android. If an app is released for API level x and the Android OS has released API level y, where x < y, Android ignores the new features of 
API level y and the app appears and behaves as if it is still running on Android API level x. 

Whenever there is a new version of Android (for eg. level y), the app has to be tested against it to see if it works 
as expected and to take advantage of the new features and optimizations of the latest SDK version. 

The following link contains changes to APIs across API levels: http://developer.android.com/reference/android/os/Build.VERSION_CODES.html

The code has to be modified accordingly to ensure it runs on latest android versions as well. 

<i> Both the Minimum SDK and Target SDK versions are added to the manifest file to convey these values to the Android OS </i>

> <i> Compile SDK Version (Build Target) </i>

This information is used by the compiler to resolve the classes and methods (including imports) used in the app. 

Each API level has classes and methods in its SDK. The Compile SDK version determines which SDK to be used to resolve 
the classes used in the app.

<i> When any of the aforementioned parameters are modified in the app's build.gradle file, the project must be synchronized with the changes in the gradle file. This can be done in Android Studio by Tools -> Android -> Sync Project with Gradle Files </i>

### Android Lint

> What if the Minimum SDK Version (x) is < Compile SDK Version (y) ?

The app can refer to classes new to API level y because at compile time the SDK version y is used to resolve classes used in the app. If the app is run on an Android device with API level x, it crashes when the app attempts to access a class that is available only in API level y.

In such scenarios, Android Lint would report a warning as the Lint uses the Minimum SDK Version to evaluate the code whereas the compiler uses the Compile SDK Version. 

To explicitly run the Lint in Android Studio, Analyze -> Inspect Code ...
