package com.bup.to_docompose.navigation

import androidx.navigation.NavHostController
import com.bup.to_docompose.util.Action
import com.bup.to_docompose.util.Constants.LIST_SCREEN
import com.bup.to_docompose.util.Constants.SPLASH_SCREEN

class Screens (navController: NavHostController) {

    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION.name}") {
            popUpTo(SPLASH_SCREEN){ inclusive = true}
        }
    }
    val list:(Int) ->  Unit = {taskId ->
        navController.navigate(route = "task/$taskId")
    }

    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true}
        }
    }


}