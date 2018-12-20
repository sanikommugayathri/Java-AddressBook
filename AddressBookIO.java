
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Closeable;

public class AddressBookIO
{
    private static File addressBookFile = new File("address_book.txt");
    private static final String FIELD_SEP = "\t";
    private static final int COL_WIDTH = 20;

    // use this method to return a string that displays
    // all entries in the address_book.txt file
    public static String getEntriesString()
    {
        BufferedReader in = null;
        try
        {
            checkFile();

            in = new BufferedReader(
                 new FileReader(addressBookFile));

            // define the string and set a header
            String entriesString = "";
            entriesString = padWithSpaces("Name", COL_WIDTH)
                + padWithSpaces("email", COL_WIDTH)
                + padWithSpaces("Cell Number", COL_WIDTH)
                + "\n";

            entriesString += padWithSpaces("------------------", COL_WIDTH)
                + padWithSpaces("------------------", COL_WIDTH)
                + padWithSpaces("------------------", COL_WIDTH)
                + "\n";

            // append each line in the file to the entriesString
            String line = in.readLine();
            while(line != null)
            {
                String[] columns = line.split(FIELD_SEP);
                String name = columns[0];
                String emailAddress = columns[1];
                String cellNumber = columns[2];

                entriesString +=
                    padWithSpaces(name, COL_WIDTH) +
                    padWithSpaces(emailAddress, COL_WIDTH) +
                    padWithSpaces(cellNumber, COL_WIDTH) +
                    "\n";

                line = in.readLine();
            }
            return entriesString;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }
        finally
        {
            close(in);
        }
    }

    // use this method to append an address book entry
    // to the end of the address_book.txt file
    public static boolean saveEntry(AddressBookEntry entry)
    {
        PrintWriter out = null;
        try
        {
            checkFile();

            // open output stream for appending
            out = new PrintWriter(
                  new BufferedWriter(
                  new FileWriter(addressBookFile, true)));

            // write all entry to the end of the file
            out.println();
            out.print(entry.getName() + FIELD_SEP);
            out.print(entry.getEmail() + FIELD_SEP);
            out.print(entry.getCellNumber() + FIELD_SEP);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return false;
        }
        finally
        {
            close(out);
        }
        return true;
    }

    // a private method that creates a blank file if the file doesn't already exist
    private static void checkFile() throws IOException
    {
        // if the file doesn't exist, create it
        if (!addressBookFile.exists())
            addressBookFile.createNewFile();
    }

    // a private method that closes the I/O stream
    private static void close(Closeable stream)
    {
        try
        {
            if (stream != null)
                stream.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    // a private method that is used to set the width of a column
    private static String padWithSpaces(String s, int length)
    {
        if (s.length() < length)
        {
            StringBuilder sb = new StringBuilder(s);
            while(sb.length() < length)
            {
                sb.append(" ");
            }
            return sb.toString();
        }
        else
        {
            return s.substring(0, length);
        }
    }
}
    
    

