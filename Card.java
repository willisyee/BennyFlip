import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 * 
 *         This class sets up the graphics of the "cards" that you flip over to
 *         see what's under them. There are so many GridBagLayouts in this class
 *         it isn't even funny. I would assume there's an easier way to get this
 *         effect - probably using images.
 * 
 */

public class Card extends JPanel {
	public Card() {
		setLayout(new GridBagLayout());
		GridBagConstraints a = new GridBagConstraints();
		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 0;
		a.gridy = 0;
		a.gridwidth = 1;

		JLabel red1 = new JLabel();
		red1.setBackground(new Color(209, 17, 23));
		red1.setOpaque(true);
		add(red1, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 1;
		a.gridy = 1;
		a.gridwidth = 1;
		JLabel blue1 = new JLabel();
		blue1.setBackground(new Color(0, 20, 245));
		blue1.setOpaque(true);
		add(blue1, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 2;
		a.gridy = 2;
		a.gridwidth = 1;
		JLabel blue2 = new JLabel();
		blue2.setBackground(new Color(0, 20, 245));
		blue2.setOpaque(true);
		add(blue2, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 0;
		a.gridy = 2;
		a.gridwidth = 1;
		JLabel blue3 = new JLabel();
		blue3.setBackground(new Color(0, 20, 245));
		blue3.setOpaque(true);
		add(blue3, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 2;
		a.gridy = 0;
		a.gridwidth = 1;
		JLabel red2 = new JLabel();
		red2.setBackground(new Color(209, 17, 23));
		red2.setOpaque(true);
		add(red2, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 1;
		a.gridy = 0;
		a.gridwidth = 1;
		JLabel red3 = new JLabel();
		red3.setBackground(new Color(209, 17, 23));
		red3.setOpaque(true);
		add(red3, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 1;
		a.gridy = 2;
		a.gridwidth = 1;
		JLabel white = new JLabel();
		white.setBackground(new Color(255, 255, 255));
		white.setOpaque(true);
		add(white, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 0;
		a.gridy = 1;
		a.gridwidth = 1;
		JLabel white2 = new JLabel();
		white2.setBackground(new Color(255, 255, 255));
		white2.setOpaque(true);
		add(white2, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.CENTER;
		a.gridx = 2;
		a.gridy = 1;
		a.gridwidth = 1;
		JLabel white3 = new JLabel();
		white3.setBackground(new Color(255, 255, 255));
		white3.setOpaque(true);
		add(white3, a);

	}
}
