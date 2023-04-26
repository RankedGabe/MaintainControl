////////////////////////////////////////
//Program Name: monthlyScreen.java
//Program Purpose: create a jFrame for the monthly screen of Maintain Control
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.*; 
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

//Start of monthlyScreen Class
public class monthlyScreen extends JFrame
{

    //Objects 
    private Calendar cal;
    private int dayOfWeek; 
    private YearMonth monthandyear;  
    private JLabel monthandyearTitle;
    private Color colorful; 
    private String num; 
    private JButton dayButton;
    private JPanel monthlyGrid; 
    private JButton addEvent;
    private JButton deleteEvent; 
    private JPanel eventGrid; 
    private JTextArea events; 
    private dayClass findMonth; 

    //Constructor
    public monthlyScreen()
    {
        super("Maintain Control: Monthly View"); 
        setLayout(new FlowLayout());

        //Setting up Title Area
        monthandyear = YearMonth.now(); 
        //Setting Month and Year from system
        monthandyearTitle = new JLabel(monthandyear.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " " + monthandyear.getYear()); 
        //Setting Font
        monthandyearTitle.setFont(new Font("San-Serif", Font.BOLD, 70 ));
        //Setting color 
        colorful = new Color(0, 128, 255);
        monthandyearTitle.setForeground(colorful);
        //Adding to Frame
        add(monthandyearTitle); 

        //Setting up Monthly Grid
        colorful = new Color(204, 229, 255);
        monthlyGrid = new JPanel(); 
        //Getting the number of days to offset the calandar by
        cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        //Filling the grid with days of week 
        int count = 0;
        for (int i = 1; i <= monthandyear.lengthOfMonth()+dayOfWeek; i++)
        { 
            if (i%2 == 0)
            {
                colorful = new Color(229, 204, 255); 
            }
            else 
            {
                colorful = new Color(204, 229, 255);
            }

            if (i < dayOfWeek)
            { 
                num = "X"; 
                dayButton = new JButton(num);  
                dayButton.setBackground(colorful); 
                monthlyGrid.add(dayButton);
                count++; 

            }
            else
            {
                int day = i - count; 
                num = "" + day; 
                dayButton = new JButton(num); 
                dayButton.setBackground(colorful);
                monthlyGrid.add(dayButton); 
            }

        }//end of for loop
        monthlyGrid.setLayout(new GridLayout(0, 7));
        add(monthlyGrid); 

        //event grid set up
        eventGrid = new JPanel(); 
        eventGrid.setLayout(new GridLayout(0, 1));

        //adding remove event button
        deleteEvent = new JButton("Delete Events");  
        deleteEvent.setPreferredSize(new Dimension(200, 40));;
        colorful = new Color(204, 229, 255);
        deleteEvent.setBackground(colorful); 
        eventGrid.add(deleteEvent);

        //Adding add event button
        addEvent = new JButton("Add Events");  
        addEvent.setPreferredSize(new Dimension(200, 40));;
        colorful = new Color(204, 229, 255);
        addEvent.setBackground(colorful); 
        eventGrid.add(addEvent); 

        //adding event grid to layout
        add(eventGrid); 

        //add text area for events that month
        events = new JTextArea("EVENTS: \n", 0, 55 );  
        events.setLineWrap(true); 
        events.setWrapStyleWord(true);
        events.setEditable(false); 
        String gatheredEvents = ""; 
        gatheredEvents = gatherEvents(); 
        events.append(gatheredEvents);
        add(events);

        //setting up button handeler
        ButtonHandler click = new ButtonHandler(); 
        dayButton.addActionListener(click);
        addEvent.addActionListener(click);
        deleteEvent.addActionListener(click);

    }//End of monthlyScreen Constructor

    //Inner Class For Event Handeling
    private class ButtonHandler implements ActionListener
    {
        //Handle button event
		@Override
		public void actionPerformed(ActionEvent event)
		{
            if (event.getSource() == dayButton)
            {
                //Pop-Up Window For Daily View
                dailyScreen dailyPopUp = new dailyScreen(); 
                dailyPopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dailyPopUp.setSize(600, 300);
                dailyPopUp.setVisible(true);

            }
            else if (event.getSource() == addEvent)
            {
                eventClass newEvent = new eventClass(); 
                events.append(newEvent.getWholeEventString()); 
            }
            else if (event.getSource() == deleteEvent)
            {
                eventClass newEvent = new eventClass(1);  
                events.selectAll(); 
                events.replaceSelection(gatherEvents());
                
            }//end of else if statements   

        }//end of override of function

    }//End of ButtonHandler Class

    //Function
    private String gatherEvents()
    {
        String eventsFromFile = "";
        cal = Calendar.getInstance();
        findMonth = new dayClass(cal);  
        String key = findMonth.getDateMonthValue(); 
      
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
                if (date.length() > 3 )
                {
                    String datesub = date.substring(0, 2);  
                    if (datesub.equals(key)) 
                    {
                        String hours = myReader.nextLine(); 
                        String descrip = myReader.nextLine(); 
                        eventsFromFile += "Date: " + date + " Length: " + hours + " hours \n" + descrip + "\n\n";
                    } //end of if statment 

                }//so that subdate is only found if date feild is not empty
                
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
    }
    
}//End of monthlyScreen Class
