package com.bup.to_docompose.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bup.to_docompose.ui.screens.splash.SplashScreen
import com.bup.to_docompose.util.Constants

fun NavGraphBuilder.splashComposable(
    navigateToTaskScreen: () -> Unit
){
    composable(
        route = Constants.SPLASH_SCREEN
    ){
        SplashScreen(navigateToListScreen = navigateToTaskScreen)
    }
}