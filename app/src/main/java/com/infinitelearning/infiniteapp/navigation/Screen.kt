package com.infinitelearning.infiniteapp.navigation

sealed class Screen (val route: String){
    data object OnBoarding : Screen("onboarding")
    data object Login : Screen("login")
    data object Home : Screen("home")
    data object Gallery: Screen("gallery")
    data object Course: Screen("course")
    data object Detail: Screen("detail_mentors")
    data object Movie: Screen("movie")
    data object Splash: Screen("splash")
    data object Task : Screen("task")
    data object AddTask : Screen("add_task")
    data object DetailTask : Screen("detail_task/{title}") {
        fun createRoute(title: String) = "detail_task/$title"
    }
    data object Alarm: Screen("alarm")
}