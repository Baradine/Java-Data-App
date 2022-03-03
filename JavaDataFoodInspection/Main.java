
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main ()
    {
        CSVLoader load = new CSVLoader();
        CSVData data = load.Load("Food_Inspection.csv");
        Window w = new Window(0,0,data);
    }
    
}
