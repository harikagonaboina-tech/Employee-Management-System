# Employee Management System

## 📌 Project Overview

The **Employee Management System** is a web-based application developed using **Java Servlets, JDBC, and MySQL**.
This system allows users to create accounts, log in, and manage employee records such as viewing, updating, and deleting employee details.

The project demonstrates how **Java web technologies interact with databases to perform CRUD operations (Create, Read, Update, Delete).**

---

# 🚀 Technologies Used

* Java
* Java Servlets
* JDBC (Java Database Connectivity)
* MySQL Database
* HTML
* CSS
* Apache Tomcat Server
* Eclipse IDE

---

# ✨ Features

* User Login Authentication
* Create Employee Account
* View Employee Details
* Update Employee Information
* Delete Employee Record
* Simple Web Interface

---

# 📂 Project Structure

```
Employee-Management-System
│
├── FormServlet.java
├── LoginServlet.java
├── CreateAccountServlet.java
├── EmployeeDetailsServlet.java
├── EmployeeActionServlet.java
├── UpdateEmployeeServlet.java
│
├── form.html
├── login.html
├── createAccount.html
├── home.html
├── error.html
├── style.css
│
└── README.md
```

---

# ⚙️ How the System Works

### 1️⃣ Login Page

Users enter their **username and password** to log into the system.

If the credentials are valid:

* The user is redirected to the **Employee Details Page**.

If the credentials are invalid:

* An **error message** is displayed.

---

### 2️⃣ Create Account

Users can create a new employee account by entering:

* Employee ID
* Name
* Address
* Salary
* Gender
* Username
* Password

The system stores data in two tables:

* Employee table
* Login credentials table

---

### 3️⃣ View Employee Details

After login, the system displays all employee records in a **table format** showing:

* Employee ID
* Name
* Address
* Salary
* Gender

---

### 4️⃣ Update Employee

Users can select a row and click **Edit** to update employee information.

---

### 5️⃣ Delete Employee

Users can select a row and click **Delete** to remove an employee record from the database.

---

# 🗄️ Database Setup

Create a database named:

```
employee_management
```

---

## Employee Table

```
CREATE TABLE employee (
emp_id INT PRIMARY KEY,
name VARCHAR(50),
address VARCHAR(100),
salary DOUBLE,
gender VARCHAR(10)
);
```

---

## Login Credentials Table

```
CREATE TABLE login_credentials (
username VARCHAR(50) PRIMARY KEY,
password VARCHAR(50)
);
```

---

# 🔌 Database Connection Example

```
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/employee_management?user=root&password=root");
```

Make sure:

* MySQL Server is running
* Database name is correct
* Username and password are correct

---

# ▶️ How to Run the Project

1. Install **Java JDK**
2. Install **Apache Tomcat Server**
3. Install **MySQL Database**
4. Import the project into **Eclipse IDE**
5. Configure the **MySQL database**
6. Add the **MySQL JDBC Driver**
7. Run the project using **Apache Tomcat Server**
8. Open the browser and access:

```
http://localhost:8080/EmployeeManagementSystem/form.html
```

---

# 🔐 Future Improvements

* Add Session Management
* Improve UI using Bootstrap
* Add search functionality for employees
* Implement password encryption
* Convert project to Spring Boot

---

# 👩‍💻 Author

**Gonaboina Harika**

Entry-Level Java Full Stack Developer

Skills:

* Java
* JDBC
* SQL
* HTML
* CSS
* Web Development

---

# 📄 License

This project is created for **learning and educational purposes**.
