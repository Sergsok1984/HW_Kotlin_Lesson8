package attachment

data class LinkAttachment(
    val link: Link
) : Attachment("link")