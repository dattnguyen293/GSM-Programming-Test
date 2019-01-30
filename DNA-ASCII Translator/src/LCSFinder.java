/**
 *
 * @author datnguyen
 */
public class LCSFinder implements LCSFinderInterface {
   
    
    @Override
    //Naive Algorithm is used in this program. Basically, program will iterate through each character in each sequence,
    //  starting from the last character. Then, characters will be compared to determine the LCS
    //Time complexity is O(2^n), which means time complexity will grow exponentially
    //Therefore, Dynamic Programming approach will work better in this case
    public int findLCS(String firstSequence, int firstLength, String secondSequence, int secondLength) {  
        
        if (firstLength == 0 || secondLength == 0) {
            return 0;
        }
        if (firstSequence.charAt(firstLength - 1) == (secondSequence.charAt(secondLength -1 ))) {
            return 1 + findLCS(firstSequence, firstLength - 1, secondSequence, secondLength - 1);  
        }
        else {
            return findMax (findLCS (firstSequence, firstLength - 1, secondSequence, secondLength), 
                    findLCS (firstSequence, firstLength, secondSequence, secondLength - 1));
        }
    }

    @Override
    //find the larger value between two
    public int findMax(int firstValue, int secondValue) {
        if (firstValue > secondValue)
            return firstValue;
        else return secondValue;
    }
    
    @Override
    //print the longest common subsequence of the two DNA sequences
    public void printLCS (String firstSequence, int firstLength, String secondSequence, int secondLength) {
        //Not yet finshed. Will soon return to complete it.
    }
}
