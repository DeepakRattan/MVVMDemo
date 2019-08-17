# MVVMDemo
Demonstartion of MVVM(Model-View-ViewModel)

This project demonstrates the use of recommended app architecure(MVVM) for building robust, production-quality apps by Google.


To start, consider the following diagram, which shows how all the modules should interact with one another after designing the app:
![android-mvvm-architecture](https://user-images.githubusercontent.com/15645007/63212400-976b8b80-c121-11e9-93f4-beae4465d62a.png)

Notice that each component depends only on the component one level below it. For example, activities and fragments depend only on a view model. The repository is the only class that depends on multiple other classes.Repository depends on a persistent data model and a remote backend data source.

I have used the following components in this demo project:

1. Model
2. View
3. ViewModel
4. LiveData
5. Repository
6. DataBinding
7. Retrofit2 for API call

# 1. Repository : 

   A first idea for implementing the ViewModel might involve directly calling the Webservice
   to fetch the data and assign this data to our LiveData object. This design works, but by using it,
   our app becomes more and more difficult to maintain as it grows. It gives too much responsibility
   to the MovieListViewModel class, which violates the separation of concerns principle.
   Additionally, the scope of a ViewModel is tied to an Activity or Fragment lifecycle,
   which means that the data from the Webservice is lost when the associated UI object's
   lifecycle ends. This behavior creates an undesirable user experience.

   Instead, our ViewModel delegates the data-fetching process to a new module, a repository.

   Repository modules handle data operations. They provide a clean API so that the rest of
   the app can retrieve this data easily. They know where to get the data from and what API calls
   to make when data is updated. You can consider repositories to be mediators between different
   data sources, such as persistent models, web services, and caches.

   Repository abstracts the data sources from the rest of the app. Now, our MovieListViewModel
   doesn't know how the data is fetched, so we can provide the view model with data obtained from
   several different data-fetching implementations.   
   
# 2. View Model:

   A ViewModel object provides the data for a specific UI component,
   such as a fragment or activity.For example, the ViewModel can call other components(Repository)
   to load the data, and it can forward user requests to modify the data.
   The ViewModel doesn't know about UI components, so it isn't affected by
   configuration changes, such as recreating an activity when rotating the device.   
   
# 3. LiveData: 

LiveData is an observable data holder. Other components in your app can monitor changes to objects using this holder without creating explicit and rigid dependency paths between them. The LiveData component also respects the lifecycle state of your app's components—such as activities, fragments, and services—and includes cleanup logic to prevent object leaking and excessive memory consumption.
The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.

# 4. Data Binding:

The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.Android Data Binding library minimize the code for app logic with its UI view. It eliminates the need for these method calls “findViewById” and “setText.”.

Please refer to https://github.com/DeepakRattan/DataBindingDemo for the understanding of Data Binding in Android.

Source : https://developer.android.com/jetpack/docs/guide
