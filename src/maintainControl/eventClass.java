////////////////////////////////////////
//Program Name: eventClass.java
//Program Purpose: a class to facilitate creating of events
//Last Updated: 04/24/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import java.io.*; 
import java.util.*; 
import java.awt.*; 
import javax.swing.*; 

//Start of eventClass Class
public class eventClass 
{
    //Objects
    private String wholeEventString; 
    private String date; 
    private String hour;
    private String description; 

    //Constructor
    public eventClass()
    {
        //Gather information for event and save in object
        date = JOptionPane.showInputDialog("Input the date of your event in mm-dd-yyyy format: ");
        hour = JOptionPane.showInputDialog("Input the estimated number of hours your event will take: ");
        description = JOptionPane.showInputDialog("Input the title of your event: "); 
        wholeEventString = "Date: " + date + " Length: " + hour + " hours \n" + description + "\n";  

    }//End of Constructor
     
    //Functions
    public String getWholeEventString()
    {
        return wholeEventString; 
    }

    public String getDate()
    {
        return date; 
    }

    public String getHour()
    {
        return hour; 
    } 

    public String getDescription()
    {
        return description; 
    }
    
}//End of eventClass Class
