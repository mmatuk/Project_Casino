//******************************************************************************
//  Roulette.java                      		       Project Casino
//  Author: Matt Matuk                             Created: March 30, 2015                         
//  Team: Team 2
//
//  
//
//******************************************************************************

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Roulette extends Game
{
	final private int[] redNum =
			{
			1
			};
	final private int[] balckNum =
			{
			0
			};
	
	private int resultNumber;
	private int odds;
	private List userPick;
	
	public Roulette(String name)
	{
		super();
		gameName = name;
		resultNumber = 0;
		odds = 0;
		userPick = null;
		
		makePanel();
	}
	
	public void playGame()
	{
		if (ready())
		{
			
		}
	}
	
	private void makePanel()
	{
		gamePanel = new RouletteGameBoard().makeGameBoard();
	}
	
	/**
	 * Resets all game variables to the starting state so the variables 
	 * are ready for another game.
	 * 
	 */
	private void restGame()
	{
		resultNumber = 0;
		odds = 0;
		userPick = null;
		userBet = 0;
		result = null;
		payout = 0;
	}
	
	/**
	 * Determines if the game can be played by checking to see if the user 
	 * picked a bet amount and bet number.
	 * 
	 * @return Returns true if bet amount and number has been placed. False otherwise.
	 */
	private boolean ready()
	{
		boolean temp = false;
		if (userPick != null && userBet != 0)
		{
			temp = true;
		}
		
		return temp;
	}
	
	/**
	 * Creates a game board for the roulette game that will allow the user to click 
	 * buttons on the board to determine where the user wants to bet
	 * @author Matt
	 *
	 */
	private class RouletteGameBoard
	{
		public RouletteGameBoard()
		{
		}
		
		public JPanel makeGameBoard()
		{
			JPanel temp = new JPanel();
			JPanel topRow = new JPanel();
			topRow.setLayout(new javax.swing.BoxLayout(topRow, javax.swing.BoxLayout.X_AXIS));
			
			List<Integer> testNumbers = new ArrayList<Integer>(1);
			testNumbers.add(1);
			
			RouletteButton[] topButtons = new RouletteButton[24];
			int num = 0;
			topButtons[num] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_red_number_normal.png", "/images/btn_red_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_black_number_normal.png", "/images/btn_black_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_red_number_normal.png", "/images/btn_red_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_black_number_normal.png", "/images/btn_black_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_red_number_normal.png", "/images/btn_red_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_black_number_normal.png", "/images/btn_black_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_red_number_normal.png", "/images/btn_red_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_black_number_normal.png", "/images/btn_black_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_red_number_normal.png", "/images/btn_red_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_black_number_normal.png", "/images/btn_black_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_red_number_normal.png", "/images/btn_red_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_line_ver_number_mouseover.png", "/images/btn_line_ver_number_pressed.png", "/images/btn_line_ver_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_black_number_normal.png", "/images/btn_black_number_normal.png", testNumbers );
			topButtons[num++] = new RouletteButton("/images/btn_number_mouseover.png", "/images/btn_black_number_normal.png", "/images/btn_black_number_normal.png", testNumbers );

			for (RouletteButton button : topButtons)
			{
				System.out.println(button.getNumbers().toString());
			}
			for (RouletteButton button : topButtons)
			{
				topRow.add(button);
			}
			return topRow;
			
		}
	}


}
