package attachment

data class Link(
    val id: Int = 0,
    val url: String = "",
    val title: String = "",
    val caption: String = "",
    val description: String = "",
    val photo: PhotoAttachment? = null,
    val product: String? = null,
    val button: String? = null,
    val previewPage: String = "",
    val previewUrl: String = ""
)