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
        wholeEventString = "Date: " + date + " Length: " + hour + " hours \n" + description + "\n\n";  

        //Write Text to events file
        try
        {
            FileWriter myWriter = new FileWriter("C:\\Users\\steph\\SCHOOL\\Dev\\MaintainControl\\src\\maintainControl\\EventFile.txt", true);
            myWriter.write("\n");
            myWriter.write(date); 
            myWriter.write("\n"); 
            myWriter.write(hour);
            myWriter.write("\n"); 
            myWriter.write(description); 
            myWriter.write("\n");
            myWriter.close(); 
            JFrame f = new JFrame(); 
            JOptionPane.showMessageDialog(f, "Event successfully written to events file." ); 
        }
        catch (IOException e)
        {
            JFrame f = new JFrame(); 
            JOptionPane.showMessageDialog(f, "An Error Occurred.");
        }


    }//End of Constructor

    //Overload of constructor for daily event so that date is already there/not inputed
    public eventClass(String dateGiven)
    {
        //Gather information for event and save in object
        date = dateGiven; 
        hour = JOptionPane.showInputDialog("Input the estimated number of hours your event will take: ");
        description = JOptionPane.showInputDialog("Input the title of your event: "); 
        wholeEventString = "Date: " + date + " Length: " + hour + " hours \n" + description + "\n\n";  

        //Write Text to events file
        try
        {
            FileWriter myWriter = new FileWriter("C:\\Users\\steph\\SCHOOL\\Dev\\MaintainControl\\src\\maintainControl\\EventFile.txt", true);
            myWriter.write("\n");
            myWriter.write(date); 
            myWriter.write("\n"); 
            myWriter.write(hour);
            myWriter.write("\n"); 
            myWriter.write(description); 
            myWriter.write("\n");
            myWriter.close(); 
            JFrame f = new JFrame(); 
            JOptionPane.showMessageDialog(f, "Event successfully written to events file." ); 
        }
        catch (IOException e)
        {
            JFrame f = new JFrame(); 
            JOptionPane.showMessageDialog(f, "An Error Occurred.");
        }

    }//End of Constructor

    //Overload constructor with bool for removing an event from the text file
    public eventClass(String dateGiven, int num)
    {
        //Gather information for event that user wants to delete
        date = dateGiven; 
        hour = JOptionPane.showInputDialog("Input the hours of the event you would like to delete: ");
        description = JOptionPane.showInputDialog("Input the title of the event you would like to delete: "); 
        wholeEventString = "Date: " + date + " Length: " + hour + " hours \n" + description + "\n\n";  

        //Delete event events file
        try
        {
            File newFile = new File("C:\\Users\\steph\\SCHOOL\\Dev\\MaintainControl\\src\\maintainControl\\EventFile.txt");
            Scanner myReader = new Scanner(newFile); 
            ArrayList<String> fileContents = new ArrayList<String>(); 

            //Adding contents of file to a string
            while (myReader.hasNextLine())
            {
                fileContents.add(myReader.nextLine()); 
            }
            myReader.close(); 

            //Searching for and deleting the event parameters from array
            for (int i = 0; i < fileContents.size(); i++)
            {
                if (fileContents.get(i).equals(date) &&
                    fileContents.get(i+1).equals(hour) &&
                    fileContents.get(i+2).equals(description) )
                {
                    fileContents.remove(i);
                    fileContents.remove(i+1);
                    fileContents.remove(i+2); 
                }
            }

            //Calling function to write strings to file passing an array of strings and not appending
            writeToFile(fileContents); 

            JFrame f = new JFrame(); 
            JOptionPane.showMessageDialog(f, "Event successfully deleted from events file." ); 
        }
        catch (IOException e)
        {
            JFrame f = new JFrame(); 
            JOptionPane.showMessageDialog(f, "An Error Occurred.");
        }

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

    public static void writeToFile(ArrayList<String> list)
    {
        try
        {
            FileWriter myWriter = new FileWriter("C:\\Users\\steph\\SCHOOL\\Dev\\MaintainControl\\src\\maintainControl\\EventFile.txt");
            for (String x:list)
            {
                myWriter.write(x); 
                myWriter.write("\n");
            }
            myWriter.close();
        }
        catch (IOException e)
        {
            JFrame f = new JFrame(); 
            JOptionPane.showMessageDialog(f, "An Error Occurred.");
            e.getStackTrace(); 
        }
    }
    
}//End of eventClass Class
