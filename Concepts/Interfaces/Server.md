# Server Interface

## Service
The server offer only the simple service of being an repository of realtime data that is used for this application.

## Usage
The server should never be accessed nor updated manually but only by a secondary source, the **Controller** or the **Client** can makes these updates to the data, with exceptions between the Controller and client of course. 

## Availability
The server will be available once the service is executed, the controller and clients *Must* be on the same network in order to establish a connection. Once a connection is lost between the client or controller, the interfaces won't be able to make or view any changes.

