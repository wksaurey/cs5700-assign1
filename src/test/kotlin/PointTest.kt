import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals

class PointTest{

    val pointValues = arrayOf(
        doubleArrayOf(0.0, 0.0),
        doubleArrayOf(1.0, 2.0),
        doubleArrayOf(-3.0, -4.0),
        doubleArrayOf(0.4, 0.0001),
    )

    @Test
    fun testPointInit() {
        pointValues.forEach { pointValue ->
            val x = pointValue[0]
            val y = pointValue[1]
            val point = Point(x, y)
            assertEquals(x, point.x)
            assertEquals(y, point.y)

        }
    }

    @Test
    fun testPointClone() {
        pointValues.forEach { pointValue ->
            val x = pointValue[0]
            val y = pointValue[1]
            val point = Point(x, y)
            val pointClone = point.clone()
            assertEquals(x, pointClone.x)
            assertEquals(y, pointClone.y)
        }
    }

    @Test
    fun testPointMove() {
        val moves = listOf(
            listOf<Double>(1.0, 2.0),
            listOf<Double>(-2.0, -4.0),
            listOf<Double>(-1.5, .4)
        )
        val results = listOf(
            listOf<Double>(2.0, 2.5),
            listOf<Double>(-1.0, -3.5),
            listOf<Double>(-.5, .9)
        )

        for ((move, result) in moves.zip(results)) {
            val point = Point(1.0, .5)

            val dx = move[0]
            val dy = move[1]
            point.move(dx, dy)

            val xResult = result[0]
            val yResult = result[1]

            assertEquals(xResult, point.x)
            assertEquals(yResult, point.y)
        }
    }

    @Test
    fun testPointCloneReturnsCopy() {
        for (pointValue in pointValues) {
            val x = pointValue[0]
            val y = pointValue[1]
            val point = Point(x, y)
            val pointClone = point.clone()
            // check memory addresses
            assertFalse(point === pointClone)
        }
    }

    @Test
    fun testInfinitePointValues() {
        val point = Point(0.0, 0.0)
        assertThrows<IllegalArgumentException> {
            point.move(Double.POSITIVE_INFINITY, 0.0)
        }
        assertThrows<IllegalArgumentException> {
            point.move(0.0, Double.NEGATIVE_INFINITY)
        }
        assertThrows<IllegalArgumentException> {
            Point(Double.POSITIVE_INFINITY, 0.0)
        }
        assertThrows<IllegalArgumentException> {
            Point(0.0, Double.NEGATIVE_INFINITY)
        }
    }

    @Test
    fun testNaNPointValues() {
        val point = Point(0.0, 0.0)
        assertThrows<IllegalArgumentException> {
            point.move(Double.NaN, 0.0)
        }
        assertThrows<IllegalArgumentException> {
            point.move(0.0, Double.NaN)
        }
        assertThrows<IllegalArgumentException> {
            Point(Double.NaN, 0.0)
        }
        assertThrows<IllegalArgumentException> {
            Point(0.0, Double.NaN)
        }
    }
}