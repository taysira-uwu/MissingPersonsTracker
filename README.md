[Watch the Project Demo Video]
https://youtu.be/aiXIp7OEuzM?si=bQ1jsu-aXYvefCHf

**For more details about the project structure, learning sources, and future improvements, please check the sections below**


#Gaza Missing Persons Tracker

Developed by: Taysira Alaqad
Language: Java (Console Application)


---

##Overview

The Gaza Missing Persons Program is a Java-based console application designed to assist families and authorities in locating missing individuals during emergencies, particularly in conflict or disaster zones.

The program allows users to report missing persons, record unidentified bodies, and automatically search for possible matches between reports. It serves as a simple digital system that bridges families and the Ministry of Health in the process of identification and data management.


---

##Objectives

To create a lightweight and accessible tool that helps track and match missing person's data.

To simulate how the Ministry of Health can manage reports and body identifications using digital records.

To provide a small-scale prototype that demonstrates the use of file handling, object-oriented programming, and data persistence in Java.



---

##Features

*Report Missing Person:
Families can input detailed information including name, age, gender, physical description, and last seen details.

*Add Unidentified Body Record:
The Ministry of Health can log cases with descriptive details, location found, hospital location, and estimated age range.

*Automatic Matching System:
Once a missing person is reported, the system automatically searches for potential matches among unidentified body records based on age range and gender.

*Data Storage:
All records are automatically saved to local text files (missing_persons.txt and unidentified_bodies.txt), ensuring persistence even after closing the program.

*Error Handling:
Input validation ensures that when users enter incorrect data types (e.g., letters instead of numbers), the program responds with an [Invalid input] message instead of crashing.



---

##Technical Details

Programming Language: Java
*Files Used:

MissingPersonsProgram.java - main program file

MissingPerson.java - contains the data of each reported missing individual.

 UnidentifiedBody.java - stores information about unidentified victims found in hospitals or by official authorities.
  
  MinistryOfHealth.java - handles file operations and performs the matching process between missing and unidentified individuals.
  
missing_persons.txt - stores reported missing persons

unidentified_bodies.txt - stores unidentified body records


*Key Concepts Applied:

Object-Oriented Programming (OOP)

File Handling and Data Serialization

Exception Handling

Automatic Matching Algorithm

---


##Learning Sources

The development of this project was supported by a combination of academic and self-learning resources:

1. University Programming Fundamentals Course -
A foundational Java programming course taken at university, which covered the basics of syntax, data structures, and object-oriented principles.


2. YouTube Java Programming Course (23-Video Playlist) -
An online playlist that provided structured explanations and practical examples of Java concepts, helping reinforce theoretical knowledge through visual learning.


3. Practical Java Projects Collection -
A compilation of real-world mini Java projects used to practice file handling, loops, conditionals, and program structuring. These projects helped translate learned concepts into applicable skills.


---


##Example Workflow

1. The program starts with a menu displaying options for both families and ministry officials.


2. A family member reports a missing person - the data is saved and automatically checked for matches.


3. The Ministry can add unidentified body data or view all missing person reports.


4. All updates are written to local text files, allowing future sessions to load previous data automatically.


---

##Future Improvements:

1. Database Integration
Replacing the current text-file storage system with a structured database to improve data retrieval speed, scalability, and reliability, especially as the number of records grows.


2. Artificial Intelligence Integration
Incorporating AI-based image analysis to assist in facial recognition and matching between uploaded photos of missing persons and images of unidentified bodies collected by the Ministry or health facilities.


3. Family Photo Upload Feature
Allowing families to upload photos of their missing relatives. The system will then use AI face-matching models to automatically search for potential visual matches in the Ministry's stored database of unidentified victims.


4. Graphical User Interface (GUI)
Transition from a console-based interface to a user-friendly graphical interface to make navigation and data entry easier for both families and ministry officials.


5. Victim Identification Gallery
Replacing or complementing the current text-based descriptions with an organized gallery of victim photos and personal belongings. This would greatly improve identification, especially when physical descriptions are insufficient due to decomposition or severe injuries caused by war-related incidents.


6. Matching Accuracy Indicator
Displaying a percentage-based similarity score when a potential match is found, that provide a clearer and more reliable indication of how closely two records align.

---

This project represents an early prototype of an idea I truly believe can make a real difference, and I look forward to expanding and improving it in the future.
