package hu.nmth.afd.feature.players

sealed class PlayersIntent {
    data object FetchPlayers : PlayersIntent()
}