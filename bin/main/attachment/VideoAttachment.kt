package attachment

data class VideoAttachment(
    val video: Video
) : Attachment("video")