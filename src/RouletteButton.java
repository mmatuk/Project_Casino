
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
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Matt
 */
public class RouletteButton extends JButton
{
    private List<Integer> numbers;
    
    /**
     * Create a new Roulette button
     * 
     * @param mOver Mouseover imageIcon
     * @param press Pressed imageIcon
     * @param nor Normal imageIcon
     * @param num 
     */
    public RouletteButton(String mOver, String press, 
            String nor, List<Integer> num)
    {
        super();
        numbers = num;
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
        
    }
    
    private void setButton()
    {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    
    public List<Integer> getNumbers()
    {
    	return numbers;
    }
}
