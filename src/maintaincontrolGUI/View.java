package maintaincontrolGUI;

//Imports 
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener
{
	private JFrame jframe;
	
	public View()
	{
		jframe = new JFrame("Maintain Control");
	}
	
	public JFrame getFrame()
	{
		return jframe; 
	}
	
	public void monthlyView()
	{ 
		
		//We need to add methods to display the correct amount of 
		//days with good spacing but I wanted to wait until the
		//month class was finished to do that, 
		//maybe also a display of how many events are scheduled for 
		//each day would be good
		
		//Initializing variables
		JButton day; 
		String number;   
		
		//For Loop for making day buttons
		for(int i = 1; i <= 35; i++)
		{
			number = "" + i; 
			day = new JButton(number);
			day.setBackground(Color.pink);
			jframe.add(day); 
		}
		
		//Setting layout of JFrame
		jframe.setLayout(new GridLayout(5, 7));
		
		//Event Handling for day buttons would go here
		
	}
	
	public void weeklyView()
	{
		//Creating Day of Week Buttons
		//I would like to eventually replace the string that just has the 
		//name of the day of the week with a string returned from the 
		//weekly class that shows the events scheduled for that day 
		JButton monday = new JButton("Monday");
		JButton tuesday = new JButton("Tuesday");
		JButton wednesday = new JButton("Wednesday");
		JButton thursday = new JButton("Thursday");
		JButton friday = new JButton("Friday");
		JButton saturday = new JButton("Saturday");
		JButton sunday = new JButton("Sunday");
		
		//Changing Color of Buttons 
		//Note: I am looking into doing custom colors rather than 
		//the default colors because that would probably look a lot better. 
		monday.setBackground(Color.red);
		tuesday.setBackground(Color.orange);
		wednesday.setBackground(Color.yellow); 
		thursday.setBackground(Color.green);
		friday.setBackground(Color.cyan);
		saturday.setBackground(Color.pink);
		sunday.setBackground(Color.magenta);
		
		//adding days of week to frame
		jframe.add(monday);
		jframe.add(tuesday); 
		jframe.add(wednesday); 
		jframe.add(thursday); 
		jframe.add(friday); 
		jframe.add(saturday);
		jframe.add(sunday);
		
		
		//setting the grid layout using the parameterless construct 
		jframe.setLayout(new GridLayout()); 
		
		//Event handling for day buttons
		
	}
	
	public void dailyView()
	{
		//Want a method for pulling the number of events on a certain day
		int numberOfEvents = 10;  
		
		for (int i = 0; i < numberOfEvents; i++)
		{
			//This would initialize a button for the user to click on with the
			//name of the event on it, Example Event would be replaced
			//with a call to get the name of each event in an event 
			//array for the date that this view is for. 
			JButton event = new JButton("Example Event");
			event.setBackground(Color.pink);
			jframe.add(event); 
		}
		
		//putting events into a grid 
		jframe.setLayout(new GridLayout(numberOfEvents/2, numberOfEvents));
		
		//Event handling for clicking on an event button
	}
	
	public void todoView()
	{
		//I didn't really get around to finishing this one
		//but my idea is to have a button at the top that says add task
		//and then the list will be JCheckboxes and the alignment is super 
		//weird right now
		jframe.setBackground(Color.white);
		JButton addTask = new JButton("Add Task");
		jframe.add(addTask, BorderLayout.PAGE_END);
		addTask.addActionListener(new ActionListener() 
		{
			@Override
            public void actionPerformed(ActionEvent e)
			{
				String taskName = JOptionPane.showInputDialog("Enter Task"); 
				JCheckBox newTask = new JCheckBox(taskName);
				jframe.add(newTask); 
            }
        });
		
		//Listener for checking boxes will need to be added
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Here so that we can implement ActionListener class
	}

}//end of View class