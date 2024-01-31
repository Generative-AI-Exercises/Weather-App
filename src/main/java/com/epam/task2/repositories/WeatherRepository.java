package com.epam.task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.task2.entities.WeatherData;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
    Optional<WeatherData> findByCityName(String cityName);
    Optional<WeatherData> findByZipCode(String zip);
}