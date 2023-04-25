////////////////////////////////////////
//Program Name: weeklyScreen.java
//Program Purpose: create a jFrame for the weekly screen of Maintain Control
//Last Updated: 04/24/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

//Start of weeklyScreen Class 
public class weeklyScreen extends JFrame
{
    //Objects
    private Color colorful; 
    private Color colorful2; 
    private JLabel weekTitle; 
    private Calendar cal; 
    private YearMonth monthandyear; 
    private weekClass thisWeek;  
    private JPanel weeklyEvents; 
    private JTextArea sundayEvents; 
    private JTextArea mondayEvents;
    private JTextArea tuesdayEvents;
    private JTextArea wednesdayEvents;
    private JTextArea thursdayEvents;
    private JTextArea fridayEvents;
    private JTextArea saturdayEvents;
    private String events; 
    

    //Constructor
    public weeklyScreen()
    {
        //Setting Up Title Area
        super("Maintain Control: Weekly Screen"); 
        setLayout(new FlowLayout());
        colorful = new Color(0, 0, 0);

        //Setting up Title Area
        cal = Calendar.getInstance();
        thisWeek = new weekClass(cal);
        monthandyear = YearMonth.now(); 
        weekTitle = new JLabel("Week Of " + monthandyear.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " " + thisWeek.getDateStartWeek() + "-" + thisWeek.getDateEndWeek());
        weekTitle.setForeground(colorful); 
        weekTitle.setFont(new Font("San-Serif", Font.BOLD, 70 ));
        add(weekTitle);

        //Adding area for each day for events  with name of day at top
        weeklyEvents = new JPanel(); 
        colorful = new Color(204, 229, 255); 
        colorful2 = new Color(229, 204, 255); 
        
        sundayEvents = new JTextArea("              SUNDAY\n\n", 20, 15); 
        sundayEvents.setLineWrap(true); 
        sundayEvents.setWrapStyleWord(true);
        sundayEvents.setBackground(colorful); 
        sundayEvents.setEditable(false);
        events = ""; 
        events = gatherEvents(thisWeek.getDateStartWeek());
        sundayEvents.append(events);
        weeklyEvents.add(sundayEvents); 

        mondayEvents = new JTextArea("              MONDAY\n\n",20, 15);
        mondayEvents.setLineWrap(true); 
        mondayEvents.setWrapStyleWord(true);
        mondayEvents.setBackground(colorful2);
        mondayEvents.setEditable(false); 
        events = ""; 
        events = gatherEvents(thisWeek.getDateMonday());
        mondayEvents.append(events);
        weeklyEvents.add(mondayEvents);

        tuesdayEvents = new JTextArea("             TUESDAY\n\n",20, 15);
        tuesdayEvents.setBackground(colorful);
        tuesdayEvents.setLineWrap(true); 
        tuesdayEvents.setWrapStyleWord(true);
        tuesdayEvents.setEditable(false);
        events = ""; 
        events = gatherEvents(thisWeek.getDateTuesday());
        tuesdayEvents.append(events);
        weeklyEvents.add(tuesdayEvents);

        wednesdayEvents = new JTextArea("           WEDNESDAY\n\n",20, 15);
        wednesdayEvents.setBackground(colorful2);
        wednesdayEvents.setLineWrap(true); 
        wednesdayEvents.setWrapStyleWord(true);
        wednesdayEvents.setEditable(false);
        events = ""; 
        events = gatherEvents(thisWeek.getDateWednesday());
        wednesdayEvents.append(events);
        weeklyEvents.add(wednesdayEvents);

        thursdayEvents = new JTextArea("            THURSDAY\n\n",20, 15);
        thursdayEvents.setBackground(colorful);
        thursdayEvents.setLineWrap(true); 
        thursdayEvents.setWrapStyleWord(true);
        thursdayEvents.setEditable(false);
        events = ""; 
        events = gatherEvents(thisWeek.getDateThursday());
        thursdayEvents.append(events);
        weeklyEvents.add(thursdayEvents);

        fridayEvents = new JTextArea("              FRIDAY\n\n",20, 15);
        fridayEvents.setBackground(colorful2);
        fridayEvents.setLineWrap(true); 
        fridayEvents.setWrapStyleWord(true);
        fridayEvents.setEditable(false);
        events = ""; 
        events = gatherEvents(thisWeek.getDateFriday());
        fridayEvents.append(events);
        weeklyEvents.add(fridayEvents);

        saturdayEvents = new JTextArea("            SATURDAY\n\n",20, 15);
        saturdayEvents.setBackground(colorful);
        saturdayEvents.setLineWrap(true); 
        saturdayEvents.setWrapStyleWord(true);
        saturdayEvents.setEditable(false);
        events = ""; 
        events = gatherEvents(thisWeek.getDateEndWeek());
        saturdayEvents.append(events);
        weeklyEvents.add(saturdayEvents);

        //adding weekly events panel to frame
        add(weeklyEvents); 

    }//End of weeklyScreen Constructor

    //Private Inner Function for event handeling for freetime button
    
    //Function
    private String gatherEvents(String key)
    {
        String eventsFromFile = ""; 
        //Formating passed day to be a complete date
        key = thisWeek.getMonth() + "-" + key + "-" + thisWeek.getYear(); 

        //trying to open file to read from
        try
        {
            File newFile = new File("C:\\Users\\steph\\SCHOOL\\Dev\\MaintainControl\\src\\maintainControl\\EventFile.txt");
            if(newFile.createNewFile())
            {
                JFrame f = new JFrame(); 
                JOptionPane.showMessageDialog(f, "A File was crated to store your information in the following location: "+ newFile.getAbsolutePath());
            }
           //No else statment here because I don't want to give a whole bunch of pop ups before the user can view weekly screen
            Scanner myReader = new Scanner(newFile); 
            while (myReader.hasNextLine())
            {
                String date = myReader.nextLine();
                if (date.equals(key)) 
                {
                    String hours = myReader.nextLine(); 
                    String descrip = myReader.nextLine(); 
                    eventsFromFile += "Length: " + hours + " hours \n" + descrip + "\n\n";
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
    
}//End of weeklyScreen Class
