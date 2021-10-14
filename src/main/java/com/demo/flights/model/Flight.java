package com.demo.flights.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")

public class Flight {
	
	@Id
    @GeneratedValue
    private Long id;
	private String flightNumber;
	private String departurePort;
	private String arrivalPort;
	private Date departureTime;
	private Date arrivalTime;

	
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Flight(Long id, String flightNumber, String departurePort, String arrivalPort, Date departureTime,
			Date arrivalTime) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.departurePort = departurePort;
		this.arrivalPort = arrivalPort;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getDeparturePort() {
		return departurePort;
	}


	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}


	public String getArrivalPort() {
		return arrivalPort;
	}


	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}


	public Date getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}


	public Date getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	

}
