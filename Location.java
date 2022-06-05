/*
 * For Mac and Linux:
 * Compile: javac-introcs -cp ".:lib/*:.lift/*" Location.java
 * Execute: java-introcs -cp ".:lib/*:.lift/*" Location
 */

// Purpose of the Java File:
// This java file creates a arraylist of the all of the buroughs
// included in the HIV testing facilities across NYC dataset from the
// NYC Department of Health (DOH). Then, using the user's specified burough
// of interest, the program will output a list of testing facilities located
// in this burough. Then, based on the chosen facility, the program will output
// the exact address and phone number of this facility

import java.util.ArrayList;
import java.util.Scanner;

public class Location {
    private String[][] locationsFile; // creates a private variable to store data
    private ArrayList<String> buroughsArray; // private array list to store unique regions
    private String buroughOfInterest;
    // private string that stores the the user's burough of interest
    private String clinic; // private string that stores the user's clinic

    // Constructor method which is creating a new object with the
    // specified dataset
    public Location(String filePath) {
        // Parse .csv file and save as 2d array.
        locationsFile = CSVReader.parseCSV(filePath);
    }

    // Method to get the dataset from the Location client
    public String[][] getFile() {
        return locationsFile;
    }

    // Function that outputs an array list of the buroughs
    // included in the dataset
    public void buroughsArrayMethod() {
        buroughsArray = new ArrayList<String>();

        // filling sample array list with all of the unique buroughs in the
        // data file; will print a list of all unique values
        for (int i = 1; i < locationsFile.length; i++) {
            if (!buroughsArray.contains(locationsFile[i][16])) {
                buroughsArray.add(locationsFile[i][16]);
            }
        }
        for (String buroughLocation : buroughsArray) {
            System.out.println(buroughLocation);
        }
    }

    // Function that will ask user for a specific burough of interest
    // and check to see if it is in the dataset
    public void pokeUser(String buroughOfInterest) {
        this.buroughOfInterest = buroughOfInterest;
        // cycling through the array list of locations
        boolean found = false;
        for (String regionalLocation : buroughsArray) {
            if (regionalLocation.equals(buroughOfInterest)) {
                found = true;
            }
        }
    }


    // Method to output the names of all of the testing facilities that are
    // located in that burough
    public void findAddresses(String buroughOfInterest) {
        this.buroughOfInterest = buroughOfInterest;
        // cycling through the array list of locations
        for (int i = 1; i < locationsFile.length; i++) {
            if (locationsFile[i][16].equals(buroughOfInterest)) {
                System.out.println(locationsFile[i][2]);
            }
        }
    }

    // how to get in touch with the facility!
    public void contact(String clinic) {
        this.clinic = clinic;
        String phone = "";
        String address = "";
        for (int i = 1; i < locationsFile.length; i++) {
            if (locationsFile[i][2].equals(clinic)) {
                phone = locationsFile[i][12];
                address = locationsFile[i][13];
                break;
            }
        }

        if (phone.equals("")) {
            phone = "unavailable";
        }
        if (address.equals("")) {
            address = "not found";
        }

        // output the phone number and address of the desired facility
        System.out.println("The phone number of " + clinic
                                   + " is: " + phone
                                   + " and the address of the facility is: "
                                   + address);
    }

    public static void main(String[] args) {

        // Creating a new location client (will not output anything)
        Location test1 = new Location("projectdata/locations.csv");

        // testing the buroughs method; will output a list of all unique
        // burough categories used for classification purposes in the dataset
        test1.buroughsArrayMethod();

        //  prompt for the user's burough of interest
        // User can type in a burough such as "Queens" or "BRONX"
        System.out.print("Enter your burough: ");

        // get their input as a String
        // create a scanner so we can read the command-line input
        Scanner scannerBurough = new Scanner(System.in);
        String buroughOfInterest = scannerBurough.nextLine();

        // testing poke User method; will not output anything
        test1.pokeUser(buroughOfInterest);

        // testing the find nearest facilities functions based on the chose burough
        test1.findAddresses(buroughOfInterest);

        //  prompt for the user's desired clinic and it will output the
        // phone number and address if they are found in the dataset
        System.out.print("Enter your desired clinic: ");

        // get their input as a String
        // create a scanner so we can read the command-line input
        Scanner scannerClinic = new Scanner(System.in);
        String clinic = scannerClinic.nextLine();

        // testing the contact function based on the chosen facility
        // Test: burough is Manhattan and desired clinic is Mount Sinai - Samuels Clinic,
        // Output is:
        // The phone number of Mount Sinai - Samuels Clinic is: unavailable and
        // the address of the facility is: 1000 Tenth Avenue
        test1.contact(clinic);

    }
}
