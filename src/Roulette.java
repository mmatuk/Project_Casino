//******************************************************************************
//  Roulette.java                      		       Project Casino
//  Author: Matt Matuk                             Created: March 30, 2015                         
//  Team: Team 2
//
//  
//
//******************************************************************************

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Roulette extends Game
{
	// int[] for any numbers that need words
	public final static int[] RED_NUM =
			{
			1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36
			};
	public static final int[] BLACK_NUM =
			{
			2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35
			};
	public static final int[] ODD_NUM =
			{
			1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35			
			};
	public static final int[] EVEN_NUM =
			{
			2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36			
			};
	public static final int[] FIRST_TWELVE =
			{
			1,2,3,4,5,6,7,8,9,10,11,12		
			};
	public static final int[] SECOND_TWELVE =
			{
			13,14,15,16,17,18,19,20,21,22,23,24			
			};
	public static final int[] THIRD_TWELVE =
			{
			25,26,27,28,29,30,31,32,33,34,35,36			
			};
	public static final int[] TWO_ONE_TOP =
			{
			3,6,9,12,15,18,21,24,27,30,33,36		
			};
	public static final int[] TWO_ONE_TOP_MID =
			{
			2,3,4,6,8,6,11,12,14,15,17,18,20,21,23,24,26,27,29,30,32,33,35,36		
			};
	public static final int[] TWO_ONE_MID =
			{
			2,5,8,11,14,17,20,23,26,29,32,35		
			};
	public static final int[] TWO_ONE_MID_BOTTOM =
			{
			1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23,25,26,28,29,31,32,34,35		
			};
	public static final int[] TWO_ONE_BOTTOM =
			{
			1,4,7,10,13,16,19,22,25,28,31,34			
			};
	public static final int[] FIRST_HALF =
			{
			1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18			
			};
	public static final int[] LAST_HALF =
			{
			19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36		
			};
	
	public final static String TWO_TEXT = "2 to 1";
	public final static String TWO_TOP_TEXT = "2 to 1 Top";
	public final static String TWO_TOP_MID_TEXT = "2 to 1 Between Top and Middle";
	public final static String TWO_MID_TEXT = "2 to 1 Middle";
	public final static String TWO_MID_BOTTOM_TEXT = "2 to 1 Between Middle and Bottom";
	public final static String TWO_BOTTOM_TEXT = "2 to 1 Bottom";
	public final static String FIRST_TWELVE_TEXT = "1st 12";
	public final static String SECOND_TWELVE_TEXT = "2nd 12";
	public final static String THIRD_TWELVE_TEXT = "3rd 12";
	public final static String EVEN_TEXT = "EVEN";		
	public final static String FIRST_HALF_TEXT = "1 to 18";
	public final static String SECOND_HALF_TEXT = "19 to 36";
	public final static String ODD_TEXT = "ODD";
	public final static String RED_TEXT = "RED";
	public final static String BLACK_TEXT = "BLACK";
	
	private int resultNumber;
	private double odds;
	private static int[] userPick;
	
	public Roulette(String name)
	{
		super();
		gameName = name;
		resultNumber = 0;
		odds = 0;
		userPick = null;
	}
	
	/**
	 * Plays the game.
	 * 
	 * @return Returns the results as a string. null if no game was played.
	 */
	public String playGame()
	{
		if (ready())
		{		
                        payout = 0;
			odds = determineOdds();
			resultNumber = new Random().nextInt(38);

			String result = getResult(didUserWin());
                        resetGame();

			return result;
		}
		return null;
	}
	
	/**
	 * Makes the game panel and sets it to gamPanel.
	 */
	public JPanel makePanel()
	{
                Roulette_GameBoard board = new Roulette_GameBoard();
		return gamePanel = board;
	}
	
	/**
	 * Sets the odds for the current game based off the size of 
	 * the userPick array. 
	 * 
	 * @return The odds. -1 if no odds were found.
	 */
	private double determineOdds()
	{
		switch (userPick.length)
		{
		case 1:
			return 35;
		case 2:
			return 17;
		case 3:
			return 11;
		case 4:
			return 8;
		case 5:
			return 6;
		case 6:
			return 5;
		case 12:
			return 2;
		case 24:
			return .5;
		case 18:
			return 1;
		default:
			return -1;
		}
	}
	
	/**
	 * Checks to see if the number picked is in the userPicked array.
	 * 
	 * @return True if userPick contains resultNumber.
	 */
	private boolean didUserWin()
	{
		for (int number : userPick)
		{
			if (number == resultNumber)
			{
				return true;
			}
		}
		return false;
	}
	
	private String getResult(boolean bool)
	{
		String result;
		String userPickedText = determinePickText();
		String redOrBlack = "";
		
		if (resultNumber != 0 && resultNumber != 37)
		{
			for (int num : BLACK_NUM)
			{
				if (num == resultNumber)
				{
					redOrBlack = "BLACK";
				}
			}
			
			if (redOrBlack.equals(""))
			{
				redOrBlack = "RED";
			}
		}
		
                // if the user won
		if (bool)
		{
			payout = userBet + (userBet * odds);
			result = "YOU WIN!!!\n"
					+ "Your Numbers Picked: " + userPickedText + "\n"
					+ "Game Number: " + (resultNumber == 37 ? "00" : resultNumber) 
						+ " " +redOrBlack + "\n"
					+ "Your Bet Amount: " + userBet + "\n"
					+ "Your Payout: " + payout;
		}
                //if the user lost
		else
		{
			payout = 0;
			result = "YOU LOSE!!!\n"
					+ "Your Numbers Picked: " + userPickedText + "\n"
					+ "Game Number: " + (resultNumber == 37 ? "00" : resultNumber) 
						+ " "+ redOrBlack + "\n"
					+ "Your Bet Amount: " + userBet + "\n"
					+ "Your Payout: " + payout;
		}
		
		return result;
	}
	
	/**
	 *  Determines what string to return for any user pick if the user picked numbers 
	 *  that have words displayed. 
	 *  
	 * @return The text for the number picked. Null if user picked a number without text.
	 */
	private String determinePickText()
	{
		if (userPick == BLACK_NUM)
		{
			return BLACK_TEXT;
		}
		else if (userPick == RED_NUM)
		{
			return RED_TEXT;
		}
		else if (userPick == FIRST_HALF)
		{
			return FIRST_HALF_TEXT;
		}
		else if (userPick == LAST_HALF)
		{
			return SECOND_HALF_TEXT;
		}
		else if (userPick == FIRST_TWELVE)
		{
			return FIRST_TWELVE_TEXT;
		}
		else if (userPick == SECOND_TWELVE)
		{
			return SECOND_TWELVE_TEXT;
		}
		else if (userPick == THIRD_TWELVE)
		{
			return THIRD_TWELVE_TEXT;
		}
		else if (userPick == EVEN_NUM)
		{
			return EVEN_TEXT;
		}
		else if (userPick == ODD_NUM)
		{
			return ODD_TEXT;
		}
		else if (userPick == TWO_ONE_TOP)
		{
			return TWO_TOP_TEXT;
		}
		else if (userPick == TWO_ONE_TOP_MID)
		{
			return TWO_TOP_MID_TEXT;
		}
		else if (userPick == TWO_ONE_MID)
		{
			return TWO_MID_TEXT;
		}
		else if (userPick == TWO_ONE_MID_BOTTOM)
		{
			return TWO_MID_BOTTOM_TEXT;
		}
		else if (userPick == TWO_ONE_BOTTOM)
		{
			return TWO_BOTTOM_TEXT;
		}
		else
		{
			String result = "";
			
			for (int num = 0; num < userPick.length; num++)
			{
				if (num == userPick.length-1)
				{
					System.out.print(num);
					if (userPick[num] == 37)
					{
						result = result + "00";
					}
					else
					{
						result = result + userPick[num];
					}
				}
				else
				{
					if (userPick[num] == 37)
					{
						result = result + "00, ";
					}
					else
					{
						result = result + userPick[num] + ", ";
					}
				}
			}
			return result;
		}
	}
	
	/**
	 * Resets all game variables to the starting state so the variables 
	 * are ready for another game.
         * 
         * ** Do not reset userBet or payout.
	 * 
	 */
	public void resetGame()
	{
		resultNumber = 0;
		odds = 0;
		userPick = null;
		result = null;
                
                // clears the text for the user picked numbers after the game is played
                Roulette_GameBoard tempPanel = (Roulette_GameBoard) gamePanel;
                tempPanel.getLblNumbersPickedDisplay().setText("Pick Number");
	}
	
	/**
	 * Determines if the game can be played by checking to see if the user 
	 * picked a bet amount and bet number.
	 * 
	 * @return Returns true if bet amount and number has been placed. False otherwise.
	 */
	private boolean ready()
	{
		if (userPick == null)
		{
			JOptionPane.showMessageDialog(gamePanel, "Please pick a "
                                + "number to bet before playing.");
                        return false;
		}
                if (userBet == 0)
                {
                    JOptionPane.showMessageDialog(gamePanel, "Please enter a "
                            + "bet before playing.");
                    return false;
                }
		return true;
	}
	        
        public int[] getUserPick()
        {
            return userPick;
        }
        
        public static void setUserPick(int... pick)
        {
            userPick = pick;
        }
}
