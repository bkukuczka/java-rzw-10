package pl.sda.countriesmanager.countries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CountryServiceTest {

    @MockBean
    CountryRepository repository;

    @Autowired
    CountryService service;

    @Test
    void shouldGetAllCountriesFromRepository() {
        //given


        //when
        var resultCountries = service.getAllCountries();

        //then

    }


}