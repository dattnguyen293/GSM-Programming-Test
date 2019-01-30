
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author datnguyen
 */
public class SequenceTranslator {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        DNAEncoder encoder = new DNAEncoder();
        ASCIIDecoder decoder = new ASCIIDecoder();
        LCSFinder lcsfinder = new LCSFinder();
        boolean stop = false;

        while (!stop) {
            try {
                System.out.println("*********** Welcome ***********");
                System.out.println("Enter 1 to encode ASCII text string as DNA or RNA");
                System.out.println("Enter 2 to find the first zero-based index where the ASCII substring begins in a DNA sequence");
                System.out.println("Enter 3 to decode a complementary strand of DNA into ASCII text string of the primary strand");
                System.out.println("Enter 4 to find the longest common subsequences of two strands of DNA");
                System.out.println("Enter 0 to exit");

                System.out.print("Select: ");
                int option = console.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("\n**************************");
                        System.out.print("Enter an ASCII text string to encode: ");
                        String textString = console.next();
                        System.out.print("Enter 1 for DNA Sequence, 2 for RNA Sequence: ");
                        int choice = console.nextInt();
                        System.out.println("\nDNA Sequence: " + encoder.convert(textString, choice));
                        System.out.println("\n\n");
                        break;

                    case 2:
                        System.out.println("\n**************************");
                        System.out.print("Enter the DNA sequence: ");
                        String input = console.next();

                        if (!input.matches("[ATGC]+")) {
                            System.out.print("Invalid input! Only characters A, T, G, C are allowable");
                            System.out.println("\n\n");
                            break;
                        }
                        int foundIndex = decoder.findfirstIndexofSubString(input);
                        if (foundIndex == -1) {
                            System.out.println("No substring found.");
                        } else {
                            System.out.println("Substrings starts at " + foundIndex);
                        }
                        System.out.println("\n\n");
                        break;

                    case 3:
                        System.out.println("\n**************************");
                        System.out.print("Enter the complementary strand of DNA to decode: ");
                        String complementaryStrand = console.next();
                        if (!complementaryStrand.matches("[ATGC]+")) {
                            System.out.print("Invalid input! Only characters A, T, G, C are allowable");
                            System.out.println("\n\n");
                            break;
                        }
                        System.out.println("Output: " + decoder.convert(complementaryStrand));
                        System.out.println("\n\n");
                        break;

                    case 4:
                        System.out.println("\n**************************");
                        System.out.print("Enter the 1st sequence: ");
                        String firstSeq = console.next();
                        if (!firstSeq.matches("[ATGC]+")) {
                            System.out.print("Invalid input! Only characters A, T, G, C are allowable");
                            System.out.println("\n\n");
                            break;
                        }
                        System.out.print("Enter the 2nd sequence: ");
                        String secondSeq = console.next();
                        if (!secondSeq.matches("[ATGC]+")) {
                            System.out.print("Invalid input! Only characters A, T, G, C are allowable");
                            System.out.println("\n\n");
                            break;
                        }
                        System.out.println("\nThe longest common subsequences is: " + lcsfinder.findLCS(firstSeq, firstSeq.length(), secondSeq, secondSeq.length()));
                        System.out.println("\n\n");
                        break;

                    case 0:
                        System.out.println("Program is exiting... Closed!");
                        stop = true;
                        break;

                    default:
                        System.out.println("Invalid input! Enter again.");
                        System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter again.\n\n");
                console.next();
            }
        }
    }

}
