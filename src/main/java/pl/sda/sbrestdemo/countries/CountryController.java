package pl.sda.sbrestdemo.countries;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(path = "/countries")
@RestController
public class CountryController {

    CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<CountryDto> getCountries() {
        return service.getAllCountries();
    }

    @GetMapping("/{countryName}")
    public CountryDto getCountryById(@PathVariable String countryName) {
        return service.findByName(countryName);
    }

    @PostMapping
    public void createCountry(@RequestBody CountryDto newCountry) {
        service.createCountry(newCountry);
    }
}