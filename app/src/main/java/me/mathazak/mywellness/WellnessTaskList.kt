package me.mathazak.mywellness

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.mathazak.mywellness.data.WellnessTask

@Composable
fun WellnessTaskList(
    tasksList: List<WellnessTask>,
    onCloseItem: (WellnessTask) -> Unit,
    onCheckItem: (WellnessTask, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(items = tasksList, key = { item -> item.id }) { task ->
            WellnessTaskItem(
                task = task,
                onClose = { onCloseItem(task) },
                onCheck = { checked: Boolean -> onCheckItem(task, checked) }
            )
        }
    }
}