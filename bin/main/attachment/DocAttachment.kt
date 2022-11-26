package attachment

data class DocAttachment(
    val doc: Doc
) : Attachment("doc")