package ru.rsreu.savushkin.pr3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.savushkin.pr3.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
