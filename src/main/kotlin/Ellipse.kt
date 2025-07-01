import kotlin.math.PI

class Ellipse(
    centerPoint: Point,
    xRadius: Double,
    yRadius: Double
): Circle(centerPoint, xRadius) {
    var xRadius: Double = validateValue(xRadius)
        private set
    var yRadius: Double = validateValue(yRadius)
        private set

    override fun getArea() = PI * xRadius * yRadius
}