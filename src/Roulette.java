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
import javax.swing.ImageIcon;
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
		private String twoText = "2 to 1";
		private String firstTwelve = "1st 12";
		private String secondTwelve = "2nd 12";
		private String thirdTwelve = "3rd 12";
		private String even = "EVEN ";		
		private String firstHalf = "1 to 18";
		private String secondHalf = "19 to 36";
		private String odd = "ODD";
		private String red = "RED";
		private String black = "BLACK";
		
		private String twoN = "/images/btn_2to1_bottom_normal.png";
		private String twoM = "/images/btn_2to1_bottom_mouseover.png";
		private String twoP = "/images/btn_2to1_bottom_pressed.png";

		private String twoMidN = "/images/btn_2to1_normal.png";
		private String twoMidM = "/images/btn_2to1_mouseover.png";
		private String twoMidP = "/images/btn_2to1_pressed.png";
		
		private String horN = "/images/btn_line_hor_number_normal.png";
		private String horP = "/images/btn_line_hor_number_pressed.png";
		private String horM = "/images/btn_line_hor_number_mouseover.png";
		
		private String sqN = "/images/btn_line_square_number_normal.png";
		private String sqM = "/images/btn_line_square_number_mouseover.png";
		private String sqP = "/images/btn_line_square_number_pressed.png";
		
		private String redN = "/images/btn_red_number_normal.png";
		private String redP = "/images/btn_red_number_pressed.png";
		
		private String mOver = "/images/btn_number_mouseover.png";

		private String blkN = "/images/btn_black_number_normal.png";
		private String blkP = "/images/btn_black_number_pressed.png";
		
		private String verN = "/images/btn_line_ver_number_normal.png";
		private String verM = "/images/btn_line_ver_number_mouseover.png";
		private String verP = "/images/btn_line_ver_number_pressed.png";
		
		private String topN = "/images/btn_line_top.png";

		public RouletteGameBoard()
		{
		}
		
		public JPanel makeGameBoard()
		{
			JPanel numbers = new JPanel();
			numbers.setLayout(new javax.swing.BoxLayout(numbers, javax.swing.BoxLayout.Y_AXIS));

			JPanel totalBoard = new JPanel();
			totalBoard.setLayout(new javax.swing.BoxLayout(totalBoard, javax.swing.BoxLayout.X_AXIS));

			JPanel tmp = new JPanel();
			tmp.setLayout(new javax.swing.BoxLayout(tmp, javax.swing.BoxLayout.X_AXIS));
			RouletteButton topLine = new RouletteButton(topN, topN, topN, -1,-1);
			topLine.setDisabledIcon(new ImageIcon(getClass().getResource(topN)));
			topLine.setEnabled(false);
			tmp.add(topLine);
			
			numbers.add(tmp);
			numbers.add(firstRowNumbers());
			numbers.add(firstrowLines());
			numbers.add(secondRowNumbers());
			numbers.add(secondRowLines());
			numbers.add(thridRowNumbers());

			
			JPanel zeros = zeros();
			JPanel linesBetween0andNumbers = linesBetween0andnumbers();
			JPanel twoToOne = twoToOne();
			JPanel twelve = twelve();
			JPanel bottomOfBoard = bottomOfBoard();

			zeros.setAlignmentY(Component.TOP_ALIGNMENT);
			linesBetween0andNumbers.setAlignmentY(Component.TOP_ALIGNMENT);
			numbers.setAlignmentY(Component.TOP_ALIGNMENT);
			twoToOne.setAlignmentY(Component.TOP_ALIGNMENT);
			twelve.setAlignmentY(Component.LEFT_ALIGNMENT);
			bottomOfBoard.setAlignmentY(Component.LEFT_ALIGNMENT);
			
			numbers.add(twelve);
			numbers.add(bottomOfBoard);
			
			totalBoard.add(zeros);
			totalBoard.add(linesBetween0andNumbers);
			totalBoard.add(numbers);
			totalBoard.add(twoToOne);

			totalBoard.setBackground(Color.decode("#137c43"));
			twoToOne.setBackground(Color.decode("#137c43"));
			
			return totalBoard;
			
		}
		
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
				//*************************testing*********
				button.addMouseListener(listener); 
				//******************************************
				temp.add(button);
			}
			
			return temp;
		}
		
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

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
		}
		
		private JPanel thridRowNumbers()
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

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
		}
		
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
			
			RouletteButton[] buttons = new RouletteButton[8];
			
			buttons[0] = new RouletteButton(larLineM, larLineP, larLineN, 3,37);
			buttons[1] = new RouletteButton(sqM, sqP, sqN, 2,3,37);
			buttons[2] = new RouletteButton(smallM, smallP, smallN, 2,37);
			buttons[3] = new RouletteButton(larM, larP, larN, 0,2,37);
			buttons[4] = new RouletteButton(smallM, smallP, smallN, 0,2);
			buttons[5] = new RouletteButton(sqM, sqP, sqN, 0,1,2);
			buttons[6] = new RouletteButton(verM, verP, verN, 0,1);
			
			buttons[7] = new RouletteButton(lineleft, lineleft, lineleft, -1,-1);
			buttons[7].setDisabledIcon(new ImageIcon(getClass().getResource(lineleft)));
			buttons[7].setEnabled(false);

			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			return temp;
		}
		
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
			
			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			return temp;
		}
		
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
					36,9,12,15,18,21,24,27,30,33,36);
			buttons[0].addStringTextRotated(twoText, 20);
			buttons[1] = new RouletteButton(horBetweenM, horBetweenP, horBetweenN, 
					2,3,4,6,8,6,11,12,14,15,17,18,20,21,23,24,26,27,29,30,32,33,35,36);
			buttons[2] = new RouletteButton(twoMidM, twoMidP, twoMidN, 
					2,5,8,11,14,17,20,23,26,29,32,35);
			buttons[2].addStringTextRotated(twoText, 20);
			buttons[3] = new RouletteButton(horBetweenM, horBetweenP, horBetweenN, 
					1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23,25,26,28,29,31,32,34,35);
			buttons[4] = new RouletteButton(twoM, twoP, twoN, 
					1,4,7,10,13,16,19,22,25,28,31,34);
			buttons[4].addStringTextRotated(twoText, 20);
			
			buttons[5] = new RouletteButton(lineRight, lineRight, lineRight, -1,-1);
			buttons[5].setDisabledIcon(new ImageIcon(getClass().getResource(lineRight)));
			buttons[5].setEnabled(false);
			
			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
		}
		
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
			
			buttons[0] = new RouletteButton(midM, midP, midN, 1,2,3,4,5,6,7,8,9,10,11,12);
			buttons[0].addText(firstTwelve, 30);
			buttons[1] = new RouletteButton(endM, endP, endN, 13,14,15,16,17,18,19,20,21,22,23,24);
			buttons[1].addText(secondTwelve, 30);
			buttons[2] = new RouletteButton(midM, midP, midN, 25,26,27,28,29,30,31,32,33,34,35,36);
			buttons[2].addText(thirdTwelve, 30);
			
			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
		}
		
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
			
			buttons[0] = new RouletteButton(lastHalfM, lastHalfP, lastHalfN, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
			buttons[0].addText(firstHalf, 25);
			buttons[1] = new RouletteButton(lastHalfM, lastHalfP, lastHalfN, 2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36);
			buttons[1].addText(even, 25);
			buttons[2] = new RouletteButton(lastHalfM, lastHalfP, lastHalfN, 1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36);
			buttons[2].addText(red, 25);
			buttons[2].setForeground(Color.RED);
			buttons[3] = new RouletteButton(midM, midP, midN, 2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35);
			buttons[3].addText(black, 25);
			buttons[3].setForeground(Color.BLACK);
			buttons[4] = new RouletteButton(firstHalfM, firstHalfP, firstHalfN, 1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35);
			buttons[4].addText(odd, 25);
			buttons[5] = new RouletteButton(midM, midP, midN, 19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36);
			buttons[5].addText(secondHalf, 25);
			
			for (RouletteButton button : buttons)
			{
				temp.add(button);
			}
			
			return temp;
			
		}
		
		
		//*****************Testing this class still*****************
		private class ButtonListener implements MouseListener
		{

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
				displayButton((RouletteButton) e.getSource());
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void displayButton(RouletteButton b)
			{
				String temp = "";
				for (int num : b.getNumbers())
				{
					temp = temp + num + ", ";
				}
				//MainPanel.lblResults.setText(temp);
			}
			
		}
	}


}
