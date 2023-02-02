import java.lang.Exception
import java.lang.RuntimeException


data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val date: Int = System.currentTimeMillis().toInt(),
    val createdBy: Int = 0,
    val signerId: Int = 0,
    val text: String = "",
    val postType: String = "",
    val isVaforite: Boolean = false,
    val markedAsAds: Boolean = false,
    var comment: Comment = Comment(),
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = true,
    val copyright: String = "",
    val likes: Likes = Likes(),
    val reposts: Reposts? = Reposts(),
    val views: Views = Views(),
    val geo: Geo? = Geo(),
    var copyHistory: Array<Reposts> = emptyArray(),
    val canPin: Boolean = true,
    val canDelete:Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val postponedId: Int? = 0,
    var attachment: Array<Attachment> = emptyArray()
)

class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)
class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)
class  Reposts( val count: Int = 0, val userReposted: Boolean = false)
class Views(val count: Int = 0)
class Geo(
    val type: String = "",
    val coordinates: String = "",
    val place: String = ""
)

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var newIdAdd = 0
    fun add(post: Post): Post {
        val newPost: Post = post.copy(id = ++newIdAdd)
        posts += newPost
        return posts.last()
    }

    class PostNotFoundException(message: String) : RuntimeException(message)

    private fun findById(id: Int): Post? {
        for (post in posts) {
            if (id == post.id) {
                return post
            }
        }
        return null
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val findResult = findById(id = postId)
        if (findResult == null) {
            throw PostNotFoundException("PostNotFound exception")
        } else comments += comment
        return comments.last()
    }


    fun update(post: Post): Boolean {
        val id = post.id
        for ((index, thisPost) in posts.withIndex()) {
            if (thisPost.id == id) {
                val newPostDate = thisPost.date
                val newPostOwnerId = thisPost.ownerId
                posts[index] = post.copy(date = newPostDate, ownerId = newPostOwnerId)
                return true
            }
        }
        return false

    }
}
