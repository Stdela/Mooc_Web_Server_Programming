In this task, you need to build a task management application that uses a database.
List all tasks. When a user makes a request to the root path of an application, they should be shown the page where the tasks are listed. 
The HTML page that comes with the task template contains information about the name of the list to be added to the Model, as well as a ready-made HTML form.
Adding a single task. When the user fills out the form and sends the information to the server, the application should add the task to the list displayed.
Displaying an individual task. When a user clicks on a link related to a task, the user should be presented with a page showing the details of one task. 
In addition, when displaying a task, the number of inspections related to the task, i.e. views, should increase by one. 
To do this, retrieve the object from the database (interface method getOne), update the value of the associated Viewpoint variable, and save the object to the database (interface method save).
