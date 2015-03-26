
import javax.swing.JFrame;

//***********************************************************
// 	Start.java								Team 2 
//	Matt Matuk, Wyatt leith, Nick Tsang
//
//	File Created by: Matt Matuk				March 19, 2015
//
//	This is the casino game that we are creating.
//	This class will be the main driver of the program that
//	will start the game.
//***********************************************************


public class Start 
{
	public static void main(String[] args)
	{

            JFrame frm = new JFrame("Project Casino");
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
           // frm.setContentPane(new LoginPanel());
            frm.setContentPane(new MainPanel());
            frm.pack();
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);

	}

}
