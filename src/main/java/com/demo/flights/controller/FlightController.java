package com.demo.flights.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flights.model.IFlightData;
import com.demo.flights.model.Flight;

@RestController
//@RequestMapping("/api")

public class FlightController {
	
	private final IFlightData flightData;

	public FlightController(IFlightData flightData) {
		this.flightData = flightData;
	}
	
	@GetMapping("/")
	public String index() {
		String html = "<html><a href='http://localhost:8080/GET/flights'>Get all flights.</a><br>"
				+ "<a href='http://localhost:8080/GET/flights/code/EK'>Get by airline code.</a><br>"
				+ "<a href='http://localhost:8080/GET/flights/airline?code=EK'>Get by airline code using param.</a><br> </html>";											
		return html;
	}
	
	//ALL
	@GetMapping("GET/flights")
    public List<Flight> getFlights() {
        return flightData.findAll();
    }
	
	@GetMapping("GET/flights/{id}")
    public Flight getID(@PathVariable Long id) {
        return flightData.findById(id).orElseThrow(RuntimeException::new);
    }
	
	//airline code
	@SuppressWarnings("rawtypes")
	@GetMapping("GET/flights/code/{airlineCode}")
    public List findByFlightNumber(@PathVariable String airlineCode) {
        return flightData.findByAirlineCode(airlineCode);
    }
	
	//airline code param
	@SuppressWarnings("rawtypes")
	@GetMapping("GET/flights/airline")
    public List findByFlightCode(@RequestParam(required = false) String code) {
        return flightData.findByAirlineCode(code);
    }
	
	@SuppressWarnings("rawtypes")
	@PostMapping("POST/flights")
    public ResponseEntity createFlight(@RequestBody Flight fdata) throws URISyntaxException {
		Flight savedFlight = flightData.save(fdata);
        return ResponseEntity.created(new URI("/flights/" + savedFlight.getId())).body(savedFlight);
    }
	


    


}
