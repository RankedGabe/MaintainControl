////////////////////////////////////////
//Program Name: eventClass.java
//Program Purpose: a class to facilitate listing and adding and removing of events
//Last Updated: 04/23/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import java.io.*; 
import java.util.*; 

//Start of eventClass Class
public class eventClass 
{
    //Objects
    private String wholeEventString; 
    private String date; 
    private String hour;
    private String description; 

    //Constructor
    public eventClass(String day, String time1, String title)
    {
        //Store Data
        date = day; 
        hour = time1; 
        description = title; 
        wholeEventString = "Date: " + date + " Length: " + hour + " hours \n" + description + "\n";  

    }//End of Constructor 

    //Second Constructor
    public eventClass()
    {
        wholeEventString = " ";  
        date = " ";  
        hour= " "; 
        description = " ";  
    }

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
