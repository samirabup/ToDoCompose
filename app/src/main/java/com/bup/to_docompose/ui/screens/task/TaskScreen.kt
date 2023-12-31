package com.bup.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.bup.to_docompose.data.models.Priority
import com.bup.to_docompose.data.models.ToDoTask
import com.bup.to_docompose.ui.viewmodels.SharedViewModel
import com.bup.to_docompose.util.Action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String = sharedViewModel.title
    val description: String = sharedViewModel.description
    val priority: Priority = sharedViewModel.priority

    val context = LocalContext.current
    
   // BackHandler(onBackPressed = {navigateToListScreen(Action.NO_ACTION)})
    BackHandler {
        navigateToListScreen(Action.NO_ACTION)
    }

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context = context)
                        }
                    }
                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.updateTitle(newTitle = it)
                },
                description = description,
                onDescriptionChanged = {
                    sharedViewModel.updateDescription(newDescription = it)
                },
                priority = priority,
                onPrioritySelected = {
                    sharedViewModel.updatePriority(newPriority = it)
                },
                paddingValues = it
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty.",
        Toast.LENGTH_SHORT
    ).show()

}

//@Composable
//fun BackHandler(
//    backDispatcher: OnBackPressedDispatcher? =
//        LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
//    onBackPressed: () -> Unit
//){
//    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)
//
//    val backCallback = remember {
//        object : OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                currentOnBackPressed()
//            }
//        }
//    }
//
//    DisposableEffect(key1 = backDispatcher ){
//        backDispatcher?.addCallback(backCallback)
//
//        onDispose {
//            backCallback.remove()
//        }
//    }
//    
//}
