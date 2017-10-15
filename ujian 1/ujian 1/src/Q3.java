import java.io.*;

public class Q3 {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "B.BIN";
        
        // The name of the file to create.
        String fileName2 = "C.txt";

        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            FileInputStream inputStream = 
                new FileInputStream(fileName);

            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            while((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
                System.out.println(new String(buffer));
                total += nRead;
            }   

            // Always close files.
            inputStream.close();        
            System.out.println("Read " + total + " bytes");
          //-----------------
            try {
                // Put some bytes in a buffer so we can
                // write them. Usually this would be
                // image data or something. Or it might
                // be unicode text.
                //String bytes = "5E4D3C2B1A";
               // byte[] buffer = bytes.getBytes();

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

                System.out.println("Wrote " + buffer.length + " bytes");
            }
            catch(IOException ex) {
                System.out.println(
                    "Error writing to file '"
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
