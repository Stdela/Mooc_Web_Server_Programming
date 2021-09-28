Reload Heroes keeps track of user reloads of the page. When a user first enters the app, a random username is created for him and the number of his visits is put together. 
With each revisit, the number of user visits increases by one.


The method should return the five most reloaded users in order of magnitude as the model attribute "scores". 
In the first place in the list is the person who made the most reloads, in the second place the second most, etc.
In addition, the method must return the status associated with the requesting person as an ReloadStatusattribute of the model. 
If the user has not made any requests before, the user must create a new ID and initialize the number of reloads together. 
On the other hand, if the user has made requests before, the number of requests made by the user should be increased by one. 
Information on the number of requests should also be stored in the database.
