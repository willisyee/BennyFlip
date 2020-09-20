import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 *
 *         This class sets up the numbers that correspond to the number of
 *         Bennys and the number of numbers on the board behind the cards.
 * 
 */
public class BoardNumbers extends JPanel {
	int sum = 0;
	int bennyNumber = 0;
	JPanel sumBox = new JPanel();
	JPanel bennyBox = new JPanel();

	public BoardNumbers(int sum, int bennyNumber, Color color) {
		this.sum = sum;
		this.bennyNumber = bennyNumber;
		init(color);
	}

	public void reset(int sum, int bennyNumber, Color color) {
		removeAll();
		sumBox.removeAll();
		bennyBox.removeAll();

		this.sum = sum;
		this.bennyNumber = bennyNumber;
		init(color);
	}

	private void init(Color color) {
		BufferedImage tempPic = null;
		try {
			tempPic = ImageIO.read(this.getClass().getResource("TinyBenny.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon pic = new ImageIcon(tempPic);
		JLabel benny = new JLabel(pic);

		setLayout(new GridBagLayout());
		GridBagConstraints a = new GridBagConstraints();

		a.fill = GridBagConstraints.BOTH;
		a.gridx = 0;
		a.gridy = 0;
		a.anchor = GridBagConstraints.LINE_END;
		a.weightx = 1;
		a.weighty = 0.1;
		JLabel sumLabel = new JLabel("" + sum);
		sumBox.add(sumLabel);
		sumBox.setBorder(BorderFactory.createLineBorder(Color.black));
		sumBox.setBackground(color);
		add(sumBox, a);

		bennyBox.setBorder(BorderFactory.createLineBorder(Color.black));
		bennyBox.setBackground(color);
		bennyBox.setLayout(new GridBagLayout());
		a.gridx = 0;
		a.gridy = 0;
		a.weightx = 0.1;
		bennyBox.add(benny, a);
		a.gridx = 1;
		a.weightx = 0.1;
		bennyBox.add(new JLabel(Integer.toString(bennyNumber)), a);
		a.gridx = 0;
		a.weightx = 1;
		a.gridy = 1;
		a.weighty = 1;
		add(bennyBox, a);
	}

}
