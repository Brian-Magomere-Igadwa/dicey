package design.fiti.dicey

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


enum class Routes(
    @StringRes title: Int
) {
    ColorSelectScreen(title = R.string.color_select_screen),
    ThemedScreen(title = R.string.themed_screen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, navigateUp: () -> Unit, canNavigate: Boolean) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (canNavigate) {
                IconButton(onClick = { navigateUp }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }

            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStack by navController.currentBackStackEntryAsState()
    val currentScreen = Routes.valueOf(
        backStack?.destination?.route ?: Routes.ColorSelectScreen.name
    )

    Scaffold(modifier = modifier, topBar = {
        AppBar(
            title = currentScreen.name,
            navigateUp = { navController.navigateUp() },
            canNavigate = navController.previousBackStackEntry != null
        )
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.ColorSelectScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Routes.ColorSelectScreen.name) {

            }
            composable(route = Routes.ThemedScreen.name) {

            }
        }
    }

}