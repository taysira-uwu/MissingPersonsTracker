# Gaza Missing Persons Tracker

**Developed by:** Taysira Alaqad   
**Language:** Java (Console Application)

---

## 📌 Overview

The Gaza Missing Persons Tracker is a Java-based console application designed to assist families and authorities in locating missing individuals during emergencies.  

The system acts as a bridge between:
- Families reporting missing relatives  
- The Ministry of Health registering unidentified bodies  

This version applies advanced **Object-Oriented Programming (OOP)** principles and **Binary Serialization** to ensure structured data management and persistent storage.

---

## 🚀 Key Features

### 1️⃣ Comprehensive Data Management (CRUD)

- **Report Missing Person**
  - Name
  - Age
  - Last Seen Date
  - Description
  - Contact Information

- **Register Unidentified Bodies**
  - Location
  - Gender
  - Estimated Age Range
  - Description

- **Search Functionality**
  - Search for a missing person by name

- **Edit & Delete**
  - Update contact information
  - Delete records by ID when a case is closed

---

### 2️⃣ Smart Hospital Selection

The system includes a predefined list of operating hospitals (e.g., Shifa Hospital, Nasser Hospital) to standardize data entry for unidentified bodies.

---

### 3️⃣ Automatic Matching System

The system automatically cross-references missing persons with unidentified body records.

**Matching Logic:**
- Gender
- Estimated Age Range

If a match is found, the system displays:
- Hospital Name
- Body ID

---

### 4️⃣ Advanced Data Persistence (Serialization)

Instead of using plain text files, this project uses **Java Serialization (.dat files)** to store objects directly.

**Files used:**
- `missing_data.dat`
- `bodies_data.dat`

Data is automatically saved and loaded when the application restarts.

---

## 🛠 Technical Details

### 🔹 OOP Concepts Applied

- **Inheritance & Abstraction**
  - `Person` (Abstract Class)
  - `MissingPerson` (Extends Person)
  - `UnidentifiedBody` (Extends Person)

- **Encapsulation**
  - All fields are private
  - Accessed using Getters & Setters

- **Polymorphism**
  - Overriding `toString()` and `getDetails()`

- **Collections**
  - `ArrayList<MissingPerson>`
  - `ArrayList<UnidentifiedBody>`

---

## 📂 Project Structure

```
MissingPersonsSystem.java
MinistryManager.java
Person.java
MissingPerson.java
UnidentifiedBody.java
missing_data.dat
bodies_data.dat
```

### File Descriptions

- **MissingPersonsSystem.java**
  - Main entry point
  - Menu and user interface logic

- **MinistryManager.java**
  - Business logic
  - Adding, searching, deleting, matching
  - File I/O handling

- **Person.java**
  - Abstract superclass

- **MissingPerson.java**
  - Represents reported missing individuals

- **UnidentifiedBody.java**
  - Represents unidentified victims

---

## 📖 How to Run

### 1️⃣ Compile all Java files

```bash
javac *.java
```

### 2️⃣ Run the main system

```bash
java MissingPersonsSystem
```

---

## 🖥 Main Menu Options

- Report Missing Person  
- Add Unidentified Body Data  
- Show All Missing Reports  
- Show All Unidentified Bodies  
- Search Missing Person by Name  
- Delete Missing Report  
- Edit Missing Person Phone  
- Exit  

---

## 📚 Learning Sources

- University Programming Courses
- Duke University Course (Coursera)
- Java Serialization Documentation  
- Online Java Communities  

---

## 🔮 Future Improvements

- GUI implementation using JavaFX or Swing  
- Database integration (MySQL / SQLite)  
- AI-based image recognition for photo matching  

---

## 📌 Project Purpose

This project aims to demonstrate strong understanding of:
- Java OOP Design
- File Handling & Serialization
- Modular Programming
- Real-world problem solving using software engineering principles

---
