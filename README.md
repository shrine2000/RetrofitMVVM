# RetrofitMVVM

This is an Android application that displays a list of users retrieved from an API. The app uses the Model-View-ViewModel (MVVM) architecture, Retrofit for networking, and Kotlin Coroutines for asynchronous programming.

## Installation

1.  Clone the repository using 
			 `git clone https://github.com/<username>/UserListApp.git`
2.  Open the project in Android Studio
3.  Build the project using `Build > Make Project`
4.  Run the app on an emulator or physical device using `Run > Run 'app'`

## Dependencies

The app has the following dependencies:

-   Retrofit: For networking
-   Kotlin Coroutines: For asynchronous programming
-   Coil: For image loading and caching
-   RecyclerView: For displaying the list of users
-   ViewModel: For implementing the ViewModel layer of the MVVM architecture
-   LiveData: For handling data updates in the ViewModel layer
-   Navigation: For navigating between screens in the app

## Usage

When the app is launched, it fetches a list of users from the API and displays them in a RecyclerView. Each item in the list displays the user's name, email, and profile picture. Clicking on an item expands it to show the user's salary.

The app has a refresh button that allows the user to refresh the list of users. If there is an error while fetching the users, an error message is displayed on the screen.

## Architecture

The app uses the MVVM architecture to separate concerns and make the code more testable and maintainable. The three layers of the architecture are:

-   **Model**: The model layer contains the data and business logic of the app. In this app, the model layer consists of the `User` data class and the `UserService` class, which fetches the list of users from the API using Retrofit.
-   **View**: The view layer contains the UI elements of the app. In this app, the view layer is implemented using the `MainActivity` and the `UserListAdapter`.
-   **ViewModel**: The ViewModel layer acts as the mediator between the model and view layers. In this app, the ViewModel layer is implemented using the `ListViewModel`, which fetches the list of users from the `UserService` and exposes the list of users to the view layer using LiveData.

## Conclusion

This app demonstrates the use of the MVVM architecture, Retrofit, Kotlin Coroutines, and other Android libraries in building a simple yet functional Android app. 
