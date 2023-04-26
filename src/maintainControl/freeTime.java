////////////////////////////////////////
//Program Name: FreeTime.java
//Program Purpose: a class for calculating user's freetime
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Imports


//Start of FreeTime class
public class FreeTime 
{
    //Objects
    double freeHours; 

    //Constructor
    public FreeTime()
    { 
        freeHours = 24; 

    }//End of constructor

    //Functions
    public double getFreeHours()
    {
        return freeHours; 
    }

    public void setFreeHours(double FreeTime)
    {
        freeHours = FreeTime; 
    }

    public void subtractHours(double minus)
    {
        freeHours = freeHours - minus; 
    }

    public void addHours(double add)
    {
        freeHours = freeHours + add; 
    }

    public double calculateFreeTime(String date, int type) throws FileNotFoundException
    {
        //Putting contents of file into an array for easier search use
        File newFile = new File("C:\\Users\\steph\\SCHOOL\\Dev\\MaintainControl\\src\\maintainControl\\EventFile.txt");
        Scanner myReader = new Scanner(newFile); 
        ArrayList<String> fileContents = new ArrayList<String>(); 

        //Adding contents of file to a string array for easy acsess 
        while (myReader.hasNextLine())
        {
            fileContents.add(myReader.nextLine()); 
        }
        myReader.close(); 


        if (type == 1) //calculate for daily time
        {
            for (int i = 0; i < fileContents.size(); i++)
            {
                if(fileContents.get(i).equals(date))
                {
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
            }
            return freeHours; 

        }
        else if (type == 2) //calculate for weeklytime
        {

        }
        else if (type == 3)
        {

        }

        return freeHours; 
    }
    
}//End of FreeTime Class
