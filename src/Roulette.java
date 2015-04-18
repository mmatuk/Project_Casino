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
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Roulette extends Game
{
	// int[] for any numbers that need words
	private final static int[] RED_NUM =
			{
			1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36
			};
	private static final int[] BLACK_NUM =
			{
			2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35
			};
	private static final int[] ODD_NUM =
			{
			1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35			
			};
	private static final int[] EVEN_NUM =
			{
			2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36			
			};
	private static final int[] FIRST_TWELVE =
			{
			1,2,3,4,5,6,7,8,9,10,11,12		
			};
	private static final int[] SECOND_TWELVE =
			{
			13,14,15,16,17,18,19,20,21,22,23,24			
			};
	private static final int[] THIRD_TWELVE =
			{
			25,26,27,28,29,30,31,32,33,34,35,36			
			};
	private static final int[] TWO_ONE_TOP =
			{
			3,6,9,12,15,18,21,24,27,30,33,36		
			};
	private static final int[] TWO_ONE_TOP_MID =
			{
			2,3,4,6,8,6,11,12,14,15,17,18,20,21,23,24,26,27,29,30,32,33,35,36		
			};
	private static final int[] TWO_ONE_MID =
			{
			2,5,8,11,14,17,20,23,26,29,32,35		
			};
	private static final int[] TWO_ONE_MID_BOTTOM =
			{
			1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23,25,26,28,29,31,32,34,35		
			};
	private static final int[] TWO_ONE_BOTTOM =
			{
			1,4,7,10,13,16,19,22,25,28,31,34			
			};
	private static final int[] FIRST_HALF =
			{
			1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18			
			};
	private static final int[] LAST_HALF =
			{
			19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36		
			};
	
	private final static String TWO_TEXT = "2 to 1";
	private final static String TWO_TOP_TEXT = "2 to 1 Top";
	private final static String TWO_TOP_MID_TEXT = "2 to 1 Between Top and Middle";
	private final static String TWO_MID_TEXT = "2 to 1 Middle";
	private final static String TWO_MID_BOTTOM_TEXT = "2 to 1 Between Middle and Bottom";
	private final static String TWO_BOTTOM_TEXT = "2 to 1 Bottom";
	private final static String FIRST_TWELVE_TEXT = "1st 12";
	private final static String SECOND_TWELVE_TEXT = "2nd 12";
	private final static String THIRD_TWELVE_TEXT = "3rd 12";
	private final static String EVEN_TEXT = "EVEN";		
	private final static String FIRST_HALF_TEXT = "1 to 18";
	private final static String SECOND_HALF_TEXT = "19 to 36";
	private final static String ODD_TEXT = "ODD";
	private final static String RED_TEXT = "RED";
	private final static String BLACK_TEXT = "BLACK";
	
	private int resultNumber;
	private double odds;
	private int[] userPick;
	
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
		return gamePanel = new RouletteGameBoard().makeGameBoard();
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
	        
        public int[] getUserPick()
        {
            return userPick;
        }
        
	/**
	 * Creates a game board for the roulette game that will allow the user to click 
	 * buttons on the board to determine where the user wants to bet
	 * @author Matt
	 *
	 */
	private class RouletteGameBoard
	{
			
		// Strings for image locations
		private final String twoN = "/images/btn_2to1_bottom_normal.png";
		private final String twoM = "/images/btn_2to1_bottom_mouseover.png";
		private final String twoP = "/images/btn_2to1_bottom_pressed.png";

		private final String twoMidN = "/images/btn_2to1_normal.png";
		private final String twoMidM = "/images/btn_2to1_mouseover.png";
		private final String twoMidP = "/images/btn_2to1_pressed.png";
		
		private final String horN = "/images/btn_line_hor_number_normal.png";
		private final String horP = "/images/btn_line_hor_number_pressed.png";
		private final String horM = "/images/btn_line_hor_number_mouseover.png";
		
		private final String sqN = "/images/btn_line_square_number_normal.png";
		private final String sqM = "/images/btn_line_square_number_mouseover.png";
		private final String sqP = "/images/btn_line_square_number_pressed.png";
		
		private final String redN = "/images/btn_red_number_normal.png";
		private final String redP = "/images/btn_red_number_pressed.png";
		
		private final String mOver = "/images/btn_number_mouseover.png";

		private final String blkN = "/images/btn_black_number_normal.png";
		private final String blkP = "/images/btn_black_number_pressed.png";
		
		private final String verN = "/images/btn_line_ver_number_normal.png";
		private final String verM = "/images/btn_line_ver_number_mouseover.png";
		private final String verP = "/images/btn_line_ver_number_pressed.png";
		
		private final String topN = "/images/btn_line_top.png";

                //****************Test*******************
                RouletteButton test = new RouletteButton("/images/chip_test.png", 
                         "/images/chip_test.png", "/images/chip_test.png", RouletteButton.LINE_BUTTON_NOT_CLICKABLE);
                //*********************************
                
		public RouletteGameBoard()
		{
		}
		
		/**
		 * Creates a game board by calling each method that will return the proper panel with buttons.
		 * 
		 * @return The whole game board created.
		 */
		public JPanel makeGameBoard()
		{
			// for all the number and line buttons and the bottom half of the board buttons.
			JPanel numbers = new JPanel();
			numbers.setLayout(new javax.swing.BoxLayout(
					numbers, javax.swing.BoxLayout.Y_AXIS));

			// The whole game board.
			JPanel totalBoard = new JPanel();
			totalBoard.setLayout(new javax.swing.BoxLayout(
					totalBoard, javax.swing.BoxLayout.X_AXIS));

			// Add the top white line to the board. Only used to show the line and not used
			// as a button.
			JPanel tmp = new JPanel();
			tmp.setLayout(new javax.swing.BoxLayout(tmp, javax.swing.BoxLayout.X_AXIS));
			RouletteButton topLine = new RouletteButton(topN, topN, topN, 
					RouletteButton.LINE_BUTTON_NOT_CLICKABLE);
			topLine.setDisabledIcon(new ImageIcon(getClass().getResource(topN)));
			topLine.setEnabled(false);
			tmp.add(topLine);
			
			// Adds all the middle vertical buttons.
			numbers.add(tmp);
			numbers.add(firstRowNumbers());
			numbers.add(firstrowLines());
			numbers.add(secondRowNumbers());
			numbers.add(secondRowLines());
			numbers.add(thirdRowNumbers());
			numbers.add(thirdRowLines());
			
			// The rest of the buttons
			JPanel zeros = zeros();
			JPanel linesBetween0andNumbers = linesBetween0andnumbers();
			JPanel twoToOne = twoToOne();
			JPanel twelve = twelve();
			JPanel bottomOfBoard = bottomOfBoard();

			// Makes all buttons align to the top
			zeros.setAlignmentY(Component.TOP_ALIGNMENT);
			linesBetween0andNumbers.setAlignmentY(Component.TOP_ALIGNMENT);
			numbers.setAlignmentY(Component.TOP_ALIGNMENT);
			twoToOne.setAlignmentY(Component.TOP_ALIGNMENT);
			twelve.setAlignmentY(Component.LEFT_ALIGNMENT);
			bottomOfBoard.setAlignmentY(Component.LEFT_ALIGNMENT);
			
			// adds the bottom half of board to the numbers panel
			numbers.add(twelve);
			numbers.add(bottomOfBoard);
			
			// adds all panels to the total board.
			totalBoard.add(zeros);
			totalBoard.add(linesBetween0andNumbers);
			totalBoard.add(numbers);
			totalBoard.add(twoToOne);

			// set the background color to green
			totalBoard.setBackground(Color.decode("#137c43"));
			twoToOne.setBackground(Color.decode("#137c43"));
			
                        // ***********TEST****************************
                        //*********************************************
                        JLayeredPane gameBoardLayer = new JLayeredPane();
                        test.setDisabledIcon(new ImageIcon(getClass().getResource("/images/chip_test.png")));
			test.setEnabled(false);
                        test.setVisible(true);
                        JPanel test3 = new JPanel();

                        test3.add(test);
                        test3.setLayout(new javax.swing.BoxLayout(
                                    test3, javax.swing.BoxLayout.X_AXIS));
                        test3.setBounds(0,0,500,500);
                        gameBoardLayer.add(test3, new Integer(1), 0);

                        //gameBoardLayer.add(test, 1);
                        totalBoard.setBounds(0, 0, 1400, 800);
                        gameBoardLayer.add(totalBoard, new Integer(0), 0);                        
                        JPanel test2 = new JPanel();
                        test2.add(gameBoardLayer);
                        test2.setLayout(new javax.swing.BoxLayout(
                                    test2, javax.swing.BoxLayout.X_AXIS));
                        //*********************************************                        
                        //*********************************************
                        
			return test2;
			
		}
		
		/**
		 * Creates a panel that contains the first row of number buttons and the vertical lines
		 * inbetween them.
		 * 
		 * @return The panel created.
		 */
		private JPanel firstRowNumbers()
		{
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

			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			
			return temp;
		}
		
		/**
		 * Creates a panel that contains the second row of number buttons and the vertical lines
		 * inbetween them.
		 * 
		 * @return The panel created.
		 */
		private JPanel secondRowNumbers()
		{
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

			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			
			return temp;
		}
		
		/**
		 * Creates a panel that contains the third row of number buttons and the vertical lines
		 * inbetween them.
		 * 
		 * @return Thr panel created.
		 */
		private JPanel thirdRowNumbers()
		{
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

			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			
			return temp;
		}
		
		/**
		 * Creates a panel that contains the first horizontal line buttons that are inbetween the numbers
		 * on the game board. 
		 * 
		 * @return The panel created.
		 */
		private JPanel firstrowLines()
		{
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
				buttons[num3] = new RouletteButton(sqM, sqP, sqN, 
						num1,num2,num1 = num1 +3, num2 = num2 +3);
				num3++;
				
			}
			buttons[num3] = new RouletteButton(horM, horP, horN, 35,36);

			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			return temp;
		}
		
		/**
		 * Creates a panel that contains the second horizontal line buttons that are inbetween the numbers
		 * on the game board. 
		 * 
		 * @return The panel created.
		 */
		private JPanel secondRowLines()
		{
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
				buttons[num3] = new RouletteButton(sqM, sqP, sqN, 
						num1,num2,num1 = num1 +3, num2 = num2 +3);
				num3++;
				
			}
			
			buttons[num3] = new RouletteButton(horM, horP, horN, 35,36);

			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			return temp;
		}
		
		/**
		 * Creates a panel that contains the third horizontal line buttons that are inbetween the numbers
		 * and the bottom of the game board. 
		 * 
		 * @return The panel created.
		 */
		private JPanel thirdRowLines()
		{
			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[23];

			int num1 = 1;
			int num2 = 2;
			int num3 = 3;
			int num4 = 0;
			
			for (int num = 0; num < 11; num++)
			{
				buttons[num4] = new RouletteButton(horM, horP, horN, num1,num2,num3);
				num4++;
				buttons[num4] = new RouletteButton(sqM, sqP, sqN, 
						num1,num2,num3,num1 = num1 +3, num2 = num2 +3,num3 = num3 +3);
				num4++;
				
			}
			
			buttons[num4] = new RouletteButton(horM, horP, horN, 34,35,36);

			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			return temp;
		}
		
		/**
		 * Creates a panel that contains all the buttons between the 0 buttons and the numbers
		 * on the game board.
		 * 
		 * @return The panel created.
		 */
		private JPanel linesBetween0andnumbers()
		{
			String smallN = "/images/btn_line_ver_small_normal.png";
			String smallM = "/images/btn_line_ver_small_mouseover.png";
			String smallP = "/images/btn_line_ver_small_pressed.png";

			String larN = "/images/btn_line_square_larger_number_normal.png";
			String larM = "/images/btn_line_square_larger_number_mouseover.png";
			String larP = "/images/btn_line_square_larger_number_pressed.png";
			
			String larLineN = "/images/btn_line_ver_larger_normal.png";
			String larLineM = "/images/btn_line_ver_larger_mouseover.png";
			String larLineP = "/images/btn_line_ver_larger_pressed.png";
			
			String lineleft = "/images/btn_line_left.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.Y_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[9];
			
			buttons[0] = new RouletteButton(larLineM, larLineP, larLineN, 3,37);
			buttons[1] = new RouletteButton(sqM, sqP, sqN, 2,3,37);
			buttons[2] = new RouletteButton(smallM, smallP, smallN, 2,37);
			buttons[3] = new RouletteButton(larM, larP, larN, 0,2,37);
			buttons[4] = new RouletteButton(smallM, smallP, smallN, 0,2);
			buttons[5] = new RouletteButton(sqM, sqP, sqN, 0,1,2);
			buttons[6] = new RouletteButton(verM, verP, verN, 0,1);
			buttons[7] = new RouletteButton(sqM, sqP, sqN, 0,1,2,3,37);

			
			// This is for the white line next to the bottom half of the board on the right. Only used 
			// because of the need for the picture and not the button
			buttons[8] = new RouletteButton(lineleft, lineleft, lineleft, 
					RouletteButton.LINE_BUTTON_NOT_CLICKABLE);
			buttons[8].setDisabledIcon(new ImageIcon(getClass().getResource(lineleft)));
			buttons[8].setEnabled(false);

			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			return temp;
		}
		
		/**
		 * Creates a panel the contains the two zero buttons and the line inbetween them.
		 * 
		 * @return The panel created.
		 */
		private JPanel zeros()
		{
			String ooN = "/images/btn_00_normal.png";
			String ooM = "/images/btn_00_mouseover.png";
			String ooP = "/images/btn_00_pressed.png";

			String oN = "/images/btn_0_normal.png";
			String oM = "/images/btn_0_mouseover.png";
			String oP = "/images/btn_0_pressed.png";
			
			String horON = "/images/btn_line_between0_normal.png";
			String horOM = "/images/btn_line_between0_mouseover.png";
			String horOP = "/images/btn_line_between0_pressed.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.Y_AXIS));
			
			RouletteButton[] buttons = new RouletteButton[3];

			buttons[0] = new RouletteButton(ooM, ooP, ooN, 37);
			buttons[1] = new RouletteButton(horOM, horOP, horON, 0,37);
			buttons[2] = new RouletteButton(oM, oP, oN, 0);
			
			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			return temp;
		}
		
		/**
		 * Creates a panel that contains the three buttons for 2 to 1 odds. 
		 * 
		 * @return The Panel created.
		 */
		private JPanel twoToOne()
		{

			String horBetweenN = "/images/btn_line_between2_normal.png";
			String horBetweenM = "/images/btn_line_between2_mouseover.png";
			String horBetweenP = "/images/btn_line_between2_pressed.png";
			
			String twoTopN = "/images/btn_2to1_top_normal.png";
			String twoTopM = "/images/btn_2to1_top_mouseover.png";
			String twoTopP = "/images/btn_2to1_top_pressed.png";
			
			String lineRight = "/images/btn_line_right.png";

			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.Y_AXIS));

			RouletteButton[] buttons = new RouletteButton[6];
			
			buttons[0] = new RouletteButton(twoTopM, twoTopP, twoTopN, 
					TWO_ONE_TOP);
			buttons[0].addStringTextRotated(TWO_TEXT, 20);
			buttons[1] = new RouletteButton(horBetweenM, horBetweenP, horBetweenN, 
					TWO_ONE_TOP_MID);
			buttons[2] = new RouletteButton(twoMidM, twoMidP, twoMidN, 
					TWO_ONE_MID);
			buttons[2].addStringTextRotated(TWO_TEXT, 20);
			buttons[3] = new RouletteButton(horBetweenM, horBetweenP, horBetweenN, 
					TWO_ONE_MID_BOTTOM);
			buttons[4] = new RouletteButton(twoM, twoP, twoN, 
					TWO_ONE_BOTTOM);
			buttons[4].addStringTextRotated(TWO_TEXT, 20);
			
			// This is for the white line next to the bottom half of the board on the right. Only used 
			// because of the need for the picture and not the button
			buttons[5] = new RouletteButton(lineRight, lineRight, lineRight, 
					RouletteButton.LINE_BUTTON_NOT_CLICKABLE);
			buttons[5].setDisabledIcon(new ImageIcon(getClass().getResource(lineRight)));
			buttons[5].setEnabled(false);
			
			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			
			return temp;
		}
		
		/**
		 * Creates a panel that contains the buttons 1st 12, 2nd 12, and 3rd 12 for the game.
		 * 
		 * @return The panel created.
		 */
		private JPanel twelve()
		{
			String endN = "/images/btn_3rds_ends_normal.png";
			String endM = "/images/btn_3rds_ends_mouseover.png";
			String endP = "/images/btn_3rds_ends_pressed.png";
			
			String midN = "/images/btn_3rds_mid_normal.png";
			String midM = "/images/btn_3rds_mid_mouseover.png";
			String midP = "/images/btn_3rds_mid_pressed.png";
		
			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
	
			RouletteButton[] buttons = new RouletteButton[3];
			
			buttons[0] = new RouletteButton(midM, midP, midN, FIRST_TWELVE);
			buttons[0].addText(FIRST_TWELVE_TEXT, 30);
			buttons[1] = new RouletteButton(endM, endP, endN, SECOND_TWELVE);
			buttons[1].addText(SECOND_TWELVE_TEXT, 30);
			buttons[2] = new RouletteButton(midM, midP, midN, THIRD_TWELVE);
			buttons[2].addText(THIRD_TWELVE_TEXT, 30);
			
			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			
			return temp;
		}
		
		/**
		 * Creates the Panel for the bottom of the board. The panel will contain 1 to 18, 
		 * EVEN, RED, BLACK, ODD, 19 to 36 buttons.
		 * 
		 * @return The panel created
		 */
		private JPanel bottomOfBoard()
		{
			String firstHalfN = "/images/btn_1-18_and_odd_normal.png";
			String firstHalfM = "/images/btn_1-18_and_odd_mouseover.png";
			String firstHalfP = "/images/btn_1-18_and_odd_pressed.png";
			
			String lastHalfN = "/images/btn_even_red_19-36_normal.png";
			String lastHalfM = "/images/btn_even_red_19-36_mouseover.png";
			String lastHalfP = "/images/btn_even_red_19-36_pressed.png";
			
			String midN = "/images/btn_black_normal.png";
			String midM = "/images/btn_black_mouseover.png";
			String midP = "/images/btn_black_pressed.png";
			
			JPanel temp = new JPanel();
			temp.setLayout(new javax.swing.BoxLayout(temp, javax.swing.BoxLayout.X_AXIS));
	
			RouletteButton[] buttons = new RouletteButton[6];
			
			buttons[0] = new RouletteButton(lastHalfM, lastHalfP, lastHalfN, FIRST_HALF);
			buttons[0].addText(FIRST_HALF_TEXT, 25);
			buttons[1] = new RouletteButton(lastHalfM, lastHalfP, lastHalfN, EVEN_NUM);
			buttons[1].addText(EVEN_TEXT, 25);
			buttons[2] = new RouletteButton(lastHalfM, lastHalfP, lastHalfN, RED_NUM);
			buttons[2].addText(RED_TEXT, 25);
			buttons[2].setForeground(Color.RED);
			buttons[3] = new RouletteButton(midM, midP, midN, BLACK_NUM);
			buttons[3].addText(BLACK_TEXT, 25);
			buttons[3].setForeground(Color.BLACK);
			buttons[4] = new RouletteButton(firstHalfM, firstHalfP, firstHalfN, ODD_NUM);
			buttons[4].addText(ODD_TEXT, 25);
			buttons[5] = new RouletteButton(midM, midP, midN, LAST_HALF);
			buttons[5].addText(SECOND_HALF_TEXT, 25);
			
			ButtonListener listener = new ButtonListener();
			
			for (RouletteButton button : buttons)
			{
				button.addMouseListener(listener); 
				temp.add(button);
			}
			
			return temp;
		}
		
		
		//*****************Testing this class still*****************
		private class ButtonListener implements MouseListener
		{

			public void mouseClicked(java.awt.event.MouseEvent e) 
			{
                            try
                            {
                                RouletteButton b = (RouletteButton) e.getSource();
                                userPick = b.getNumbers();
                                
                                //*******Test********************
                                test.setLocation(b.getLocation());
                                //*******************************
                            } 
                            catch (Exception error)
                            {
                                error.printStackTrace();
                                JOptionPane.showMessageDialog(gamePanel, "Error. Button not found.");
                            }
                        }

			public void mouseEntered(java.awt.event.MouseEvent e) 
			{				
			}

			public void mouseExited(java.awt.event.MouseEvent e) 
			{				
			}

			public void mousePressed(java.awt.event.MouseEvent e) 
			{				
			}

			public void mouseReleased(java.awt.event.MouseEvent e) 
			{				
			}
		}
	}


}
