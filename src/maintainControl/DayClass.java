////////////////////////////////////////
//Program Name: dayClass.java
//Program Purpose: a class to facilitate use of dates and stuff
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import java.util.*;
import java.text.*; 

public class dayClass
{

    //Objects
    private Calendar date; 
    private String dateNum;
    private String dayOfWeek;

    //Constructor
    public dayClass(Calendar dateGiven)
    {
        date = dateGiven; 
        Date representation = date.getTime();
        DateFormat repFormat = new SimpleDateFormat("MM-dd-YYYY"); 
        dateNum =  repFormat.format(representation); 
         
        if (date.get(Calendar.DAY_OF_WEEK) == 1)
        {
            dayOfWeek = "Sunday"; 
        }
        else if(date.get(Calendar.DAY_OF_WEEK) == 2)
        {
            dayOfWeek = "Monday"; 
        }
        else if(date.get(Calendar.DAY_OF_WEEK) == 3)
        {
            dayOfWeek = "Tuesday"; 
        }
        else if(date.get(Calendar.DAY_OF_WEEK) == 4)
        {
            dayOfWeek = "Wednesday"; 
        }
        else if(date.get(Calendar.DAY_OF_WEEK) == 5)
        {
            dayOfWeek = "Thursday"; 
        }
        else if(date.get(Calendar.DAY_OF_WEEK) == 6)
        {
            dayOfWeek = "Friday"; 
        }
        else if(date.get(Calendar.DAY_OF_WEEK) == 7)
        {
            dayOfWeek = "Saturday"; 
        }
        
    }//End of constructor

    //Functionn
    public String getDateNum()
    {
        return dateNum; 
        
    }//end of getDate Function

    public String getDayOfWeek()
    {
        return dayOfWeek; 
        
    }//end of getDate Function

    public String getDateDay()
    {
        String toreturn = getDateNum(); 
        toreturn = toreturn.substring(3, 5);
        return toreturn; 

    }//End of gatDateDay function


    
}//end of DayClass class
