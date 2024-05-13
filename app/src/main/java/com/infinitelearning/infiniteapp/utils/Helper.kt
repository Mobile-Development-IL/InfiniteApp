package com.infinitelearning.infiniteapp.utils

import com.infinitelearning.infiniteapp.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Course.route,
        Screen.Gallery.route,
        Screen.Movie.route
    )
}