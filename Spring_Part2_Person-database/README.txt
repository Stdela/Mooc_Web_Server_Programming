Create an app to save and list people. 
In the task you must:

Create a class Person. Add a string attribute to the class nameand make the class an entity.
Create an interface for storing people PersonRepositorythat inherits the interface JpaRepository. 
Use the JpaRepositoryclass Person and the type of the class Personmaster key as the interface type parameters .
Edit the class PersonDatabaseControllerso that the class has two methods:

The method that handles the incoming GET request to the root path of the application retrieves all person objects from the database, 
adds them to the model ( Modeltype object) with the "persons" key, and transfers the processing responsibility to Thymeleaf.
The method that handles the POST request that enters the root path of the application creates a new person entity, stores it in the database, 
and redirects the browser to make a new GET-type request to the root path of the application.
