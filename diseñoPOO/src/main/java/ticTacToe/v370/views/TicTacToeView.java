package ticTacToe.v370.views;

import ticTacToe.v370.controllers.ColocateController;
import ticTacToe.v370.controllers.ContinueController;
import ticTacToe.v370.controllers.OperationController;
import ticTacToe.v370.controllers.OperationControllerVisitor;
import ticTacToe.v370.controllers.StartController;

public class TicTacToeView implements OperationControllerVisitor {
	
	private StartView startView;
	
	private GameView gameView;
	
	private ContinueView continueView;
	
	public TicTacToeView(){
		startView = new StartView();
		gameView = new GameView();
		continueView = new ContinueView();
	}

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}
	
	@Override
	public void visit(ColocateController colocateController) {
		gameView.interact(colocateController);
	}

	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}

}
