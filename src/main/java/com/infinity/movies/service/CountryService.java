package com.infinity.movies.service;

import com.infinity.movies.entity.Country;
import com.infinity.movies.model.CountryModel;

public interface CountryService {

    Country getCountryById(Long id);

    Iterable<Country> getCountries();

    Country addCountry(CountryModel countryModel);

    Country updateCountry(Long id, CountryModel countryModel);

    void deleteById(Long id);
}
