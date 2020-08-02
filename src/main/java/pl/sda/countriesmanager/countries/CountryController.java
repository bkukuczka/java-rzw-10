package pl.sda.countriesmanager.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(path = "/countries")
@RestController
public class CountryController {

    CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<CountryDto>> getCountries() {
        var countries = service.getAllCountries();

        return ok().body(countries);
    }

    @GetMapping("/{countryName}")
    public CountryDto getCountryById(@PathVariable String countryName) {
        return service.findByName(countryName);
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