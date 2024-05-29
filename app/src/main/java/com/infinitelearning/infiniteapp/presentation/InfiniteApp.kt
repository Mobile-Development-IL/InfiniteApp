package com.infinitelearning.infiniteapp.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrowseGallery
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Topic
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.navigation.NavigationItem
import com.infinitelearning.infiniteapp.navigation.Screen
import com.infinitelearning.infiniteapp.presentation.component.shareItem
import com.infinitelearning.infiniteapp.presentation.screen.course.CourseScreen
import com.infinitelearning.infiniteapp.presentation.screen.detail.DetailMentorScreen
import com.infinitelearning.infiniteapp.presentation.screen.gallery.GalleryScreen
import com.infinitelearning.infiniteapp.presentation.screen.home.HomeScreen
import com.infinitelearning.infiniteapp.presentation.screen.login.LoginScreen
import com.infinitelearning.infiniteapp.presentation.screen.maps.MapsScreen
import com.infinitelearning.infiniteapp.presentation.screen.movie.MovieScreen
import com.infinitelearning.infiniteapp.presentation.screen.onboarding.OnBoardingScreen
import com.infinitelearning.infiniteapp.presentation.screen.splash.SplashScreen
import com.infinitelearning.infiniteapp.presentation.screen.task.AddTaskScreen
import com.infinitelearning.infiniteapp.presentation.screen.task.DetailTaskScreen
import com.infinitelearning.infiniteapp.presentation.screen.task.TaskScreen
import com.infinitelearning.infiniteapp.utils.shouldShowBottomBar
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfiniteApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    Scaffold(
        topBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar(),
            ) {
                TopAppBar(
                    title = { Text(text = "Infinite App") },
                    actions = {
                        IconButton(onClick = { shareItem(context) }) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = stringResource(id = R.string.menu_share)
                            )
                        }
                        IconButton(onClick = {
                                navController.navigate(Screen.Maps.route)
                        }) {
                            Icon(imageVector = Icons.Default.Map, contentDescription = "maps")
                        }
                    }
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(navController = navController)
            }

            composable(Screen.OnBoarding.route) {
                OnBoardingScreen(navController = navController)
            }

            composable(Screen.Login.route) {
                LoginScreen(navController)
            }

            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }

            composable(Screen.Gallery.route) {
                GalleryScreen()
            }

            composable(Screen.Course.route) {
                CourseScreen()
            }

            composable(
                Screen.Detail.route + "/{mentorId}",
                arguments = listOf(navArgument("mentorId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailMentorScreen(
                    navController = navController,
                    mentorsId = navBackStackEntry.arguments?.getInt("mentorId")
                )
            }
            composable(Screen.Movie.route) {
                MovieScreen()
            }

            composable(Screen.Task.route) {
                TaskScreen(navController = navController)
            }

            composable(Screen.AddTask.route) {
                AddTaskScreen(navController = navController)
            }

            composable(
                route = Screen.DetailTask.route,
                arguments = listOf(
                    navArgument("title") { type = NavType.StringType }
                )
            ) {
                val titleFile = it.arguments?.getString("title") ?: ""

                DetailTaskScreen(
                    titleFile = titleFile, navController = navController
                )
            }

            composable(Screen.Maps.route) {
                MapsScreen(navController = navController)
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_gallery),
                icon = Icons.Default.BrowseGallery,
                screen = Screen.Gallery
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_course),
                icon = Icons.Default.Topic,
                screen = Screen.Course
            ),
            NavigationItem(
                title = stringResource(R.string.movie),
                icon = Icons.Default.Movie,
                screen = Screen.Movie
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfiniteAppPrev() {
    InfiniteApp()
}