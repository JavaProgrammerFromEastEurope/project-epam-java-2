package by.epam.java.application.actions.stages.impl;

import by.epam.java.application.actions.IAction;
import by.epam.java.application.actions.stages.BaseStageAction;

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
