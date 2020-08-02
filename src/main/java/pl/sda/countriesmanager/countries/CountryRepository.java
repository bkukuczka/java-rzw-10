package pl.sda.countriesmanager.countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);

    @Query("from Country c where " +
            "c.population > :minPopulation " +
            "or " +
            ":minPopulation = null")
    Collection<Country> findAllWithMinPopulation(Integer minPopulation);
}