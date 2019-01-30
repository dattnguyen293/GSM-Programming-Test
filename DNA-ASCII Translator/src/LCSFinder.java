/**
 *
 * @author datnguyen
 */
public class LCSFinder implements LCSFinderInterface {
   
    
    @Override
    //Algorithm: 
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
    //find the larger value between two
    public void printLCS (String firstSequence, int firstLength, String secondSequence, int secondLength) {
        //Not yet finshed. Will soon return to complete it.
    }
}
