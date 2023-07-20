package design.fiti.dicey.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThemedScreen(modifier: Modifier = Modifier, color: Color) {
    val counter = listOf(1..60)
    LazyVerticalStaggeredGrid(
        modifier = modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2)
    ) {
        this.items(counter.size) {
            Box(
                modifier = Modifier
                    .height(randomizeHeights().dp)
                    .width(100.dp)
                    .background(color = color)
            )

        }
    }
}

@Preview
@Composable
fun ThemedPrev() {
    ThemedScreen(color = Color.Cyan)
}


private fun randomizeHeights(): Int = Random.nextInt(60, 180)