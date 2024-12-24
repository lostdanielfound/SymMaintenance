# SymMaintenance

## Description
An maintenance tracking application that keeps and analyzes records of maintenance tasks to provide a suite of organized and real time tasks reporting to a team of production technicians. 

## Disclaimer
This application is not approved or related to any company and thus should **Not** be used in actually production of some sort. I made this to practice making an application organized with clean architecture 

## Functionality
This service is setup and organize with 3 endpoints, **Controller**, **Server**, and the **Client**. 

#### Controller
The user that enters in new maintenance tasks at the time or planned for later throughout other shift times. These users are able to do the following: 
- Create new tasks
- Complete and un-complete a task
- Modify tasks and plan tasks

#### Client
The device that fetches and presents the current realtime tasks, users are able to do the following: 
- Complete and un-complete a task
- Initial a task
- Comment on a maintenance task. 

(This concept would be meant for those that are allowed to use authorized devices on the production floor, using unauthorized devices on the floor is dangerous and will present hazards to those using it and around the user.)

#### Server
- The device that stores and delivers / updates tasks between the Controller and Clients.

## Type of Tasks
- Wrangle
- Push
- Deck location
- Aisle location
- PM
- Other

## Requirements

#### Controller
Controllers are able to perform app operations via SymMaintenance web application, this application is only accessable when the server is setup and running locally on the same connected network. 

#### Client
Clients must install the client application on their approved floor device and connect to the proper Websocket service. The client Application can be installed **Here** (Application not setup).

#### Server
This device must be setup on an approved device in an internal network which has websockets ports open and listening. 
