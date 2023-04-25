/////////////////////////////////////////
//Program Name: homeScreen.java
//Program Purpose: create a jFrame for the home screen of Maintain Control
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import javax.swing.*; 
import java.awt.Dimension; 
import javax.swing.JPanel; 
import java.awt.*; 
import java.awt.event.*;

//Start of toDoListScreen Class 
public class toDoListScreen extends JFrame
{
    //Objects
    private Color colorful;
    private JLabel title; 
    private JButton addTask;
    private JPanel marksArea; 

    //Constructor
    public toDoListScreen()
    {
        super("Maintain Control: To-Do List");
        setLayout(new FlowLayout());
        colorful = new Color(0, 128, 255);
        
        //Setting Up Title Area
        title = new JLabel("To-Do List"); 
        title.setFont(new Font("San-Serif", Font.BOLD, 70));
        title.setForeground(colorful); 
        //Adding to Frame
        add(title); 

        //Setting Up Button
        addTask = new JButton("Add Task");
        addTask.setPreferredSize(new Dimension(500, 40));;
        colorful = new Color(204, 229, 255);
        addTask.setBackground(colorful);

        //Setting Up Button Handler
        ButtonHandler click = new ButtonHandler();
        addTask.addActionListener(click); 

        //Adding Button to frame
        add(addTask); 

        //Add task area
        marksArea = new JPanel(new FlowLayout()); 
        marksArea.setPreferredSize(new Dimension(750, 300));
        colorful = new Color(229, 204, 255); 
        marksArea.setBackground(colorful); 
        add(marksArea);  

    }//End of toDoListScreen Constructor

    //Private Inner Class For Event Handeling
    private class ButtonHandler implements ActionListener
    {
        //Handle button event
		@Override
		public void actionPerformed(ActionEvent event)
		{
            if (event.getSource() == addTask)
            {
                String task = JOptionPane.showInputDialog("Task To Add: "); 
                JCheckBox newTask = new JCheckBox(task);
                newTask.setBackground(colorful); 
                marksArea.add(newTask); 
            }

        }//end of override of function

    }//End of ButtonHandler Class
    
}//End of toDoListScreen Class
