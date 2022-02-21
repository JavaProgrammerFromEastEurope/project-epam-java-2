package by.epam.taskArray.application.action.stages.impl;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.action.stages.BaseStageAction;

public class FirstStageAction extends BaseStageAction implements IAction {

    @Override
    public String description() {
        return "Finding min/max of array.\n";
    }

    @Override
    public void action() {
        serviceActions.calcFirstFunction();
    }
}
