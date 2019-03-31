/*
Class: Candidate
Description: This class will essentially create a candidate who is running in the election which will include their name and a brief biography.
             It gets and sets both the candidate's name and biography.
*/
public class Candidate {

    private String candidateName; // string representing candidate's name
    private String candidateBiography; // string representing candidate's biography

    /*
    Constructor: Candidate
    Description: set candidate's name to name and set candidate's biography to biography passed from object instantiation
    Usage: in Test class
    Parameters: string candidateName, string candidateBiography (passed from VotePersonalIdentification class, candidate's name and their biography)
    Return Type: N/A
    */
    public Candidate(String candidateName, String candidateBiography){

        this.candidateName = candidateName; // set candidate's name to name passed from object instantiation
        this.candidateBiography = candidateBiography; // set candidate's biography to biography passed from object instantiation

    }

    /*
    Method: getCandidateName
    Description: return the candidate's name
    Usage: called in VotePersonalIdentification class
    Parameters: none
    Return Type: string
    */
    public String getCandidateName(){

        return candidateName; // return the candidate's name

    }

    /*
    Method: getCandidateBiography
    Description: return the candidate's biography
    Usage: called in VotePersonalIdentification class
    Parameters: none
    Return Type: string
    */
    public String getCandidateBiography(){

        return candidateBiography; // return the candidate's biography

    }

}
