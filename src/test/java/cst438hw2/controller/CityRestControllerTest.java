package cst438hw2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.*;
import cst438hw2.domain.*;
import cst438hw2.service.CityService;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(CityRestController.class)
public class CityRestControllerTest {

	@MockBean
	private CityService cityService;

	@Autowired
	private MockMvc mvc;

	// This object will be magically initialized by the initFields method below.
	private JacksonTester<CityInfo> json;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void getCityInfo() throws Exception {
		City city = new City(1, "TestCity", "DistrictTest", "100000", 300000);
		CityInfo cityI = new CityInfo(city, "CountryName", 99.90, "25200");
		given(cityService.getCityInfo("TestCity")).willReturn(cityI);
		MockHttpServletResponse response = mvc.perform(get("/api/cities/TestCity")).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualByComparingTo(HttpStatus.OK.value());
		CityInfo cityResult = json.parseObject(response.getContentAsString());
		CityInfo expectedResult = cityI;
		assertThat(cityResult).isEqualTo(expectedResult);
	}

	
}
