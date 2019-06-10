package ticTacToe.v330.controllers;

import ticTacToe.v330.models.Coordinate;
import ticTacToe.v330.models.Game;

public class UserCoordinateController extends CoordinateController {

	protected UserCoordinateController(Game game) {
		super(game);
	}

	@Override
	public Coordinate getOrigin() {
		return new Coordinate();
	}

	@Override
	public Coordinate getTarget() {
		return new Coordinate();
	}
	
}
