🍽️ Online Food Delivery System

An end-to-end **Spring Boot** backend project that simulates the operations of an online food delivery platform, including **role-based access (Admin & Customer)**, **JWT authentication**, restaurant and food item management, **cart**, **order placement**, and secure user operations.

---

## 🚀 Tech Stack

- **Backend:** Java, Spring Boot
- **ORM:** Spring Data JPA (Hibernate)
- **Database:** MySQL
- **Security:** Spring Security + JWT (JSON Web Token)
- **API Testing:** Postman
- **Build Tool:** Maven

---

## 👥 Roles and Functionalities

### 👨‍💼 Admin

- Register/Login
- Add & Manage Restaurants
- Add Food Items to Restaurants
- View Restaurants and Food Inventory

### 👤 Customer

- Register/Login (JWT Token Auth)
- View Available Food Items by Name
- Add Food Items to Cart
- Place Orders from Cart
- View Order History
- Update/Delete User Profile

---

## 🔐 Authentication

- **Login generates JWT Token**
- Token required for accessing secured endpoints
- Role-based authorization (Admin vs Customer)

---

## 🛒 Order Flow

1. **Customer** adds food items to **Cart**
2. Places an **Order**
3. Items from cart are converted into **OrderItems**
4. Order is saved with timestamp, status, and address

---

## 🔄 Entity Relationships

| Entity        | Relationship                          |
|---------------|----------------------------------------|
| User ↔ Order         | One-to-Many (user can place many orders) |
| Order ↔ OrderItem    | One-to-Many                      |
| Cart ↔ FoodItem      | Many-to-One                      |
| Restaurant ↔ FoodItem| One-to-Many                      |
| Cart ↔ User          | One-to-One                       |

---

## 📦 Modules

- **User Module:** Registration, Login, Update, Delete
- **Restaurant Module:** Create & fetch restaurants
- **FoodItem Module:** Add/view food items
- **Cart Module:** Add/view items
- **Order Module:** Place order, view history
- **JWT Auth Module:** Token validation and filtering

---

## 📁 Project Structure

com.fooddelivery.onlinefooddelivery
│
├── controller/
├── service/
├── serviceImpl/
├── dto/
├── entity/
├── repository/
├── response/
├── exception/
└── util/ (JWT utilities)

yaml
Copy
Edit

---

## 🧪 Testing (Postman)

- Tested all APIs using Postman
- Token added to `Authorization: Bearer <token>` header
- Example requests include:
  - Register/Login
  - Add to Cart
  - Place Order
  - View Restaurants by Food Name

---

## 📌 Sample Postman Collection (Optional)

> [Click here to download Postman collection](#) *(replace with actual link if available)*

---

## 💡 What I Learned

- Clean layering: Controller → Service → Repository
- DTO pattern and separation of concerns
- Secure REST API with JWT
- Managing One-to-Many and Many-to-One relationships
- Transactional order processing
- Error handling with `@ControllerAdvice`

---

## 📎 Author

**Darshan B K**  
Full Stack Java Developer | 2025 Graduate  
[LinkedIn](https://www.linkedin.com/in/darshan-b-k-a7b501298)  
[GitHub](https://github.com/your-github-username)

---

## 📌 Note

This project is for learning/demo purposes and does not include a frontend UI. It can be integrated with any frontend (Angular, React, etc.) using the exposed REST APIs.
