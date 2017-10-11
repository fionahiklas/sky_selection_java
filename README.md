## Overview


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

