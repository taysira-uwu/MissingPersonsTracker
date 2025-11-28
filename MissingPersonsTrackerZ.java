import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class MissingPerson {
    String name;
    int age;
    String gender;
    String description;
    String phoneNumber;
    String lastSeenLocation;
    String lastSeenDate;

    MissingPerson(String name, int age, String gender, String description, String phoneNumber, String lastSeenLocation, String lastSeenDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.lastSeenLocation = lastSeenLocation;
        this.lastSeenDate = lastSeenDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Description: " + description +
               ", Phone: " + phoneNumber + ", Last Seen Location: " + lastSeenLocation + ", Last Seen Date: " + lastSeenDate;
    }

    // For saving to file
    String toFileString() {
        return name + "," + age + "," + gender + "," + description + "," + phoneNumber + "," + lastSeenLocation + "," + lastSeenDate;
    }

    // For loading from file
    static MissingPerson fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 7) {
            return new MissingPerson(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], parts[4], parts[5], parts[6]);
        }
        return null;
    }
}

class UnidentifiedBody {
    String description;
    String foundLocation;
    String hospitalLocation;
    int minAge;
    int maxAge;
    String gender;


    UnidentifiedBody(String description, String foundLocation, String hospitalLocation, int minAge, int maxAge, String gender) {
        this.description = description;
        this.foundLocation = foundLocation;
        this.hospitalLocation = hospitalLocation;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Found Location: " + foundLocation + ", Hospital: " + hospitalLocation +
               ", Approx Age: " + minAge + "-" + maxAge + ", Gender: " + gender;
    }

    // For saving to file
    String toFileString() {
        return description + "," + foundLocation + "," + hospitalLocation + "," + minAge + "," + maxAge + "," + gender;
    }

    // For loading from file
    static UnidentifiedBody fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 6) {
            return new UnidentifiedBody(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), parts[5]);
        }
        return null;
    }
}

class MinistryOfHealth {
    ArrayList<MissingPerson> missingPersons = new ArrayList<>();
    ArrayList<UnidentifiedBody> unidentifiedBodies = new ArrayList<>();
    String contactNumber = "+123-456-7890"; // Example Ministry of Health contact number

    void addMissingPerson(MissingPerson mp) {
        missingPersons.add(mp);
        saveMissingPersonsToFile();
    }

    void addUnidentifiedBody(UnidentifiedBody ub) {
        unidentifiedBodies.add(ub);
        saveUnidentifiedBodiesToFile();
    }

    void loadMissingPersonsFromFile() {
        try (Scanner scanner = new Scanner(new File("missing_persons.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                MissingPerson mp = MissingPerson.fromFileString(line);
                if (mp != null) {
                    missingPersons.add(mp);
                }
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, no issue
        } catch (Exception e) {
            System.out.println("Error loading missing persons: " + e.getMessage());
        }
    }

    void loadUnidentifiedBodiesFromFile() {
        try (Scanner scanner = new Scanner(new File("unidentified_bodies.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                UnidentifiedBody ub = UnidentifiedBody.fromFileString(line);
                if (ub != null) {
                    unidentifiedBodies.add(ub);
                }
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, no issue
        } catch (Exception e) {
            System.out.println("Error loading unidentified bodies: " + e.getMessage());
        }
    }

    private void saveMissingPersonsToFile() {
        try (FileWriter writer = new FileWriter("missing_persons.txt")) {
            for (MissingPerson mp : missingPersons) {
                writer.write(mp.toFileString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving missing persons: " + e.getMessage());
        }
    }

    private void saveUnidentifiedBodiesToFile() {
        try (FileWriter writer = new FileWriter("unidentified_bodies.txt")) {
            for (UnidentifiedBody ub : unidentifiedBodies) {
                writer.write(ub.toFileString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving unidentified bodies: " + e.getMessage());
        }
    }

    void searchMatchesForMissingPerson(MissingPerson mp) {
        System.out.println("Searching for potential matches...");
        boolean found = false;
        for (UnidentifiedBody ub : unidentifiedBodies) {
            boolean ageMatch = (mp.age >= ub.minAge && mp.age <= ub.maxAge);
            boolean genderMatch = mp.gender.equalsIgnoreCase(ub.gender);
            boolean regionalMatch = mp.lastSeenLocation.equalsIgnoreCase(ub.foundLocation);
            if (ageMatch && genderMatch) {  // Potential match requires age and gender
                System.out.println("Potential match found: " + ub);
                System.out.println("A potential match was found.\nPlease contact the Ministry at " + contactNumber + " or visit the mentioned hospital to confirm and proceed.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Currently, no matches have been identified.\nThe Ministry will reach out if new data or updates become available.");
        }
    }

    void listBodySpecifications() {
        System.out.println("Ministry of Health Contact: " + contactNumber + " (Call if you recognize someone)");
        if (unidentifiedBodies.isEmpty()) {
            System.out.println("No body specifications available.");
        } else {
            for (UnidentifiedBody ub : unidentifiedBodies) {
                System.out.println(ub);
            }
        }
    }

    void displayAllMissingPersons() {
        if (missingPersons.isEmpty()) {
            System.out.println("No missing person reports submitted yet.");
        } else {
            System.out.println("All Missing Person Reports:");
            for (int i = 0; i < missingPersons.size(); i++) {
                System.out.println((i + 1) + ". " + missingPersons.get(i));
            }
        }
    }
}

public class MissingPersonsProgram {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Gaza Missing Persons Program");
        System.out.println("Developed by Taysira Alaqad - Java Console Project");
        System.out.println("Helping identify missing persons during emergencies.\n");

        Scanner scanner = new Scanner(System.in);
        MinistryOfHealth moh = new MinistryOfHealth();

        // Load data from files at startup
        moh.loadMissingPersonsFromFile();
        moh.loadUnidentifiedBodiesFromFile();

        while (true) {
            System.out.println("\n=== Missing Persons Tracker Program ===");
            System.out.println("--- Family Options ---");
            System.out.println("1. Report Missing Person");
            System.out.println("2. Browse Unidentified Bodies Specifications");
            System.out.println("--- Ministry of Health Options ---");
            System.out.println("3. Add Unidentified Body");
            System.out.println("4. Display All Missing Person Reports");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choiceStr = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            switch (choice) {
                case 1: // Family: Report Missing Person
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    String ageStr = scanner.nextLine();
                    int age;
                    try {
                        age = Integer.parseInt(ageStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                        continue;
                    }
                    System.out.print("Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Last Seen Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Last Seen Date (e.g., YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    MissingPerson mp = new MissingPerson(name, age, gender, desc, phone, location, date);
                    moh.addMissingPerson(mp);
                    System.out.println("Missing person reported.");
                    // Automatic matching after reporting
                    moh.searchMatchesForMissingPerson(mp);
                    break;

                case 2: // Family: Browse Body Specifications
                    moh.listBodySpecifications();
                    break;

                case 3: // Ministry of Health: Add Unidentified Body
                    System.out.print("Textual specifications of the unidentified body: ");
                    desc = scanner.nextLine();
                    System.out.print("Location where it was found: ");
                    String foundLocation = scanner.nextLine();
                    System.out.print("Hospital where it is currently stored: ");
                    String hospitalLocation = scanner.nextLine();
                    System.out.print("Minimum approximate age: ");
                    String minAgeStr = scanner.nextLine();
                    int minAge;
                    try {
                        minAge = Integer.parseInt(minAgeStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                        continue;
                    }
                    System.out.print("Maximum approximate age: ");
                    String maxAgeStr = scanner.nextLine();
                    int maxAge;
                    try {
                        maxAge = Integer.parseInt(maxAgeStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                        continue;
                    }
                    System.out.print("Gender: ");
                    gender = scanner.nextLine();
                    
                    moh.addUnidentifiedBody(new UnidentifiedBody(desc, foundLocation, hospitalLocation, minAge, maxAge, gender));
                    System.out.println("Unidentified body added.");
                    break;

                case 4: // Ministry of Health: Display All Missing Person Reports
                    moh.displayAllMissingPersons();
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
