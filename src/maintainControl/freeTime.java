////////////////////////////////////////
//Program Name: freeTime.java
//Program Purpose: a class for calculating user's freetime
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports


//Start of freeTime class
public class freeTime 
{
    //Objects
    double freeHours; 

    //Constructor
    public freeTime()
    { 
        freeHours = 0; 

    }//End of constructor

    //Functions
    public double getFreeHours()
    {
        return freeHours; 
    }

    public void setFreeHours(double freeTime)
    {
        freeHours = freeTime; 
    }

    public void subtractHours(double minus)
    {
        freeHours = freeHours - minus; 
    }

    public void addHours(double add)
    {
        freeHours = freeHours + add; 
    }
    
}//End of freeTime Class
