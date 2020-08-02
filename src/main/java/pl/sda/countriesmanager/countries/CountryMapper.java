package pl.sda.countriesmanager.countries;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto map(Country country);
}