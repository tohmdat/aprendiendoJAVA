package ticTacToe.v490.controllers.local;

import ticTacToe.v490.controllers.CoordinateController;
import ticTacToe.v490.models.Coordinate;
import ticTacToe.v490.models.Game;

public abstract class LocalCoordinateController extends LocalController
		implements CoordinateController {

	protected LocalCoordinateController(Game game) {
		super(game);
	}

	public abstract Coordinate getOrigin();

	public abstract Coordinate getTarget();

}
