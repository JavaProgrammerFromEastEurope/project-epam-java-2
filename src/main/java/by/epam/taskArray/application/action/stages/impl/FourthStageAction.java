package by.epam.taskArray.application.action.stages.impl;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.action.stages.BaseStageAction;

public class FourthStageAction extends BaseStageAction implements IAction {

    @Override
    public String description() {
        return "Determining sum of array elements.\n";
    }

    @Override
    public void action() {
        serviceActions.calcFourthFunction();
    }
}
