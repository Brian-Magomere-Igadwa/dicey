package design.fiti.dicey.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random


class DiceyViewModel:ViewModel() {
    private var _uiState = MutableStateFlow(DiceyUiState(currentColor = Color.Cyan))
    val uiState: StateFlow<DiceyUiState> = _uiState.asStateFlow()

    private fun setColor(color: Color) {
        _uiState.update {
            it.copy(currentColor = color)
        }
    }

    fun randomizeColor() {

        val color = Color(
            red = generateColorNumber(),
            green = generateColorNumber(),
            blue = generateColorNumber(),
            1
        )
        setColor(color)

    }

    private fun generateColorNumber(): Int = Random.nextInt(0, 255)

}