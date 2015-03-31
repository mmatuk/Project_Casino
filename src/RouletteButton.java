
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

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Matt
 */
public class RouletteButton extends JButton
{
    private int[] numbers;
    
    public RouletteButton(ImageIcon mOver, ImageIcon press, 
            ImageIcon nor, int[] num)
    {
        super(nor);
        setPressedIcon(press);
        setRolloverIcon(mOver);
        numbers = num;
        setButton();
        Dimension temp = new Dimension(nor.getIconWidth(), nor.getIconHeight());
        setPreferredSize(temp);
        setMinimumSize(temp);
        setMaximumSize(temp);
    }
    
    private void setButton()
    {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
}
