package ticTacToe.v410.controllers;

public enum Error {
	
	NOT_EMPTY("Esa casilla ya est� ocupada"),
	REPEATED_COORDINATE("No se puede poner de donde se quit�"),
	NOT_PROPERTY("Esa casilla no est� ocupada por ninguna de tus fichas");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
