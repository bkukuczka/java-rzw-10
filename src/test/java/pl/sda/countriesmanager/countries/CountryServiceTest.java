package pl.sda.countriesmanager.countries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Import({CountryService.class})
@ExtendWith(SpringExtension.class)
class CountryServiceTest {

    @MockBean
    CountryRepository repository;

    @Autowired
    CountryService service;

    @Test
    void shouldGetCountryFromRepositoryByName() {
        //given
        var anyCountryName = "Poland";

        var expectedCountry = Country.builder()
                .name(anyCountryName)
                .build();

        Mockito.when(repository.findByName(anyCountryName))
                .thenReturn(Optional.of(expectedCountry));

        //when
        var resultCountry = service.findByName(anyCountryName);

        //then
        assertThat(resultCountry, notNullValue());

        assertThat(resultCountry.getName(), is(anyCountryName));
    }
}