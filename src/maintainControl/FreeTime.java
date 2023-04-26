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
import java.util.Calendar;
import java.util.Scanner;

//Imports


//Start of FreeTime class
public class FreeTime 
{
    //Objects
    private double freeHours; 

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

        }//end of if
        else if (type == 2) //calculate for weeklytime
        {
            System.out.print("We have gotten into correct if else\n" );
            Calendar cal = Calendar.getInstance();
            WeekClass thisWeek = new WeekClass(cal);
            for (int i = 0; i < fileContents.size(); i++)
            {
                System.out.print("We have gotten into the for loop\n");
                if(fileContents.get(i).equals(thisWeek.getMonth() + "-" + thisWeek.getDateStartWeek() + "-" + thisWeek.getYear()))
                {
                    System.out.print("We have gotten into the if statment\n");
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
                else if (fileContents.get(i).equals(thisWeek.getMonth() + "-" + thisWeek.getDateMonday() + "-" + thisWeek.getYear()) )
                {
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
                else if ( fileContents.get(i).equals(thisWeek.getMonth() + "-" + thisWeek.getDateTuesday() + "-" + thisWeek.getYear()) )
                {
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
                else if (fileContents.get(i).equals(thisWeek.getMonth() + "-" + thisWeek.getDateWednesday() + "-" + thisWeek.getYear()))
                {
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
                else if (fileContents.get(i).equals(thisWeek.getMonth() + "-" + thisWeek.getDateThursday() + "-" + thisWeek.getYear()) )
                {
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
                else if (fileContents.get(i).equals(thisWeek.getMonth() + "-" + thisWeek.getDateFriday() + "-" + thisWeek.getYear()) )
                {
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
                else if (fileContents.get(i).equals(thisWeek.getMonth() + "-" + thisWeek.getDateEndWeek() + "-" + thisWeek.getYear()))
                {
                    freeHours -= Double.parseDouble(fileContents.get(i+1)); 
                }
            }
            return freeHours;
        }//end of else
        else if (type == 3) //calculate for monthly time 
        {
            //If time had allowed would have written another case for calculating monthly time
        }//end of last else

        return freeHours; 
    }
    
}//End of FreeTime Class
