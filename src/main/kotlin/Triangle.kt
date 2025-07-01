import kotlin.math.abs

class Triangle(
    private val point1: Point,
    private val point2: Point,
    private val point3: Point
) {
    init {
        validatePoints(point1, point2, point3)
    }

    fun getPoints(): List<Point> {
        return listOf(point1.clone(), point2.clone(), point3.clone())
    }

    fun getArea() = getArea(point1, point2, point3)

    private fun getArea(point1: Point, point2: Point, point3: Point): Double {
        return .5 * abs(point1.x * (point2.y - point3.y) + point2.x * (point3.y - point1.y) + point3.x * (point1.y - point2.y))
    }

    private fun validatePoints(point1: Point, point2: Point, point3: Point) {
        if (getArea(point1, point2, point3) == 0.0) {
            throw IllegalArgumentException("area must be greater than zero")
        }
    }
}