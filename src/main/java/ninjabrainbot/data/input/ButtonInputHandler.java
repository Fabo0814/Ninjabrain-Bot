package ninjabrainbot.data.input;

import ninjabrainbot.data.IDataState;
import ninjabrainbot.data.actions.IActionExecutor;
import ninjabrainbot.data.actions.ResetAction;
import ninjabrainbot.data.temp.IDomainModel;

public class ButtonInputHandler implements IButtonInputHandler {

	private final IDomainModel domainModel;
	private final IDataState dataState;
	private final IActionExecutor actionExecutor;

	public ButtonInputHandler(IDomainModel domainModel, IDataState dataState, IActionExecutor actionExecutor) {
		this.domainModel = domainModel;
		this.dataState = dataState;
		this.actionExecutor = actionExecutor;
	}

	public void onResetButtonPressed() {
		actionExecutor.executeImmediately(new ResetAction(domainModel));
	}

	@Override
	public void onUndoButtonPressed() {

	}

}
