🧼 Deep Clean Laundry – Laundry Management System

A desktop-based laundry management system built using Java, featuring a graphical user interface (JavaFX), modular architecture, and an integrated database for managing customers, employees, orders, and payments.
This project simulates real operations inside a laundry shop with a focus on automation, accuracy, and ease of use.

🚀 Features
👥 Customer Management

Add, edit, and remove customer accounts

Store customer information and service history

🧾 Order & Service Management

Create and track laundry orders

Assign services (washing, ironing, dry-cleaning, etc.)

Calculate order cost automatically based on service type and quantity

💵 Payment & Billing

Generate bills for completed orders

Track paid & unpaid invoices

Simple financial summaries

👨‍💼 Employee Management

Manage employee records

Add, update, or remove staff

📊 Reporting

Expense report

Order distribution

Employee activity summary

Database info report

🖥️ Graphical User Interface (JavaFX)

Fully interactive GUI with screens for:

Login page

Dashboard

Add/Edit/Delete customers

Manage employees

Add new orders

View reports

🛠️ Tech Stack
Category	Technologies
Language	Java
GUI	JavaFX / FXML
Build Tool	Maven
Database	Embedded file-based DB (.db)
Architecture	MVC + Layered Structure
📁 Project Structure
src/main/
    java/
        controllers/
        model/
        utils/
        db/
    resources/com/example/project_db/
        *.jpg / *.png  (UI assets)
        *.fxml          (GUI layout files)

🗄️ Database Design

The system includes the following main tables:

Customer Table

customer_id

name

phone

address

Employee Table

employee_id

name

position

salary

Orders Table

order_id

customer_id (FK)

date

service_type

quantity

total_price

Payments Table

payment_id

order_id (FK)

amount

status

▶️ How to Run the Project

Clone the repository:

git clone https://github.com/Abo-AL-Yaseen/Deep-Clean-Laundry.git


Open the project in IntelliJ IDEA (recommended)

Ensure JavaFX is configured
(Maven should automatically download dependencies.)

Run the application:
Navigate to:

src/main/java/com/example/Main.java


Click Run.

📸 Screenshots (Suggested to Add)

You can add images inside resources and reference them like:

![Dashboard](images/dashboard.png)
![Add Order](images/add-order.png)

🌟 Future Improvements

Add authentication system

Add email/SMS notifications

Add inventory management

Add cloud database support

Add REST API for mobile app integration

👨‍💻 Developer

Mahmoud Yaseen
Computer Engineering Student | Java Developer
Passionate about building clean, efficient systems with strong architecture and great user experience.
