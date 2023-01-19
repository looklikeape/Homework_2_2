fun main() {
    val service = WallService()
    service.add(Post())
    service.add(Post())
    service.add(Post())
    val update = service.add(Post(id=1,text = "bla-bla-bla"))
    val result = service.update(update)
    println(result)
}

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
    val comments: Comments = Comments()
)

class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

class WallService {
    private var posts = emptyArray<Post>()
    private var newIdAdd = 0
    fun add(post: Post): Post {

        val newPost: Post = post.copy(id = ++newIdAdd)
        posts += newPost
        return posts.last()
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