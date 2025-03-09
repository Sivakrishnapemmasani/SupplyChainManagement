# Supply Chain Management System

## Overview
Supply Chain Management System is a backend application built using Spring Boot to manage and streamline supply chain operations. It provides APIs for handling orders, producers, suppliers, customers, and shipments.

## Tech Stack
- **Backend:** Spring Boot (Java)
- **Database:** PostgreSQL
- **API Testing:** Postman

## Prerequisites
Before running the project, ensure you have the following installed:
- Java 17 or later
- PostgreSQL
- Postman (for API testing)

## Setup Instructions
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-username/supplychainmanagement.git
   cd supplychainmanagement
   ```

2. **Configure Database**
   - Create a PostgreSQL database (e.g., `supply_chain_db`).
   - Update `application.properties` (located in `src/main/resources/`) with your database credentials:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/supply_chain_db
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     server.port=8050
     ```

3. **Build and Run the Application**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
   The server will start on `http://localhost:8050`.

## API Testing with Postman
1. Open Postman.
2. Import the API collection (if available) or manually add requests.
3. Test endpoints like:
   - `GET /api/orders`
   - `POST /api/producers`
   - `PUT /api/suppliers/{id}`
   - `DELETE /api/customers/{id}`

## Contributing
Contributions are welcome! Feel free to fork the repository and submit a pull request.

## License
This project is licensed under the MIT License.

---

**Author:** Siva Krishna  
**GitHub:** [your-github-profile](https://github.com/your-username)

