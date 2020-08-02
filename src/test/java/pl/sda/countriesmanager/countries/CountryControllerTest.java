package pl.sda.countriesmanager.countries;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(controllers = {CountryController.class})
class CountryControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    CountryService mockService;

    @MockBean
    CountryMapper mockMapper;


    @Test
    void shouldEditCountryWhenChangedProvided() throws Exception {
        //given
        var countryName = "USA";

        var countryToEdit = CountryDto.builder()
                .name("USA")
                .capital("New York")
                .currency("USD")
                .language("English")
                .population(10000)
                .build();

        var editRequestCountryJson = mapper.writeValueAsString(countryToEdit);

        //when
        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.put("/countries/{countryName}", countryName)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(editRequestCountryJson));

        //then
        result.andExpect(MockMvcResultMatchers.status().isNoContent());

        Mockito.verify(mockService).editCountry(countryToEdit);
    }
}