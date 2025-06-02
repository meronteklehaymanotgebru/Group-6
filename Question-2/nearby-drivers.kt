import kotlin.math.sqrt
import kotlin.math.pow
fun main(){
    val maxDistance=7.00
    val drivers = listOf(
        Driver(name = "Noah", location = Location(lat = 27.7490, lon = 12.40)),
        Driver(name = "Mike", location = Location(lat = 37.634, lon = 20.40)),
        Driver(name = "Caleb", location = Location(lat = 37.80, lon = 11.14))
    )
    val userLocation = Location(lat = 37.49, lon = 22.41)
    println(findNearbyDrivers(userLocation,drivers,maxDistance))
}



data class Location(val lat: Double, val lon: Double)
data class Driver(val name: String, val location: Location)
fun simpleDistance(loc1: Location, loc2: Location): Double {
    val dx = loc1.lat - loc2.lat
    val dy = loc1.lon - loc2.lon
    return sqrt(dx.pow(2) + dy.pow(2))
}
fun findNearbyDrivers(userLoc: Location, drivers: List<Driver>, maxDistance: Double): List<Driver> {
    return drivers.filter { driver ->
        simpleDistance(userLoc, driver.location) <= maxDistance
    }
}