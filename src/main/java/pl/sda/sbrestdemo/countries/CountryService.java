package pl.sda.sbrestdemo.countries;

import org.springframework.stereotype.Service;
import pl.sda.sbrestdemo.commons.ResourceNotFound;

import java.util.*;

@Service
public class CountryService {

    private List<CountryDto> countries;

    public CountryService() {
        countries = new ArrayList<>();

        countries.add(new CountryDto("Poland", "Warsaw", "Polish", "PLN", 37970000));
        countries.add(new CountryDto("Czech Republic", "Prague", "Czech", "CZK", 15000000));
        countries.add(new CountryDto("USA", "Washington", "English", "USD", 360000000));
    }

    Collection<CountryDto> getAllCountries() {
        return countries;
    }

    public void createCountry(CountryDto country) {
        countries.add(country);
    }

    public CountryDto findByName(String countryName) {
        return countries.stream()
                .filter(c -> c.getName().equals(countryName))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFound("Country not exist"));
    }
}