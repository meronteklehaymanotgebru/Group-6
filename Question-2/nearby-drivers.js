function simpleDistance(loc1, loc2) {
  const dx = loc1.lat - loc2.lat;
  const dy = loc1.lon - loc2.lon;
  return Math.sqrt(dx * dx + dy * dy);
}
function findNearbyDrivers(userLoc, drivers, maxDistance) {
  return drivers.filter(driver =>
    simpleDistance(userLoc, driver.location) <= maxDistance
  );
}

const userLocation = { lat: 10, lon: 20 };

const drivers = [
  { id:1, location: { lat: 10.2, lon: 20.1 } },
  { id:2 , location: { lat: 15, lon: 24 } },
  { id:3, location: { lat: 9.9, lon: 19.8 } }
];

const maxDistance = 1; 
const nearbyDrivers = findNearbyDrivers(userLocation, drivers, maxDistance);
console.log("Nearby drivers:", nearbyDrivers);