package designPatterns.exercises.n3_manager.v2.manager;

import designPatterns.exercises.n3_manager.v2.store.StoreImplementation;

public class StandaloneManager extends Manager {

	@Override
	protected Store createStore() {
		return new StoreImplementation();
	}
	
	public static void main(String[] args) {
		new StandaloneManager().manage();
	}
	
}
