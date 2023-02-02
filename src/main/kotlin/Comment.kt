class Comment(
    val lid: Int = 0,
    val fromId: Int = 0,
    val date: Int = System.currentTimeMillis().toInt(),
    val text: String = "It's the empty comment",
    val donut: Donut = Donut(),
    val replyToUser: Int? = 0,
    val replyToComment: Int? = 0,
    var attachment: Array<Attachment> = emptyArray(),
    var parentsStack: Array<ParentStack> = emptyArray(),
    val thread: Thread = Thread()
)

class Donut(
    isDon: Boolean = false,
    placeholder: String = ""
)

class Thread(
    val count: Int = 0,
    val canPost: Boolean = true,
    val showReplyButton: Boolean = true,
    val groupsCanPost: Boolean = true


)

class ParentStack(

)

