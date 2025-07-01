import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals

class TriangleTest{

    val pointsValues = listOf(
        listOf<Point>(Point(0.0, 0.0), Point(2.0, 1.0), Point(0.0, 2.0)),
        listOf<Point>(Point(0.0, 0.5), Point(-2.0, -.43), Point(10.0, .01)),
    )

    @Test
    fun testTriangleInit() {
        for (pointValue in pointsValues){
            val point1 = pointValue[0]
            val point2 = pointValue[1]
            val point3 = pointValue[2]

            val triangle = Triangle(point1, point2, point3)
            val actualPoints = triangle.getPoints()
            val actualPoint1 = actualPoints[0]
            val actualPoint2 = actualPoints[1]
            val actualPoint3 = actualPoints[2]
            assertEquals(actualPoint1.x, point1.x)
            assertEquals(actualPoint1.y, point1.y)
            assertEquals(actualPoint2.x, point2.x)
            assertEquals(actualPoint2.y, point2.y)
            assertEquals(actualPoint3.x, point3.x)
            assertEquals(actualPoint3.y, point3.y)
        }
    }

    @Test
    fun testZeroAreaTriangle() {
        // same 3 points
        assertThrows<IllegalArgumentException> {
            Triangle(Point(0.0, 0.0), Point(0.0, 0.0), Point(0.0, 0.0))
        }

        // 3 points on a horizontal line
        assertThrows<IllegalArgumentException> {
            Triangle(Point(0.0, 0.0), Point(1.0, 0.0), Point(2.0, 0.0))
        }

        // 3 points on a diagonal line
        assertThrows<IllegalArgumentException> {
            Triangle(Point(.5, .925), Point(1.0, 1.55), Point(2.3, 3.175))
        }
    }

    @Test
    fun testTriangleArea() {
        val pointsValues = listOf(
            listOf<Point>(Point(2.0, 4.0), Point(3.0, -6.0), Point(7.0, 8.0)),
            listOf<Point>(Point(.5, .925), Point(1.0,-2.0), Point(2.3, -4.0))

        )

        val expectedAreas = listOf<Double>(
            27.0,
            1.401
        )

        for ((pointValues, expectedArea) in pointsValues.zip(expectedAreas)) {
            val triangle = Triangle(pointValues[0], pointValues[1], pointValues[2])
            assertEquals(expectedArea, triangle.getArea(), .001)
        }
    }

    @Test
    fun testTriangleMove() {

    }
}