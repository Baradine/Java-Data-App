
/**
 * Runs the app
 *
 * @author Davis Teigeler
 * @version v1.0
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
