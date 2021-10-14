package com.demo.flights.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
//@RequestMapping("/flights")

public class FlightController {
	
	private final IFlightData flightData;

	public FlightController(IFlightData flightData) {
		this.flightData = flightData;
	}
	
	@RequestMapping("GET/flights")
	@GetMapping
    public List<Flight> getFlights() {
        return flightData.findAll();
    }
	
	@RequestMapping("/flights/{id}")
	//@GetMapping("/{id}")
    public Flight getFightID(@PathVariable Long id) {
        return flightData.findById(id).orElseThrow(RuntimeException::new);
    }
	
	
//	@GetMapping(path = {"/user", "/user/{data}"})
//	public void user(@PathVariable(required=false,name="data") String data,
//            @RequestParam(required=false) Map<String,String> qparams){
//
//		qparams.forEach((a,b) -> 
//	        System.out.println(String.format("%s -> %s",a,b));
//	    
//		
//		}
	
//	
//	@GetMapping("/today")
//	public @ResponseBody List<Flight> fetchResult(@DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate) {
//		return flightData.findAll();
//    }


//	@GetMapping("/today")
//    public List<Flight> findAllFlightsToday(@PathVariable String date){
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		   LocalDateTime now = LocalDateTime.now(); 
//		   
//        return flightData.findAllFlightsToday(dtf.format(now));
//    }

    
	@SuppressWarnings("rawtypes")
	@RequestMapping("POST/flights")
	@PostMapping
    public ResponseEntity createFlight(@RequestBody Flight client) throws URISyntaxException {
		Flight savedClient = flightData.save(client);
        return ResponseEntity.created(new URI("/flights/" + savedClient.getId())).body(savedClient);
    }

}
