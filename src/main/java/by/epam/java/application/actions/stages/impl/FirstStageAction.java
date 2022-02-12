package by.epam.java.application.actions.stages.impl;

import by.epam.java.application.actions.IAction;
import by.epam.java.application.actions.stages.BaseStageAction;

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
