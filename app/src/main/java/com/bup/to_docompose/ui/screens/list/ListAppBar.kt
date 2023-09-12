package com.bup.to_docompose.ui.screens.list

import android.view.animation.AlphaAnimation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bup.to_docompose.R
import com.bup.to_docompose.data.models.Priority
import com.bup.to_docompose.ui.theme.topAppBarBackgroundColor
import com.bup.to_docompose.ui.theme.topAppBarContentColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.core.graphics.alpha
import com.bup.to_docompose.components.PriorityItem
import com.bup.to_docompose.ui.theme.LARGE_PADDING
import com.bup.to_docompose.ui.theme.TOP_APP_BAR_HEIGHT
import com.bup.to_docompose.ui.theme.Typography

@Composable
fun ListAppBar(){
//    DefaultListAppBar(
//        onSearchClicked = {},
//        onSortClicked = {},
//        onDeleteClicked = {}
//    )
    SearchAppBar(
        text = "Search" ,
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colorScheme.topAppBarContentColor
            )
        },
        Modifier.background(MaterialTheme.colorScheme.topAppBarBackgroundColor),
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        }
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction ( onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = { onSearchClicked()}
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_tasks),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
){
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true}
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_filter) ,
            contentDescription = stringResource(id = R.string.sort_tasks),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded ,
            onDismissRequest = { expanded = false }

        ) {
            DropdownMenuItem(
                text = {("")},
                onClick = {
                    expanded = false
                    onSortClicked(Priority.LOW)
                }
            )
            PriorityItem(priority = Priority.LOW)

            DropdownMenuItem(text = { ("") },
                onClick = {
                expanded = false
                onSortClicked(Priority.HIGH)
            })
            PriorityItem(priority = Priority.HIGH)

            DropdownMenuItem(text = { ("") },
                onClick = {
                expanded = false
                onSortClicked(Priority.NONE)
            })
            PriorityItem(priority = Priority.NONE)
        }
    }
}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
){
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_more),
            contentDescription = stringResource(id = R.string.delete_all_actions),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
        DropdownMenu(expanded = expanded,
            onDismissRequest = {
                expanded = false
            }) {
            DropdownMenuItem(text = { "Delete All" },
                onClick = {
                    expanded = false
                    onDeleteClicked()
            })
            Text(
                modifier = Modifier
                    .padding(start = LARGE_PADDING),
                text = stringResource(id = R.string.delete_all_actions),
                style = Typography.headlineSmall
                )
        }
        
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        color = MaterialTheme.colorScheme.topAppBarBackgroundColor
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text ,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(alpha = 0.1f),
                    text = "Search",
                    color = Color.Black
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.topAppBarContentColor,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(alpha = 0.5f),
                    onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colorScheme.topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        onCloseClicked()
                    }
                ) {
                    Icon(imageVector = Icons.Filled.Close ,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colorScheme.topAppBarContentColor
                    )
                    
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colorScheme.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}
@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Composable
@Preview
private fun SearchAppBarPreview(){
    SearchAppBar(
        text = "Search" ,
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}