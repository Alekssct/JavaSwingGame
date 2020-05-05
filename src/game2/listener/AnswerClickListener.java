package game2.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import game2.model.Answer;
import game2.model.Game;

public class AnswerClickListener implements ActionListener {

	private Game game;

	public AnswerClickListener(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String answerText = e.getActionCommand();
		if (isCorrectAnswer(answerText)) {
			JOptionPane.showMessageDialog(game.getGameView(), "Верно!");
			showNextGame();
		} else {
			JOptionPane.showMessageDialog(game.getGameView(), "Попробуйте еще раз.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean isCorrectAnswer(String answerText) {
		for (Answer answer : game.getQuestion().getAnswers()) {
			if (answer.getName().equals(answerText)) {
				return answer.isCorrect();
			}
		}
		return false;
	}

	private void showNextGame() {
		if (game.hasNextGame()) {
			game.getGameView().hideWindow();
			game.getNextGame().getGameView().showWindow();
		}
	}

}
