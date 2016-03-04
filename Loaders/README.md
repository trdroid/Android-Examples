# Loaders

Loaders are the recommended way of loading data from data sources. 

### Issues with Data Loading tasks in Activities/Fragments 

* Data loading tasks in Activities/Fragments could potentially take longer on an application's main thread resulting in an ANR message.
* When performing data loading tasks in Activities/Fragments, the tasks have to be programmed in accordance with the life cycle events of the Activities and Fragments. 
	A programmer must take into consideration the life cycle events that would occur when an Activity is restarted due to a configuration change, or is destroyed by the system 
	to reclaim memory or is partially obscured.

### Predecessors

Managed Cursors were used prior to the introduction of Loaders in Android 3.0/API 11.

### How Loaders Help

Loaders simplify the process of loading data in an activity or a fragment asynchronously. 

* Loaders handle the ANR problem by performing the data loading tasks on worker threads
* Loaders provide callbacks to Activities and Fragments to respond to various events related to data loading tasks. 

### Key Points

* An Activity/Fragment can be associated with multiple Loaders, each associated with a different data source. 
* A Loader monitors its data source for changes and provides the data updates back to the Activity or Fragment it is associated with.
* Loaders are not destroyed and reconstructed on configuration changes, which eliminates the need for requerying the dataset after configuration changes.

### Using loaders in Activities and Fragments

An Activity or a Fragment uses a *LoaderManager* object to manage the loaders associated with it. 

* The loaders have to be registered with the LoaderManager.
* The Activity/Fragment 

