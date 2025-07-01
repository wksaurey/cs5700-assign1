class Rectangle(
    point: Point,
    width: Double,
    height: Double
): Square(point, width) {
    var height: Double = validateValue(height)
        private set

    override fun getArea() = width * height
}