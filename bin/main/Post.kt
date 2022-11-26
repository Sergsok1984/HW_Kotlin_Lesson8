package attachment

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val comments: Array<Comment>? = null,
    val copyright: Copyright? = null,
    val likes: Array<Likes>? = null,
    val reposts: Array<Repost>? = null,
    val views: Array<View>? = null,
    val postType: String = "",
    val signerId: Int = 0,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut? = null,
    val postponedId: Int = 0,
    var attachments: Array<Attachment>? = null
)

data class Comment(
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val donut: Donut? = null,
    val replyToUser: Int? = null,
    val replyToComment: Int? = null,
    val replyToPost: Int? = null,
    var attachments: Array<Attachment>? = null,
    var parentsStack: Array<Comment>? = null,
    val thread: Any? = null
)

data class Copyright(
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = ""
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = false,
    val canPublish: Boolean = false
)

data class Repost(
    val count: Int = 0,
    val userReposted: Boolean = false
)

data class View(
    val count: Int = 0
)

data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int = 0,
    val placeholder: String = "",
    val canPublishFreeCopy: Boolean = false,
    val editMode: String = ""
)

data class Report(
    val commentId: Int,
    val reason: UInt
)
