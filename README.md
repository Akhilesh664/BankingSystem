
# <h1>🏦 Banking System </h1>

A robust and secure **Banking System** built using **Core Java**, **Spring Boot**, **MySQL**, and **Spring Data JPA**. This project provides RESTful APIs for handling user authentication, account management, fund transfers, transaction history, and real-time balance checks. It also supports role-based access and automated notifications.

---

## 🚀 Features

✅ Secure User Registration & Login (JWT-based)  
✅ Account Creation & Management  
✅ Fund Transfer between Accounts  
✅ View Transaction History  
✅ Real-Time Balance Check  
✅ Role-Based Access Control (Admin / User)  
✅ RESTful API Architecture  
✅ Input Validation & Error Handling  
✅ Automated Email or Console Notifications  
✅ MySQL Integration with JPA/Hibernate

---

## 🧰 Tech Stack

- **Java** (Core Java, Java 17 or above)
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**
- **JWT for Authentication**
- **Lombok**
- **Maven**
- **Postman** for API Testing

---

## 📁 Project Structure

```
src
└── main
    ├── java
    │   └── com.bankingsystem
    │       ├── controller
    │       ├── service
    │       ├── repository
    │       ├── model
    │       └── config
    └── resources
        ├── application.properties
        └── data.sql
```

---

## 🛠️ Getting Started

### ✅ Prerequisites

- Java 17+
- Maven
- MySQL Server

### 🚦 Steps to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/Banking-System.git
   cd Banking-System
   ```

2. **Set up MySQL Database**
   ```sql
   CREATE DATABASE banking_system;
   ```

3. **Configure `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/banking_system
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Build and Run**
   ```bash
   mvn spring-boot:run
   ```

5. **Test with Postman**
   - Base URL: `http://localhost:8080/api`

---

## 📮 API Endpoints

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| POST   | /auth/register            | Register new user            |
| POST   | /auth/login               | Login and get JWT token      |
| GET    | /accounts/{id}            | Get account details          |
| POST   | /accounts/transfer        | Transfer funds               |
| GET    | /transactions/{userId}    | Transaction history          |
| GET    | /accounts/balance/{id}    | Real-time balance check      |

---

## 🔐 Role-Based Access

| Role  | Access Permissions                          |
|-------|----------------------------------------------|
| Admin | View all users, transactions, delete users   |
| User  | Manage own account, transfer, view history    |

---

## 📷 Screenshots (Optional)

> Add Postman screenshots, Swagger UI, or terminal output here.

---

## 🧪 Testing

- Use **JUnit** and **Mockito** for service/controller layer testing.
- Coverage for login, transfer, and exception handling.

---

## 🙌 Acknowledgements

- Spring Boot Documentation  
- MySQL Community  
- Baeldung & StackOverflow

---

## 📬 Contact

**Akhilesh Ojha**  
📧 [akhil00664@gmail.com](mailto:akhil00664@gmail.com)  
🌐 [LinkedIn](https://www.linkedin.com/in/theakhileshojha/)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
