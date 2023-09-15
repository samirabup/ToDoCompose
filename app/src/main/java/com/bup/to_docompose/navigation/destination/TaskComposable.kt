package com.bup.to_docompose.navigation.destination

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bup.to_docompose.ui.screens.task.TaskScreen
import com.bup.to_docompose.util.Action
import com.bup.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import com.bup.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){ navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.d("TaskComposable", taskId.toString())
        
        TaskScreen(navigateToListScreen = navigateToListScreen)

    }
}