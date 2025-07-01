import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals

class SquareTest{

    val widthValues = listOf<Double>(3.0, 1.5, .5, .001)
    val point = Point(1.0, 2.0)

    @Test
    fun testSquareInit() {
        for (width in widthValues){
            val square = Square(point, width)
            val centerPoint = square.getCenterPoint()
            assertEquals(1.0, centerPoint.x)
            assertEquals(2.0, centerPoint.y)
            assertEquals(width, square.width)
        }
    }

    @Test
    fun testZeroWidth() {
        assertThrows<IllegalArgumentException>{ Square(point, 0.0) }
        assertThrows<IllegalArgumentException>{ Square(point, -10.0) }
        assertThrows<IllegalArgumentException>{ Square(point, -.1) }
    }

    @Test
    fun testSquareArea() {
        val expectedAreas = listOf<Double>(9.0, 2.25, .25, .000001)
        for ((width, expectedArea) in widthValues.zip(expectedAreas)){
            val square = Square(point, width)
            assertEquals(expectedArea, square.getArea())
        }
    }

    @Test
    fun testSquareMove() {
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
            val square = Square(point, 1.0)

            val dx = move[0]
            val dy = move[1]
            square.move(dx, dy)

            val xResult = result[0]
            val yResult = result[1]

            val actualPoint = square.getCenterPoint()

            assertEquals(xResult, actualPoint.x)
            assertEquals(yResult, actualPoint.y)
        }
    }
}