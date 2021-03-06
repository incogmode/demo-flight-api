package com.demo.flights.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightData extends JpaRepository<Flight, Long> {
	List<Flight> findByAirlineCode(String string);


}
