package by.epam.taskArray.application.action.stages.impl;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.action.stages.BaseStageAction;

public class FifthStageAction extends BaseStageAction implements IAction {

    @Override
    public String description() {
        return "Determination the number of positive/negative array elements.\n";
    }

    @Override
    public void action() {
        serviceActions.calcFifthFunction();
    }
}
