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
	private int[] userPick;
	
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
			JPanel numbers = new JPanel();
			numbers.setLayout(new javax.swing.BoxLayout(numbers, javax.swing.BoxLayout.Y_AXIS));

			JPanel topHalfOfBoard = new JPanel();
			numbers.setLayout(new javax.swing.BoxLayout(numbers, javax.swing.BoxLayout.X_AXIS));

			numbers.add(firstRowNumbers());
			numbers.add(firstrowLines());
			numbers.add(secondRowNumbers());
			numbers.add(secondRowLines());
			numbers.add(thridRowNumbers());
			
			topHalfOfBoard.add(linesBetween0andnumbers());
			topHalfOfBoard.add(numbers);
			
			return topHalfOfBoard;
			
		}
		
		private JPanel firstRowNumbers()
		{
			String redN = "/images/btn_red_number_normal.png";
			String redP = "/images/btn_red_number_pressed.png";
			
			String mOver = "/images/btn_number_mouseover.png";

			String blkN = "/images/btn_black_number_normal.png";
			String blkP = "/images/btn_black_number_pressed.png";
			
			String verN = "/images/btn_line_ver_number_normal.png";
			String verM = "/images/btn_line_ver_number_mouseover.png";
			String verP = "/images/btn_line_ver_number_pressed.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[23];
			
			buttons[0] = new RouletteButton(mOver, redP, redN,3);
			buttons[1] = new RouletteButton(verM, verP, verN, 3,6);
			buttons[2] = new RouletteButton(mOver, blkP, blkN, 6);

			buttons[3] = new RouletteButton(verM, verP, verN, 6,9);
			buttons[4] = new RouletteButton(mOver, redP, redN, 9);
			buttons[5] = new RouletteButton(verM, verP, verN, 9,12);
			buttons[6] = new RouletteButton(mOver, redP, redN, 12);
			
			buttons[7] = new RouletteButton(verM, verP, verN, 12,15);
			buttons[8] = new RouletteButton(mOver, blkP, blkN, 15);
			buttons[9] = new RouletteButton(verM, verP, verN, 15,18);
			buttons[10] = new RouletteButton(mOver, redP, redN, 18);
			
			buttons[11] = new RouletteButton(verM, verP, verN, 18,21);
			buttons[12] = new RouletteButton(mOver, redP, redN, 21);
			buttons[13] = new RouletteButton(verM, verP, verN, 21,24);
			buttons[14] = new RouletteButton(mOver, blkP, blkN, 24);
			
			buttons[15] = new RouletteButton(verM, verP, verN, 24,27);
			buttons[16] = new RouletteButton(mOver, redP, redN, 27);
			buttons[17] = new RouletteButton(verM, verP, verN, 27,30);
			buttons[18] = new RouletteButton(mOver, redP, redN, 30);
			
			buttons[19] = new RouletteButton(verM, verP, verN, 30,33);
			buttons[20] = new RouletteButton(mOver, blkP, blkN, 33);
			buttons[21] = new RouletteButton(verM, verP, verN, 33,36);
			buttons[22] = new RouletteButton(mOver, redP, redN, 36);

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
		}
		
		private JPanel secondRowNumbers()
		{
			String redN = "/images/btn_red_number_normal.png";
			String redP = "/images/btn_red_number_pressed.png";
			
			String mOver = "/images/btn_number_mouseover.png";

			String blkN = "/images/btn_black_number_normal.png";
			String blkP = "/images/btn_black_number_pressed.png";
			
			String verN = "/images/btn_line_ver_number_normal.png";
			String verM = "/images/btn_line_ver_number_mouseover.png";
			String verP = "/images/btn_line_ver_number_pressed.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[23];
			
			buttons[0] = new RouletteButton(mOver, blkP, blkN, 2);
			buttons[1] = new RouletteButton(verM, verP, verN, 2,5);
			buttons[2] = new RouletteButton(mOver, redP, redN, 5);

			buttons[3] = new RouletteButton(verM, verP, verN, 5,8);
			buttons[4] = new RouletteButton(mOver, blkP, blkN, 8);
			buttons[5] = new RouletteButton(verM, verP, verN, 8,11);
			buttons[6] = new RouletteButton(mOver, blkP, blkN, 11);
			
			buttons[7] = new RouletteButton(verM, verP, verN, 11,14);
			buttons[8] = new RouletteButton(mOver, redP, redN, 14);
			buttons[9] = new RouletteButton(verM, verP, verN, 14,17);
			buttons[10] = new RouletteButton(mOver, blkP, blkN, 17);
			
			buttons[11] = new RouletteButton(verM, verP, verN, 17,20);
			buttons[12] = new RouletteButton(mOver, blkP, blkN, 20);
			buttons[13] = new RouletteButton(verM, verP, verN, 20,23);
			buttons[14] = new RouletteButton(mOver, redP, redN, 23);
			
			buttons[15] = new RouletteButton(verM, verP, verN, 23,26);
			buttons[16] = new RouletteButton(mOver, blkP, blkN, 26);
			buttons[17] = new RouletteButton(verM, verP, verN, 26,29);
			buttons[18] = new RouletteButton(mOver, blkP, blkN, 29);
			
			buttons[19] = new RouletteButton(verM, verP, verN, 29,32);
			buttons[20] = new RouletteButton(mOver, redP, redN, 32);
			buttons[21] = new RouletteButton(verM, verP, verN, 32,35);
			buttons[22] = new RouletteButton(mOver, blkP, blkN, 35);

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
		}
		
		private JPanel thridRowNumbers()
		{
			String redN = "/images/btn_red_number_normal.png";
			String redP = "/images/btn_red_number_pressed.png";
			
			String mOver = "/images/btn_number_mouseover.png";

			String blkN = "/images/btn_black_number_normal.png";
			String blkP = "/images/btn_black_number_pressed.png";
			
			String verN = "/images/btn_line_ver_number_normal.png";
			String verM = "/images/btn_line_ver_number_mouseover.png";
			String verP = "/images/btn_line_ver_number_pressed.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[23];
			
			buttons[0] = new RouletteButton(mOver, redP, redN,1);
			buttons[1] = new RouletteButton(verM, verP, verN, 1,4);
			buttons[2] = new RouletteButton(mOver, blkP, blkN, 4);

			buttons[3] = new RouletteButton(verM, verP, verN, 4,7);
			buttons[4] = new RouletteButton(mOver, redP, redN, 7);
			buttons[5] = new RouletteButton(verM, verP, verN, 7,10);
			buttons[6] = new RouletteButton(mOver, blkP, blkN, 10);
			
			buttons[7] = new RouletteButton(verM, verP, verN, 10,13);
			buttons[8] = new RouletteButton(mOver, blkP, blkN, 13);
			buttons[9] = new RouletteButton(verM, verP, verN, 13,16);
			buttons[10] = new RouletteButton(mOver, redP, redN, 16);
			
			buttons[11] = new RouletteButton(verM, verP, verN, 16,19);
			buttons[12] = new RouletteButton(mOver, redP, redN, 19);
			buttons[13] = new RouletteButton(verM, verP, verN, 19,22);
			buttons[14] = new RouletteButton(mOver, blkP, blkN, 22);
			
			buttons[15] = new RouletteButton(verM, verP, verN, 22,25);
			buttons[16] = new RouletteButton(mOver, redP, redN, 25);
			buttons[17] = new RouletteButton(verM, verP, verN, 25,28);
			buttons[18] = new RouletteButton(mOver, blkP, blkN, 28);
			
			buttons[19] = new RouletteButton(verM, verP, verN, 28,31);
			buttons[20] = new RouletteButton(mOver, blkP, blkN, 31);
			buttons[21] = new RouletteButton(verM, verP, verN, 31,34);
			buttons[22] = new RouletteButton(mOver, redP, redN, 34);

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
		}
		
		private JPanel firstrowLines()
		{
			String horN = "/images/btn_line_hor_number_normal.png";
			String horP = "/images/btn_line_hor_number_pressed.png";
			String horM = "/images/btn_line_hor_number_mouseover.png";

			String sqN = "/images/btn_line_square_number_normal.png";
			String sqM = "/images/btn_line_square_number_mouseover.png";
			String sqP = "/images/btn_line_square_number_pressed.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[23];

			int num1 = 2;
			int num2 = 3;
			int num3 = 0;
			
			for (int num = 0; num < 11; num++)
			{
				buttons[num3] = new RouletteButton(horM, horP, horN, num1,num2);
				num3++;
				buttons[num3] = new RouletteButton(sqM, sqP, sqN, num1,num2,num1 = num1 +3, num2 = num2 +3);
				num3++;
				
			}
			
			buttons[num3] = new RouletteButton(horM, horP, horN, 35,36);

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			return temp;
		}
		
		private JPanel secondRowLines()
		{
			String horN = "/images/btn_line_hor_number_normal.png";
			String horP = "/images/btn_line_hor_number_pressed.png";
			String horM = "/images/btn_line_hor_number_mouseover.png";

			String sqN = "/images/btn_line_square_number_normal.png";
			String sqM = "/images/btn_line_square_number_mouseover.png";
			String sqP = "/images/btn_line_square_number_pressed.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[23];

			int num1 = 1;
			int num2 = 2;
			int num3 = 0;
			
			for (int num = 0; num < 11; num++)
			{
				buttons[num3] = new RouletteButton(horM, horP, horN, num1,num2);
				num3++;
				buttons[num3] = new RouletteButton(sqM, sqP, sqN, num1,num2,num1 = num1 +3, num2 = num2 +3);
				num3++;
				
			}
			
			buttons[num3] = new RouletteButton(horM, horP, horN, 35,36);

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			return temp;
		}
		
		private JPanel linesBetween0andnumbers()
		{
			String verN = "/images/btn_line_ver_number_normal.png";
			String verM = "/images/btn_line_ver_number_mouseover.png";
			String verP = "/images/btn_line_ver_number_pressed.png";

			String smallN = "/images/btn_line_ver_small_normal.png";
			String smallM = "/images/btn_line_ver_small_mouseover.png";
			String smallP = "/images/btn_line_ver_small_pressed.png";

			String sqN = "/images/btn_line_square_number_normal.png";
			String sqM = "/images/btn_line_square_number_mouseover.png";
			String sqP = "/images/btn_line_square_number_pressed.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.Y_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[7];
			
			buttons[0] = new RouletteButton(verM, verP, verN, 3,37);
			buttons[1] = new RouletteButton(sqM, sqP, sqN, 2,3,37);
			buttons[2] = new RouletteButton(smallM, smallP, smallN, 2,37);
			buttons[3] = new RouletteButton(sqM, sqP, sqN, 0,2,37);
			buttons[4] = new RouletteButton(smallM, smallP, smallN, 0,2);
			buttons[5] = new RouletteButton(sqM, sqP, sqN, 0,1,2);
			buttons[6] = new RouletteButton(verM, verP, verN, 0,1);

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			return temp;
		}
	}


}
