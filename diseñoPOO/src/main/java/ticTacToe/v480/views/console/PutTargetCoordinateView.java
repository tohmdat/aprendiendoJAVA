package ticTacToe.v480.views.console;

import ticTacToe.v480.controllers.CoordinateController;
import ticTacToe.v480.controllers.RandomCoordinateController;
import ticTacToe.v480.controllers.UserCoordinateController;
import ticTacToe.v480.models.Coordinate;

class PutTargetCoordinateView extends ColocateCoordinateView {

	private Coordinate target;

	PutTargetCoordinateView(CoordinateController coordinateController) {
		super(coordinateController);
	}		
		
	Coordinate getCoordinate(){
		target = this.getCoordinateController().getTarget();
		this.getCoordinateController().accept(this);
		return target;
	}

	@Override
	public void visit(UserCoordinateController userCoordinateController) {
		CoordinateView.instance().read("En", target);
	}

	@Override
	public void visit(RandomCoordinateController randomCoordinateController) {
		this.show("pone en", target);
	}

}
