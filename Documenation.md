Follow These Steps To Get Result

**Introduction**
This CRM system enables admin users to manage:

**User Registration and Authentication** - _Admin can register new users, log in, reset passwords, etc._
Task Management: CRUD operations on tasks.
Activity Logging: Track and log user activities.
Reports: Generate task-related summary reports.
**Features** 
User Management:
**Register, login, and password reset functionality**.

Task Management:
**Create, update, delete, and view tasks**.
Activity Log:

**Track all activities (task creation, updates, etc.)**.

Report Generation:

**Retrieve task summary report showing total, completed, and pending tasks.**

Project Setup
Prerequisites:
JDK 11 or higher
Spring Boot 2.x
MySQL (for production) or H2 (for development)
Maven or Gradle (for dependency management)
Clone the Repository:
bash
Copy code
**git clone https://github.com/your-repository/crm-system.git**
cd crm-system

Database Setup:
**Create a MySQL database (or use H2 for testing)**.

**Configure application.properties to connect to the database**.
Configure Database Authentication With Your Userid & password.

To The APis in postman with given steps
**API Endpoints**

**User Endpoints**


**To Register User**
**POST** 
**http://localhost:8080/crm.technothinksup.in/admin/register**

In Request Body:
type - json
Copy code
{
  "email": "sahilchavan.technothinksup@gmail.com",
  "password": "Sahil@123",
  "role": "Back End Developer"
}
After  Hiting post You Will Get status code 200 ok 

**Response: "Registration Successful..."**

**Login User:** 
**POST** 
**http://localhost:8080/crm.technothinksup.in/admin/login**

Request Body:
json
Copy code

{
  "email": "sahilchavan.technothinksup@gmail.com",
  "password": "Sahil@123"
}

Response: 200 ok
json
Copy code
{
  "message": "Login Successful...",
  "role": "Back End Developer"
}

**Forgot Password:** 
POST 
**http://localhost:8080//crm.technothinksup.in/admin/forgot-password**

Request Body:
json
Copy code
{
  "email": "sahilchavan.technothinksup@gmail.com"
}

Response: "Reset token generated. Use this token to reset your password: <token> " for example in my case token is generated like **fee783dd-cdd4-4b09-b669-ee51c8a96396**

Reset Password: 
**POST** 
**http://localhost:8080/crm.technothinksup.in/admin/reset-password?resetToken=fee783dd-cdd4-4b09-b669-ee51c8a96396&newPassword=sahil123@**

Request Params:
Response:200 ok **"Password Reset Successful!"**

Task Endpoints
Get All Tasks: 
**GET**
**http://localhost:8080/crm.technothinksup.in/admin/task**

Response: A list of all tasks in JSON format

for ex-


Create Task: POST 
**http://localhost:8080/crm.technothinksup.in/admin/task**

Request Body:
json
Copy code
{
  "title": "Backend Development Task Assignment – CRM Application",
  "description": "Develop and implement backend functionalities for the Task CRM Application accessible at the link provided below. Ensure a robust backend setup with efficient server-side logic, seamless data management, and API integration.",
  "deadline": "2024-12-20",
  "priority": "High",
  "status": "Pending"
}
Response: The newly created task.
Update Task: 
PUT 
**http://localhost:8080/crm.technothinksup.in/admin/task/1**

Request Body:
json
Copy code
{
  "title": "Backend Development Task Assignment – CRM Application",
  "description": "Develop and implement backend functionalities for the Task CRM Application accessible at the link provided below. Ensure a robust backend setup with efficient server-side logic, seamless data management, and API integration.",
  "deadline": "2024-12-24",
  "priority": "Medium",
  "status": "Pending"
}
Response: The updated task.
Delete Task: 
**DELETE** 
**http://localhost:8080/crm.technothinksup.in/admin/task/1**

Response: "Task deleted successfully."
Get Task by ID: 
**GET** 
**http://localhost:8080/crm.technothinksup.in/admin/task/1**

Response: The task with the specified ID.
Activity Log Endpoints
**Get All Activity Logs:
GET 
http://localhost:8080/crm.technothinksup.in/admin/activity-logs**

Response: List of all activity logs.
Create Activity Log: 
**POST
http://localhost:8080/crm.technothinksup.in/admin/activity-logs**

Request Body:
json
Copy code
{
  "action": "Task Is Created",
  "userId": 1,
  "timestamp": "2024-12-19T14:30:00"
}

Response: The created activity log.
**Get Activity Log by ID: 
GET 
http://localhost:8080/crm.technothinksup.in/admin/activity-logs/1**

Response: The activity log with the specified ID.
**Report Endpoints
Get Task Summary: GET http://localhost:8080/crm.technothinksup.in/admin/reports/summary**
Response:
json
Copy code
{
  "Total Tasks": 10,
  "Completed Tasks": 8,
  "Pending Tasks": 2
}
