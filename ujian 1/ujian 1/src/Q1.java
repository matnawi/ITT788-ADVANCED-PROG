import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q1 {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "A.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("A1B2C3D4E5");
            //bufferedWriter.write(" here is some text.");
           // bufferedWriter.newLine();
           // bufferedWriter.write("We are writing");
           // bufferedWriter.write(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}

