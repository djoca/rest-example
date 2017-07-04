# Rest Example

This is a simple REST example that calculates the sum of two integer numbers.

## Requirements

Java 1.8 or better

Maven 3.5 or better

Git 2.11 or better

## Quick start

Clone this project using the command bellow:

`git clone https://github.com/djoca/rest-example.git`

Start the server with maven:

`mvn spring-boot:run`

## Using the REST API

With the server running, make POST request to the following address:

`http://localhost:8080/calculation/add/result`

Your POST request must contain a JSON with the parameters in the content body. The key names must be "A" and "B".

`{"A": 2, "B": 3}`

Once posted, the server should respond with another JSON containing the calculation result

`{"RESULTADO": 5}`

## Using the REST API with CURL

If you have CURL, you can post like that:

`curl -X POST -H "Content-type: application/json" -d "{\"A\": 2, \"B\": 3}" "http://localhost:8080/calculation/add/result"`

## Tests

Integration tests are included and you can run them with Maven.

`mvn test`
 
