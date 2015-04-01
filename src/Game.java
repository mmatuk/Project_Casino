//******************************************************************************
//  Game.java                        		     Project Casino
//  Author: Matt Matuk                           Created: March 30, 2015                         
//  Team: Team 2
//
//  1. This class is the abstract class for all games created
//
//		-- Any game created must extend this class.
//		-- The method of this class will not contain any code, the methods must
//			be used in the child class.
//
//		** Panels created must be 900x580 in size. **
//
//******************************************************************************

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

abstract class Game
{
	protected String gameName; // name of the game
	protected JPanel gamePanel; // game board for the game
	protected double userBet; 
	protected String result; // Used for the text for the results of the game
	protected double payout; // money won + users bet
	final protected int PANEL_SIZE_X = 900;
	final protected int PANEL_SIZE_Y = 580;
	final protected Dimension PANEL_SIZE;

			
	/**
	 *  Sets all variables to null or 0 and creates any error panel that will
	 *  be used if no panel is created in the child class.
	 */
	public Game()
	{
		gamePanel = null;
		userBet = 0;
		result = null;
		payout = 0;
		gameName = null;
		PANEL_SIZE = new Dimension(PANEL_SIZE_X,PANEL_SIZE_Y);
		makePanel();
	}
	
	public void playGame()
	{
		// Add game code here
	}
	
	/**
	 * Makes a panel that will be used to display the game board of the 
	 * game in the tabs
	 * 
	 */
	private void makePanel()
	{
		// This is for if no panel was created. An error panel will be
		// created instead
		
		gamePanel = new JPanel();
		JTextArea error = new JTextArea(
				"Error. No panel was created for the game: " + gameName);
		error.setEditable(false);
		gamePanel.add(error);
		gamePanel.setPreferredSize(PANEL_SIZE);
	}
	
	public String getGameName()
	{
		return gameName;
	}
	
	public JPanel getGamePanel()
	{
		return gamePanel;
	}
	
	public double getUserBet()
	{
		return userBet;
	}
	
	public String getResult()
	{
		return result;
	}
	
	public double getPayout()
	{
		return payout;
	}
	
	public void setGameName(String str)
	{
		gameName = str;
	}
	
	public void setUserBet(double bet)
	{
		userBet = bet;
	}
	
	public void setGamePanel(JPanel panel)
	{
		gamePanel = panel;
	}
	
	public void setPayout(double pay)
	{
		payout = pay;
	}
	
	public void setResult(String str)
	{
		result = str;
	}
	
	public String toString()
	{
		return gameName;
	}
	
}