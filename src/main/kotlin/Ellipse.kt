import kotlin.math.PI

class Ellipse(
    centerPoint: Point,
    xRadius: Double,
    yRadius: Double
): Rectangle(centerPoint, xRadius*2, yRadius*2) {
    var xRadius: Double = validateValue(xRadius)
        private set
    var yRadius: Double = validateValue(yRadius)
        private set

    override fun getArea() = PI * xRadius * yRadius
}