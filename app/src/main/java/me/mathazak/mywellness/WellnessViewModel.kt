package me.mathazak.mywellness

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import me.mathazak.mywellness.data.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getSampleTasks().toMutableStateList()
    val tasks: List<WellnessTask> = _tasks

    fun removeTask(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == task.id }?.let { it.checked = checked }
    }
}

fun getSampleTasks() = List(30) { WellnessTask(it, "Task # $it") }