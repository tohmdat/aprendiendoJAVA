package designPatterns.exercises.n2_tickets.v1.frenchConfiguration;

import designPatterns.exercises.n2_tickets.v1.menu.CancellationLineCommand;
import designPatterns.exercises.n2_tickets.v1.menu.Menu;
import designPatterns.exercises.n2_tickets.v1.menu.RepetitionLineCommand;
import designPatterns.exercises.n2_tickets.v1.menu.SaleLineCommand;

class FrenchMenu extends Menu {
	
	@Override
	protected void setCommands() {
		commandList.add(new SaleLineCommand());
		commandList.add(new RepetitionLineCommand());
		commandList.add(new CancellationLineCommand());
	}

}
