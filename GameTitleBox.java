import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 * 
 *         This class sets up the information that goes in the title box at the
 *         top of the game.
 * 
 */

public class GameTitleBox extends JPanel {

	private JLabel a = new JLabel();

	public GameTitleBox() {
		setLayout(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();

		b.weightx = 0.1;
		b.weighty = 0.1;
		b.anchor = GridBagConstraints.CENTER;
		b.gridx = 1;
		b.gridy = 1;
		b.gridwidth = 3;

		this.setBorder(BorderFactory.createLineBorder(new Color(0, 20, 245), 1));
		setMessage();

		Font labelFont = a.getFont();
		a.setFont(new Font(labelFont.getName(), Font.PLAIN, 25));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setVerticalAlignment(SwingConstants.CENTER);
		a.setForeground(Color.BLUE);

		add(a, b);
	}

	public void setMessage() {
		a.setText("BennyFlip");
	}

	public void click(int score) {
		a.setText("Your points = " + score);
	}

	public void lose() {
		a.setText("You definitely did not win.");
	}

	public void win() {
		a.setText("Oh wow, you're good at this!");
	}

	public void restart() {
		setMessage();
	}
}
