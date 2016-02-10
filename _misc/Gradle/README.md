### Definitions

<b>Projects</b>: A build file contains atleast one project. Generally, a build file, conventionally called <i>build.gradle</i>, represents a single project. A project contains one or more tasks. 

<b>Tasks</b>: Every project contains one or more tasks. Tasks are defined in a build script and contain a list of Actions to perform.

<b>Actions</b>: An Action is a block of code and is analagous to a method in Java. Actions are contained in Tasks and are executed in order. 

### Build configuration file

To build a project, Gradle expects a <i>build.gradle</i> file. This is the file where the build is configured. Every <i>build.gradle</i> file represents a project.

A build file for Android, at a minimum requires the following elements.
* a build script block
* a repositories block
* a dependencies block

```groovy
buildscript {
	repositories {
		jcenter()
	}

	dependencies {
		classpath 'com.android.tools.build:gradle:1.2.3'
	}
}
```

In the repositories block, a preconfigured Maven repository, JCenter acts as a source of dependencies for the build script.
Like JCenter, several other repositories are provided by Gradle which requires no extra setup.

Custom local or remote repositories can be configured as well.


