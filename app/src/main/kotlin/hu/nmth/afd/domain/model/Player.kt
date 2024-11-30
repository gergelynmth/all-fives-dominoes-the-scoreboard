package hu.nmth.afd.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Player(
    val id: Long,
    val name: String
): Parcelable

val DEFAULT_PLAYER = Player(
    id = 0,
    name = ""
)