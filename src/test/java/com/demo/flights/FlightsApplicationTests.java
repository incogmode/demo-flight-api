package com.demo.flights;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightsApplicationTests {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void getDefault() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	@Test
	public void getAllFlight() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/GET/flights").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}