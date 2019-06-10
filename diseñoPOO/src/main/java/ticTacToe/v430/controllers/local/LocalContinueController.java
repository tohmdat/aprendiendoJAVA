package ticTacToe.v430.controllers.local;

import ticTacToe.v430.models.State;
import ticTacToe.v430.controllers.ContinueController;
import ticTacToe.v430.controllers.OperationControllerVisitor;
import ticTacToe.v430.models.Game;

public class LocalContinueController extends LocalOperationController implements
		ContinueController {

	LocalContinueController(Game game) {
		super(game);
	}

	public void resume(boolean another) {
		assert this.getState() == State.FINAL;
		if (another) {
			this.clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
