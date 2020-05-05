package game2;

import game2.model.Answer;
import game2.model.Game;
import game2.model.Question;
import game2.view.GameView;

public class Main {

	public static void main(String[] args) {
		Game[] games = createGames();
		games[0].getGameView().showWindow();
	}

	private static Game[] createGames() {
		Game firstGame = new Game();
		Question firstGameQuestion = new Question();
		firstGameQuestion.setName("Где лев?");

		Answer firstAnswer = new Answer();
		firstAnswer.setName("кот");
		firstAnswer.setImageName("cat");
		firstAnswer.setCorrect(false);

		Answer secondAnswer = new Answer();
		secondAnswer.setName("лев");
		secondAnswer.setImageName("lev");
		secondAnswer.setCorrect(true);

		Answer thirdAnswer = new Answer();
		thirdAnswer.setName("петух");
		thirdAnswer.setImageName("petuh");
		thirdAnswer.setCorrect(false);

		firstGameQuestion.setAnswers(new Answer[] { firstAnswer, secondAnswer, thirdAnswer });

		firstGame.setQuestion(firstGameQuestion);
		firstGame.setGameView(new GameView("Угадайка - 1", firstGame));

		Game secondGame = new Game();
		Question secondGameQuestion = new Question();
		secondGameQuestion.setName("Где заяц?");

		firstAnswer = new Answer();
		firstAnswer.setName("крыса");
		firstAnswer.setImageName("rat");
		firstAnswer.setCorrect(false);

		secondAnswer = new Answer();
		secondAnswer.setName("волк");
		secondAnswer.setImageName("wolf");
		secondAnswer.setCorrect(false);

		thirdAnswer = new Answer();
		thirdAnswer.setName("заяц");
		thirdAnswer.setImageName("zayac");
		thirdAnswer.setCorrect(true);

		secondGameQuestion.setAnswers(new Answer[] { firstAnswer, secondAnswer, thirdAnswer });

		secondGame.setQuestion(secondGameQuestion);
		secondGame.setGameView(new GameView("Угадайка - 2", secondGame));

		firstGame.setNextGame(secondGame);

		return new Game[] { firstGame, secondGame };
	}
}