package com.epam.task2.services;

import java.util.List;
import java.util.Optional;

import com.epam.task2.entities.WeatherData;


public interface WeatherService {
	
	void updateWeatherData();
	Optional<WeatherData> getWeatherByCityName(String cityName);
	Optional<WeatherData> getWeatherByZip(String zip);
}
