/**
 *
 * @author datnguyen
 */
public interface DecodingMachineInterface {
    
    /**
     * Return the ASCII equivalent of the primary strand of the given sequence
     * 
     * @param input Complementary strand of the primary strand that needs to be decoded to ASCII text.
     * @return ASCII equivalent of the primary strand
     */
    public String convert(String input);
           
}
