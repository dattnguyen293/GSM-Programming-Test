/**
 *
 * @author datnguyen
 */
public class ASCIIDecoder implements DecodingMachineInterface, ASCIISubStringinSequence {
    private int startingIndex = -1;

    
    //Convert a DNA sequence into binary sequence
    private String convertSequenceIntoBinary(String sequence) {
        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < sequence.length(); i++) {
            switch (sequence.charAt(i)) {
                case 'A':
                    binaryString.append("00");
                    break;
                case 'T':
                    binaryString.append("01");
                    break;
                case 'G':
                    binaryString.append("10");
                    break;
                case 'C':
                    binaryString.append("11");
                    break;
                //default:       
            }
        }
        return binaryString.toString();
    }
    
    //Replace each DNA base with the other complementary base
    private String findDNAPrimaryStrand(String complementaryStrand) {
        StringBuilder primaryStrand = new StringBuilder();
        for (int i = 0; i < complementaryStrand.length(); i++) {
            switch (complementaryStrand.charAt(i)) {
                case 'A':
                    primaryStrand.append("T");
                    break;
                case 'T':
                    primaryStrand.append("A");
                    break;
                case 'C':
                    primaryStrand.append("G");
                    break;
                case 'G':
                    primaryStrand.append("C");
                    break;   
                //default
            }
        }
  
        return primaryStrand.toString();
    }
     
    //default constructor
    public ASCIIDecoder() {
    }

    @Override
    //decode the primary strand of the given complementary strand (input) as ASCII text
    public String convert(String input) {
        String newSequence = findDNAPrimaryStrand (input);
        String binaryStr = convertSequenceIntoBinary (newSequence);
        String decodedTextString = "";
        for(int i = 0; i <= binaryStr.length()-8; i += 8) 
        {
            char decodedCharacter = (char)Integer.parseInt(binaryStr.substring(i, i+8), 2);
            
            //check if the decoded character is indeed ASCII character
            if (Character.toString(decodedCharacter).matches("\\p{ASCII}*")) {
                decodedTextString += decodedCharacter;
            }
        }
        return decodedTextString;
    }

    @Override
    //find the zero-based index where the ASCII substring in DNA sequence begins
    //index is -1 if an ASCII substring does not exist
    public int findfirstIndexofSubString(String input) {
        String binaryStr = convertSequenceIntoBinary (input);
        for(int i = 0; i <= binaryStr.length() - 8; i++) 
        {
            char decodedCharacter = (char)Integer.parseInt(binaryStr.substring(i, i+8), 2);
            
            if (Character.toString(decodedCharacter).matches("\\p{ASCII}*")) {
                System.out.print(decodedCharacter);
                if (startingIndex == -1) {
                    startingIndex = i;
                    return startingIndex;
                }
            }
        }

        return startingIndex;
    }
   
    @Override
    //check if there is any ASCII substring in the DNA sequence
    public boolean ifAsciiMatches (String input) {
        String binaryStr = convertSequenceIntoBinary (input);
        String decodedTextString = "";
        for(int i = 0; i <= binaryStr.length()-8; i++) 
        {
            decodedTextString += (char)Integer.parseInt(binaryStr.substring(i, i+8), 2);
        }
        return (decodedTextString.matches("\\p{ASCII}*"));
    } 
}
