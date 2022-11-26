package attachment

data class Photo(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = "",
    val date: Int = 0,
    val sizes: Array<String>? = null,
    val width: Int? = null,
    val height: Int? = null
)