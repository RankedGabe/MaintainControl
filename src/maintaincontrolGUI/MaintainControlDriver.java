package maintaincontrolGUI;

//Imports 
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintainControlDriver implements ActionListener
{
	//Main
	public static void main(String args[])
	{
		//Creating ViewObject so that we can call functions
		View viewObject = new View();

	    //Setting default preferences for JFrame
		viewObject.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewObject.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
		viewObject.getFrame().getContentPane().setBackground(Color.WHITE);
		
		//Creating menu bar
		JMenuBar menuBar = new JMenuBar(); 
		//Creating options on bar
		JMenu viewMenu = new JMenu("Set View");
		menuBar.add(viewMenu);
		JRadioButtonMenuItem eventMenu = new JRadioButtonMenuItem("Add Event");
		menuBar.add(eventMenu);
		
		//Buttons in viewMenu 
		ButtonGroup group = new ButtonGroup();
		//Monthly menu option
		JRadioButtonMenuItem monthlyOption = new JRadioButtonMenuItem("Monthly");
		group.add(monthlyOption);
		viewMenu.add(monthlyOption);
		//Weekly menu option 
		JRadioButtonMenuItem weeklyOption = new JRadioButtonMenuItem("Weekly");
		group.add(weeklyOption);
		viewMenu.add(weeklyOption);
		//Daily menu option
		JRadioButtonMenuItem dailyOption = new JRadioButtonMenuItem("Daily"); 
		group.add(dailyOption);
		viewMenu.add(dailyOption);
		//To Do menu option
		JRadioButtonMenuItem todoOption = new JRadioButtonMenuItem("To Do List"); 
		group.add(todoOption);
		viewMenu.add(todoOption);
		
		//Event Handling for Menu Options 
		monthlyOption.addActionListener(new ActionListener() 
		{
			@Override
            public void actionPerformed(ActionEvent e)
			{
				viewObject.getFrame().getContentPane().removeAll(); 
				viewObject.monthlyView(); 
            }
        });
		weeklyOption.addActionListener(new ActionListener() 
		{
			@Override
            public void actionPerformed(ActionEvent e)
			{
				viewObject.getFrame().getContentPane().removeAll();  
            	viewObject.weeklyView(); 
            }
        });
		dailyOption.addActionListener(new ActionListener() 
		{
			@Override
            public void actionPerformed(ActionEvent e)
			{
				viewObject.getFrame().getContentPane().removeAll();
				viewObject.dailyView(); 
            }
        });
		todoOption.addActionListener(new ActionListener() 
		{
			@Override
            public void actionPerformed(ActionEvent e)
			{
				viewObject.getFrame().getContentPane().removeAll();
				viewObject.todoView();
            }
        });
		eventMenu.addActionListener(new ActionListener() 
		{
			@Override
            public void actionPerformed(ActionEvent e)
			{
				//Getting rid of previous content
				viewObject.getFrame().getContentPane().removeAll();
				
				//Screen for adding an event
				//viewObject.
            }
        });
		
		
		//Setting menu in frame
		viewObject.getFrame().setJMenuBar(menuBar);
		
		//Setting frame as visible 
		viewObject.getFrame().setVisible(true);
		
	}//end of main

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Here so that we can implement ActionListener class
	}

}//end of MaintainControlDriver class