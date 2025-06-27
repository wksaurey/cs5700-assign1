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
        val moves = arrayOf(
            doubleArrayOf(1.0, 2.0),
            doubleArrayOf(-2.0, -4.0),
            doubleArrayOf(-1.5, .4)
        )
        val results = arrayOf(
            doubleArrayOf(2.0, 2.5),
            doubleArrayOf(-1.0, -3.5),
            doubleArrayOf(-.5, .9)
        )

        for (index in 0..moves.size-1) {
            val point = Point(1.0, .5)

            val dx = moves[index][0]
            val dy = moves[index][1]
            point.move(dx, dy)

            val xResult = results[index][0]
            val yResult = results[index][1]

            assertEquals(xResult, point.x)
            assertEquals(yResult, point.y)
        }
    }

    @Test
    fun testPointCloneReturnsCopy() {
        pointValues.forEach { pointValue ->
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
    }
}