/*
Program Name: Assignment_2_2
Author: Brianna Drew
Student No.: 0622446
Date Created: 02/21/2019
Last Modified: 02/26/2019
*/

// import required java libraries
import java.lang.System;
import java.util.Scanner;
import java.util.UUID;

/*
Class: VotePersonalIdentification
Description: This class essentially will allow a voter to register to vote by entering the following data: last name, first name, address,
             province, city, postal code, and SIN number (and will check the validity of the first and last names, postal code, and SIN number).
             It will then utilize the BallotCreation class to display the ballot, and then take the user's vote and submit it. At the beginning
             of the class, we create an array to store a list of the 5 candidates running in the election, then we create the candidate objects,
             specify the properties, and store them in each location in the array. When the ballot is displayed, each candidate is displayed
             with a corresponding number and that is what the voter uses to vote in regards to their input. Also, a random unique identifier is
             created for the voter as their unique voter ID.
*/
public class VotePersonalIdentification {

    private static String voterLastName, voterFirstName, voterAddress, voterProvince, voterCity, voterPostalCode; // initialize string variables that will store the voter's: last name, first name, address, province, city, and postal code
    public static String voterID; // initialize string variable that will store the voter's ID
    private static int voterSIN; // initialize integer variable that will store the voter's SIN number
    private static boolean valid = false; // boolean variable used to run validation while loops

    /*
    Method: main
    Description: The primary method of the program. An array to store a list of the 5 candidates running in the election is created, then the
                 candidate objects are created, specify the properties, and stored in each location in the array. Voter registers to vote by
                 entering the following data: last name, first name, address, province, city, postal code, and SIN number (and will check the
                 validity of the first and last names, postal code, and SIN number by method calling and parameter passing). Will call a
                 method that we return a randomly generated voter ID and return it, then it is displayed with a "success" statement (also
                 returned from another method). Uses BallotCreation class to make a new ballot and call the method to display the ballot,
                 with the candidates in a numbered list. The user then enters the number corresponding to the candidate they wish to vote
                 for. If the user enters a number that is actually representing a candidate, and "success" statement from BallotCreation class
                 is displayed via method calling. If not, they will have to try again.
    Usage: primary method in class VotePersonalIdentification
    Parameters: String args[]
    Return Type: void
    */
    public static void main(String[] args){

        Candidate candidates[] = new Candidate[5]; // create new array of class Candidate objects of size 5
        candidates[0] = new Candidate("Justin Trudeau","Male, Age 47, Liberal Party"); // create new object of Candidate class, pass values for candidate's name and biography, and store in 1st position in candidates array
        candidates[1] = new Candidate("Stephen Harper","Male, Age 59, Conservative Party"); // create new object of Candidate class, pass values for candidate's name and biography, and store in 2nd position in candidates array
        candidates[2] = new Candidate("Thomas Mulcair","Male, Age 64, New Democratic Party"); // create new object of Candidate class, pass values for candidate's name and biography, and store in 3rd position in candidates array
        candidates[3] = new Candidate("Gilles Duceppe", "Male, Age 71, Bloc Québécois"); // create new object of Candidate class, pass values for candidate's name and biography, and store in 4th position in candidates array
        candidates[4] = new Candidate("Elizabeth May", "Female, Age 64, Green Party"); // create new object of Candidate class, pass values for candidate's name and biography, and store in 5th position in candidates array

        Scanner scanner = new Scanner(System.in); // create new scanner object to be able to read user input
        System.out.println("******************************************");
        System.out.println("*   CANADIAN FEDERAL GOVERNMENT ONLINE   *");
        System.out.println("*            REGISTER AND VOTE           *");
        System.out.println("******************************************");
        System.out.println();

        while (!valid) { // while the user entered last name is invalid (invalid to start)...

            System.out.print("Last Name: "); // prompt voter to enter their last name
            voterLastName = scanner.nextLine(); // store voter input as voter's last name
            valid = validateLastName(voterLastName); // call method to check validity of last name entered by passing it

            if(!valid) { // if the validity check method returns invalid...

                System.out.println("Input invalid. Please try again."); // print statement that the voter-entered last name is invalid
                System.out.println();

            }

        }

        valid = false; // set validity back to false to be able to run more while loops to check validity of other inputs
        System.out.println();

        while (!valid){ // while the user entered first name is invalid (invalid to start)...

            System.out.print("First Name: "); // prompt voter to enter their first name
            voterFirstName = scanner.nextLine(); // store voter-entered first name
            valid = validateFirstName(voterFirstName); // call method to check validity of first name entered by passing it

            if(!valid) { // if the validity check method returns invalid...

                System.out.println("Input invalid. Please try again."); // print statement that the voter-entered first name is invalid
                System.out.println();

            }

        }

        valid = false; // set validity back to false to be able to run more while loops to check validity of other inputs
        System.out.println();

        System.out.print("Address: "); // prompt voter to enter their street address
        voterAddress = scanner.nextLine(); // store voter input as voter's address
        System.out.println();

        System.out.print("Province: "); // prompt voter to enter the province they live in
        voterProvince = scanner.nextLine(); // store voter input as voter's province
        System.out.println();

        System.out.print("City: "); // prompt voter to enter the city they live in
        voterCity = scanner.nextLine(); // store voter input as voter's city
        System.out.println();

        while (!valid){ // while the user entered postal code is invalid (invalid to start)...

            System.out.print("Postal Code (no spaces): "); // prompt voter to enter their postal code
            voterPostalCode = scanner.nextLine(); // store voter input as voter's postal code
            valid = validatePostalCode(voterPostalCode); // call method to check validity of postal code entered by passing it

            if (!valid) { // if the validity check method returns invalid...

                System.out.println("Input invalid. Please try again."); // print statement that the voter-entered postal code is invalid
                System.out.println();

            }

        }

        valid = false; // set validity back to false to be able to run more while loops to check validity of other inputs
        System.out.println();

        while (!valid){ // while the voter-entered SIN number is invalid (invalid to start)...

            System.out.print("SIN (no dashes or spaces): "); // prompt voter to enter their SIN number

            if (scanner.hasNextInt()) { // if the voter-entered SIN number is in integer format...

                voterSIN = scanner.nextInt(); // store voter-entered SIN number
                valid = validateSIN(voterSIN); // call method to check validity of SIN number entered by passing it

                if (!valid) { // if the validity check method returns invalid...

                    System.out.println("Input invalid. Please try again."); // print statement that the voter-entered SIN number is invalid
                    System.out.println();
                    scanner.nextLine(); // reset scanner

                }

            }

            else{ // if the voter-entered SIN number is not in integer format...

                System.out.println("Input invalid. Please try again."); // print statement that the voter-entered SIN number is invalid
                System.out.println();
                scanner.nextLine(); // reset scanner

            }

        }

        valid = false; // set validity back to false to be able to run more while loops to check validity of other inputs
        System.out.println();

        String success = successfullyRegistered(); // call method to get statement indicating that the voter has registered successfully and store returned statement as string
        voterID = voterID(); // call method to generate voter ID and store returned string
        System.out.println(success + "with new voter ID: " + voterID); // print statement indicating that the voter has registered successfully and the voter's ID using a concatenated string
        System.out.println();

        BallotCreation ballot = new BallotCreation(voterID); // create new ballot object from BallotCreation class and pass voter's ID to constructor
        String ballotName = ballot.getBallotName(); // call method to get the name of the ballot from BallotCreation class and store returned name as string
        ballot.displayBallot(ballotName,candidates); //
        System.out.println();

        while (!valid){ // while the voter-entered number representing their chosen candidate is invalid (invalid to start)...

            System.out.print("Please enter the number that corresponds to the candidate you wish to vote for: "); // prompt voter to enter a number to choose which candidate on the ballot to voter for

            if (scanner.hasNextInt()){ // if the voter-entered number is in integer format...

                int vote = scanner.nextInt(); // store voter-entered number

                if(vote < 1 || vote > 5){ // if the voter-entered number is not between 1 and 5 (including 1 and 5)...

                    System.out.println("Input invalid. Please try again."); // print statement that the voter-entered number is invalid
                    System.out.println();
                    scanner.nextLine(); // reset scanner

                }

                else{ // if the voter-entered number is between 1 and 5 (including 1 and 5)...

                    valid = true; // the voter-entered number is valid

                }
            }

            else{ // if the voter-entered number is not in integer format...

                System.out.println("Input invalid. Please try again."); // print statement that the voter-entered number is invalid
                System.out.println();
                scanner.nextLine(); // reset scanner

            }

        }

        String bSuccess = ballot.submitBallot(); // call method to get statement from BallotCreation class stating that the ballot submission was successful
        System.out.println();
        System.out.println(bSuccess); // print statement that the ballot submission was successful

    }

    /*
    Method: validateLastName
    Description: return whether or not the last name the voter entered's characters are all letters
    Usage: called in main method
    Parameters: string voterLastName (passed from main method, stores voter's last name)
    Return Type: boolean
    */
    public static boolean validateLastName(String voterLastName){

        return voterLastName.chars().allMatch(Character::isLetter); // return whether or not the last name the voter entered's characters are all letters

    }

    /*
    Method: validateFirstName
    Description: return whether or not the first name the voter entered's characters are all letters
    Usage: called in main method
    Parameters: string voterFirstName (passed from main method, stores voter's first name)
    Return Type: boolean
    */
    public static boolean validateFirstName(String voterFirstName){

        return voterFirstName.chars().allMatch(Character::isLetter); // return whether or not the first name the voter entered's characters are all letters

    }

    /*
    Method: validateSIN
    Description: return whether or not the SIN number is valid
    Usage: called in main method
    Parameters: integer voterSIN (passed from main method, stores voter's SIN number)
    Return Type: boolean
    */
    public static boolean validateSIN(int voterSIN){

        if(voterSIN < 1000000000 && voterSIN > 99999999){ // if the SIN number the voter entered is exactly 9 digits long...

            return true; // return that the SIN number is valid

        }

        else{ // if the SIN number the voter entered is not 9 digits long...

            return false; // return that the SIN number is invalid

        }

    }

    /*
    Method: voterPostalCode
    Description: return whether or not the postal code voter entered matches the regular expression (valid format of Canadian postal code)
    Usage: called in main method
    Parameters: string voterPostalCode (passed from main method, stores voter's postal code)
    Return Type: boolean
    */
    public static boolean validatePostalCode(String voterPostalCode){

        return voterPostalCode.matches("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z]●?[0-9][A-Z][0-9]$"); // return whether or not the postal code voter entered matches the regular expression (valid format of Canadian postal code)

    }

    /*
    Method: successfullyRegistered
    Description: return statement indicating that the voter's registration was successful
    Usage: called in main method
    Parameters: none
    Return Type: string
    */
    public static String successfullyRegistered(){

        return "Registration successful "; // return statement indicating that the voter's registration was successful

    }

    /*
    Method: voterID
    Description: generate random unique identifier and return it as string as voterID
    Usage: called in main method
    Parameters: none
    Return Type: string
    */
    public static String voterID(){

        return UUID.randomUUID().toString(); // generate random unique identifier and return it as string as voterID

    }

}
