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
    WindowButtons press;
    TextField rowID;
    
    CSVData data;
    /**
     * Constructor for objects of class Window
     */
    public Window(int width, int height, CSVData d)
    {
        this.data = d;
        this.press = new WindowButtons(this);
        
        frame = new JFrame(data.name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        dataArea = new Box(BoxLayout.Y_AXIS);
        controlArea = new Box(BoxLayout.Y_AXIS);
        
        dataPan = new Panel();
        int dRows = (int)Math.ceil((double)data.columns/4.0);
        dataPan.setLayout(new GridLayout(dRows*2,4));
        InitDataPanel(data);
        
        controlPan = new Panel();
        controlPan.setLayout(new GridLayout(1,2));
        Button getItem = new Button("Get Selection by Row");
        getItem.addActionListener(press);
        rowID = new TextField("",10);
        controlPan.add(getItem);
        controlPan.add(rowID);
        
        controlArea.add(controlPan);
        dataArea.add(dataPan);
        frame.add(dataArea);
        frame.add(controlArea);
        setupMenu();
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
    
    private void setupMenu()
    {
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem loadFileMenu = new JMenuItem("Load CSV");
        loadFileMenu.addActionListener(press);
        
        file.add(loadFileMenu);
        mb.add(file);
        frame.setJMenuBar(mb);
    }
}
