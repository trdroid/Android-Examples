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
where x > y

Choose a minimum SDK that allows your app to be available for a wider audience. 

For example, choosing 

> <i> Target SDK Version </i>

Target SDK specifies the API level that the app is designed to run on. 

If an app is released for API level x and the Android OS has released API level y, where x < y, the new features of 
API level y are ignored and the app appears and behaves as it is still running on Android API level x. 

Whenever there is a new version of Android (for eg. level y), the app has to be tested against it to see if it works 
as expected. 

The following link contains changes to APIs across API levels: http://developer.android.com/reference/android/os/Build.VERSION_CODES.html

The code has to be modified accordingly to ensure it runs on latest android versions as well. 

<i> Both the Minimum SDK and Target SDK versions are added to the manifest file to convey these values to the Android OS </i>

> <i> Compile SDK Version (Build Target) </i>


