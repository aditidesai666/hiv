/*
 * For Mac and Linux:
 * Compile: javac-introcs -cp ".:lib/*:.lift/*" DataAnalysisClient.java
 * Execute: java-introcs -cp ".:lib/*:.lift/*" DataAnalysisClient FILEPATH
 */
// Purpose of this Java File:

// DataAnalysisClient.java reads in a HIV/AIDS diagnoses dataset from the
// NYC department of Health (DOH) and performs data analysis to calculate
// the number of HIV diagnoses per 100,000 individuals and displays these
// results in a bar graph format. The program does this for one specific
// region of NYC that the user chooses to input into the function. (Bar
// graph is specific for this specified region of NYC).

import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysisClient {
    private String[][] dataset; // creates a private String[][] dataset
    private ArrayList<String> regionsArray; // create a private ArrayList to
    // store all of the unique regions included in the dataset
    private String regionOfInterest; // private regionOfInterest read in from
    // scanner class

    // Constructor method which is creating a new object with the
    // specified dataset
    public DataAnalysisClient(String filePath) {
        // Parse .csv file and save as 2d array.
        dataset = CSVReader.parseCSV(filePath);
    }

    // Method to get the dataset from the DataAnalysis client
    public String[][] getDataset() {
        return dataset;
    }

    // Function that outputs an array list of the regions
    public void regionsArrayMethod() {
        regionsArray = new ArrayList<String>();

        // filling sample array list with all of the unique regions
        // in the data file
        for (int i = 1; i < dataset.length; i++) {
            if (!regionsArray.contains(dataset[i][1])) {
                regionsArray.add(dataset[i][1]);
            }
        }
        for (String regionalLocation : regionsArray) {
            System.out.println(regionalLocation);
        }
    }

    // Function that will ask user for a specific region and check to see
    // if it is in the dataset
    public void pokeUser() {
        this.regionOfInterest = regionOfInterest;
        // cycling through the array list of locations
        boolean found = false;
        for (String regionalLocation : regionsArray) {
            if (regionalLocation.equals(regionOfInterest)) {
                found = true;
                break;

            }
        }
    }

    // Method to create a bar graph with the dataset and given region
    public void createBarGraph(String regionOfInterest, String title, String xAxis,
                               String source) {
        this.regionOfInterest = regionOfInterest;

        boolean found = false;
        // create a histogram with racial breakdown for that region
        double black = 0;
        double nativeAmerican = 0;
        double white = 0;
        double unknown = 0;
        double multiracial = 0;
        double asian = 0;

        // Go through the dataset to find each racial categories # of Diagnoses
        for (int i = 1; i < dataset.length; i++) {
            if (dataset[i][1].equals(regionOfInterest)) {
                found = true;
                if ((dataset[i][3]).equals("Black")) {
                    black = black + Double.parseDouble(dataset[i][5]);
                }
                else if ((dataset[i][3]).equals("Native American")) {
                    nativeAmerican = nativeAmerican +
                            Double.parseDouble(dataset[i][5]);
                }
                else if ((dataset[i][3]).equals("White")) {
                    white = white + Double.parseDouble(dataset[i][5]);
                }
                else if ((dataset[i][3]).equals("Unknown")) {
                    unknown = unknown + Double.parseDouble(dataset[i][5]);
                }
                else if ((dataset[i][3]).equals("Multiracial")) {
                    multiracial = multiracial + Double.parseDouble(dataset[i][5]);
                }
                else if ((dataset[i][3]).equals("Asian/Pacific Islander")) {
                    asian = asian + Double.parseDouble(dataset[i][5]);
                }
            }
        }


        // Creating a bar graph for this region with racial breakdown of data
        BarChart chart = new BarChart(title, xAxis, source);
        chart.setCaption("2012");

        if (black > 0) {
            chart.add("Black", (int) black, "Black");
        }
        if (nativeAmerican > 0) {
            chart.add("Native American",
                      (int) nativeAmerican, "Native American");
        }
        if (white > 0) {
            chart.add("White", (int) white, "White");
        }
        if (asian > 0) {
            chart.add("Asian", (int) asian, "Asian");
        }
        if (multiracial > 0) {
            chart.add("Multi", (int) multiracial, "Multiracial");
        }

        // draw the bar chart for the racial groups which non-negative values
        // of HIV diagnoses per 100,000 people
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        chart.draw();
        StdDraw.show();
    }

    // find ways to support function (will lead the user to a google form
    // which they can fill out depending on the way in which they would like to
    // support HIV/AIDS support networks
    public static void findSupport() {
        System.out.println(
                "Find a way to support HIV/AIDS advocacy efforts by "
                        + "clicking here! https://forms.gle/eYTGUf9A12Q2cKNo9");
        // fill this google form out to get connected to a community of
        // HIV advocacy efforts
    }

    public static void main(String[] args) {

        // Creating a new DataAnalysisClient Object; nothing returned as it is
        // a constructor
        DataAnalysisClient test = new DataAnalysisClient("projectdata/hivdata.csv");

        // Testing regionsArrayMethod which will print each of the regions/neighborhoods
        // included in the dataset so that the user can choose which one they
        // want to investigate further
        test.regionsArrayMethod();

        //  prompt for the user's specified region in the terminal; prompt the
        // user to type into the command line
        System.out.print("Enter your region: ");

        // get the User's inputted region of interest as a String
        // create a scanner so we can read the command-line input
        // Can type in "Greenpoint" and "Long Island City - Astoria" to see
        // how one-word and multi-word ommand line arguments function
        Scanner scanner = new Scanner(System.in);
        String regionOfInterest = scanner.nextLine();

        // Testing pokeUser Method; will not return anything
        test.pokeUser();

        // Testing the create Bar graph method
        String sampTitle = "HIV Diagnoses by Racial Category in "
                + regionOfInterest;

        // takes command line argument region name; no bar graph will be created
        // if user types an argument region that is not in the dataset
        test.createBarGraph(regionOfInterest, sampTitle, "Number of HIV "
                + "Diagnoses per 100,000 People", "NYC Department of Health");

        // testing support method; will return a sentence in the terminal and
        // also allow the user to click on a link to a google form
        findSupport();


    }
}


