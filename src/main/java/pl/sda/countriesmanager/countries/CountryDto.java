package pl.sda.countriesmanager.countries;

public class CountryDto {
    private String name;
    private String capital;
    private String language;
    private String currency;
    private int population;

    public CountryDto(String name, String capital, String language, String currency, int population) {
        this.name = name;
        this.capital = capital;
        this.language = language;
        this.currency = currency;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
