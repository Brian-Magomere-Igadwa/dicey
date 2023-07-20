package design.fiti.dicey.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import design.fiti.dicey.R
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThemedScreen(modifier: Modifier = Modifier, color: Color) {

    LazyVerticalStaggeredGrid(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        columns = StaggeredGridCells.Fixed(2)
    ) {
        this.items(60) {
            Box(
                modifier = Modifier
                    .height(randomizeHeights().dp)
                    .width(100.dp)
                    .padding(4.dp)
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


private fun randomizeHeights(): Int = Random.nextInt(80, 180)