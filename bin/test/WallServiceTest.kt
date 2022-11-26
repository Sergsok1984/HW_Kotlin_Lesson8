package attachment

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addNewId() {
        val wallService = WallService()
        val firstPost = Post(text = "First post")

        val addedFirstPost = wallService.add(firstPost)
        val result = addedFirstPost.id

        assertEquals(1, result)
    }

    @Test
    fun updateRealId() {
        val wallService = WallService()
        val newPost = Post(text = "First post")
        val post = wallService.add(newPost)
        val postId = post.id

        val updatedPost = Post(id = postId, text = "Updated post")
        val result = wallService.update(updatedPost)

        assertTrue(result)
    }

    @Test
    fun updateNotRealId() {
        val wallService = WallService()
        val newPost = Post(text = "First post")
        val post = wallService.add(newPost)
        val postId = post.id + 1

        val updatedPost = Post(id = postId, text = "Updated post")
        val result = wallService.update(updatedPost)

        assertFalse(result)
    }

    @Test
    fun createCommentRealId() {

        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))

        val postId = post.id

        wallService.createComment(Comment(replyToPost = postId, text = "First comment"))

        assertTrue(true)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentNotRealId() {

        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))

        val postId = post.id + 1

        wallService.createComment(Comment(replyToPost = postId, text = "First comment"))
    }

    @Test
    fun createReportRealCommentId() {

        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))
        val postId = post.id

        val comment = wallService.createComment(Comment(replyToPost = postId, text = "First comment"))
        val commentId = comment.id

        wallService.reportComment(commentId = commentId, reason = 0U)

        assertTrue(true)

    }

    @Test(expected = CommentNotFoundException::class)
    fun createReportNotRealCommentId() {

        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))
        val postId = post.id

        val comment = wallService.createComment(Comment(replyToPost = postId, text = "First comment"))
        val commentId = comment.id + 1

        wallService.reportComment(commentId = commentId, reason = 0U)
    }

    @Test(expected = IncorrectReasonException::class)
    fun createReportIncorrectReason() {

        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))
        val postId = post.id

        val comment = wallService.createComment(Comment(replyToPost = postId, text = "First comment"))
        val commentId = comment.id

        wallService.reportComment(commentId = commentId, reason = 9U)
    }
}