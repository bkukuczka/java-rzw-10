package pl.sda.countriesmanager.countries;

import org.springframework.stereotype.Service;
import pl.sda.countriesmanager.commons.exceptions.ResourceNotFound;

import java.util.*;

@Service
public class CountryService {

    private CountryRepository repository;

    private List<CountryDto> countries;

    public CountryService(CountryRepository repository) {
        this.repository = repository;

        countries = new ArrayList<>();

        countries.add(CountryDto.of("Poland", "Warsaw", "Polish", "PLN", 37970000));
        countries.add(CountryDto.of("Czech Republic", "Prague", "Czech", "CZK", 15000000));
        countries.add(CountryDto.of("USA", "Washington", "English", "USD", 360000000));
    }

    Collection<Country> getAllCountries(Integer minPopulation) {
        return repository.findAllWithMinPopulation(minPopulation);
    }

    public void createCountry(CountryDto country) {
        countries.add(country);
    }

    public Country findByName(String countryName) {
        return repository.findByName(countryName)
                .orElseThrow(() -> new ResourceNotFound("Country not found"));
    }

    public void deleteCountry(String countryName) {
        var country = findByName(countryName);

        countries.remove(country);
    }

    public void editCountry(CountryDto countryToEdit) {

    }
}