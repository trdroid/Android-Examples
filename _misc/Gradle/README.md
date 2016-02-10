### Build configuration file

To build a project, Gradle expects a <i>build.gradle</i> file. This is the file where the build is configured.

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

