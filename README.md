# ⚽ LeagueView — LaLiga Standings App

LeagueView is a modern **Android application built with Jetpack Compose** that displays **LaLiga football standings and team details** using a clean UI and scalable MVVM architecture.

The project focuses on **correct API handling**, **state-driven UI**, and **real-world architectural decisions** while avoiding common pitfalls like uncontrolled recomposition and redundant network calls.

---

## 📱 Features

- 🏆 View **LaLiga standings**
- 🔍 Dedicated **Team Details screen**
- 🧠 Separate ViewModels for Home & Details screens
- 🖼️ Image-based stat tiles with text overlay
- 🔐 Secure API key handling
- 🎨 Built fully with **Jetpack Compose (Material 3)**

---

## 🧱 Tech Stack

- **Language**: Kotlin  
- **UI**: Jetpack Compose + Material 3  
- **Architecture**: MVVM  
- **Networking**: Retrofit + OkHttp  
- **Dependency Injection**: Hilt  
- **Async**: Kotlin Coroutines  
- **Images**:
  - `painterResource()` → local images  
  - Coil → network images  

---

## 🗂️ Project Structure

```text
com.example.leagueview
│
├── data
│   ├── model          // Standing, Team, Stats
│   ├── remote         // Retrofit API
│   ├── repo           // Repository layer
│   └── utils          // UiState, Constants
│
├── di
│   └── AppModule      // Retrofit & Repo providers
│
├── view
│   ├── components     // Reusable composables
│   ├── screens
│   │   ├── home       // HomeScreen
│   │   └── details    // DetailsScreen
│   └── navigation     // NavGraph
│
├── vm
│   ├── HomeScreenViewModel
│   └── DetailsScreenViewModel
│
└── ui
    └── theme
