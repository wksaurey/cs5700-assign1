class Circle(
    point: Point,
    radius: Double
): Square(point, radius*2) {
    var radius: Double = validateValue(radius)
}