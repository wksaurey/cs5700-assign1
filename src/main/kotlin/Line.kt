class Line (
    point1: Point,
    point2: Point,
){
    var point1 = point1
        private set
    var point2 = point2
        private set

    fun getPoints(): List<Point> {
        return listOf(point1.clone(), point2.clone())
    }
}