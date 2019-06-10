package ticTacToe.v380.views;

import ticTacToe.v380.controllers.ColocateController;
import ticTacToe.v380.controllers.ColocateControllerVisitor;
import ticTacToe.v380.controllers.CoordinateController;
import ticTacToe.v380.controllers.CoordinateControllerVisitor;
import ticTacToe.v380.controllers.Error;
import ticTacToe.v380.controllers.MoveController;
import ticTacToe.v380.controllers.PutController;
import ticTacToe.v380.controllers.RandomCoordinateController;
import ticTacToe.v380.controllers.UserCoordinateController;
import ticTacToe.v380.models.Coordinate;
import ticTacToe.v380.utils.IO;

class GameView implements ColocateControllerVisitor,
		CoordinateControllerVisitor {

	private IO io = new IO();

	private String title;

	private Coordinate target;

	public void interact(ColocateController colocateController) {
		colocateController.accept(this);
	}

	@Override
	public void visit(PutController putController) {
		ColorView colorView = new ColorView(putController.take());
		colorView.writeln("Pone el jugador ");
		Coordinate target;
		Error error = null;
		do {
			target = this.getTarget("En",
					putController.getCoordinateController());
			error = putController.validateTarget(target);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		putController.put(target);
		new BoardView(putController).write();
		if (putController.existTicTacToe()) {
			colorView.writeWinner();
		}
	}

	@Override
	public void visit(MoveController moveController) {
		ColorView colorView = new ColorView(moveController.take());
		colorView.writeln("Mueve el jugador ");
		Coordinate origin;
		Error error = null;
		do {
			origin = this.getOrigin(moveController.getCoordinateController());
			error = moveController.validateOrigin(origin);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		moveController.remove(origin);
		Coordinate target;
		error = null;
		do {
			target = this.getTarget("A",
					moveController.getCoordinateController(), origin);
			error = moveController.validateTarget(origin, target);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		moveController.put(target);
		new BoardView(moveController).write();
		if (moveController.existTicTacToe()) {
			colorView.writeWinner();
		}
	}

	private Coordinate getTarget(String title,
			CoordinateController coordinateController) {
		assert title != null;
		assert coordinateController != null;
		this.title = title;
		target = coordinateController.getTarget();
		coordinateController.accept(this);
		return target;
	}

	@Override
	public void visit(UserCoordinateController userCoordinateController) {
		new CoordinateView(title, target).read();
	}

	@Override
	public void visit(RandomCoordinateController randomCoordinateController) {
		new CoordinateView("La máquina pone en ", target).write();
		io.readString(". Pulse enter para continuar");
	}

	private Coordinate getTarget(String title,
			UserCoordinateController coordinateController) {
		Coordinate coordinate = coordinateController.getTarget();
		new CoordinateView(title, coordinate).read();
		return coordinate;
	}

	private Coordinate getOrigin(CoordinateController coordinateController) {
		if (coordinateController instanceof UserCoordinateController) {
			return this
					.getOrigin((UserCoordinateController) coordinateController);
		} else if (coordinateController instanceof RandomCoordinateController) {
			return this
					.getOrigin((RandomCoordinateController) coordinateController);
		}
		return null;
	}

	private Coordinate getOrigin(UserCoordinateController coordinateController) {
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("De", coordinate).read();
		return coordinate;
	}

	private Coordinate getOrigin(RandomCoordinateController coordinateController) {
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("La máquina quita de ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

	private Coordinate getTarget(String title,
			CoordinateController coordinateController, Coordinate origin) {
		if (coordinateController instanceof UserCoordinateController) {
			return this.getTarget(title,
					(UserCoordinateController) coordinateController);
		} else if (coordinateController instanceof RandomCoordinateController) {
			return this.getTarget(title,
					(RandomCoordinateController) coordinateController, origin);
		}
		return null;
	}

	private Coordinate getTarget(String title,
			RandomCoordinateController coordinateController, Coordinate origin) {
		Coordinate coordinate = coordinateController.getTarget(origin);
		new CoordinateView("La máquina pone en ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

}
