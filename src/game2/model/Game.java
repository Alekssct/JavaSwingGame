package game2.model;

import game2.view.GameView;

public class Game {

	private Question question;

	private Game nextGame;

	private GameView gameView;
	
	public boolean hasNextGame() {
		return nextGame != null;
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Game getNextGame() {
		return nextGame;
	}

	public void setNextGame(Game nextGame) {
		this.nextGame = nextGame;
	}

	public GameView getGameView() {
		return gameView;
	}

	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nextGame == null) ? 0 : nextGame.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (nextGame == null) {
			if (other.nextGame != null)
				return false;
		} else if (!nextGame.equals(other.nextGame))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

}
