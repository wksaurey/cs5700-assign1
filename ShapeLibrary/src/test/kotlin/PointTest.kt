import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class pointTest{

    @Test
    fun testPointInit() {
        val x = 3.0
        val y = 4.0
        val point = Point(x, y)
        assertEquals(3, point.getX())
        assertEquals(4, point.getY())
    }

    @Test
    fun testPointClone() {
        val x = -3.0
        val y = 3.4
        val point = Point(x, y)
        val pointClone = point.clone()
        assertEquals(x, pointClone.x)
        assertEquals(y, pointClone.y)
    }

    @Test
    fun testPointMove() {
        val x = 0.0
        val y = 0.0
        val point = Point(x, y)
        val dx = -7.0
        val dy = 9.1
        point.move(dx, dy)
        assertEquals(x + dx, point.getX())
        assertEquals(y + dy, point.getY())
    }
}