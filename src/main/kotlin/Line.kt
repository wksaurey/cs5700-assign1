import kotlin.math.abs
import kotlin.math.hypot

class Line (
    private val point1: Point,
    private val point2: Point,
){
    init {
        validateLineLength(point1, point2)
    }

    fun validateLineLength(point1: Point, point2: Point) {
        if (getLength(point1, point2) == 0.0) {
            throw IllegalArgumentException()
        }
    }

    fun getPoints(): List<Point> {
        return listOf<Point>(point1.clone(), point2.clone())
    }

    fun getLength(): Double = getLength(point1, point2)

    private fun getLength(point1: Point, point2: Point): Double {
        return hypot(abs(point1.x - point2.x), abs(point1.y - point2.y))
    }

    fun getSlope(): Double {
        val dx = point1.x - point2.x
        val dy = point1.y - point2.y
        if (dx == 0.0) return Double.POSITIVE_INFINITY
        if (dy == 0.0) return 0.0
        return dy/dx
    }

    fun move(dx: Double, dy: Double) {
        point1.move(dx, dy)
        point2.move(dx, dy)
    }
}