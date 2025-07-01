class Point(
     x: Double,
     y: Double
){

    var x: Double = validateValue(x)
        private set
    var y: Double = validateValue(y)
        private set

    fun clone(): Point {
        return Point(x, y)
    }

    fun move(dx: Double, dy: Double) {
        x += validateValue(dx)
        y += validateValue(dy)
    }

    private fun validateValue(value: Double): Double {
        if (value.isNaN() || value.isInfinite()) {
            throw IllegalArgumentException()
        }
        return value
    }
}