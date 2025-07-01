import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals

class LineTest{

    val points = listOf(
        listOf<Point>()
    )

    @Test
    fun testLineInit() {
        val line = Line(Point(0.0, 0.0), Point(4.0, 5.0))
        val points = line.getPoints()
        val point1 = points[0]
        val point2 = points[1]
        assertEquals(0.0, point1.x)
        assertEquals(0.0, point1.y)
        assertEquals(4.0, point2.x)
        assertEquals(5.0, point2.y)
    }

    @Test
    fun testZeroLength() {
        assertThrows<IllegalArgumentException> {
            Line(Point(1.0, 1.0), Point(1.0, 1.0))
        }
    }

    @Test
    fun testLineLength() {

    }

    @Test
    fun testLineSlope() {

    }

    @Test
    fun testLineMove() {

    }
}