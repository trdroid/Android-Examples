### Terms 

<b>Screen Size</b>:
  The measurement of the diagonal size of a screen in inches

Android categorizes the screen sizes in <b>size constants</b> and provides the following qualifiers

| Qualifier        | Description           | Version  |
| ------------- |:-------------:| -----:|
|       | small |  |
|       | normal      |    |
|  | large      |     |
|  | extra large      |     |


<b>Screen Density</b>:
  The number of physical pixels contained in one inch area of the display screen. A physical pixel is an element of the 
  screen's hardware that generates 1 pixel. On LCD's, it would be one cell. On LED's, it would be one LED. 
  
  A screen with 120 pixels per inch is a low density screen.
  
  A screen with 240 pixels per inch is a high density screen.
  
  Screen Density is also given in DPI (Dots Per Inch)
  
Android categorizes the screen densities into the following <b>density constants</b>

| Qualifier        | Description           | Version  |
| ------------- |:-------------:| -----:|
|  LDPI     | low |  |
|  MDPI      | medium      |    |
|  HDPI  | high      |     |
| XHDPI | extra high      |     |
| XXHDPI | extra extra high      |  4.2.2   |
| XXXHDPI | extra extra extra large      |  4.3   |

XXXHDPI was added in 4.3 to support 4K iTVs.

<b>Screen Resolution</b>:
  The total number of physical pixels along the X and Y axes specified as X x Y
  
  The screen resolution is generally specified with the parameters of the landscape orientation. For eg. 800x480 is 800 pixels along the X axis and 480 pixels along the Y axis in the landscape mode. If the device is changed to portrait orientation, the resolution specification changes to 400x800 (the new X x Y)
  
An Android application takes into account only the screen size and the screen density (through the use of the constants provided), but not the screen resolution. 

