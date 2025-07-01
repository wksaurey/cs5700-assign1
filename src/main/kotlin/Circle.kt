import kotlin.math.PI
import kotlin.math.pow

class Circle(
    point: Point,
    radius: Double
): Square(point, radius*2) {
    var radius: Double = validateValue(radius)
        private set

    override fun getArea() = PI*radius.pow(2)
}