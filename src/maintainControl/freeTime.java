////////////////////////////////////////
//Program Name: freeTime.java
//Program Purpose: a class for calculating user's freetime
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import java.util.*; 


//Start of freeTime class
public class freeTime 
{
    //Objects
    double freeHours; 

    //Constructor
    public freeTime(ArrayList<eventClass> eventarray)
    { 
        int subHours = 0; 
        for (int i = 0; i < eventarray.size(); i++)
        {
            subHours += Integer.parseInt(eventarray.get(i).getHour());
        }

        freeHours = 24 - subHours; 

    }//End of constructor

    //Functions
    public double getFreeHours()
    {
        return freeHours; 
    }
    
}//End of freeTime Class
