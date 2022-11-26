package attachment

data class PhotoAttachment(
    val photo: Photo
) : Attachment("photo")