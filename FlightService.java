package Backend Component;

@Service
public class FlightService {
    @ **FlightService.java**
```java
@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight existingFlight = getFlightById(id);
        if (existingFlight != null) {
            existingFlight.setAirline(flight.getAirline());
            existingFlight.setFlightNumber(flight.getFlightNumber());
            existingFlight.setDepartureAirport(flight.getDepartureAirport());
            existingFlight.setArrivalAirport(flight.getArrivalAirport());
            existingFlight.setDepartureTime(flight.getDepartureTime());
            existingFlight.setArrivalTime(flight.getArrivalTime());
            return flightRepository.save(existingFlight);
        } else {
            return null;
        }
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
