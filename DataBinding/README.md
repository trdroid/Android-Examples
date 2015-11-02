# Data Binding

### Traditional Binding

* Inflate a layout XML in an Activity or Fragment
* Get a reference to the element from the layout to be updated with the data (using findViewById() method)
* Assign data to it from one or more data-sources

*Drawbacks*
A lot of boilerplate code which obscures the intent of the Activity or the Fragment class

### Google's DataBinding Library 

1. Create a binding class from the layout

2. Retrieve the data from one or more data sources 

3. Bind the data to the view using the binding class

*Benefits*
Uses code generation as opposed to reflection for better performance and easier debugging


### Alternatives

> Butter Knife
  
> RoboBinding

> Android Annotations

