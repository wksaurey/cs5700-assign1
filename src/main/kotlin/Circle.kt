import kotlin.math.PI
import kotlin.math.pow

open class Circle(
    private val centerPoint: Point,
    radius: Double
) {
    var radius: Double = validateValue(radius)
        private set

    fun getCenterPoint() = centerPoint.clone()

    open fun getArea() = PI*radius.pow(2)

    fun move(dx: Double, dy: Double) = centerPoint.move(dx, dy)

    protected open fun validateValue(radius: Double): Double {
        if (radius <= 0.0) {
            throw IllegalArgumentException("radius must be greater than zero")
        }
        return radius
    }
}