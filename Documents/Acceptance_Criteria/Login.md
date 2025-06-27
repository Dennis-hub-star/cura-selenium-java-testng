**User story**: As a user, I want to log in using my email and password, so that I can make an appointment.


**Given** that the user is on a home page.
**When** the user click on **make appointment** button
**And** the user enters a valid username and password
**Then** the user should be taken to the appointment form

**Given** that the user is on a home page.
**When** the user click on the hamburger menu button
**And** then click on the login option
**And** the user enters a valid username and password
**Then** the user should be taken to the appointment form


**Given** that the user is on a home page.
**When** the user enters a valid username and leave the password field empty
**Then** the user should not be granted an access to the appointment form
**And** an error message should be displayed (message: Login failed! Please ensure the username and password are valid.)
**And** the password and username fields should be emptied 


**Given** that the user is on a home page.
**When** the user enters a valid password and leave the username field empty
**Then** the user should not be granted an access to the appointment form
**And** an error message should be displayed (message: Login failed! Please ensure the username and password are valid.)
**And** the password and username fields should be emptied 


**Given** that the user is on a home page.
**When** the user enters a invalid password or username 
**Then** the user should not be granted an access to the appointment form
**And** an error message should be displayed (message: Login failed! Please ensure the username and password are valid.)
**And** the password and username fields should be emptied 





