package pl.sda.countriesmanager.countries;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RequestMapping(path = "/countries")
@RestController
public class CountryController {

    CountryService service;

    CountryMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<CountryDto>> getCountries(
            @PathParam("minPopulation") Integer minPopulation) {

        var countries = service.getAllCountries(minPopulation).stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ok().body(countries);
    }

    @GetMapping("/{countryName}")
    public CountryDto getCountryById(@PathVariable String countryName) {
        return mapper.map(service.findByName(countryName));
    }

    @PostMapping
    public ResponseEntity<Void> createCountry(@RequestBody CountryDto newCountry) {
        service.createCountry(newCountry);

        return noContent().build();
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{countryName}")
    public void deleteCountry(@PathVariable String countryName) {
        service.deleteCountry(countryName);
    }


    @PutMapping("/{countryName}")
    public ResponseEntity<Void> editCountry(@PathVariable String countryName,
                                            @RequestBody CountryDto editedCountry) {

        service.editCountry(editedCountry);

        return ResponseEntity.noContent().build();
    }
}