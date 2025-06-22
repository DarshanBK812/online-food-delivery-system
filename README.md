# 🍔 Online Food Delivery System

A full-stack Java Spring Boot application designed to manage food orders and deliveries with role-based access for Admins and Customers.

---

## 🚀 Features

- 🔐 **User Authentication & Authorization** (JWT-based)
- 👤 **Role-Based Access**: Admin & Customer
- 🧾 **Order Management**: Place, view, and manage orders
- 🏠 **Address Management**: Add and fetch customer addresses
- 📦 **Admin Operations**: View all customers, all orders
- 💡 **Exception Handling**: Centralized with custom exceptions
- ✅ **RESTful API Design** with DTO and Response wrapping

---

## 🧠 Project Architecture

### `src/main/java/com.fooddelivery.onlinefooddelivery`

#### ✅ Core Components

- **`OnlineFoodDeliverySystemApplication.java`**  
  Main Spring Boot entry point

#### 🔐 `config/`
- `SecurityConfig.java` – Configures Spring Security and JWT filters

#### 🎮 `controller/`
- `AddressController.java` – Manage customer addresses
- `AdminController.java` – Admin-only actions
- `CustomerController.java` – Customer actions
- `OrderController.java` – Place/view orders
- `UserController.java` – Signup/login/update

#### 🧠 `service/` & `servicelmpl/`
- Interfaces and implementations:
  - `UserService`, `AddressService`, `OrderService`

#### 🧬 `entity/`
- `User.java`, `Address.java`, `Order.java` – JPA entities with mappings

#### 📩 `dto/`
- DTOs for request payloads:
  - `UserRegisterRequest`, `LoginRequest`, `OrderRequest`, etc.

#### 📥 `response/`
- Custom response classes: 
  - `UserResponse`, `OrderResponse`, `SaveAddressResponse`, etc.

#### 💣 `exception/`
- `ExistedUser.java`, `NotFoundException.java`, and `GlobalExceptionHandler.java`

#### 🗃 `dao/`
- JPA repositories: `UserRepo`, `OrderRepo`, `AddressRepo`

---

## 📦 Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Security + JWT**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Postman** for API testing
- **Maven** for dependency management

---

## 📂 Folder Structure

onlinefooddelivery/
├── controller/
├── service/
├── servicelmpl/
├── dto/
├── response/
├── entity/
├── config/
├── dao/
├── exception/
└── OnlineFoodDeliverySystemApplication.java

yaml
Copy
Edit

---

## 🧪 API Testing

- All APIs tested with Postman
- JWT token must be included in headers after login
- Proper status codes and response structures returned

---

## ✅ Setup Instructions

1. Clone the repo  
   `git clone https://github.com/DarshanBK812/online-food-delivery-system.git`

2. Open in **Eclipse** or **IntelliJ**

3. Configure `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   jwt.secret=your_jwt_secret
Run the project from OnlineFoodDeliverySystemApplication.java

🙋‍♂️ Author
Darshan B K
LinkedIn | Java Developer | Spring Boot Enthusiast

📌 License
This project is for academic and learning purposes.

yaml
Copy
Edit
