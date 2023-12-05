package me.mathazak.mywellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableIntStateOf(0) }
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask)
                WellnessTaskItem(taskName = "take your 15 min walk", onClose = { showTask = false })
            Text(text = "number of glasses: $count")
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10,
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = "Add one")
            }
            Button(
                onClick = { count = 0; },
                enabled = count < 10,
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = "Reset counter")
            }
        }
    }
}