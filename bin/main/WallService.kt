package attachment

class PostNotFoundException(message: String) : RuntimeException(message)
class CommentNotFoundException(message: String) : RuntimeException(message)
class IncorrectReasonException(message: String) : RuntimeException(message)

internal class WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()

    fun add(post: Post): Post {
        val newId = if (posts.isNotEmpty()) posts.last().id + 1 else 1
        posts += post.copy(id = newId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = post.copy(ownerId = currentPost.ownerId, date = currentPost.date)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment): Comment {
        for (post in posts) {
            if (post.id == comment.replyToPost) {
                val newCommentId = if (comments.isNotEmpty()) comments.last().id + 1 else 1
                comments += comment.copy(id = newCommentId)
                return comments.last()
            }
        }
        throw PostNotFoundException("Post not found (id = ${comment.replyToPost})")
    }

    fun reportComment(commentId: Int, reason: UInt) {
        if (reason !in 0U .. 8U) {
            throw IncorrectReasonException("Incorrect reason (reason = $reason)")
        }
        for (comment in comments) {
            if (comment.id == commentId) {
                reports += Report(commentId = commentId, reason = reason)
                return
            }
        }
        throw CommentNotFoundException("Comment not found (id = $commentId)")
    }
}
