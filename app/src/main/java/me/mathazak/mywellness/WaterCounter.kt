package me.mathazak.mywellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(
        counter = counter,
        onCounterChange = {
            counter++
        },
        modifier = modifier
    )
}

@Composable
fun StatelessCounter(counter: Int, onCounterChange: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (counter > 0) {
            Text(text = "number of glasses: $counter")
        }
        Button(
            onClick = { onCounterChange() },
            enabled = counter < 10,
            modifier = Modifier.padding(horizontal = 4.dp)
        ) {
            Text(text = "Add one")
        }
    }
}