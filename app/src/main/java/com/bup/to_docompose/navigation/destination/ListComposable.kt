package com.bup.to_docompose.navigation.destination

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bup.to_docompose.ui.screens.list.ListScreen
import com.bup.to_docompose.ui.viewmodels.SharedViewModel
import com.bup.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import com.bup.to_docompose.util.Constants.LIST_SCREEN
import com.bup.to_docompose.util.toAction

@ExperimentalMaterial3Api
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){navBAckStackEntry ->
        val action = navBAckStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
            )
    }
}