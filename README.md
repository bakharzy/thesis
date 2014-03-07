Feedback System 
========================
Currently running on Openshift for testing:
http://data-bakharzy.rhcloud.com/root

Architecture overview
* Please click on the picture. to enlarge the picture.

![Alt text](/lib/2014-02-19 00.58.28.jpg?raw=true "General architecture")


Initial API documentation:

1. To create an application:

GET		http://localhost:8080/feedbackSystem/app/applications?name=youApplicationNAme&email=yourEmailAddress 

This request will return a JSON format object of your application ID and its other attributes.
------------------------------------------------------------------------------------------------------------------------
2. To delete an application and its actions:

POST		http://localhost:8080/feedbackSystem/app/applications/yourAppID

For example:

POST		http://localhost:8080/feedbackSystem/app/applications/79e029df-b356-4d4c-b67d-30ddaabe268d

This request will return a JSON format object of your removed application.
-----------------------------------------------------------------------------------------------------------------------
3. To update the name or email of an existing application:

PUT		http://localhost:8080/feedbackSystem/app/applications/yourAppID

For example:

PUT		http://localhost:8080/feedbackSystem/app/applications/79e029df-b356-4d4c-b67d-30ddaabe268d

A JSON object of your application and its changes needed to be sent within HTTP request. An example of the JSON object is as below:
{
    "id": "79e029df-b356-4d4c-b67d-30ddaabe268d",
    "name": "new name",
    "email": "new Email"
} 

This request will return a JSON format object of your updated application.
-----------------------------------------------------------------------------------------------------------------------
4. To get the information of an existing application:

GET		http://localhost:8080/feedbackSystem/app/applications/yourAppID

For example:

GET		http://localhost:8080/feedbackSystem/app/applications/6affe554-96d3-4987-a029-feea015a1354

This request will return a JSON format object of your requested application.
-----------------------------------------------------------------------------------------------------------------------
5. To add an action to an existing application:

POST		http://localhost:8080/feedbackSystem/app/applications/yourAppID/actions

For example:

POST		http://localhost:8080/feedbackSystem/app/applications/6affe554-96d3-4987-a029-feea015a1353/actions

A JSON object of your action and its attributes needed to be sent within HTTP request. An example of the JSON object is as below:

{
 "name":"kill button",
 "username":"user0909",
 "options":"facebook app"
} 

This request will return a JSON format object of your created action.
-----------------------------------------------------------------------------------------------------------------------
6. To delete an action of an existing application:

POST		http://localhost:8080/feedbackSystem/app/applications/yourAppID/actions/yourActionID 

For example:

POST		http://localhost:8080/feedbackSystem/app/applications/25690129-d44d-48e0-8fb6-e131bdd54915/actions/6ad84853-9077-4357-8c8d-6f7e6639a2a7

A message about whether the action has been deleted successfully or not will be returned.
-----------------------------------------------------------------------------------------------------------------------
7. To get the information of an existing action:

GET		http://localhost:8080/feedbackSystem/app/applications/yourAppID/actions/yourActionID 

For example:

GET		http://localhost:8080/feedbackSystem/app/applications/25690129-d44d-48e0-8fb6-e131bdd54915/actions/89a9468e-de96-44d5-9cf8-cceeb0960cb0

This request will return a JSON format object of your requested action.
-----------------------------------------------------------------------------------------------------------------------
8. To get the information of all the actions of an existing application:

GET		http://localhost:8080/feedbackSystem/app/applications/yourAppID/actions 

For example:

GET		http://localhost:8080/feedbackSystem/app/applications/25690129-d44d-48e0-8fb6-e131bdd54915/actions

This request will return JSON format objects of your requested actions of your application.
