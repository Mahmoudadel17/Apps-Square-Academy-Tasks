# $\color{#3DDC84}{CimaCorner App}$  <img height="40" src="https://user-images.githubusercontent.com/25181517/117269608-b7dcfb80-ae58-11eb-8e66-6cc8753553f0.png" />

## $\color{#d71b3b}{🚀 About}$

CimaCorner is an app for presenting movies, including categorization, overviews, and ratings with search functionality.



## $\color{#e8d71e}{💡 Features}$

1) **Listing**: the movies are rendered in lists (grid) filtered by genre into tabs.

   . The tabs are loaded from /genre/movie/list endpoint
   
   . All is an extra tab in the beginning where no filtering is applied
   
   . The user can select any tab or swipe to the adjacent tabs
   
   . On Selecting each tab the movies list is loaded and filtered using the corresponding genre
   
   . Show the image, name & year of production for each movies item
   
   . As the user scrolls down the next page is loaded until they reach the end. I.e. Implement infinite scrolling.

2) **Details**: The user can view the movie details in a separate page.

   . If the user clicks on a movie item from the list, they are redirected to a new page where the details of that movies are shown
   
   . The page shows all the movie’s image/ poster, name, year of production, rating, description, cast (if available)
   
   . A toolbar bar is shown on top, and has a back arrow to navigate back, and the movie title is shown too.

3) **Search**: The user can search for a specific movie

   . user can enter any "query" and search will return all movies contain this query.

   
## $\color{#16acea}{💻 Technologies}$


- Architecture: The app follows the MVVM (Model-View-ViewModel) architecture, which promotes a clear separation of concerns and facilitates easier testing and scalability.

- Clean Architecture: The app is structured using the Clean Architecture principles, separating the application into distinct layers - Presentation, Domain, and Data - to achieve modularity and maintainability.

- User Interface: The user interface is built using Jetpack Compose, a modern Android UI toolkit that simplifies and accelerates UI development through a declarative approach.

- Navigation: The Navigation component is employed to manage navigation within the app. It provides a consistent and predictable way to navigate between different screens.

- Network Communication: Retrofit is employed for handling network requests. It provides a convenient and efficient way to communicate with APIs and retrieve data from remote servers.
  
- Concurrency: Coroutines are used to manage asynchronous operations and simplify concurrency handling. They enable smoother execution of tasks without blocking the main thread.

- Dependency Injection: Hilt is utilized for dependency injection. It simplifies the process of managing dependencies and enhances the testability and maintainability of the codebase.

- Image Loading: Images are loaded efficiently using the Coil library, which handles image caching and loading with ease.

- Animations: Lottie animations are integrated into the app to provide visually appealing and interactive animations that enhance the user experience.


## $\color{#4203c9}{📷 Screenshots}$


[<img src="/screenShots/Splash.PNG" align="left"
width="200"
    hspace="10" vspace="10">](/screenShots/Splash.PNG)

[<img src="/screenShots/Loading.PNG" align="left"
width="200"
    hspace="10" vspace="10">](/screenShots/Loading.PNG)
    
[<img src="/screenShots/Home.PNG" align="center"
width="200"
    hspace="10" vspace="10">](/screenShots/Home.PNG)

[<img src="/screenShots/Search.PNG" align="left"
width="200"
    hspace="10" vspace="10">](/screenShots/Search.PNG)

[<img src="/screenShots/NoInternet.PNG" align="center"
width="200"
    hspace="10" vspace="10">](/screenShots/NoInternet.PNG)






## $\color{blue}{Author}$

- [@Mahmoudadel17](https://www.github.com/Mahmoudadel17)
