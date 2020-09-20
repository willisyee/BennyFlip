import javax.swing.JFrame;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 * This class is the main runner class, that sets everything up and sets the size of the size of the box. 
 */


public class VoltorbMain {
	public static void main (String[] args) {
		MainGUI box = new MainGUI();
		
		Sound s = new Sound();
		s.setbgmFile("GameM.wav");
		s.loop(s.bgm);
		
		box.setTitle("BennyFlip");
		box.pack();
		box.setSize(750, 850);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.setVisible(true);
		
	}
}
