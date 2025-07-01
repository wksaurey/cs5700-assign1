import org.junit.jupiter.api.Assertions.*
import kotlin.math.PI
import kotlin.test.Test

class EllipseTest{

    val lengthValues = listOf<Double>(3.0, 1.5, .5, .001)
    val point = Point(1.0, 2.0)

    @Test
    fun testEllipseInit() {
        for (xRadius in lengthValues){
            for (yRadius in lengthValues){
                val ellipse = Ellipse(point, xRadius, yRadius)
                val centerPoint = ellipse.getCenterPoint()
                assertEquals(1.0, centerPoint.x)
                assertEquals(2.0, centerPoint.y)
                assertEquals(xRadius, ellipse.xRadius)
                assertEquals(yRadius, ellipse.yRadius)
            }
        }
    }

    @Test
    fun testEllipseArea() {
        val lengthValues = listOf(
            listOf<Double>(1.0, 1.0),
            listOf<Double>(3.0, 5.0),
            listOf<Double>(.9, .4),
            listOf<Double>(.65, 4.0),
        )
        val expectedAreas = listOf<Double>(
            PI,
            47.123,
            1.131,
            8.168
        )

        for ((lengths, expectedArea) in lengthValues.zip(expectedAreas)) {
            val xRadius = lengths[0]
            val yRadius = lengths[1]
            val ellipse = Ellipse(point, xRadius, yRadius)
            assertEquals(expectedArea, ellipse.getArea(), .001)
        }
    }
}