open class Rectangle(
    centerPoint: Point,
    width: Double,
    height: Double
): Square(centerPoint, width) {
    var height: Double = validateValue(height)
        private set

    override fun getArea() = width * height
}