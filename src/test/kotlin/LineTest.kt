import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals

class LineTest{

    val points = listOf(
        Point(0.0, 0.0),
        Point(1.0, 2.0),
        Point(-3.0, -4.0),
        Point(0.4, 0.0001),
    )

    @Test
    fun testLineInit() {
        for (point1 in points) {
            for (point2 in points) {
                if (point1 === point2) continue // prevent line length 0
                val line = Line(point1, point2)
                val points = line.getPoints()
                val actualPoint1 = points[0]
                val actualPoint2 = points[1]
                assertEquals(point1.x, actualPoint1.x)
                assertEquals(point1.y, actualPoint1.y)
                assertEquals(point2.x, actualPoint2.x)
                assertEquals(point2.y, actualPoint2.y)
            }
        }
    }

    @Test
    fun testZeroLength() {
        for (point in points) {
            assertThrows<IllegalArgumentException> {
                Line(point, point.clone())
            }
        }
    }

    @Test
    fun testLineLength() {
        val pointPairs = listOf(
            listOf(Point(0.0, 0.0), Point(0.0, 1.0)),     // vertical, length 1.0
            listOf(Point(0.0, 0.0), Point(3.0, 4.0)),     // hypotenuse, 3-4-5 triangle, length 5.0
            listOf(Point(1.0, 1.0), Point(4.0, 5.0)),     // another 3-4-5, length 5.0
            listOf(Point(2.0, 3.0), Point(3.5, 7.1)),     // arbitrary, decimal > 1.0, length ~4.366
            listOf(Point(0.0, 0.0), Point(0.3, 0.4)),     // decimal < 1.0, length 0.5
            listOf(Point(0.0, 0.0), Point(-3.0, -4.0)),   // diagonal negative slope, length 5.0
            listOf(Point(2.0, 2.0), Point(1.0, 0.0)),     // downward-left, length ~2.236
            listOf(Point(-1.0, -1.0), Point(-4.0, -5.0))  // diagonal negative, length 5.0
        )

        val expectedLengths = listOf<Double>(
            1.0,
            5.0,
            5.0,
            4.366,
            0.5,
            5.0,
            2.236,
            5.0
        )

        for ((pointPair, expectedLength) in pointPairs.zip(expectedLengths)) {
            val line = Line(pointPair[0], pointPair[1])
            assertEquals(line.getLength(), expectedLength, 0.001)
        }

    }

    @Test
    fun testLineSlope() {
        val pointPairs = listOf(
            listOf(Point(0.0, 0.0), Point(0.0, 2.0)),     // vertical upward
            listOf(Point(2.0, 5.0), Point(2.0, 2.0)),     // vertical downward (negative infinity)
            listOf(Point(1.0, 1.0), Point(4.0, 1.0)),     // horizontal
            listOf(Point(2.0, 2.0), Point(3.0, 5.0)),     // positive slope > 1
            listOf(Point(0.0, 0.0), Point(2.0, 1.0)),     // positive slope < 1
            listOf(Point(1.0, 3.0), Point(4.0, 1.0)),     // negative slope < -0.5
            listOf(Point(-2.0, -1.0), Point(-1.0, 1.0))   // positive slope with negative coords
        )

        val expectedSlopes = listOf<Double>(
            Double.POSITIVE_INFINITY,  // vertical up
            Double.POSITIVE_INFINITY,  // vertical down
            0.0,                       // horizontal
            3.0,                       // steep positive
            0.5,                       // shallow positive
            -0.666,                    // shallow negative
            2.0                        // steep positive w/ neg coords
        )

        for ((pointPair, expectedSlope) in pointPairs.zip(expectedSlopes)) {
            val line = Line(pointPair[0], pointPair[1])
            assertEquals(line.getSlope(), expectedSlope, 0.001)
        }
    }

    @Test
    fun testLineMove() {
        val moves = listOf(
            listOf<Double>(0.0, 0.0),
            listOf<Double>(1.0, 2.0),
            listOf<Double>(-2.0, -4.0),
            listOf<Double>(-1.5, .4),
            listOf<Double>(1.25, -0.01)
        )

        val results = listOf(
            listOf(
                Point(1.0, 0.5), Point(-0.4, -2.0),
            ),
            listOf(
                Point(2.0, 2.5), Point(0.6, 0.0),
            ),
            listOf(
                Point(-1.0, -3.5), Point(-2.4, -6.0),
            ),
            listOf(
                Point(-0.5, 0.9), Point(-1.9, -1.6),
            ),
            listOf(
                Point(2.25, 0.49), Point(0.85, -2.01),
            ),
        )

        for ((move, result) in moves.zip(results)) {
            val line = Line(Point(1.0, .5), Point(-.4, -2.0))
            line.move(move[0], move[1])
            val points = line.getPoints()
            assertEquals(result[0].x, points[0].x)
            assertEquals(result[0].y, points[0].y)
            assertEquals(result[1].x, points[1].x)
            assertEquals(result[1].y, points[1].y)
        }
    }
}