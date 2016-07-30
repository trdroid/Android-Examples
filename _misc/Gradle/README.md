### Definitions

<b>Projects</b>: A build file contains atleast one project. Generally, a build file, conventionally called <i>build.gradle</i>, represents a single project. A project contains one or more tasks. 

<b>Tasks</b>: Every project contains one or more tasks. Tasks are defined in a build script and contain a list of Actions to perform.

<b>Actions</b>: An Action is a block of code, analagous to a method in Java. Actions are contained in Tasks and are executed in order. 

### Build configuration file

To build a project, Gradle expects a <i>build.gradle</i> file. This is the file where the build is configured. Every <i>build.gradle</i> file represents a project.

A build file for Android, at a minimum requires the following elements.
* a build script block
* a repositories block
* a dependencies block

<i>\<project\>/build.gradle</i>

```gradle
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.3.0'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```

In the repositories block, a preconfigured Maven repository, JCenter acts as a source of dependencies for the build script.
Like JCenter, several other repositories are provided by Gradle which are preconfigured and requires no extra setup.

Custom local or remote repositories can be configured as well.

In the dependencies block, a dependency on Android build tools is defined as a classpath Maven Artifact. This is the source for the the Android plugin, which provides support for building and testing of applications and MUST be applied in EVERY android project. 


<i>\<project\>/app/build.gradle</i>

```gradle
apply plugin: 'com.android.application'

android {
    compileSdkVersion 23
    buildToolsVersion "23.0.2"

    defaultConfig {
        applicationId "com.example.droid.arrayadapterexample"
        minSdkVersion 15
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

### Plugins

Plugins extend build scripts by providing the properties, blocks and tasks defined in the plugin available to the build scripts. The defaults provided by the plugins can be configured in the build script. 

Every Android project requires to apply the Android plugin in the following way, as it provides everything required to build and test the applications.


### Build Variants

Build Variant is Build Type + Product Flavor

Production Version
Staging Version (Manually verifying functionality?)

### Build Types

The Android plugin for Gradle provides a *buildTypes* block that can be configured to define how an app or a library should be built.

Test string, Try again!
