
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author datnguyen
 */
public interface EncodingMachineInterface {
   
    /**
     * Encode an ASCII text String as either DNA or RNA
     * 
     * @param stringValue ASCII string to be encoded as DNA or RNA
     * @param choice 1 to convert string to DNA, 2 to convert string to RNA
     * @return encoded DNA or RNA sequence
     */
    public String convert(String stringValue, int choice);
    
}
