package ru.rsreu.savushkin.pr3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rsreu.savushkin.pr3.entity.Country;
import ru.rsreu.savushkin.pr3.repository.CountryRepository;

import java.util.List;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
