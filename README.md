Feedback System 
========================
Currently running on Openshift for testing @
http://data-bakharzy.rhcloud.com/api

The prototype tool is a cloud-based application that can be accessed via HTTP protocol. In order to collect, store and retrieve user usage data, external software applications can use this tool to track any action which is the object of interest for them. Action refers to any event happening in software applications. For instance, clicking on buttons for different purposes (sign up, purchase, share some article, etc) are actions performed by users of software application. In order to send the action data to the prototype tool, each software application (mobile application, web application, etc) needs to be registered in the prototype tool database as an application. Therefore, there are two entities stored on the database, application and its related actions. 

For registering an application in the prototype tool database, a HTTP POST request must be sent to the address where the prototype tool is deployed on the cloud. Each application needs to provide a name and an email for registration. 

After receiving this POST request by the tool, a unique identifier (application ID) will be assigned to the new application and the application entity is created in the database. Then the server will return a JSON object to the sender. In the JSON object, the application ID, name and email are sent back in the response. Application ID is used for identification of applications whenever they want to send their action data to the prototype tool. Since the tool is a simple prototype, there is no further security check implemented like providing password or SSH keys when contacting the server. 

To communicate with the prototype tool, a REST API is provided. Via the REST API, it is possible to delete an existing application, update application name and email or retrieve the information of an existing application. 
Once the application is registered and an application ID is assigned to it, actions happening in the application can be reported. For example, Carat application is now registered on the prototype tool database and has an application ID. In order to report any action, Carat application requires to send a HTTP POST request to the server to the address dedicated to Carat application. Each application is identified by the application ID they use when connecting the server. 
The information about an action must be written to a JSON object with a specific format and send the JSON object within the HTTP POST request. The format of the JSON object contains a name, user-name and an options field which can have arbitrary number of pairs. The name is the name of the action, the user-name is the user who is performing the action. In the options field, arbitrary number of key/value pairs could be set. This gives the flexibility to the application to collect as many data as needed in any data type. After sending the HTTP POST request to the server, the server will create a new action with the fields from JSON object, the time that the action is reported and a unique identifier (action ID) for the action. Then, the server sends back a response to the application the data which is stored for the corresponding action. The action ID can be used to delete an action or retrieve the data of an existing action. It is also possible that all the actions of one application are listed via a GET HTTP request. Documentation of the API as well as the source code

Initial API documentation:

1. To create an application:
-----------------------------


    POST		http://data-bakharzy.rhcloud.com/api/app/applications?name=youApplicationNAme&email=yourEmailAddress 

This request will return a JSON format object of your application ID and its other attributes.

2. To delete an application and its actions:
--------------------------------------------

    POST		http://data-bakharzy.rhcloud.com/api/app/applications/yourAppID

For example:

    POST		http://data-bakharzy.rhcloud.com/api/app/applications/79e029df-b356-4d4c-b67d-30ddaabe268d

This request will return a JSON format object of your removed application.

3. To update the name or email of an existing application:
------------------------------------------------------------

    PUT		http://data-bakharzy.rhcloud.com/api/app/applications/yourAppID

For example:

    PUT		http://data-bakharzy.rhcloud.com/api/app/applications/79e029df-b356-4d4c-b67d-30ddaabe268d

A JSON object of your application and its changes needed to be sent within HTTP request. An example of the JSON object is as below:

    {
        "id": "79e029df-b356-4d4c-b67d-30ddaabe268d",
        "name": "new name",
        "email": "new Email"
    } 

This request will return a JSON format object of your updated application.

4. To get the information of an existing application:
------------------------------------------------------

    GET		http://data-bakharzy.rhcloud.com/api/app/applications/yourAppID

For example:

    GET		http://data-bakharzy.rhcloud.com/api/app/applications/6affe554-96d3-4987-a029-feea015a1354

This request will return a JSON format object of your requested application.

5. To add an action to an existing application:
---------------------------------------------------

    POST		http://data-bakharzy.rhcloud.com/api/app/applications/yourAppID/actions

For example:

    POST		http://data-bakharzy.rhcloud.com/api/app/applications/6affe554-96d3-4987-a029-feea015a1353/actions

A JSON object of your action and its attributes needed to be sent within HTTP request. An example of the JSON object is as below. Note that options can contain arbitrary number of pairs.

    {
        "name": "kill button",
        "username": "user001",
        "options": {
            "key1": "value1",
            "key2": "value2",
            "keyN": "valueN"
        }
    }

This request will return a JSON format object of your created action.

6. To delete an action of an existing application:
---------------------------------------------------------

    POST		http://data-bakharzy.rhcloud.com/api/app/applications/yourAppID/actions/yourActionID 

For example:

    POST		http://data-bakharzy.rhcloud.com/api/app/applications/25690129-d44d-48e0-8fb6-e131bdd54915/actions/6ad84853-9077-4357-8c8d-6f7e6639a2a7

A message about whether the action has been deleted successfully or not will be returned.

7. To get the information of an existing action:
-----------------------------------------------------

    GET		http://data-bakharzy.rhcloud.com/api/app/applications/yourAppID/actions/yourActionID 

For example:

    GET		http://data-bakharzy.rhcloud.com/api/app/applications/25690129-d44d-48e0-8fb6-e131bdd54915/actions/89a9468e-de96-44d5-9cf8-cceeb0960cb0

This request will return a JSON format object of your requested action.

8. To get the information of all the actions of an existing application:
-------------------------------------------------------------------------

    GET		http://data-bakharzy.rhcloud.com/api/app/applications/yourAppID/actions 

For example:

    GET		http://data-bakharzy.rhcloud.com/api/app/applications/25690129-d44d-48e0-8fb6-e131bdd54915/actions

This request will return JSON format objects of your requested actions of your application.
