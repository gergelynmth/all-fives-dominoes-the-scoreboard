package hu.nmth.afd.feature.game.model

data class PlayerScore(
    val id: Long,
    val name: String,
    val scores: List<Int> = listOf(0)
)

fun PlayerScore.addScore(scoreToAdd: Int): PlayerScore {
    val newScore = (scores.lastOrNull() ?: 0) + scoreToAdd
    return copy(scores = scores + newScore)
}

fun PlayerScore.removeLastScore(): PlayerScore {
    return copy(scores = scores.dropLast(1))
}
