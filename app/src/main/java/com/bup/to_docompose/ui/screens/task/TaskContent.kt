package com.bup.to_docompose.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bup.to_docompose.R
import com.bup.to_docompose.components.PriorityDropDown
import com.bup.to_docompose.data.models.Priority
import com.bup.to_docompose.ui.theme.LARGE_PADDING
import com.bup.to_docompose.ui.theme.MEDIUM_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChanged: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
    paddingValues: PaddingValues
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = paddingValues.calculateTopPadding())
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = {onTitleChange(it)},
            label = { Text(text = stringResource(id = R.string.title) )},
            textStyle = MaterialTheme.typography.bodySmall,
            singleLine = true
        )
        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = MaterialTheme.colorScheme.background
        )
        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        Divider(
                modifier = Modifier.height(MEDIUM_PADDING),
        color = MaterialTheme.colorScheme.background
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChanged(it) },
            textStyle = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
@Preview
private fun TaskContentPreview(){
    TaskContent(
        title = "",
        onTitleChange = {},
        description ="" ,
        onDescriptionChanged = {},
        priority = Priority.LOW,
        onPrioritySelected = {},
        paddingValues = PaddingValues(all = LARGE_PADDING)
    )
}