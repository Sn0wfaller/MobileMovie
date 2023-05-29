package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.Country;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.CountryModel;
import com.infinity.movies.repository.CountryRepository;
import com.infinity.movies.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {


    private final CountryRepository countryRepository;

    @Override
    public Country getCountryById(Long id) {

        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Страны с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Country> getCountries() {

        return countryRepository.findAll();
    }

    @Override
    public Country addCountry(CountryModel countryModel) {

        Country country = countryRepository.findCountryByName(countryModel.getName());

        if (country == null){
            country = new Country(countryModel.getName());
            countryRepository.save(country);
        }

        return country;
    }

    @Override
    public Country updateCountry(Long id, CountryModel countryModel) {

        if(!countryRepository.existsById(id)){
            throw new ResourceNotFoundException("Страны с id = " + id + " не существует.");
        }
        Country country = new Country(id, countryModel.getName());

        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {

        countryRepository.deleteById(id);
    }
}
