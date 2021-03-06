## Overview

Implementation of the Sky programming task

## Quick Start 

Install the prerequisites listed below and run the following command

```
mvn clean install exec:java
```

In a browser navigate to the following URL

```
http://localhost:4567
```

There are two test customer ID's

* vimes - for the London location 
* aching - for Liverpool

Enter one of these into the text box and press submit

You can now tick/un-tick products

## TODO

* Some of the work in organising the products and categories that the front-end does should be in the backend
* The models for data in the shopping basket needs a bit more thought
* There needs to be a "Purchase" button or something similar
* The whole "screen" for selecting products needs to be grouped as one so it can be removed/created
* In a real system the shopping basket would likely be at the top of the page and persist across several screens
* Need a way to persist data/state across page re-load (maybe local storage)
* Way better to use something like Angular for the UI!
* There is no sorting of products in the list or shopping basket, this means things look messy
* A polished UI would have smoother transitions 
* Ideally the Catalogue and Location services wouldn't be in this repo, they would be plugins
* More thought needed on packaging the JavaScript files - really should use require
* Really should be using bower or similar for JavaScript dependencies


## Getting Started

### Prerequisite

* Java JDK 1.8
* Maven 3.5.0 (or greater)


### Compiling the code 

Run the following command 

```
mvn clean test
```

All tests should pass


### Run the application in the IDE

Run the following class in your IDE

```
com.hiklas.mucking.around.rest.ProductSelectionApp
```

### Run from Maven

Execute the following command to run the code via Maven

```
mvn exec:java
```

### Run front end tests

***NOTE: Make sure that you have built the code (using maven), this also copies the static content files to target/classes/public***

Run the following commands

```
mvn clean install  # This is to make sure the resources are available 
mvn exec:java      # Run's the application 
```

The front-end unit tests can then be accessed in a browser using the following URL

```
http://localhost:4567/qunit/index.html
```

### Testing REST API With Curl

Run the following command from another shell

```
curl -v -b "customerID=vimes" http://localhost:4567/products
```

This should result in the following output

```
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 4567 (#0)
> GET /products HTTP/1.1
> Host: localhost:4567
> User-Agent: curl/7.54.1
> Accept: */*
> Cookie: customerID=vimes
> 
< HTTP/1.1 200 OK
< Date: Wed, 11 Oct 2017 16:52:16 GMT
< Content-Type: application/json
< Transfer-Encoding: chunked
< Server: Jetty(9.4.4.v20170414)
< 
* Connection #0 to host localhost left intact
{"products":[{"id":"skyNews1","name":"Sky News","category":"News"},{"id":"skySportsNews1","name":"Sky Sports News","category":"News"},{"id":"arsenalTV","name":"Arsenal TV","category":"Sports"},{"id":"chelseaTV","name":"Chelsea TV","category":"Sports"}]}
```



## Task

```

SKY TECHNOLOGY UNATTENDED PROGRAMMING TEST  
PRODUCT SELECTION 
 
Scenario 
A groundbreaking broadcaster has decided to trial some new channels to its customers. A software engineering team, developing the customer website, is working on the story below. 
The Account Management team has partnered with the Sales team that provides a service that offers channel subscriptions to certain customers, based on where they live. 
 
 
Display customer’s available products 
 	 
 	As a customer, I want to select the products that are available to me, based on the location of my home. 
 
 
Instructions 
You are required to provide an implementation of a catalogue service and a product selection web page. You may use any programming language/s you like. 
 
 
 	 
Background 
To help, U/X have created the following wireframe of the product selection page.  

 
When the user visits the product selection page, it can be assumed a cookie named customerID will be present, which will hold a customer identifier. 

The Customer Location Service will be called to get the customer’s location.  
The Catalogue Service will be called to get the catalogue of available products. 
The customer will add products to their basket and checkout, submitting their selection to the confirmation page.  
 	 
 
Acceptance Criteria 
Product Selection Page 
You are required to provide a web page so that 
 when the customer selects or unselects a product, the basket is updated to show the selected 
products.   when the customer chooses to checkout, the customer is taken to the confirmation page.  
 when the customer chooses to checkout, the customer’s customerID and list of selected products 
are posted to the confirmation page. 
 
Confirmation Page 
A Confirmation Page will be available, which accepts the customerID and the selected products.  
 You are required to provide a stub of the confirmation page. 
 
CustomerLocationService 
A CustomerLocationService is available which will take the customerID as an input and return one of the following outputs.  

 
 You are required to provide a stub of the CustomerLocationService interface. 
 
CatalogueService 
The locationID returned from CustomerLocationService should be passed to a CatalogueService, which must return the following products.  
 

 
The CatalogueService will only return ArsenalTV and ChelseaTV if the locationID is LONDON. 
The CatalogueService will only return LiverpoolTV if the locationID is LIVERPOOL. 
The CatalogueService will always return Sky News and Sky Sports News.  
 You are required to provide an implementation of the CatalogueService. 
 	 
What we are looking for 
 
We are interested in  
how you structure your code so that it's  o fully tested o easily extensible o easy to modify  o easy to understand by others 
If using a OOP language complies with best object-oriented practices 
If using a functional language complies with functional idioms

evidence of TDD, BDD and web testing 
knowledge of front-end AND back-end development 
evidence of ability to create eloquent and responsive web pages. 
We do not expect a polished website design for this test so please do not spend too much time on the look and feel of the web page, but we do enjoy demonstration of proper software engineering front-end techniques. 
 
Please supply us with your source code, a README file that explains how to build and run your submission, build scripts and any tests you have written. 
We expect this test to take approximately 3 hours.  
```

