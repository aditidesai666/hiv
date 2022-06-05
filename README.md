# COS126 Final Project: Implementation

Please complete the following questions and upload this `implementation.md`
file to the TigerFile assignment for the "Final Project Implementation".

**Do not alter the formatting**
(e.g. write your answer after the asterisks ** FIELD NAME ** or on the next
line after the header ### HEADER NAME). We have filled in a dummy response
for the first question in the first two sections as an example.

## Basic Information

You may copy and paste your answers from questions 1-8 in the status update.

1. **Name 1:** Aditi Desai


2. **NetID 1:** aditid


3. **Name 2:** Leuna Sen


4. **NetID 2:** lsen


5. **Project preceptor name:** Alfredo Velasco


6. **Project title:** Promoting HIV Testing and Prevention:
Visualizing The Racial Break of HIV/AIDS Diagnoses in NYC Regions (2010-2013)
 and Finding Nearest Testing Facilities


7. **CodePost link for proposal:** https://codepost.io/code/567794


8. **CodePost link for revised proposal (include if submitted):**


9. **CodePost link for status update:** emailed separately to project preceptor


10. **Link to project video:** https://www.loom.com/share/586bf176984d483fb0753d00b259ff10


11. **Number of hours to complete implementation:** 12-16 hours


## Required Questions

### A. Describe your implemented project in a few sentences below.

Our final project takes in two different dataset files from the New York City
Department of Health Website. The first dataset is a record of all of the HIV
diagnoses in New York City (2012 data). The program asks the user for a region
of interest (specific area/city/town) from a list. Then it will calculate
the racial breakdown of HIV diagnoses per 100,000 people and create a grpahical
representation of this data. This program will also prompot the user to click
on a google form which will lead them to different support/advocacy resources if
they are interested.

The second dataset concerns HIV/AIDS testing facilities. The user will be
presented with a list of unique buroughs included in the dataset, they will
input whichever they are interested in, and finally be presented with a list
of testingn faclities in that region. Then they can use the contact function to
find the address and phone number of that specific testing facility.


### B. Describe your three features.
*Be specific in your description of each feature.
In particular, specify **where** they are implemented
(e.g. .java file name, starting and ending line numbers, method names, etc.).*

  1. Creating a bar chart: This is located in the DataAnalysisClient.java file
  at lines 68-136. The method name is createBarGraph(String regionOfInterest,
  String title, String xAxis, String source). While it is a void method, it i
  will create a bar graph of the number of HIV diagnoses per 100,000 people
  in different racial categories for a specific user-desired location in NYC.


  2. Finding ways to support HIV Advocacy: This is located in the DataAnalysisClient.java
  file at lines 138-147. The method name is findSupport(). It is a void method,
  however, will output "Find a way to support HIV/AIDS advocacy efforts by
  clicking here! https://forms.gle/eYTGUf9A12Q2cKNo9" - thereby leading the user
  to a google form which records their desired form of advocacy (volunteer, charity,
  education) and leads them to the appropriate resources accordingly.


  3. Getting Contact info for a specific clinic/testing facility: This is located
  in Location.java at lines 88-105. The method name is contact(String clinic) and
  it outputs a sentence describing the phone number and address of the indicated
  facility (if they are found in the dataset).

### C. Describe in detail how to compile and run your program.
*Include a few example run commands and the expected results of running your program.
For non-textual outputs (e.g. graphical or auditory), feel free to describe in
words what the output should be or reference output files (e.g. images, audio files)
of the expected output.*

1. To compile and run the DataAnalysisClient.java file, the compile command is
javac-introcs -cp ".:lib/*:.lift/*" DataAnalysisClient.java
and java-introcs -cp ".:lib/*:.lift/*" DataAnalysisClient. After this, the program
will ask for a user input. We can input "Greenpoint" without quotes as an example.
A graph will appear in a new window with the racial breakdown of HIV diagnoses
per 100,000 people. One can also try "Green" (which is not a region in the dataset)
and no graph will appear. Finally, the google form link also appears in the terminal.

2. To compile and run the Location.java file, the compile command is
javac-introcs -cp ".:lib/*:.lift/*" Location.java
and java-introcs -cp ".:lib/*:.lift/*" Location. The program will then output
a list of all of the burough regions, and the user will be asked to enter one.
If we enter "Queens" as an example, then a list of all of the testing facilities
in Queens will be outputted. Then the program asks the user to enter a desired
clinic, say we input "The Child Center of NY," then the program will output
The phone number of The Child Center of NY is: 718-322-4953 and the
address of the facility is: 60-02 Queens Boulevard Woodside.


### D. Describe how your program accepts user input
*Mention the line number(s) at which your program accepts user input.*

1. The DataAnalysisClient.java file accepts user input when asking for the
neighborhood of interest at lines 168-169

2. The Location.java file accepts user input twice when asking for the burough
of interest (line 122) and the clinic of interst at line 137.


### E. Describe how your program produces output based on user input
*Mention the line number(s) at which your program produces output.*

The program produces a number of outputs, such as the:
1. In DataAnalysisClient.java Line 158, a list of all of the unique neighborhoods
are printed out
2. In DataAnalysisClient.java Line 180-181, the program takes in the usser's region
of interest and outputs a visual bar graph in a separate window
3. In DataAnalysisClient.java Line 185, the program outputs a sentence assisting
users in accessing the google form.
4. In Location.java Line 114, the program outputs a list of all of the unique
buroughs in the dataset
5. In Location.java Line 129, the program outputs a list of all of the clinics
in the desired burough
6. In Location.java Line 145, the program outputs a sentence with the address and
phone number of the desired clinic


### F. Describe the data structure your program uses
*Also describe how it supports your program's functionality.
Include the variable name and the line number(s) at which it is declared
and initialized).*

The program extensively uses 2D arrays, arrayLists, and CSV datasets. These
really support the functionality of the program since the program is based on
the information contained in the dataset (which is stored as a 2D string array
on line 26 of DataAnalysisClient.java). The arrayLists in both DataAnalysisClient.java
and Location.java create a "word bank" for user to choose a region or facility
of interest to them. These are located on DataAnalaysisClient.java line 38 and
Location.java line 39.


### G. List the two custom methods written by your project group
*Include method signatures and line numbers.
If your project group wrote more than two custom functions, choose the
two functions that were most extensively tested.*

1. createBarGraph(String regionOfInterest, String title, String xAxis,
  String source) --> DataAnalysisClient.java (Line 69)

2. findAddresses(String regionOfInterest) --> Location.java (Line 70)

### H. List the line numbers where you test each of your two custom methods twice.
*For each of the four tests (two for each method), explain what was being
tested and the expected result. For non-textual results (e.g. graphical or
auditory), you may describe in your own words what the expected result
should be or reference output files (e.g. images, audio files).*

1. DataAnalysisClient.java Line 180 --> can test the createBarGraph(args) method
using an indicated region such as "Greenpoint"

2.DataAnalysisClient.java Line 180 --> can test the createBarGraph(args) method
  using an indicated region such as "Green" which does not exist in the dataset,
  so an empty graph will be produced

3. Location.java Line 129 --> testing to see if the program will output an array
of all of the unique regions located in the dataset

4. Also tested another similar method in DataAnalysisClient.java Line 158 which is
regionsArrayMethod() --> outputs a list of all of the unique regions in the first
dataset


## Citing Resources

### A. List below *EVERY* resource your project group looked at
*Bullet lists and links suffice.*

- HIV Diagnoses Dataset: https://data.cityofnewyork.us/Health/HIV-AIDS-Diagnoses-by-Neighborhood-Sex-and-Race-Et/ykvb-493p/data
- Locations Dataset: https://data.cityofnewyork.us/Health/HIV-Testing-Locations/72ss-25qh/data
- BarChart Library: https://coursera.cs.princeton.edu/introcs/assignments/barchart/files/BarChart.java
- CSV Reader Library: Dr. Ruth Fong's File (from COS 126)


### B. Did you cite every resource that influenced your code in the code itself?
*Every resource that informed your code should be cited in a comment at/near the
line(s) of code that it informed.*

**Yes or No?** Yes

### C. Did you receive help from classmates, past COS 126 students, or anyone else?
*If so, please list their names. ("A Sunday lab TA" or "Office hours on
Thursday" is ok if you don't know their name.)*

**Yes or No?** Yes, our Project Preceptor assisted us when we ran into challenges (Alfredo)



### D. Did you encounter any serious problems? If so, please describe.

**Yes or No?** No



### E. List any other comments here. ###

This project was a great learning experience!


## Submission Checklist
*Please mark that you’ve done all of the following steps
(fill in square bracket with x, i.e. [x]):*

* [ ] Created a project.zip file, unzipped its contents, and checked that our
    compile and run commands work on the unzipped contents. Ensure that the .zip
    file is under 50MB in size.
* [ ] Created and uploaded a Loom or YouTube video that...
  * [ ] is maximum 2 minutes in length
  * [ ] demonstrates live your program's input(s) and output(s)
  * [ ] demonstrates live your 3 features
  * [ ] does **not** reveal any code
  * [ ] includes your project name and the name of each student
  * [ ] has its thumbnail and/or starting frame set to an image of your program
        or a title slide
  * [ ] is publicly viewable (check in an incognito browser)
  * [ ] is linked to in this `implementation.md` file (Q10 under Basic Information)
* [ ] Uploaded all .java files to TigerFile. Each .java file should be uploaded
      separately as an additional file.
* [ ] Uploaded project.zip file to TigerFile.

*After you’ve submitted the above on TigerFile, **remember to do the following**:*
* [ ] Complete and upload this `implementation.md` file to TigerFile.
* [ ] Complete and submit this Google Form
    (https://forms.cs50.io/27ca51e0-4d81-4d97-8621-ba1e5d26cd78).


## Partial Credit: Bug Report(s)
*For partial credit for buggy features, you may include a bug report for at
most 4 bugs that your project group was not able to fix before the submission
deadline. For each bug report, copy and paste the following questions and
answer them in full. Your bug report should be detailed enough for the grader
to reproduce the bug.*

***Note:** if your code appears bug-free, you should **not** submit any bug reports.*

### BUG REPORT #1:
**1. Describe in a sentence or two the bug below.**




**2. Describe in detail how to reproduce the bug (e.g. run commands, user input,
etc.).**




**3. Describe the resulting effect of bug and provide evidence
(e.g. copy-and-paste the buggy output, reference screenshot files and/or buggy
output files, include a Loom video of reproducing and showing the effects of
the bug, etc.).**




**4. Describe where in your program code you believe the bug occurs (e.g. line
numbers).**




**5. Please describe what steps you tried to fix the bug.**





## Extra Credit

### A. Going above and beyond the scope of COS126

#### Did your program go above and beyond the scope of COS126?

**Yes or No?** Yes

*If yes, please answer the following question.*

#### Describe in detail how your program went above and beyond the scope of COS126.

Our project went above and beyond the scope of COS 126 because
we used two external libraries and/or Java libraries not covered in this course.
These two external libraries are BarChart.java and CSVReader.java. These
were also quite integral to the program as a whole since one of the major
outputs of this program is a visual graph which uses BarChart.java. Additionally,
to gather, collect, analyze information from the datasets from the NYC DOH
site, we needed to read in a CSV file using the external CSVReader.java library.


### B. Runtime Analysis

#### Did you analyze the efficiency of a substantial component of your project?

**Yes or No?**

*If yes, please answer the following questions.*

**1. Specify the scope of the component you are analyzing
(e.g. function name, starting and ending lines of specific .java file).**




**2. What is the estimated runtime (e.g. big-O complexity) of this component?
Provide justification for this runtime (i.e. explain in your own words why
you expect this component to have this runtime performance).**




**3. Provide experimental evidence in the form of timed analysis supporting this
runtime estimate. (Hint: you may find it helpful to use command-line
arguments/flags to run just the specified component being analyzed).**




### C. Packaging project as an executable .jar file

#### Did you package your project as an executable .jar file?

**Yes or No?**

*If yes, please answer the following question.*

#### Describe in detail how to execute your .jar application (e.g. what execution command to use on the terminal).
*Include a few example execution commands and the expected results of running
your program. For non-textual outputs (e.g. graphical or auditory), feel free
to describe in words what the output should be or reference output files
(e.g. images, audio files) of the expected output.*



