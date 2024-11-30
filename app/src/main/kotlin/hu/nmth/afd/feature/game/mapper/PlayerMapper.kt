package hu.nmth.afd.feature.game.mapper

import hu.nmth.afd.domain.model.Player
import hu.nmth.afd.feature.game.model.PlayerScore

fun Player.toPlayerScore(): PlayerScore =
    PlayerScore(
        id = id,
        name = name
    )