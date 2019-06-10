package designPatterns.exercises.n5_vending.observer.menu.manager;

import designPatterns.exercises.n5_vending.observer.devices.DeviceFacade;
import designPatterns.exercises.n5_vending.observer.menu.Command;
import designPatterns.exercises.n5_vending.observer.utils.LimitedIntDialog;

public class AddWateTankCommand extends Command {

	public AddWateTankCommand() {
		super("Añadir agua");
	}

	@Override
	public void execute() {
		int amount = LimitedIntDialog.instance().read("Cantidad de azucar? ", 100);
		DeviceFacade.instance().addWater(amount);
	}


}
