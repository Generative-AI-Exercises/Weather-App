package com.epam.task2.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;

import com.epam.task2.entities.WeatherApiResponse;
import com.epam.task2.entities.WeatherData;
import com.epam.task2.exceptions.ResourceNotFoundException;
import com.epam.task2.repositories.WeatherRepository;
import com.epam.task2.services.WeatherService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{

	private final WeatherRepository weatherRepository;

    @Scheduled(fixedRateString = "PT1H")
    public void updateWeatherData() {
        // Call to weather API to update all records
        // A sample API calling code (make sure `WeatherApiResponse` matches the structure of your API response)

        RestTemplate restTemplate = new RestTemplate();
        WeatherApiResponse response = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q={cityName}", WeatherApiResponse.class);
        // Convert response to `WeatherData` and save it
    }

    public Optional<WeatherData> getWeatherByCityName(String cityName) {
        return weatherRepository.findByCityName(cityName);
    }

    public Optional<WeatherData> getWeatherByZip(String zip) {
        return weatherRepository.findByZipCode(zip);
    }
	

}
