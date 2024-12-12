package Backend Component;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport) {
        Airport existingAirport = getAirportById(id);
        if (existingAirport != null) {
            existingAirport.setName(airport.getName());
            existingAirport.setCode(airport.getCode());
            return airportRepository.save(existingAirport);
        } else {
            return null;
        }
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
