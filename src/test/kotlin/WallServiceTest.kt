import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    @Test
    fun add() {
        val service = WallService()
        val testPost = service.add(Post())
        val testPost1 = service.add(Post())
        assertEquals(2, testPost1.id)
    }
    @Test
    fun update() {
        val service = WallService()
        service.add(Post (ownerId = 7, text = "Hello"))
        service.add(Post(ownerId = 64, text = "Hello world"))
        service.add(Post(ownerId = 45, text = "Hello Kotlin"))
        var update = service.add(Post(ownerId = 7))
        update = update.copy(text = "Hi there")
        val result = service.update(update)
        assertTrue( result)
    }

    @Test
    fun update_failed() {
        val service = WallService()
        service.add(Post(ownerId = 7))
        service.add(Post(ownerId = 64))
        service.add(Post(ownerId = 45))
        var update = service.add(Post(ownerId = 7))
        update = update.copy(id = 777, text = "Hi there")
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun createComment() {
        val service = WallService()
        val post1 = service.add(Post(text = "Hello"))
        val post2 = service.add(Post(text = "Hello world"))
        val post3 = service.add(Post(text = "Hello Kotlin"))
        service.createComment(1, comment = Comment(text = "nice"))


    }

    @Test(expected = WallService.PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService()
        val post1 = service.add(Post(text = "Hello"))
        val post2 = service.add(Post(text = "Hello world"))
        val post3 = service.add(Post(text = "Hello Kotlin"))
        service.createComment(66, comment = Comment(text = "nice"))


    }
}
