package pl.sda.countriesmanager.countries;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RequestMapping(path = "/countries",
        produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class CountryController {

    CountryService service;

    CountryMapper mapper;

    @ApiOperation(value = "Returns all countries with optional minimum population filter", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Get all countries succeeded")
    @GetMapping
    public ResponseEntity<Collection<CountryDto>> getCountries(
            @RequestParam("minPopulation") Integer minPopulation) {

        var countries = service.getAllCountries(minPopulation).stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ok().body(countries);
    }

    @ApiOperation(value = "Returns a specific country with given name", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Get a specific country succeeded")
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