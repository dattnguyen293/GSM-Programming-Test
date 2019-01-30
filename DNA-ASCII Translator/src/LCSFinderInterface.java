/**
 *
 * @author datnguyen
 */
public interface LCSFinderInterface {

    /**
     * Find the length of the longest common subsequence of the two given sequences
     * 
     * @param firstSequence the first DNA sequence
     * @param firstLength the length of the first DNA sequence
     * @param secondSequence the second DNA sequence
     * @param secondLength the length of the second DNA sequence
     * @return the length of the longest common subsequence of the two sequences
     */
    public int findLCS (String firstSequence, int firstLength, String secondSequence, int secondLength);
    
    /**
     * Find the largest value of the two
     * 
     * @param firstValue first value
     * @param secondValue second value
     * @return the largest one of the two values
     */
    public int findMax(int firstValue, int secondValue);
    
    /**
     * Print the longest common subsequence of the two sequences
     * 
     * @param firstSequence the first DNA sequence
     * @param firstLength the length of the first DNA sequence
     * @param secondSequence the second DNA sequence
     * @param secondLength the length of the second DNA sequence
     */
    public void printLCS (String firstSequence, int firstLength, String secondSequence, int secondLength);
}
