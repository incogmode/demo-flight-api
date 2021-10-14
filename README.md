# demo-flight-api
Demo api




###How to run###

#1.Pull or import this package to your local machine

#2. run the ff:
  mvn clean install
  mvn spring-boot:run
  
#3. Before runnng the end-points, build some dummy data using postman. You may use the script below:\

curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X POST --data 
  '{"flightNumber": "123ABC", "departurePort": "PH", "arrivalPort":"X","departureTime":"2021-10-10T09:00:23Z" ,"arrivalTime":"" }' "http://localhost:8080/POST/flights"


4. Check and run the endpoints

# URL end-points

#get all flights
http://localhost:8080/GET/flights

#get flight id
http://localhost:8080/flights/{id}





#Existing port error
#Follow steps below to manually terminate existing port

> netstat -ano | findstr *<port used>*

  TCP    0.0.0.0:*<port used>*  0.0.0.0:0              LISTENING       *<pid>*
  TCP    [::]:*<port used>*     [::]:0                 LISTENING       *<pid>*

> taskkill /F /PID *<pid>*
