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
        colorful = new Color(255, 204, 255); 
        colorful2 = new Color(229, 204, 255); 
        
        sundayEvents = new JTextArea("              SUNDAY\n\n", 20, 15); 
        sundayEvents.setLineWrap(true); 
        sundayEvents.setWrapStyleWord(true);
        sundayEvents.setBackground(colorful); 
        sundayEvents.setEditable(false);
        sundayEvents.append("here is where \nthetext will go");
        weeklyEvents.add(sundayEvents); 

        mondayEvents = new JTextArea("              MONDAY\n\n",20, 15);
        mondayEvents.setLineWrap(true); 
        mondayEvents.setWrapStyleWord(true);
        mondayEvents.setBackground(colorful2);
        mondayEvents.setEditable(false); 
        mondayEvents.append("STUFF HERE"); //the get events for the specified day
        weeklyEvents.add(mondayEvents);

        tuesdayEvents = new JTextArea("             TUESDAY\n\n",20, 15);
        tuesdayEvents.setBackground(colorful);
        tuesdayEvents.setLineWrap(true); 
        tuesdayEvents.setWrapStyleWord(true);
        tuesdayEvents.setEditable(false);
        //APPEND
        weeklyEvents.add(tuesdayEvents);

        wednesdayEvents = new JTextArea("           WEDNESDAY\n\n",20, 15);
        wednesdayEvents.setBackground(colorful2);
        wednesdayEvents.setLineWrap(true); 
        wednesdayEvents.setWrapStyleWord(true);
        wednesdayEvents.setEditable(false);
        //APPEND
        weeklyEvents.add(wednesdayEvents);

        thursdayEvents = new JTextArea("            THURSDAY\n\n",20, 15);
        thursdayEvents.setBackground(colorful);
        thursdayEvents.setLineWrap(true); 
        thursdayEvents.setWrapStyleWord(true);
        thursdayEvents.setEditable(false);
        //APPEND
        weeklyEvents.add(thursdayEvents);

        fridayEvents = new JTextArea("              FRIDAY\n\n",20, 15);
        fridayEvents.setBackground(colorful2);
        fridayEvents.setLineWrap(true); 
        fridayEvents.setWrapStyleWord(true);
        fridayEvents.setEditable(false);
        //APPEND
        weeklyEvents.add(fridayEvents);

        saturdayEvents = new JTextArea("            SATURDAY\n\n",20, 15);
        saturdayEvents.setBackground(colorful);
        saturdayEvents.setLineWrap(true); 
        saturdayEvents.setWrapStyleWord(true);
        saturdayEvents.setEditable(false);
        //APPEND
        weeklyEvents.add(saturdayEvents);

        //adding weekly events panel to frame
        add(weeklyEvents); 

    }//End of weeklyScreen Constructor

    //Private Inner Function for event handeling 
    
}//End of weeklyScreen Class
