import java.io.*;
import java.util.Scanner;

/**
 * CSC 201 - Assignment 17.4
 * (Convert a text file into UTF) Write a program that reads lines of characters from
 * a text file and writes each line as a UTF-8 string into a binary file. Display the
 * sizes of the text file and the binary file. Use the following command to run the
 * program: java Exercise17_04 Welcome.java Welcome.utf
 *
 * @author Laura Witherspoon
 */

public class Main {
    public static void main(String[] args) throws IOException {

        // Exit with error message if incorrect number of arguments provided
        if (args.length != 2) {
            System.out.println("Usage: java Main sourceFile targetFile");
            System.exit(1);
        }

        // Exit with error message if source file doesn't exist
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            System.exit(2);
        }

        // Exit with error message if target file doesn't exist
        File targetFile = new File(args[1]);
        if (!targetFile.exists()) {
            System.out.println("Target file does not exist.");
            System.exit(3);
        }

        try {
            try (
                    Scanner input = new Scanner(sourceFile);
                    DataOutputStream output = new DataOutputStream(new FileOutputStream(args[1]));
            ) {
                // Keep reading and writing while source file has data
                while (input.hasNext()) {
                    output.writeUTF(input.nextLine());
                }

                // Display sizes of source and target files
                System.out.println("Size of source file: " + sourceFile.length());
                System.out.println("Size of target file: " + output.size());
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
