Project Background
Club Name: Aftas, it's in Mirleft, a place in Tiznit.
What They Do: They offer sports like Surfing, Tennis, Quad biking, Underwater fishing, Paragliding, and more stuff.
Main Event: They set up these underwater hunting competitions in different places in Morocco. Club members can join these if they pay a fee. The club arranges all the stuff needed for these competitions and decides who judges and how to score.
What They Want in the Web App
The Main Idea: They need a web app that works well on all devices. This app should make it easier for the club and the judges to handle these competitions.
About the Members: Each member has a membership number, name, ID, where they're from, and when they joined.
Competitions: They are for single players, and they only have one competition per day.
Fish Details: They note down the scientific name of the fish, average weight, and how tough they are to catch.
Scoring: Points depend on how hard it is to catch the fish.
Key Features Needed
Joining Competitions: Members should sign up for competitions, up until a day before they start.
Managing Competitions: Adding new ones, seeing a list, and filtering them (like seeing which ones are happening now or done).
Looking Up Members: Find them by their number, name, or first name.
Recording Results: Counting fish and showing who won, second, third, etc.
Keeping Track of All Results: For everyone who took part.
Tech Stuff They Need
For the Backend: Use something called Spring Boot for the API.
How to Build It: The app should be organized in different layers.
Data Validation: Making sure all the info entered is correct.
Error Handling: Managing mistakes in a central way (they mention something like restControllerAdvice).
Pagination: This is about how you show lists of stuff, like not all on one page.
Unit Testing: Writing tests for the part that calculates competition results, with different scenarios.
API Requirements: It should have all the functions needed.
For the Frontend: Use Angular for the user interfaces.
Functional Requirements
Adding Competitions: Be able to put new competitions in the system.
Listing Competitions: Show all competitions with options to filter them.
Member Registration: Let members sign up for competitions. If they're not already in the system, they should be added.
Inserting Day's Competition Results: Put in the results of that day's competition.
Displaying the Winners: Show the top three.
