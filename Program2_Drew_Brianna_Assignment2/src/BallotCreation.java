/*
Class: BallotCreation
Description: This class will essentially create a voting ballot with the voter's unique ID as well as a numbered list of the candidates
             running in the election. It creates the object, gets and sets the ballot name (voter ID).
*/
public class BallotCreation {

    private String ballotName; // string representing the name of the ballot

    /*
    Constructor: BallotCreation
    Description: set ballot name to concatenated string introducing ballot name and setting ballot name to voterID passed from object
                 instantiation in VotePersonalIdentification class
    Usage: in Test class
    Parameters: string voterID (passed from VotePersonalIdentification class, voter's unique identification)
    Return Type: N/A
    */
    public BallotCreation(String voterID){

        this.ballotName = "BALLOT " + voterID; // set ballot name to concatenated string introducing ballot name and setting ballot name to voterID passed from object instantiation in VotePersonalIdentification class

    }

    /*
    Method: getBallotName
    Description: return the ballot name
    Usage: called in VotePersonalIdentification class
    Parameters: none
    Return Type: string
    */
    public String getBallotName(){

        return ballotName; // return the ballot name

    }

    /*
    Method: displayBallot
    Description: display the ballot (including ballot name and candidates and their biographies in a list ordered by number)
    Usage: called in VotePersonalIdentification class
    Parameters: string ballotName, Candidate array candidates[] (passed from VotePersonalIdentification class, name of the current ballot and list of candidates running in election)
    Return Type: void
    */
    public void displayBallot(String ballotName, Candidate candidates[]){
        System.out.println("************************************************************************************************************");
        System.out.println("**                      ELECTIONS CANADA: " + ballotName + "                     **"); // display the name of the ballot
        System.out.println("************************************************************************************************************");
        System.out.println();

        int i = 1; // counter for foreach loop set to 1 (to display candidates in a numbered list format)
        for (Candidate can: candidates) { // for each candidate in the array containing the candidates...

            String candidateName = can.getCandidateName(); // call method in Candidate class to get candidate name from Candidate class for current candidate and store received name
            String candidateBiography = can.getCandidateBiography(); // call method in Candidate class to get candidate biography from Candidate class for current candidate and store received biography
            System.out.println(i + ". " + candidateName + ": " + candidateBiography); // print candidate's name and biography using formatted concatenated string
            System.out.println();
            i++; // increase counter by 1 for next time through loop

        }
        System.out.println("************************************************************************************************************");
    }

    /*
    Method: submitBallot
    Description: return statement indicating that the vote and ballot submission was successful
    Usage: called in VotePersonalIdentification class
    Parameters: none
    Return Type: string
    */
    public String submitBallot(){

        return "Ballot submitted successfully."; // return statement indicating that the vote and ballot submission was successful

    }

}
