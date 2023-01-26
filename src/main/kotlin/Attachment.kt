

interface Attachment {
val type:String

}

class AttachmentPhoto(
    val attachmentPhoto: Photo = Photo()
):Attachment{
    override val type: String
        get() = "photo"
}

class AttachmentAudio(
    val attachmentAudio: Audio = Audio()
):Attachment{
    override val type: String
        get() = "audio"



}
class AttachmentFile(
    val AttachmentFile: File = File()
):Attachment{
    override val type: String
        get() = "file"
}
class AttachmentGift(
    val AttachmentGift:Gift = Gift()
):Attachment {
    override val type: String
        get() = "gift"
}

class AttachmentGraffiti(
    val AttachmentGraffiti:Graffiti = Graffiti()
):Attachment{
    override val type: String
        get() = "graffiti"

}
class Photo(
    id:Int = 0,
    albumId:Int = 0,
    ownerId:Int = 0,
    userId:Int = 0,
    text:String = "",
    date: Int = 0,
    sizes:Array<Sizes> = emptyArray(),
    width: Int = 0,
    height: Int = 0
    )
class Sizes(
    val type:String = "",
    val url:String = "",
    val width: Int = 0,
    val height: Int = 0

)
class Audio(
    id:Int = 0,
    ownerId:Int = 0,
    artist:String = "Default",
    title:String = "Default",
    duration: Int = 0,
    url:String = "",
    lyricsId: Int? = null,
    albumId: Int? = null,
    genreId: Int = 0,
    date: Int = 0,
    noSearch:Int? = 1 ?: null,
    isHq:Int? = 1 ?: null
)
class File(
    id: Int = 0,
    ownerId:Int = 0,
    title: String ="Default",
    size: Int = 0,
    ext: String = "",
    url: String = "",
    date: Int = 0,
    type: IntRange = 1..8
    )
class Gift(
    id: Int = 0,
    thumb256:String = "http//256x256",
    thumb96:String = "http//96x96",
    thumb48:String = "http//48x48",

)
class Graffiti(
    id: Int = 0,
    ownerId: Int = 0,
    url: String = "",
    width: Int = 0,
    height: Int = 0
)
