import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 * 
 *         This class is meant to display Benny and the numbers behind the cards
 */

public class BennyDisplay extends JPanel {
	int item = 0;
	BufferedImage image = null;
	boolean bennyTorb = false;

	public BennyDisplay(int item) {
		this.item = item;
		setLayout(new GridBagLayout());
		GridBagConstraints a = new GridBagConstraints();
		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 0;
		a.gridy = 0;
		a.gridwidth = 1;

		setBackground(new Color(255, 255, 255));

		try {
			image = ImageIO.read(this.getClass().getResource("LilBenny.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon pic = new ImageIcon(image);
		JLabel bennyImage = new JLabel(pic);

		JLabel label = new JLabel(Integer.toString(item));
		Font labelFont = label.getFont();
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 35));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		if (item != 0) {
			add(label, a);
		}

		else {
			bennyTorb = true;

		}
	}

	@Override
	protected void paintComponent(Graphics gr) {

		super.paintComponent(gr);

		if (bennyTorb)
			gr.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

}
