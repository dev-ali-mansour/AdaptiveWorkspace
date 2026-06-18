package dev.alimansour.adaptive.workspace.data

import androidx.compose.ui.graphics.Color
import dev.alimansour.adaptive.workspace.ui.theme.AvatarColors
import kotlin.math.absoluteValue

data class Email(
    val id: String,
    val sender: String,
    val senderEmail: String,
    val subject: String,
    val preview: String,
    val body: String,
    val timestamp: String,
    val isStarred: Boolean = false,
    val isRead: Boolean = false
)

/** Derive a consistent avatar color from the sender's name. */
fun Email.avatarColor(): Color =
    AvatarColors[sender.hashCode().absoluteValue % AvatarColors.size]

/** First letter of the sender's name for the avatar circle. */
fun Email.avatarInitial(): Char = sender.first().uppercaseChar()
