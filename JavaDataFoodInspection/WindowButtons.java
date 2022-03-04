import java.awt.event.*;
import java.awt.*;
/**
 * Gets and does actions for our Window Buttons
 *
 * @author Davis Teigeler
 * @version v1.0
 */
public class WindowButtons implements ActionListener
{
    
    private Window win;
    /**
     * Constructor for objects of class WindowButtons
     */
    public WindowButtons(Window w)
    {
        this.win = w;
    }
    
    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand() == "Get Selection by Row")
        {
            int id;
            try
            {
               id = Integer.parseInt(win.rowID.getText()); 
               PopulateWindowByRow(id);
            }
            catch(Exception x)
            {
                
            }
        }
    }
    
    private void PopulateWindowByRow (int row)
    {
        for (int i = 0; i < win.data.header.length; i++)
        {
            TextField field = (TextField)win.dataPan.getComponent((i*2)+1);
            field.setText(win.data.data[row][i]);
        }
        win.frame.validate();
    }
}
