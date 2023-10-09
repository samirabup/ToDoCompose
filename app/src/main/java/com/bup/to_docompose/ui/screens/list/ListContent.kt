package com.bup.to_docompose.ui.screens.list

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bup.to_docompose.R
import com.bup.to_docompose.data.models.Priority
import com.bup.to_docompose.data.models.ToDoTask
import com.bup.to_docompose.ui.theme.HighPriorityColor
import com.bup.to_docompose.ui.theme.LARGEST_PADDING
import com.bup.to_docompose.ui.theme.LARGE_PADDING
import com.bup.to_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.bup.to_docompose.ui.theme.TASK_ITEM_ELEVATION
import com.bup.to_docompose.ui.theme.taskItemBackgroundColor
import com.bup.to_docompose.ui.theme.taskItemTextColor
import com.bup.to_docompose.util.RequestState
import com.bup.to_docompose.util.SearchAppBarState

@ExperimentalMaterial3Api
@Composable
fun ListContent(
    allTasks: RequestState<List<ToDoTask>>,
    searchedTasks: RequestState<List<ToDoTask>>,
    lowPriorityTasks: List<ToDoTask>,
    highPriorityTasks: List<ToDoTask>,
    sortState: RequestState<Priority>,
    searchAppBarState: SearchAppBarState,
    navigationToTaskScreen: (taskId: Int) -> Unit
){
    if (sortState is RequestState.Success){
            when{
                searchAppBarState == SearchAppBarState.TRIGGERED -> {
                    if (searchedTasks is RequestState.Success){
                        HandelListContent(
                            tasks = searchedTasks.data,
                            navigationToTaskScreen = navigationToTaskScreen
                        )
                    }
                }
                sortState.data == Priority.NONE -> {
                    if (allTasks is RequestState.Success) {
                        HandelListContent(
                            tasks = allTasks.data,
                            navigationToTaskScreen = navigationToTaskScreen
                        )
                    }
                }
                sortState.data == Priority.LOW -> {
                    HandelListContent(
                        tasks = lowPriorityTasks,
                        navigationToTaskScreen = navigationToTaskScreen
                    )
                }
                sortState.data == Priority.HIGH -> {
                    HandelListContent(
                        tasks = highPriorityTasks,
                        navigationToTaskScreen = navigationToTaskScreen
                    )
                }
            }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HandelListContent(
    tasks: List<ToDoTask>,
    navigationToTaskScreen: (taskId: Int) -> Unit
){
    if (tasks.isEmpty()) {
        EmptyContent()
    } else {
        DisplayTasks(
            tasks = tasks,
            navigationToTaskScreen = navigationToTaskScreen
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun DisplayTasks(
    tasks: List<ToDoTask>,
    navigationToTaskScreen: (taskId: Int) -> Unit
){
    LazyColumn(
        contentPadding = PaddingValues(all = LARGE_PADDING),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(
            items = tasks,
            key = { task ->
                task.id
            }
        ){ task ->
//            val dismissState = rememberDismissState()
//            val degrees by animateFloatAsState(
//                if (dismissState.targetValue == DismissValue.Default)
//                    0f
//            else
//                -45f
//            )
//            SwipeToDismiss(
//                state = dismissState,
//                directions = setOf(DismissDirection.EndToStart),
//                dismissThresholds = { FractionalThreshold(fraction = 0.2f)},
//                background = { RedBackground(degrees = degrees)},
//                dismissContent = {
//
//                }
//            )
        }
    }
}

@Composable
fun RedBackground(degrees: Float){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(HighPriorityColor)
        .padding(horizontal = LARGEST_PADDING),
    contentAlignment = Alignment.CenterEnd
    ){
        Icon(
            modifier = Modifier.rotate(degrees = degrees),
            imageVector = Icons.Filled.Delete ,
            contentDescription = stringResource(id = R.string.delete_icon),
            tint = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigationToTaskScreen: (taskId: Int) -> Unit
){
    Surface (
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.taskItemBackgroundColor,
        shape = RectangleShape,
        tonalElevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigationToTaskScreen(toDoTask.id)
        }
    ){
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row() {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colorScheme.taskItemTextColor,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE)
                    ){
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colorScheme.taskItemTextColor,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TaskItemPreview(){
    TaskItem(
        toDoTask = ToDoTask(
            id = 0,
            title = "Title",
            description = "Some random text",
            priority = Priority.MEDIUM
        ),
        navigationToTaskScreen = {}
    )
}