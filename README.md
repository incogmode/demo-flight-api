# demo-flight-api
Demo api




###How to run###

#1.Pull or import this package to your local machine

#2. run the ff:
  mvn clean install
  mvn spring-boot:run
  
#3. Before runnng the end-points, build some dummy data using postman. You may use the script below and Import as "Raw text":\

curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X POST --data 
  '{"id":19,"flightNumber":"12234","departurePort":"PH","arrivalPort":"X","departureTime":"2021-10-16T08:30:00.000+00:00","arrivalTime":"2021-10-16T13:30:00.000+00:00","airlineCode":"EK","airlineDesc":"Emirates"}' "http://localhost:8080/POST/flights"


4. Check and run the endpoints

# URL end-points

get all flights
http://localhost:8080/api/GET/flights

get flight id
http://localhost:8080/api/GET/flights/{id}

get airline code
http://localhost:8080/api/GET/flights/code/{airlineCode}




# Existing port error solution
Follow steps below to manually terminate existing port

> netstat -ano | findstr {the port you use. ie 8080}

> taskkill /F /PID {pid}
