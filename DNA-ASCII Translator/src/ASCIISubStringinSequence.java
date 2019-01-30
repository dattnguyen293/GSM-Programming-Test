/**
 *
 * @author datnguyen
 */
public interface ASCIISubStringinSequence {

    /**
     * Return the zero-based index where the ASCII sub-string begins in the DNA input sequence
     * 
     * @param input - DNA sequence
     * @return first index where ASCII sub-string begins. -1 if no string is found
     */
    public int findfirstIndexofSubString (String input);
  
    /**
     * Return true if there exists an ASCII sub-string in the DNA sequence
     * 
     * @param input - DNA sequence
     * @return "true" if an ASCII sub-string is found. Otherwise, "false" is returned
     */
    public boolean ifAsciiMatches (String input);
}
