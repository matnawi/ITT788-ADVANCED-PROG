import java.io.*;
import java.io.IOException;

public class Q2 {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "A.txt";
        
        // The name of the file to create.
        String fileName2 = "B.BIN";
      
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   
                     
            // Always close files.
            bufferedReader.close();  
          //-----------------

            try {
                // Put some bytes in a buffer so we can
                // write them. Usually this would be
                // image data or something. Or it might
                // be unicode text.
                String bytes = "5E4D3C2B1A";
                byte[] buffer = bytes.getBytes();

                FileOutputStream outputStream =
                    new FileOutputStream(fileName2);

                // write() writes as many bytes from the buffer
                // as the length of the buffer. You can also
                // use
                // write(buffer, offset, length)
                // if you want to write a specific number of
                // bytes, or only part of the buffer.
                outputStream.write(buffer);

                // Always close files.
                outputStream.close();       

                System.out.println("Wrote " + buffer.length + 
                    " bytes");
            }
            catch(IOException ex) {
                System.out.println(
                    "Error writing file '"
                    + fileName2 + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
            //-----------------          
            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
}
