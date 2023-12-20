# Project Background

## Club Name
Aftas Club

## Activities
The club offers various sports activities including:
- <link>Underwater fishing</link>

## Main Event
The club organizes underwater hunting competitions in different locations across <link>Morocco</link>. Club members can participate by paying a fee. The club manages the logistics for these competitions, including the selection of judges and scoring criteria.

## Web App Requirements
### Main Objective
The club requires a responsive web app that facilitates the management of competitions for both the club and judges.

### Member Information
Each member has a membership number, name, ID, place of origin, and registration date.

### Competitions
Competitions are for individual players and are held once per day.

### Fish Details
The app should capture the scientific name of the fish, average weight, and difficulty level in catching them.

### Scoring
Points awarded should reflect the difficulty level of catching the fish.

## Key Features Needed
- Joining Competitions: Members should be able to register for competitions up to a day before they begin.
- Managing Competitions: Adding, viewing, and filtering competitions (e.g., upcoming or completed).
- Member Lookup: Ability to search for members by their number, name, or first name.
- Recording Results: Recording and displaying competition results, including winners.
- Results Tracking: Maintaining a record of all participants' results.

## Tech Stack Requirements
### Backend
- <link>Spring Boot</link> for the API
- Layered app organization
- Data validation to ensure accuracy
- Centralized error handling (e.g., restControllerAdvice)
- Pagination for displaying lists of items
- Unit testing for competition result calculations

### API Requirements
The API should incorporate all necessary functions.

### Frontend
- <link>Angular</link> for user interfaces

## Functional Requirements
- Adding Competitions: Capability to add new competitions to the system.
- Listing Competitions: Display all competitions with filtering options.
- Member Registration: Allow members to register for competitions; new members should be added to the system if not already present.
- Inserting Competition Results: Facility to input the results of each day's competition.
- Displaying Winners: Show the top three winners.
