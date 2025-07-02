import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class CircleTest{

    val point = Point(1.0, 2.0)
    val radiusValues = listOf<Double>(3.0, 1.5, .5, .1)

    @Test
    fun testCircleInit() {
        for (radius in radiusValues){
            val circle = Circle(point, radius)
            val centerPoint = circle.getCenterPoint()
            assertEquals(1.0, centerPoint.x)
            assertEquals(2.0, centerPoint.y)
            assertEquals(radius, circle.radius)
        }
    }

    @Test
    fun testZeroWidth() {
        assertThrows<IllegalArgumentException> { Circle(point, 0.0) }
        assertThrows<IllegalArgumentException>{ Circle(point, -10.0) }
        assertThrows<IllegalArgumentException>{ Circle(point, -.1) }
    }

    @Test
    fun testCircleArea() {
        val expectedAreas = listOf<Double>(28.274, 7.069, .7854, .031)
        for ((radius, expectedArea) in radiusValues.zip(expectedAreas)) {
            val circle = Circle(point, radius)
            assertEquals(expectedArea, circle.getArea(), .001)
        }

    }

    @Test
    fun testCircleMove() {
        val moves = listOf(
            listOf<Double>(0.0, 0.0),
            listOf<Double>(1.0, 2.0),
            listOf<Double>(-2.0, -4.0),
            listOf<Double>(-1.5, .4),
            listOf<Double>(1.25, -0.01)
        )
        val results = listOf(
            listOf<Double>(1.0, 0.5),
            listOf<Double>(2.0, 2.5),
            listOf<Double>(-1.0, -3.5),
            listOf<Double>(-.5, .9),
            listOf<Double>(2.25, 0.49)
        )

        for ((move, result) in moves.zip(results)) {
            val point = Point(1.0, .5)
            val circle = Circle(point, 1.0)

            val dx = move[0]
            val dy = move[1]
            circle.move(dx, dy)

            val xResult = result[0]
            val yResult = result[1]

            val actualPoint = circle.getCenterPoint()

            assertEquals(xResult, actualPoint.x)
            assertEquals(yResult, actualPoint.y)
        }
    }
}