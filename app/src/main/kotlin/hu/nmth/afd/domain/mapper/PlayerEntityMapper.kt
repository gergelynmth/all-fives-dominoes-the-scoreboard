package hu.nmth.afd.domain.mapper

import hu.nmth.afd.data.entities.PlayerEntity
import hu.nmth.afd.domain.model.Player

fun PlayerEntity.toPlayer(): Player = Player(
    id = id,
    name = name
)