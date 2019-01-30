/**
 *
 * @author datnguyen
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class DNAEncoder implements EncodingMachineInterface {
    
    private final HashMap <String,String> convertTable = new HashMap<>();
    
    //convert an ASCII character to binary
    private static String asciiToBinary(String asciiString){  
          byte[] bytesArray = asciiString.getBytes();  
          StringBuilder binaryStr = new StringBuilder();  
          for (byte b : bytesArray)  
          {  
             int val = b;  
             for (int i = 0; i < 8; i++)  
             {  
                binaryStr.append((val & 128) == 0 ? 0 : 1);  
                val <<= 1;  
             }   
          }  
          return binaryStr.toString();  
    }
    
    //import conversion rules from txt files to the hash table.
    private void initializeDNAConvertTable (int choice) throws IOException {
        String fileName = "";
        switch (choice) {
            case 1: fileName = "dna_conversion_rules.txt";
            break;
            case 2: fileName = "rna_conversion_rules.txt";
            break;
            //default:
        }
        
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while ((line = reader.readLine()) != null) {
            String[] components = line.split(" ", 2);
            convertTable.put(components[0], components[1]);
        }
        
        reader.close();  
    } 
    
    //default constructor
    public DNAEncoder () {
    }

    @Override
    //encode an ASCII string to either DNA or RNA
    public String convert(String stringValue, int choice) {
        try {
            initializeDNAConvertTable(choice);
        } catch (IOException ex) {
            Logger.getLogger(DNAEncoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String binaryString = asciiToBinary(stringValue);
      
        int j = 0;
        StringBuilder encodedSequence = new StringBuilder();
        while (true) {
            if (j >= binaryString.length())
                break;
            
            else {
                encodedSequence.append(convertTable.get(binaryString.substring(j, j + 2)));
                j += 2;
            }
        }
        return encodedSequence.toString();
    }  
}
