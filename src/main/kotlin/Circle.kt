import kotlin.math.PI
import kotlin.math.pow

class Circle(
    point: Point,
    radius: Double
): Square(point, radius*2) {
    var radius: Double = validateValue(radius)

    override fun getArea() = 2*PI*radius.pow(2)
}