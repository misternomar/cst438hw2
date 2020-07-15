package cst438hw2.service;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.assertj.core.api.Assertions.assertThat;

import cst438hw2.domain.*;
 
@SpringBootTest
public class CityServiceTest {

	@MockBean
	private WeatherService weatherService;
	
	@Autowired
	private CityService cityService;
	
	@MockBean
	private CityRepository cityRepository;
	
	@MockBean
	private CountryRepository countryRepository;

	
	@Test
	public void contextLoads() {
	}


	@Test
	public void testCityFound() throws Exception {		
		City city = new City(1, "TestCity", "DistrictTest", "100000", 300000);
		List<City> cities = Lists.newArrayList(city);
		Country country = new Country("test", "DistrictTest");
		TempAndTime tempTime = new TempAndTime(2.0, 2, 1);
		given(cityRepository.findByName("TestCity")).willReturn(cities);
		given(countryRepository.findByCode("DistrictTest")).willReturn(country);
		given(weatherService.getTempAndTime("TestCity")).willReturn(tempTime);
		CityInfo ci = cityService.getCityInfo("TestCity");
		double fahrenheit = (2.0 - 273.15) * 9.0/5.0 + 32.0;
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		TimeZone tz = TimeZone.getTimeZone("UTC");
		tz.setRawOffset((int) 1 * 1000);
		sdf.setTimeZone(tz);
		Date date = new Date(now);
		String  formattedDate  =  sdf.format(date);
		CityInfo ce = new CityInfo(city, "DistrictTest", fahrenheit, formattedDate);
		assertThat(ce).isEqualTo(ci);
	}
	
	@Test 
	public void  testCityNotFound() {
		String cityName = "Malibu";
		List<City> testCity = new ArrayList <City>();
		given(cityRepository.findByName(cityName)).willReturn(testCity);
		assertThat(cityService.getCityInfo(cityName)).isNull();		
	}
	
	@Test 
	public void  testCityMultiple() {
		City city = new City(1, "TestCity", "DistrictTest", "100000", 300000);
		List<City> cities = Lists.newArrayList(city);
		cities.add(new City(2, "TestCity", "OtherTest", "20000", 400000));
		Country country = new Country("test", "DistrictTest");
		TempAndTime tempTime = new TempAndTime(2.0, 2, 1);
		given(cityRepository.findByName("TestCity")).willReturn(cities);
		given(countryRepository.findByCode("DistrictTest")).willReturn(country);
		given(weatherService.getTempAndTime("TestCity")).willReturn(tempTime);
		CityInfo ci = cityService.getCityInfo("TestCity");
		double fahrenheit = (2.0 - 273.15) * 9.0/5.0 + 32.0;
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		TimeZone tz = TimeZone.getTimeZone("UTC");
		tz.setRawOffset((int) 1 * 1000);
		sdf.setTimeZone(tz);
		Date date = new Date(now);
		String  formattedDate  =  sdf.format(date);
		CityInfo ce = new CityInfo(city, "DistrictTest", fahrenheit, formattedDate);
		assertThat(ce).isEqualTo(ci);
		
	}

}
