////////////////////////////////////////
//Program Name: dailyScreen.java
//Program Purpose: create a jFrame for the daily screen of Maintain Control
//Last Updated: 04/24/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Impots
import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.*;
import java.awt.event.*;
import java.io.File; 
import java.io.IOException; 

//Start of dailyScreen class
public class dailyScreen extends JFrame
{

    //Objects
    private Color colorful; 
    private JLabel dayTitle; 
    private Calendar cal;
    private dayClass date; 
    private YearMonth monthandyear; 
    private JTextArea events; 
    private JButton deleteEvent; 
    private JButton addEvent; 
    private String gatheredEvents; 

    //Constructor
    public dailyScreen()
    {
        //Calling super consturctor and setting layout
        super("Maintain Control: Daily Screen"); 
        setLayout(new FlowLayout());
        colorful = new Color(0, 128, 255);

        //Setting up Title Area
        cal = Calendar.getInstance();
        date = new dayClass(cal); 
        monthandyear = YearMonth.now();
        //Setting Month and Year from system
        dayTitle = new JLabel(monthandyear.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " " + date.getDayOfWeek() + " " + date.getDateDay()); 
        //Setting Font
        dayTitle.setFont(new Font("San-Serif", Font.BOLD, 70 ));
        //Setting color 
        dayTitle.setForeground(colorful);
        //Adding to Frame
        add(dayTitle);

        //adding remove event button
        deleteEvent = new JButton("Delete Events");  
        deleteEvent.setPreferredSize(new Dimension(200, 40));;
        colorful = new Color(204, 229, 255);
        deleteEvent.setBackground(colorful); 
        add(deleteEvent);

        //Adding add event button
        addEvent = new JButton("Add Events");  
        addEvent.setPreferredSize(new Dimension(200, 40));;
        colorful = new Color(204, 229, 255);
        addEvent.setBackground(colorful); 
        add(addEvent);
        
        //add text area for events that month
        events = new JTextArea(0, 55);  
        events.setLineWrap(true); 
        events.setWrapStyleWord(true); 
        events.setEditable(false);

        gatheredEvents = ""; 
        gatheredEvents = gatherEvents(date.getDateNum()); //TESTING
        events.append(gatheredEvents);
        add(events);

        //adding event handlers
        ButtonHandler click = new ButtonHandler();
        addEvent.addActionListener(click);
        deleteEvent.addActionListener(click);

    }//End of dailyScreen constructor

    //Event Handeling Inner Class
    private class ButtonHandler implements ActionListener
    {
        //Handle button event
		@Override
		public void actionPerformed(ActionEvent event)
		{
            if (event.getSource() == addEvent)
            {
                //in testing phase
                eventClass newEvent = new eventClass(); 
                events.append(newEvent.getWholeEventString()); 
            }
            else if (event.getSource() == deleteEvent)
            {
                //still have to figure this out
                
            }//end of else if statements   

        }//end of override of function

    }//End of ButtonHandler Class

    //Function
    private String gatherEvents(String key)
    {
        String eventsFromFile = ""; 

        //trying to open file to read from
        try
        {
            File newFile = new File("C:\\Users\\steph\\SCHOOL\\Dev\\MaintainControl\\src\\maintainControl\\EventFile.txt");
            if(newFile.createNewFile())
            {
                JFrame f = new JFrame(); 
                JOptionPane.showMessageDialog(f, "A File was crated to store your information in the following location: "+ newFile.getAbsolutePath());
            }
            else
            {
                JFrame f = new JFrame(); 
                JOptionPane.showMessageDialog(f, "Extracting events for " + key + " from EventFile.txt"); 
            }
            Scanner myReader = new Scanner(newFile); 
            while (myReader.hasNextLine())
            {
                String date = myReader.nextLine();
                if (date.equals(key)) 
                {
                    //For some reasn we can't get into this block so lets pretend it's not in a block for a sec
                    String hours = myReader.nextLine(); 
                    String descrip = myReader.nextLine(); 
                    eventsFromFile += "Date: " + date + " Length: " + hours + " hours \n" + descrip + "\n\n";
                }
            }
            myReader.close(); 
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(rootPane, "An Error Occured"); 
            e.printStackTrace();
        }

        //returning read events 
        return eventsFromFile; 
    }//End of gather events function
    
}//End of dailyScreen Class
