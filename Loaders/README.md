# Loaders

Loaders are the recommended way of loading data from data sources.

### Issues with Data Loading tasks in Activities and Fragments 

* Data loading tasks in Activities and Fragments could potentially take longer on an application's main thread resulting in an ANR message.
* When performing data loading tasks in Activities and Fragments, the tasks have to be programmed in accordance with the life cycle events of the Activities and Fragments. 
	A programmer must take into consideration the life cycle events that would occur when a component is restarted due to a configuration change, or destroyed by the system to reclaim memory or is partially obscured. 

### Key Points

* Loaders simplify the process of asynchronously loading data in an activity or a fragment. 
* Loaders are not destroyed and reconstructed on configuration changes, which eliminates the need for requerying the dataset after configuration changes.



