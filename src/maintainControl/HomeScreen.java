/////////////////////////////////////////
//Program Name: HomeScreen.java
//Program Purpose: create a jFrame for the home screen of Maintain Control
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

//Start of homeScreen Class
public class HomeScreen extends JFrame
{
    //Objects
    private JLabel titleArea;
    private JPanel options;  
    private JButton monthlyView; 
    private JButton weeklyView; 
    private JButton dailyView; 
    private JButton toDoListView; 
    private Color colorful; 


    //Constructor
    public HomeScreen()
    {
        super("Maintain Control"); 
        setLayout(new FlowLayout());
        colorful = new Color(0, 128, 255); 

        //Setting up Title area
        titleArea = new JLabel("Maintain Control");  
        //Setting Font
        titleArea.setFont(new Font("San-Serif", Font.BOLD, 80 ));
        //Setting color 
        titleArea.setForeground(colorful);
        //Adding Title to Frame
        add(titleArea); 


        //Setting up Button Optoins Panel
        options = new JPanel(); 
        options.setLayout(new FlowLayout());

        //Setting up Button Handeler
        ButtonHandler click = new ButtonHandler(); 
        
        //Setting up Buttons
        monthlyView = new JButton("Monthly");
        monthlyView.setPreferredSize(new Dimension(100, 50));
        colorful = new Color(204, 229, 255); 
        monthlyView.setBackground(colorful);
        monthlyView.addActionListener(click); 
        
        weeklyView = new JButton("Weekly"); 
        weeklyView.setPreferredSize(new Dimension(100, 50)); 
        weeklyView.setBackground(colorful);
        weeklyView.addActionListener(click);

        dailyView = new JButton("Daily"); 
        dailyView.setPreferredSize(new Dimension(100, 50)); 
        dailyView.setBackground(colorful);
        dailyView.addActionListener(click);

        toDoListView = new JButton("To Do List"); 
        toDoListView.setPreferredSize(new Dimension(100, 50)); 
        toDoListView.setBackground(colorful);
        toDoListView.addActionListener(click);
        
        //Adding Buttons to panel
        options.add(monthlyView); 
        options.add(weeklyView); 
        options.add(dailyView); 
        options.add(toDoListView); 
        //Adding panel to screen 
        add(options); 

    }//end of homeScreen Constructor

    //Inner Class for Button Event Handeling
    private class ButtonHandler implements ActionListener
    {
        //Handle button event
		@Override
		public void actionPerformed(ActionEvent event)
		{
            if (event.getSource() == monthlyView)
            {
                //Pop-Up Window For Monthly View
                MonthlyScreen monthlyPopUp = new MonthlyScreen(); 
                monthlyPopUp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                monthlyPopUp.setSize(600, 800);
                monthlyPopUp.setVisible(true);

            }
            else if (event.getSource() == weeklyView)
            {
                WeeklyScreen weeklyPopUp = new WeeklyScreen(); 
                weeklyPopUp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                weeklyPopUp.setSize(1110, 550);
                weeklyPopUp.setVisible(true);

            }
            else if (event.getSource() == dailyView)
            {
                DailyScreen dailyPopUp = new DailyScreen(); 
                dailyPopUp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                dailyPopUp.setSize(600, 600);
                dailyPopUp.setVisible(true);
                
            }
            else if (event.getSource() == toDoListView)
            {
                ToDoListScreen toDoListPopUp = new ToDoListScreen(); 
                toDoListPopUp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                toDoListPopUp.setSize(800, 600);
                toDoListPopUp.setVisible(true);
                
            }//end of else if statements   

        }//end of override of function

    }//End of ButtonHandler Class

}//End of HomeScreen Class
