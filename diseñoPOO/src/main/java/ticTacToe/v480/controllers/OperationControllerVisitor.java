package ticTacToe.v480.controllers;

public interface OperationControllerVisitor {

	void visit(StartController startController);
	
	void visit(ColocateController colocateController);
	
	void visit(ContinueController continueController);

}

