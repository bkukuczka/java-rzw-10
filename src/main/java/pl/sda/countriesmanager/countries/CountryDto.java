package pl.sda.countriesmanager.countries;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class CountryDto {
    private String name;
    private String capital;
    private String language;
    private String currency;
    private int population;
}