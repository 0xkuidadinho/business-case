# Android Support Exercise

This project is an Android application developed as part of an exercise to learn about Android development principles, including networking, Room database integration, and UI design. Below is a summary of the changes and improvements made throughout the development journey.

## Project Overview

The app loads a list of posts from a remote server via an API and displays them in a `RecyclerView`. The app also integrates a local Room database to store and retrieve a user’s data, showing the user's information on the main screen. 

## Key Changes and Updates

### 1. **API Integration with Retrofit**
   - Set up Retrofit to fetch data from a remote API.
   - Implemented `ApiService` interface with a `GET` request to retrieve posts.
   - Used `suspend` functions for network operations, leveraging Kotlin Coroutines for asynchronous calls.

### 2. **Room Database Setup**
   - Added Room database integration to store and retrieve user data.
   - Created a `User` entity and a `UserDao` interface for database operations.
   - Implemented a singleton pattern in the `AppDatabase` class to ensure a single instance of the database throughout the app.
   - In `AppDatabase`, added logic to insert a default user if no user data exists in the database.
   - Created a coroutine in the `AppDatabase` class to insert default user data asynchronously if the database is empty.

### 3. **ViewModel and LiveData Implementation**
   - Introduced `MainActivityViewModel` to manage the UI-related data in a lifecycle-conscious way.
   - Used `LiveData` to observe changes in user data and posts, which ensures the UI is updated automatically when data changes.
   - Used `MutableLiveData` for private data exposure and public getter methods (`LiveData`) to ensure proper encapsulation of data.

### 4. **UI Design and RecyclerView**
   - Designed the `activity_main.xml` layout to include an image view for displaying the user's image, a text view for displaying the user's name, and a `RecyclerView` to show the list of posts.
   - Set up a `RecyclerView` with a custom adapter (`PostAdapter`) to bind the posts to the UI.
   - Updated the `PostAdapter` to display post details such as the post ID and title, with a custom layout.

### 5. **Edge-to-Edge Support**
   - Implemented edge-to-edge display by adjusting window insets in the `MainActivity`.
   - Used the `ViewCompat.setOnApplyWindowInsetsListener` to correctly apply padding to the main view, ensuring that content is not hidden behind system UI elements like the status bar or navigation bar.

### 6. **Data Binding and Glide for Image Loading**
   - Used Glide to efficiently load and display user images from URLs.
   - Set up observers for user data and post data to update the UI when changes occur.

### 7. **Code Optimizations**
   - Ensured thread safety by using Kotlin Coroutines for database operations and network calls.
   - Made use of the `suspend` function in the API and DAO methods to perform long-running operations off the main thread.
   - Managed resources effectively by using `LiveData` to observe data changes, reducing the need for manual UI updates.

### 8. **Bug Fixes and Enhancements**
   - Fixed issues related to UI responsiveness by ensuring background tasks were properly offloaded to worker threads.
   - Ensured proper image loading and text binding by utilizing Android's standard libraries like Glide and `TextView`.

### 9. **Error Handling**
   - Added basic error handling to catch exceptions in network requests and database queries to ensure smooth app operation and prevent crashes.

### 10. **Refactor of ViewModel and Data Flow**
   - Refined the data flow between the `ViewModel`, `Repository`, and `Activity`.
   - Used proper encapsulation in the `ViewModel` to ensure that UI components do not directly access the data sources.
   - Observed LiveData from the `ViewModel` to update the UI asynchronously.

## How to Run the Project

To run the project locally, follow these steps:

1. **Clone the Repository**
   - Clone the repository to your local machine:
     ```bash
     git clone https://github.com/yourusername/Android-Support-Exercise.git
     ```

2. **Open the Project in Android Studio**
   - Open Android Studio and select "Open an existing Android Studio project."
   - Navigate to the folder where you cloned the repository and open the project.

3. **Build and Run**
   - Click the "Run" button (the green play icon) in Android Studio to build and run the project on an emulator or physical device.

## Libraries and Tools Used

- **Retrofit**: For network calls and API integration.
- **Room**: For local database integration and data persistence.
- **Glide**: For image loading and caching.
- **LiveData**: For observing changes in data.
- **Kotlin Coroutines**: For asynchronous operations.

## Future Enhancements

- Implement pagination for loading posts from the API to improve performance.
- Add additional error handling for network and database failures.
- Implement unit and UI tests to ensure app reliability.

