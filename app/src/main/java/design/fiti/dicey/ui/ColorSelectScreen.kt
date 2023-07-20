package design.fiti.dicey.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import design.fiti.dicey.R

@Composable
fun ColorSelectScreen(
    modifier: Modifier = Modifier,
    randomizeColor: () -> Unit = {},
    color: Color = Color.White
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            IconButton(onClick = { randomizeColor }) {
                Box(
                    modifier = Modifier
                        .size(380.dp)
                        .background(color = color)
                )
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.next))
            }

        }
    }
}

@Preview
@Composable
fun ColorSelectScreenPrev() {
    ColorSelectScreen()
}