package com.bup.to_docompose.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bup.to_docompose.data.models.Priority
import com.bup.to_docompose.data.models.ToDoTask
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
    searchAppBarState: SearchAppBarState,
    navigationToTaskScreen: (taskId: Int) -> Unit
){
    if (searchAppBarState == SearchAppBarState.TRIGGERED) {
        if (searchedTasks is RequestState.Success){
            HandelListContent(
                tasks = searchedTasks.data,
                navigationToTaskScreen = navigationToTaskScreen
            )
        }
    } else {
        if (allTasks is RequestState.Success) {
            HandelListContent(
                tasks = allTasks.data,
                navigationToTaskScreen = navigationToTaskScreen
            )
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
            TaskItem(
                toDoTask = task,
                navigationToTaskScreen = navigationToTaskScreen
            )
        }
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