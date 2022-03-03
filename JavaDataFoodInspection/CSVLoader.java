import java.io.*;
/**
 * Loads in any generic CSV file
 *
 * @author Davis Teigeler
 * @version v1.0
 */
public class CSVLoader
{
    // Regex string which splits by commas except for when within quotes
    final String regexMagicDelim = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    String file;
    
    public CSVData Load (String filename)
    {
        File f = new File(filename);
        if (f.exists())
        {
            int rows = CountRows(filename);
            return LoadData(filename, rows);
        }
        return null;
    }
    
    public int CountRows (String filename)
    {
        int countRows = 0;
        try {
            String line;
            BufferedReader reader = 
                new BufferedReader(new FileReader(filename));
            while((line=reader.readLine())!=null){
                countRows++;
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("There was a problem reading the metadata.");
            System.err.println(e);
            return -1;
        }
        return countRows;
    }
    
    public CSVData LoadData(String filename, int rows)
    {
        if (rows<=0) {
            return null;
        }
        CSVData d = new CSVData();
        d.data = new String[rows-1][];
        String [] record;
        int row = -1; // header=-1, data starts at 0
        try {
            String line;
            BufferedReader reader = 
                new BufferedReader(new FileReader(filename));
            while((line=reader.readLine())!=null){
                // Place header in seperate array
                if (row>=0) {
                    String [] fields = line.split(regexMagicDelim);
                    d.data[row]=fields;
                }
                else
                {
                    String[] fields = line.split(regexMagicDelim);
                    d.header = fields;
                }
                row++;
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("There was a problem reading the data.");
            System.err.println(e);
            return null;
        }
        d.name = filename;
        d.columns = d.header.length;
        d.initialized = true;
        return d;
    }
}
