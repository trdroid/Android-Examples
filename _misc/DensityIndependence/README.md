# Density Independence

An application is said to be density independent, when it preserves the physical appearance of its UI elements when displayed across devices with different screen densities (i.e. with different ppis or dpis)

<i>Why is it important?</i>

Without density independence, the UI elements appear larger on lower-density screens and smaller on higher-density screens.


Android provides density independence to an application by scaling the following 

1) DIP units

2) drawable resources

### Density Independent Pixels (DIP)

DIP units are the recommended units for specifying layout dimensions and positioning UI elements to achieve 
density-independence across devices. 

Android scales the DIP units up or down to suit the screen density of a device. 

 


