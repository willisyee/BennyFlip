import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee This class sets up the
 *         structure of the main GUI of the game
 */

public class MainGUI extends JFrame {

	private static final Insets inset = new Insets(5, 5, 5, 5);
	private boolean[][] clickArray = new boolean[5][5];
	private GridBagConstraints a = new GridBagConstraints();
	private JButton[][] buttonsArray = new JButton[5][5];
	private BoardNumbers[] boardNumbersArray = new BoardNumbers[10];

	public MainGUI() {
		Sound s = new Sound();
		setLayout(new GridBagLayout());

		getContentPane().setBackground(new Color(255, 255, 255));

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 1;
		a.weighty = 1;
		a.anchor = GridBagConstraints.CENTER;
		a.insets = inset;
		a.gridx = 0;
		a.gridy = 0;
		a.gridwidth = 6;

		Board board = new Board();
		board.fillGameboard();

		GameTitleBox title = new GameTitleBox();
		add(title, a);
		/**
		 * These for loops create the boxes where the number of bennys and the number of
		 * numbers exist
		 */

		for (int i = 0; i < 5; i++) {
			a.fill = GridBagConstraints.BOTH;
			a.weightx = 0.1;
			a.weighty = 0.1;
			a.anchor = GridBagConstraints.CENTER;
			a.insets = inset;
			a.gridx = 5;
			a.gridy = i + 1;
			a.gridwidth = 1;
			Color color = Color.BLUE;
			switch (i) {
			case 0:
				color = color.white;
				break;
			case 1:
				color = color.white;
				break;
			case 2:
				color = color.white;
				break;
			case 3:
				color = color.white;
				break;
			case 4:
				color = color.white;
				break;
			}
			boardNumbersArray[i] = new BoardNumbers(board.sumArrayRow(i), board.bennysArrayRow(i), color);
			add(boardNumbersArray[i], a);
		}

		for (int i = 5; i < 10; i++) {
			a.fill = GridBagConstraints.BOTH;
			a.weightx = 0.1;
			a.weighty = 0.1;
			a.anchor = GridBagConstraints.CENTER;
			a.insets = inset;
			a.gridx = i - 5;
			a.gridy = 6;
			a.gridwidth = 1;
			Color color = Color.blue;
			switch (i) {
			case 5:
				color = new Color(255, 255, 255);
				break;
			case 6:
				color = new Color(255, 255, 255);
				break;
			case 7:
				color = new Color(255, 255, 255);
				break;
			case 8:
				color = new Color(255, 255, 255);
				break;
			case 9:
				color = new Color(255, 255, 255);
				break;
			}
			boardNumbersArray[i] = new BoardNumbers(board.sumArrayColumn(i - 5), board.bennysArrayColumn(i - 5), color);
			add(boardNumbersArray[i], a);

		}

		/**
		 * This creates the 5x5 grid and buttons for the grid
		 */

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				buttonsArray[i][j] = new JButton("");
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				a.fill = GridBagConstraints.BOTH;
				a.weightx = 0.5;
				a.weighty = 0.5;
				a.anchor = GridBagConstraints.CENTER;
				a.insets = inset;
				a.gridx = j;
				a.gridy = i + 1;
				a.gridwidth = 1;
				buttonsArray[i][j].setFocusPainted(false);
				buttonsArray[i][j].setMargin(new Insets(0, 0, 0, 0));
				buttonsArray[i][j].setContentAreaFilled(false);
				buttonsArray[i][j].setLayout(new BorderLayout());
				buttonsArray[i][j].setBorder(BorderFactory.createLineBorder(Color.blue, 2));
				Card checkerLook = new Card();
				buttonsArray[i][j].add(checkerLook, BorderLayout.CENTER);
				add(buttonsArray[i][j], a);
				int x = i;
				int y = j;
				buttonsArray[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						s.setTileFile("wood.wav");
						s.play(s.flip);
						if (!clickArray[x][y]) {
							update();
							clickArray[x][y] = true;
							buttonsArray[x][y].removeAll();
							buttonsArray[x][y].add(new BennyDisplay(board.getBoxNumber(x, y)), BorderLayout.CENTER);
							board.flip(x, y);
							title.click(board.getScore());
							if (board.isOver()) {
								update();
								for (int p = 0; p < 5; p++) {

									for (int z = 0; z < 5; z++) {

										if (!clickArray[p][z]) {
											clickArray[p][z] = true;
											buttonsArray[p][z].removeAll();
											buttonsArray[p][z].add(new BennyDisplay(board.getBoxNumber(p, z)),
													BorderLayout.CENTER);
											update();
										}
										update();
									}
									update();
								}
								update();
								if (board.isWon()) {
									title.win();
									update();
								}

								else {
									title.lose();
									update();
								}
								update();
							}

							update();

						}
						update();

					}

				});
			}
		}
		update();

		/**
		 * The following buttons are the How-To buttons and the Reset buttons
		 */

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.1;
		a.weighty = 0.1;
		a.anchor = GridBagConstraints.LAST_LINE_END;
		a.insets = inset;
		a.gridx = 0;
		a.gridy = 1;
		a.gridwidth = 1;

		JPanel infoButton = new JPanel();
		infoButton.setLayout(new GridBagLayout());
		infoButton.setBackground(new Color(0, 20, 245));
		JButton exit = new JButton("How-To");
		exit.setBorder(null);
		exit.setBorder(BorderFactory.createLineBorder(Color.blue));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JScrollPane scrollpane = new JScrollPane();
				String categories[] = { "Welcome to BennyFlip!", "This game consists of 25 tiles with either a point value or a Benny behind them.", 
				"Each row and column has an indicator box next to it that displays the number of Bennys and the number of point tiles.", 
				"Your mission, should you choose to accept it, is to avoid clicking on a Benny at all costs!", 
				"For the first point tile that you flip, you will receive that number of points.", "However, for each subsequent flip",
				"your point total will be multiplied by the number you flip.",
				"Happy flipping!! #goquakers" };
				JList list = new JList(categories);

				scrollpane = new JScrollPane(list);

				JPanel panel = new JPanel();
				panel.add(scrollpane);

				scrollpane.getViewport().add(list);
				JOptionPane.showMessageDialog(null, scrollpane, "How-To", JOptionPane.PLAIN_MESSAGE);
			}
		});
		Font labelFont = exit.getFont();
		exit.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setVerticalAlignment(SwingConstants.CENTER);
		exit.setBackground(Color.WHITE);
		exit.setOpaque(true);
		infoButton.add(exit, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.001;
		a.weighty = 1;
		a.anchor = GridBagConstraints.LAST_LINE_END;
		a.insets = inset;
		a.gridx = 0;
		a.gridy = 0;
		a.gridwidth = 1;

		JButton reset = new JButton("Reset Board");
		reset.setBackground(Color.WHITE);
		reset.setOpaque(true);
		reset.setBorder(null);
		reset.setBorder(BorderFactory.createLineBorder(Color.blue));
		reset.addActionListener(new ActionListener() {

			/**
			 * The following code resets the numbers on the bottom row and right-most column
			 * when the "reset" button is clicked
			 */

			public void actionPerformed(ActionEvent evt) {
				title.setMessage();
				board.resetGame();
				for (int i = 0; i < 5; i++) {

					for (int j = 0; j < 5; j++) {
						update();
						clickArray[i][j] = false;
						buttonsArray[i][j].removeAll();

						Card checkerLook = new Card();
						buttonsArray[i][j].add(checkerLook, BorderLayout.CENTER);

						for (int i1 = 0; i1 < 5; i1++) {
							a.fill = GridBagConstraints.BOTH;
							a.weightx = 0.1;
							a.weighty = 0.1;
							a.anchor = GridBagConstraints.CENTER;
							a.insets = inset;
							a.gridx = 5;
							a.gridy = i1 + 1;
							a.gridwidth = 1;
							Color color = Color.blue;
							switch (i1) {
							case 0:
								color = new Color(255, 255, 255);
								break;
							case 1:
								color = new Color(255, 255, 255);
								break;
							case 2:
								color = new Color(255, 255, 255);
								break;
							case 3:
								color = new Color(255, 255, 255);
								break;
							case 4:
								color = new Color(255, 255, 255);
								break;
							}
							boardNumbersArray[i1].reset(board.sumArrayRow(i1), board.bennysArrayRow(i1), color);
						}
						update();

						for (int i1 = 5; i1 < 10; i1++) {

							a.fill = GridBagConstraints.BOTH;
							a.weightx = 0.3;
							a.weighty = 0.2;
							a.anchor = GridBagConstraints.CENTER;
							a.insets = inset;
							a.gridx = i1 - 5;
							a.gridy = 6;
							a.gridwidth = 1;
							Color color = Color.blue;
							switch (i1) {
							case 5:
								color = new Color(255, 255, 255);
								break;
							case 6:
								color = new Color(255, 255, 255);
								break;
							case 7:
								color = new Color(255, 255, 255);
								break;
							case 8:
								color = new Color(255, 255, 255);
								break;
							case 9:
								color = new Color(255, 255, 255);
								break;
							}
							boardNumbersArray[i1].reset(board.sumArrayColumn(i1 - 5), board.bennysArrayColumn(i1 - 5),
									color);
							update();
						}
						update();

					}
					update();
				}
				update();
			}
		});

		Font resetFont = reset.getFont();
		reset.setFont(new Font(resetFont.getName(), Font.PLAIN, 14));
		reset.setHorizontalAlignment(SwingConstants.CENTER);
		reset.setVerticalAlignment(SwingConstants.CENTER);
		infoButton.add(reset, a);

		a.fill = GridBagConstraints.BOTH;
		a.weightx = 0.2;
		a.weighty = 0.2;
		a.anchor = GridBagConstraints.LAST_LINE_END;
		a.insets = new Insets(15, 15, 10, 10);
		a.gridx = 5;
		a.gridy = 6;
		a.gridwidth = 1;
		add(infoButton, a);

	}

	public void update() {
		revalidate();
		repaint();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				buttonsArray[i][j].invalidate();
				buttonsArray[i][j].validate();

				int u = i;
				int r = j;
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						buttonsArray[u][r].repaint();
					}
				});

			}
		}

		for (int i = 0; i < 10; i++) {
			boardNumbersArray[i].invalidate();
			boardNumbersArray[i].validate();
			int u = i;
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					boardNumbersArray[u].repaint();
				}
			});
		}
	}
}
