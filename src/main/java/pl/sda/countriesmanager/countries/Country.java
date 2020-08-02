package pl.sda.countriesmanager.countries;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String capital;
    private String language;
    private String currency;
    private int population;
}