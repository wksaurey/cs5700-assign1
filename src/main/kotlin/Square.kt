import kotlin.math.pow

class Square(
    centerPoint: Point,
    width: Double
){
    var centerPoint: Point = centerPoint
        private set
    var width: Double = validateValue(width)
        private set

    fun getArea() = width.pow(2)

    fun move(dx: Double, dy: Double) = centerPoint.move(dx, dy)

    fun validateValue(width: Double): Double {
        if (width <= 0.0) {
            throw IllegalArgumentException("width must be greater than zero")
        }
        return width
    }
}