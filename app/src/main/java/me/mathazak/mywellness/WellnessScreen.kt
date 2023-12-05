package me.mathazak.mywellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier) {
        WaterCounter(modifier)
        WellnessTaskList(
            tasksList = wellnessViewModel.tasks,
            onCloseItem = { task -> wellnessViewModel.removeTask(task) },
            onCheckItem = {task, checked -> wellnessViewModel.changeTaskChecked(task, checked)}
        )
    }
}