# Articles Demo
This repository contains a sample Android App that shows most popular articles data from NY Times API. This is a sample app that shows how different jetpack libraries interact with each other. The app code follows SOLID principles by implementing Clean Architecture. The basic purpose of this project is to show how Android apps are structured and developed at [DevCrew.IO](https://devcrew.io/).

## Clean Architecture Implementation 
The project has the following three packages.
- **Data**
Layer that contains repositories, API (Network), Persistence DB.
- **Domain**
Layer that  contains Entities, Use Cases, and Repository interfaces.
- **Presentation**
Layer that contains UI related stuff like Views and ViewModel etc

## Screenshorts

Home                       |  Detail                    
:-------------------------:|:-------------------------
[![Screenshot-1642145363-3-20.png](https://i.postimg.cc/W4GNvLRB/Screenshot-1642145363-3-20.png)](https://postimg.cc/t1gQ3c4k) | [![Screenshot-1642145353-1-20.png](https://i.postimg.cc/7hfrbjcY/Screenshot-1642145353-1-20.png)](https://postimg.cc/ctybbk0V)
## Build With
This project follow MVVM base Clean Architecture. The following tools and technologies have been used to develop:

### Tools and Technology

|**Tool**|**Version**|
| :- | :- |
|Android Studio|Arctic Fox 2020.3.1|
|Kotlin|1.6.10|
|XML||
|Gradle|7.0.4|
|JDK|11|

### JetPack Libraries
The following libraries have used in this project:
- Hilt DI
- DataBinding, ViewBinding
- Navigation Component
- ViewModel
- LiveData
- Retrofit2
- Kotlin Coroutines
- Lifecycle aware 

## Getting Starting

### Prerequisite
Before you set up the project please make sure you have installed required min versions of tools installed mentioned in above **Development Tools table**. Otherwise you may come to build errors.

### Installation
Here are simple steps to setup project:

- Clone the repo

|https://github.com/WaseemAbbas-DevCrew/articles-demo.git|
| - |
- Make sure you have checked out master branch
- Open project in your preferred IDE (Android Studio)

### Usage
You can run and test the app on Android devices. To build and & run the app simply press the RUN button from Android Studio.

## Author
Waseem Abbas (Sr. Software Engineer at [DevCrew.IO](https://devcrew.io/)).

## Contributing
Contributions, issues, and feature requests are welcome!

## Show your Support
Give a start if this project helped you.

## License
Copyright © 2022, [DevCrew.IO](https://devcrew.io/)
