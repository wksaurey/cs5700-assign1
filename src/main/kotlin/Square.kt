import kotlin.math.pow

open class Square(
    private val centerPoint: Point,
    width: Double
){
    var width: Double = validateValue(width)
        private set

    fun getCenterPoint() = centerPoint.clone()

    open fun getArea() = width.pow(2)

    fun move(dx: Double, dy: Double) = centerPoint.move(dx, dy)

    open fun validateValue(length: Double): Double {
        if (length <= 0.0) {
            throw IllegalArgumentException("length must be greater than zero")
        }
        return length
    }
}