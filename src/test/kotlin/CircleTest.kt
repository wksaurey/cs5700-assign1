import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

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
    fun testCircleArea() {
        val expectedAreas = listOf<Double>(28.274, 7.069, .7854, .031)
        for ((radius, expectedArea) in radiusValues.zip(expectedAreas)) {
            val circle = Circle(point, radius)
            assertEquals(expectedArea, circle.getArea())
        }

    }
}