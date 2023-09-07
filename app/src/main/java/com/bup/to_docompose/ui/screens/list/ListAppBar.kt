package com.bup.to_docompose.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bup.to_docompose.ui.theme.topAppBarBackgroundColor
import com.bup.to_docompose.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar(){
DefaultListAppBar()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(){
    TopAppBar(
        title = {
            Text(text = "Tasks", color = MaterialTheme.colorScheme.topAppBarContentColor)
        },
      Modifier.background(MaterialTheme.colorScheme.topAppBarBackgroundColor)
    )
}

@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar()
}