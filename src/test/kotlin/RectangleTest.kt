import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class RectangleTest{

    val lengthValues = listOf<Double>(3.0, 1.5, .5, .001)
    val point = Point(1.0, 2.0)

    @Test
    fun testRectangleInit() {
        for (width in lengthValues){
            for (height in lengthValues){
                val rectangle = Rectangle(point, width, height)
                val centerPoint = rectangle.getCenterPoint()
                assertEquals(1.0, centerPoint.x)
                assertEquals(2.0, centerPoint.y)
                assertEquals(width, rectangle.width)
                assertEquals(height, rectangle.height)
            }
        }
    }

    @Test
    fun testZeroHeight() {
        assertThrows<IllegalArgumentException> { Rectangle(point, 1.0, 0.0) }
        assertThrows<IllegalArgumentException>{ Rectangle(point, 1.0, -10.0) }
        assertThrows<IllegalArgumentException>{ Rectangle(point, 1.0, -.1) }
    }

    @Test
    fun testRectangleArea() {
        val lengthValues = listOf(
            listOf<Double>(1.0, 1.0),
            listOf<Double>(3.0, 5.0),
            listOf<Double>(.9, .4),
            listOf<Double>(.65, 4.0),
        )
        val expectedAreas = listOf<Double>(
            1.0,
            15.0,
            0.36,
            2.6
        )

        for ((lengths, expectedArea) in lengthValues.zip(expectedAreas)) {
            val width = lengths[0]
            val height = lengths[1]
            val rectangle = Rectangle(point, width, height)
            assertEquals(expectedArea, rectangle.getArea(), .001)
        }
    }
}