Video Rental Service
===================

This library is a quick exercise about how to create an API for a video rental service 

Quick start guide
-----------------

- Download from github:
git clone https://github.com/maduxi/rentalservice.git

- Enter into the project folder and compile it:
cd rentalservice/
mvn clean package

- If compilation is successful, the project is ready to run! Launch the server:
java -jar target/video-rental-service-*.jar

API description
---------------
There are three main domain objects on the API:

- User
Has three attributes, id, name and bonusPoints.

- Film
Has three attributes, id, name and type.

- Rent
The most complex one. It has filmId, userId, days, rentDay (yyyy-MM-dd), type (NEW | REGULAR | OLD), price and returned.

Create examples (from terminal using curl):
---------------
- User:
curl -H "Content-Type: application/json" -X POST -d '{"name":"Madhava"}' http://localhost:8080/user
-- {"id":1,"name":"Madhava","bonusPoints":0}

- Film
curl -H "Content-Type: application/json" -X POST -d '{"name":"Matrix3","type":"NEW"}' http://localhost:8080/film
-- {"id":1,"name":"Matrix3","type":"NEW"}
curl -H "Content-Type: application/json" -X POST -d '{"name":"Matrix2","type":"REGULAR"}' http://localhost:8080/film
-- {"id":2,"name":"Matrix2","type":"REGULAR"}
curl -H "Content-Type: application/json" -X POST -d '{"name":"Matrix1","type":"OLD"}' http://localhost:8080/film
-- {"id":3,"name":"Matrix1","type":"OLD"}

- Rent
curl -H "Content-Type: application/json" -X POST -d '{"filmId":3,"userId":1,"days":1}' http://localhost:8080/rent
-- {"id":1,"filmId":3,"userId":1,"days":1,"rentDay":"2016-01-12","type":"OLD","price":0.0,"returned":false}

List entities
-------------
- User  
http://localhost:8080/user

- Film
http://localhost:8080/film

Return a film
-------------

Return rent id 1:
curl http://localhost:8080/rent/1/return
-- {"surcharge":0.0}

Configure prices
----------------
Edit the properties file:
src/main/resources/price.properties


Work left to do:

- Data integrity (entities relationships). Important point, but not much time left.
- Data validation. If had more time, I would have used the JSR-303 annotations...
- Testing of controller methods.
- Implement all CRUD operations (Update, delete...).
- Persistent database.
- List of rents per user.
- When a movie should be returned.
- Alert of long time overdue film rents.
- Create a way of testing surcharges through the API. 




