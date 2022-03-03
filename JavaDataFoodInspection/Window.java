import javax.swing.*;
import java.awt.*;
/**
 * Wrapper class for our JFrame so we can quickly and easily replace values
 *
 * @author Davis Teigeler
 * @version v1.0
 */
public class Window
{
    JFrame frame;
    Box dataArea;
    Box controlArea;
    Panel dataPan;
    Panel controlPan;
    
    CSVData data;
    /**
     * Constructor for objects of class Window
     */
    public Window(int width, int height, CSVData d)
    {
        this.data = d;
        
        frame = new JFrame(data.name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        dataArea = new Box(BoxLayout.Y_AXIS);
        controlArea = new Box(BoxLayout.Y_AXIS);
        
        dataPan = new Panel();
        int dRows = (int)Math.ceil((double)data.columns/6.0);
        dataPan.setLayout(new GridLayout(dRows*2,6));
        
        InitDataPanel(data);
        
        frame.add(dataPan);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void InitDataPanel(CSVData d)
    {
        for (int i = 0; i < d.header.length; i++)
        {
            TextField txt = new TextField("",20);
            Label lbl = new Label(d.header[i]);
            dataPan.add(lbl);
            dataPan.add(txt);
        }
    }
}
