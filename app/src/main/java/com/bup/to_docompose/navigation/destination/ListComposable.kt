package com.bup.to_docompose.navigation.destination

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bup.to_docompose.ui.screens.list.ListScreen
import com.bup.to_docompose.ui.viewmodels.SharedViewModel
import com.bup.to_docompose.util.Action
import com.bup.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import com.bup.to_docompose.util.Constants.LIST_SCREEN
import com.bup.to_docompose.util.toAction
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

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

        var myAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = myAction) {
            if (action != myAction){
                myAction = action
                sharedViewModel.action.value = action
            }
        }

        val databaseAction by sharedViewModel.action

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
            )
    }
}