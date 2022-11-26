package attachment

data class Audio(
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
    val url: String = "",
    val lyricsId: Int? = null,
    val albumId: Int? = null,
    val genreId: Int = 0,
    val date: Int = 0,
    val noSearch: Boolean = false,
    val isHq: Boolean = false
)

