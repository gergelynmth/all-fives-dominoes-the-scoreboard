package hu.nmth.afd.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import hu.nmth.afd.domain.model.DEFAULT_PLAYER
import hu.nmth.afd.domain.model.Player
import hu.nmth.afd.feature.game.GameScreen
import hu.nmth.afd.feature.game.GameScreenDestination
import hu.nmth.afd.feature.home.HomeScreen
import hu.nmth.afd.feature.home.HomeScreenDestination
import hu.nmth.afd.feature.newgame.NewGameScreen
import hu.nmth.afd.feature.newgame.NewGameScreenDestination
import hu.nmth.afd.navigation.typeutil.parcelableType
import kotlin.reflect.typeOf

@Composable
fun AdfNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreenDestination
    ) {
        composable<HomeScreenDestination> {
            HomeScreen(
                navigateToNewGame = {
                    navController.navigate(
                        NewGameScreenDestination
                    )
                }
            )
        }

        composable<NewGameScreenDestination> {
            NewGameScreen(
                navigateToGame = { players ->
                    navController.navigate(
                        GameScreenDestination(
                            player1 = players[0],
                            player2 = players[1],
                            player3 = players.getOrNull(2) ?: DEFAULT_PLAYER,
                            player4 = players.getOrNull(3) ?: DEFAULT_PLAYER,
                        )
                    )
                }
            )
        }

        composable<GameScreenDestination>(
            typeMap = mapOf(
                typeOf<Player>() to parcelableType<Player>()
            )
        ) {
            val args = it.toRoute<GameScreenDestination>()
            GameScreen(
                navParameters = args,
                navigateToHome = {
                    navController.navigate(HomeScreenDestination) {
                        popUpTo<HomeScreenDestination>()
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
