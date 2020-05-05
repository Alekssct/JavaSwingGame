package game2.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game2.listener.AnswerClickListener;
import game2.model.Answer;
import game2.model.Game;

public class GameView extends JFrame {

	private static final int WIDTH = 300;
	private static final int HEIGHT = 560;

	private Game game;

	public GameView(String title, Game game) {
		setTitle(title);
		setGame(game);
		GamePanel panel = new GamePanel();
		add(panel);

		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void showWindow() {
		setVisible(true);
	}

	public void hideWindow() {
		setVisible(false);
	}

	private class GamePanel extends JPanel {

		private static final String PICTURES_FOLDER = "pic";
		private static final String PICTURES_FORMAT = ".jpg";

		private AnswerClickListener listener;

		public GamePanel() {
			listener = new AnswerClickListener(game);
			final JLabel questionLabel = new JLabel(game.getQuestion().getName());
			add(questionLabel);

			for (Answer answer : game.getQuestion().getAnswers()) {
				final JButton answerButton = new JButton();
				final ImageIcon imageIcon = new ImageIcon(
						PICTURES_FOLDER + "\\" + answer.getImageName() + PICTURES_FORMAT);
				answerButton.setIcon(imageIcon);
				answerButton.setActionCommand(answer.getName());
				answerButton.addActionListener(listener);
				add(answerButton);
			}
		}

	}
}
