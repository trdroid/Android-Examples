# Resource Qualifiers

https://developer.android.com/guide/practices/screens_support.html

**Screen Size**

Android provided support for multiple screen sizes and densities starting Android 1.6 (API Level 4). This feature can be used to customize an application's UI for each screen configuration.

*Screen Size* is the measurement of the diagonal length of a screen in inches.

Prior to Android 3.2 (API Level 13), Android categorized the screen sizes in *size constants* and provided the following resource qualifiers.

| Resource Qualifier        |   Generalized Screen Size         | Minimum Screen Resolution |
| ------------- |:-------------:| -----:|
| \<resource\>-small    | small screens | 426 dp x 320 dp |
| \<resource\>-medium      | normal screens     |  470 dp x 320 dp  |
| \<resource\>-large |  large screens    |   640 dp x 480 dp  |
| \<resource\>-xlarge |  xlarge screens    |  960 dp x 720 dp   |


*Issues with this categorization*

In Android 3.2 (API Level 13), a new set of resource qualifiers were introduced that are based on the actual screen dimensions in *dp units*. 

| Resource Qualifier          |  Description |
| ------------- |-----:|
| \<resource\>-sw___dp  | Screen with at least the specified Smallest Width irrespective of the orientation |
| \<resource\>-w___dp   |  Screen with at least the specified Width in the current orientation  |
| \<resource\>-h___dp | Screen with at least the specified Height in the current orientation  |



**Screen Density**

  The number of physical pixels contained in one inch area of the display screen. A physical pixel is an element of the 
  screen's hardware that generates 1 pixel. On LCD's, it would be one cell. On LED's, it would be one LED. 
  
  A screen with 120 pixels per inch is a low density screen.
  
  A screen with 240 pixels per inch is a high density screen.
  
  Screen Density is also given in DPI (Dots Per Inch)
  
Android categorizes the screen densities into the following <b>density constants</b>

| Qualifier        | Description           | dots per inch (dpi)  | Version  |
| ------------- |:-------------:| -----:|-----:|
|  LDPI     | low | ~120 dpi |  |
|  MDPI      | medium      |  ~160 dpi  |  |
|  HDPI  | high      |  ~240 dpi   |  |
| XHDPI | extra high      | ~320 dpi    |  |
| XXHDPI | extra extra high      |  ~480 dpi   | 4.2.2 |
| XXXHDPI | extra extra extra large      | ~640 dpi |  4.3  |

XXXHDPI was added in 4.3 to support 4K iTVs.

<b>Screen Resolution</b>:
  The total number of physical pixels along the X and Y axes specified as X x Y
  
  The screen resolution is generally specified with the parameters of the landscape orientation. For eg. 800x480 is 800 pixels along the X axis and 480 pixels along the Y axis in the landscape mode. If the device is changed to portrait orientation, the resolution specification changes to 400x800 (the new X x Y)
  
An Android application takes into account only the screen size and the screen density (through the use of the constants provided), but not the screen resolution. 

### Resource Qualifiers associated with Layouts

**Orientation based Resource Qualifiers associated with Layouts**

Orientation based resource qualifier associated with layouts allow Android to choose layouts based on orientation. Android provides the resource qualifiers *port* and *land* to allow developers to provide different layouts for portland and landscape orientations.

Android chooses a specific layout from 

* *res/layout/* or
* *res/layout-port/* or
* *res/layout-land/*

based on the orientation of the device. 

*Scenario*

1) Use a different layout based on the orientation of an Android device i.e. use a single pane in portrait mode and multi-pane layout in landscape mode. 

* Place default layouts in *res/layout/* directory.
* Place portrait-only layouts in *res/layout-port/* directory
* Place landscape-only layouts in *res/layout-land/* directory

**Screen Size based Resource Qualifiers associated with Layouts**

Android provides the *sw (smallestWidth)* qualifier to distinguish between a phone and a tablet. *smallestWidth* implies the smaller of the width and height irrespective of the orientation of the device.

*Scenario*



**Resource Qualifiers to handle different Android versions**

Resource qualifiers can be used to specify the usage of alternate resources based on the version of Android an app is running on. 

*Scenario*

Use different colors when an app is running on Android 4.1 than on Android 5. 

* Place default colors in *res/values/colors.xml*
* Place 4.1 (API 16) specific colors in *res/values-v16/colors.xml*

### Specifying Multiple Qualifiers

Multiple resource qualifiers can be specified for a single set of resources separated by dashes. 
