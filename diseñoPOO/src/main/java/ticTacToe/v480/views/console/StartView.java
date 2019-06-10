package ticTacToe.v480.views.console;

import ticTacToe.v480.controllers.StartController;
import ticTacToe.v480.utils.LimitedIntDialog;

class StartView {

	private BoardView boardView;
	
	StartView(BoardView boardView) {
		this.boardView = boardView;
	}
	
	void interact(StartController startController){
		int users = LimitedIntDialog.instance().read("Cu�ntos usuarios?", 0, 2);
		startController.start(users);
		boardView.write(startController);
	}
}
