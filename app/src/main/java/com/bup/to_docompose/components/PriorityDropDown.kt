package com.bup.to_docompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bup.to_docompose.data.models.Priority
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bup.to_docompose.R
import com.bup.to_docompose.ui.theme.PRIORITY_DROP_DOWN_HEIGHT

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f
    )
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .height(PRIORITY_DROP_DOWN_HEIGHT)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0f),
            shape = MaterialTheme.shapes.small
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .size(16.dp)
                .weight(weight = 1f)
        ){
            drawCircle(color = priority.color)
        }
        Text(
        modifier = Modifier
            .weight(weight = 8f),
            text =priority.name,
            style = MaterialTheme.typography.bodySmall
        )
        IconButton(
            modifier = Modifier
                .alpha(0.5f)
                .rotate(degrees = angle)
                .weight(weight = 1.5f),
            onClick = { expanded = true}) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(id =R.string.drop_down_arrow)
            )
        }
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.94f),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Priority.LOW.name },
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.LOW)
                }
            )
            PriorityItem(priority = Priority.LOW)

            DropdownMenuItem(
                text = { Priority.MEDIUM.name },
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.MEDIUM)
                }
            )
            PriorityItem(priority = Priority.MEDIUM)
            DropdownMenuItem(
                text = { Priority.HIGH.name },
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.HIGH)
                }
            )
            PriorityItem(priority = Priority.HIGH)
        }
    }
}

@Composable
@Preview
fun PriorityDropDownPreview(){
    PriorityDropDown(
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}
