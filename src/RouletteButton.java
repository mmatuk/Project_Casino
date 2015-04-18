//******************************************************************************
//  RouletteButton.java                             Project Casino
//  Author: Matt Matuk                              Created: march 30, 2015                         
//  Team: Team 2
//
//  1. This class will extend JButton and create a custom button object.
//  2. The custom button will store images and values for the size and an array
//  for the numbers that the button represents.
//  The buttom will be a custom looking button that when combined to other 
//  roulete buttons, will look like a roulette game board.
//******************************************************************************

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Matt
 */
public class RouletteButton extends JButton
{
    private int[] numbers;
    
	public final static int[] LINE_BUTTON_NOT_CLICKABLE = {-1,-1}; //For the lines that are not clickable.
    
    /**
     * Create a new Roulette button
     * 
     * @param mOver Mouseover imageIcon
     * @param press Pressed imageIcon
     * @param nor Normal imageIcon
     * @param num Integers for the numbers that the button controls. 
     * Make sure when passing the ints to keep them in numerical order.
     */
    public RouletteButton(String mOver, String press, 
            String nor, int...num)
    {
        super();
        setNumbers(num);
        setButton();

        ImageIcon normalIcon = new ImageIcon(getClass().getResource(nor));
        ImageIcon pressedIcon = new ImageIcon(getClass().getResource(press));
        ImageIcon mouseoverIcon = new ImageIcon(getClass().getResource(mOver));
        
        setPressedIcon(pressedIcon);
        setRolloverIcon(mouseoverIcon);
        setIcon(normalIcon);
        
        Dimension temp = new Dimension(pressedIcon.getIconWidth(), pressedIcon.getIconHeight());
        setPreferredSize(temp);
        setMinimumSize(temp);
        setMaximumSize(temp);
        
        if (numbers.length == 1)
        {
        	addNumberText();
        }
        
    }
    
    private void setButton()
    {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    
    public int[] getNumbers()
    {
    	return numbers;
    }
    
    public void setNumbers(int...num)
    {
    	numbers = num;
    }
    
    private void addNumberText()
    {
    	setHorizontalTextPosition(JButton.CENTER);
    	setVerticalTextPosition(JButton.CENTER);

    	// for double 00 number
    	if (numbers[0] == 37)
    	{
    		setText("00");

    	}
    	// adds space for any single digit numbers 
    	// so text is in center when rotated
    	else if (numbers[0] <= 9)
    	{
    		setText(" "+numbers[0]);
    	}
    	else
    	{
    		setText(""+numbers[0]);
    	}
    	
    	Font tmp1 = new Font("", Font.PLAIN, 45);
    	    	
    	AffineTransform test = new AffineTransform();
    	test.rotate(Math.toRadians(-90), tmp1.getSize()/2-2, tmp1.getSize()/9);

    	setFont(tmp1.deriveFont(test));
    	setForeground(Color.WHITE);
    }
    
    public void addStringTextRotated(String txt, int size)
    {
    	setText(txt);
    	
    	setHorizontalTextPosition(JButton.CENTER);
    	setVerticalTextPosition(JButton.CENTER);
    	
    	Font tmp1 = new Font(txt, Font.PLAIN, size);
    	
    	AffineTransform test = new AffineTransform();
    	test.rotate(Math.toRadians(-90), tmp1.getSize()/2+5, tmp1.getSize()/2);

    	setFont(tmp1.deriveFont(test));
    	setForeground(Color.WHITE);
    }
    
    public void addText(String str, int size)
    {
    	setText(str);
    	Font tmp1 = new Font("", Font.PLAIN, size);
    	setFont(tmp1);
    	setForeground(Color.WHITE);
    	
    	setHorizontalTextPosition(JButton.CENTER);
    	setVerticalTextPosition(JButton.CENTER);
    }
    
    public String toString()
    {
    	String temp = "";
    	
    	for (int num : numbers)
    	{
    		temp = temp + num +", ";
    	}
    	return "Button numbers: " +temp;
    }
}
