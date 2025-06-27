**User story**: As a user that is logged in, I want to make an appointment, so that I can receive medical.


**Given** that the user is on a form.
**When** the user picks a date
**And** leaves the "Apply for hospital readmission" check box unchecked 
**And** click on **Book Appointment** button
**Then** the user should be taken to the appointment confirmation page

**Given** that the user is on a form.
**When** the user picks a date
**And** check the "Apply for hospital readmission" checkbox 
**And** click on **Book Appointment** button
**Then** the user should be taken to the appointment confirmation page 

**Given** that the user is on a form.
**When** the user picks a date
**And** fill the comment field or leaves it empty 
**And** click on **Book Appointment** button
**Then** the user should be taken to the appointment confirmation page   

**Given** that the user is on a form.
**When** the user does not pick a date
**And** check the "Apply for hospital readmission" checkbox 
**And** click on **Book Appointment** button
**Then** the user should not be taken to the appointment confirmation page  
**And** the "fill out this field" pop-up should appear together with the date picker