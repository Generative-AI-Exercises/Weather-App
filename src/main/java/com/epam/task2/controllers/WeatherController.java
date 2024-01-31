package com.epam.task2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epam.task2.entities.WeatherData;
import com.epam.task2.services.WeatherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController  {

	private final WeatherService weatherService;
	
    @GetMapping("/city/{cityName}")
    public WeatherData getWeatherByCity(@PathVariable String cityName) {
        Optional<WeatherData> weatherData = weatherService.getWeatherByCityName(cityName);
        return weatherData.orElse(null);
    }

    @GetMapping("/zip/{zip}")
    public WeatherData getWeatherByZip(@PathVariable String zip) {
        Optional weatherData = weatherService.getWeatherByZip(zip);
        return (WeatherData) weatherData.orElse(null);
    }

}
