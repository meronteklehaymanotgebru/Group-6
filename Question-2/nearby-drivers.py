from math import sqrt
class Location:
    def __init__(self, lat, lon):
        self.lat = lat
        self.lon = lon

class Driver:
    def __init__(self, id, location):
        self.id = id
        self.location = location

def simple_distance(loc1, loc2):
    dx = loc1.lat - loc2.lat
    dy = loc1.lon - loc2.lon
    return sqrt(dx**2 + dy**2)

def find_nearby_drivers(user_location, drivers, max_distance):
    return [d for d in drivers if simple_distance(user_location, d.location) <= max_distance]

user_loc = Location(3, 2)
drivers = [
    Driver(1, Location(3, 2)),
    Driver(2, Location(1, 5)),
    Driver(3, Location(1, 4))
]
nearby = find_nearby_drivers(user_loc, drivers, 1)
for n in nearby:
    print(f"Driver id: {n.id}\nLocation: {n.location.lat} and {n.location.lon}")