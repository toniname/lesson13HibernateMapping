
import org.example.Client;
import org.example.ClientCrudService;
import org.example.Planet;
import org.example.PlanetCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

class CrudServiceTests {


    private ClientCrudService clientCrudService;

    private PlanetCrudService planetCrudService;

    @BeforeEach
    void setUp(){
        clientCrudService = new ClientCrudService();
        planetCrudService = new PlanetCrudService();
    }

    @Test
    void testClientCrudService(){
        Client client = new Client();
        client.setName("John Doe");
        clientCrudService.createClient(client);

        // Отримання клієнта за ID
        Optional <Client> optionalClient = Optional.ofNullable(clientCrudService.getClientById(client.getId()));
        assert optionalClient.isPresent();
        Client retrievedClient = optionalClient.get();
        assert retrievedClient.getName().equals("John Doe");

        // Оновлення ім'я клієнта
        retrievedClient.setName("Jane Smith");
        clientCrudService.createClient(retrievedClient);

        // Перевірка оновленого імені клієнта
        Optional<Client> updatedOptionalClient = Optional.ofNullable(clientCrudService.getClientById(retrievedClient.getId()));
        assert updatedOptionalClient.isPresent();
        Client updatedClient = updatedOptionalClient.get();
        assert updatedClient.getName().equals("Jane Smith");
        // Видалення клієнта
        clientCrudService.deleteClientById(updatedClient.getId());

        // Перевірка, чи видалений клієнт більше не існує
        Optional<Client> deletedOptionalClient = Optional.ofNullable(clientCrudService.getClientById(updatedClient.getId()));
        assert deletedOptionalClient.isEmpty();
    }
    @Test
    void testPlanetCrudService() {
        // Створення планети
        Planet planet = new Planet();
        planet.setId("MARS");
        planet.setName("Mars");
        planetCrudService.createPlanet(planet);

        // Отримання планети за ID
        Optional<Planet> optionalPlanet = Optional.ofNullable(planetCrudService.getPlanetById(planet.getId()));
        assert optionalPlanet.isPresent();
        Planet retrievedPlanet = optionalPlanet.get();
        assert retrievedPlanet.getName().equals("Mars");

        // Оновлення ім'я планети
        retrievedPlanet.setName("Red Planet");
        planetCrudService.createPlanet(retrievedPlanet);

        // Перевірка оновленого імені планети
        Optional<Planet> updatedOptionalPlanet = Optional.ofNullable(planetCrudService.getPlanetById(retrievedPlanet.getId()));
        assert updatedOptionalPlanet.isPresent();
        Planet updatedPlanet = updatedOptionalPlanet.get();
        assert updatedPlanet.getName().equals("Red Planet");

        // Видалення планети
        planetCrudService.deletePlanetById(updatedPlanet.getId());

        // Перевірка, чи видалена планета більше не існує
        Optional<Planet> deletedOptionalPlanet = Optional.ofNullable(planetCrudService.getPlanetById(updatedPlanet.getId()));
        assert deletedOptionalPlanet.isEmpty();
    }
}
