package attachment

data class AudioAttachment(
    val audio: Audio
) : Attachment("audio")