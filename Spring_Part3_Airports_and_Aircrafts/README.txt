Recordable: `Aircraft` and` Airport`.
Add an Aircraftattribute to the category airportthat describes the airplane's home field and is of type Airport.
Define the connection so that each aircraft has one Home Field, but multiple planes can have the same Home Field.

In the Next Airportcategory aircrafts, add an attribute that describes all machines whose Home Field is that field. Attribute type is List<Aircraft>. 
Add an appropriate annotation to the connection and define the connection so that the owner of the connection is in the class Aircraft(this is done with the attribute mappedBy.

Airport setting for an airplane
Add functionality to the app to add an airport to an airplane. The user interface already contains the necessary functionality, so AircraftControllera new method for the controller class must be implemented here . Use as the method name assignAirportand return type String. When a user adds an airport to an aircraft, the user interface sends a POST-type query to the address /aircrafts/{aircraftId}/airportswhere the aircraftIdaircraft database ID is located. The request is accompanied by a request parameter airportIdthat contains the airport database ID.

Implement the method by first retrieving the airplane and airport using the IDs obtained in the request, then setting the airplane to the airplane and the airplane to the airport,
and finally saving the airplane.

Finally, redirect the request to /aircrafts


